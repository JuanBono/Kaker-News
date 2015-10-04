package controllers;

import models.Noticia;
import play.data.Form;
import play.mvc.*;
import views.html.*;

import java.util.Date;
import java.util.List;

public class Application extends Controller {

    /* Capaz despues puedo renombrar list() como index(), ni idea.
    public Result index() {
        return ok(index.render(list()));
    }
    */

    public Result list() {
        List<Noticia> listaNoticias = Noticia.find.all();
        return ok(index.render(listaNoticias));
    }

    public Result create() {
        Form<Noticia> noticiaForm = Form.form(Noticia.class);
        return ok(create.render(noticiaForm));
    }


    public Result save() {
        Form<Noticia> noticiaForm = Form.form(Noticia.class).bindFromRequest();
        if ( noticiaForm.hasErrors() ) {
            return badRequest( create.render(noticiaForm) );

        } else {
            noticiaForm.get().fecha = new Date();
            noticiaForm.get().save();
            return redirect(routes.Application.list());
        }
    }

    public Result ingresar() {
        return TODO;
    }

    public Result modifyHeaders() {
        response().setHeader("ETag", "foo_java");
        return ok("Header Modification Example");
    }

    public Result modifyCookies() {
        response().setCookie("source", "tw", (60 * 60));
        return ok("Cookie Modification Example");
    }

    public Result modifySession() {
        final String sessionVar = "user_pref";
        final String userPref = session(sessionVar);
        if (userPref == null) {
            session(sessionVar, "tw");
            return ok("Setting Session var: " + sessionVar);
        } else {
            return ok("Found user_pref: " + userPref);
        }
    }


    @With(AuthAction.class)
    public Result dashboard() {
        return ok("User dashboard");
    }

    public Result login() {
        return ok("Please Login");
    }

}
