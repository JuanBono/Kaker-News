package controllers;

import play.*;
import play.mvc.*;
import play.libs.*;
import play.libs.F.*;

public class AuthAction extends play.mvc.Action.Simple {

    public F.Promise<Result> call(Http.Context ctx) throws Throwable {
        Http.Cookie authCookie = ctx.request().cookie("auth");

        if (authCookie != null) {
            Logger.info("Cookie: " + authCookie);
            return delegate.call(ctx);
        } else {
            Logger.info("Redirecting to login page");
            return Promise.pure(redirect(routes.Application.login()));
        }
    }
}
