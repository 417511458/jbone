package cn.jbone.errors;

import org.jasig.cas.client.validation.TicketValidationException;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.http.HttpStatus;

public class JboneErrorPageRegister implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/errors/404.html");
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/errors/500.html");

        ErrorPage ticketValidateError = new ErrorPage(TicketValidationException.class,"/errors/ticketValidateError.html");
        errorPageRegistry.addErrorPages(ticketValidateError,e404, e500);
    }
}
