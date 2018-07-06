package cn.jbone.cas.client.pac4j.handler;

import org.pac4j.cas.logout.DefaultCasLogoutHandler;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.context.session.SessionStore;
import org.pac4j.core.profile.ProfileManager;
import org.pac4j.core.util.CommonHelper;

public class JboneCasLogoutHandler<C extends WebContext> extends DefaultCasLogoutHandler<C> {

    @Override
    public void recordSession(C context, String ticket) {
        SessionStore sessionStore = context.getSessionStore();
        if (sessionStore == null) {
            logger.error("No session store available for this web context");
        } else {
            String sessionId = sessionStore.getOrCreateSessionId(context);
            Object trackableSession = sessionStore.getTrackableSession(context);
            if (trackableSession != null) {
                logger.debug("ticket: {} -> trackableSession: {}", ticket, trackableSession);
                logger.debug("sessionId: {}", sessionId);
                getStore().set(ticket, trackableSession);
                getStore().set(sessionId, ticket);
            } else {
                logger.debug("No trackable session for the current session store: {}", sessionStore);
            }
        }

    }

    public void destroySessionFront(C context, String ticket) {
        getStore().remove(ticket);
        SessionStore sessionStore = context.getSessionStore();
        if (sessionStore == null) {
            logger.error("No session store available for this web context");
        } else {
            String currentSessionId = sessionStore.getOrCreateSessionId(context);
            logger.debug("currentSessionId: {}", currentSessionId);
            String sessionToTicket = (String)getStore().get(currentSessionId);
            logger.debug("-> ticket: {}", ticket);
            getStore().remove(currentSessionId);
            if (CommonHelper.areEquals(ticket, sessionToTicket)) {
                this.destroy(context, sessionStore, "front");
            } else {
                logger.error("The user profiles (and session) can not be destroyed for CAS front channel logout because the provided ticket is not the same as the one linked to the current session");
            }
        }

    }

    protected void destroy(C context, SessionStore sessionStore, String channel) {
        ProfileManager manager = new ProfileManager(context);
        manager.logout();
        logger.debug("destroy the user profiles");
        if (isDestroySession()) {
            logger.debug("destroy the whole session");
            boolean invalidated = sessionStore.destroySession(context);
            if (!invalidated) {
                logger.error("The session has not been invalidated for {} channel logout", channel);
            }
        }

    }

    public void destroySessionBack(C context, String ticket) {
        Object trackableSession = getStore().get(ticket);
        logger.debug("ticket: {} -> trackableSession: {}", ticket, trackableSession);
        if (trackableSession == null) {
            logger.error("No trackable session found for back channel logout. Either the session store does not support to track session or it has expired from the store and the store settings must be updated (expired data)");
        } else {
            getStore().remove(ticket);
            SessionStore sessionStore = context.getSessionStore();
            if (sessionStore == null) {
                logger.error("No session store available for this web context");
            } else {
                SessionStore<C> newSessionStore = sessionStore.buildFromTrackableSession(context, trackableSession);
                if (newSessionStore != null) {
                    logger.debug("newSesionStore: {}", newSessionStore);
                    context.setSessionStore(newSessionStore);
                    String sessionId = newSessionStore.getOrCreateSessionId(context);
                    logger.debug("remove sessionId: {}", sessionId);
                    getStore().remove(sessionId);
                    this.destroy(context, newSessionStore, "back");
                } else {
                    logger.error("The session store should be able to build a new session store from the tracked session");
                }
            }
        }

    }

    public void renewSession(String oldSessionId, C context) {
        String ticket = (String)getStore().get(oldSessionId);
        logger.debug("oldSessionId: {} -> ticket: {}", oldSessionId, ticket);
        if (ticket != null) {
            getStore().remove(ticket);
            getStore().remove(oldSessionId);
            this.recordSession(context, ticket);
        }

    }
}
