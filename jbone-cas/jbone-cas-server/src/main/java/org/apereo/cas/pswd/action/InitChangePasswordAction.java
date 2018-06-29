package org.apereo.cas.pswd.action;

import org.apereo.cas.configuration.CasConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

public class InitChangePasswordAction extends AbstractAction {
    @Autowired
    private CasConfigurationProperties casProperties;

    @Override
    protected Event doExecute(final RequestContext requestContext) {
        requestContext.getFlowScope().put("policyPattern", casProperties.getAuthn().getPm().getPolicyPattern());
        return success();
    }
}
