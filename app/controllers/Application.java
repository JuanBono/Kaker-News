package controllers;

import models.Noticia;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

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
            noticiaForm.get().save();
            return redirect(routes.Application.list());
        }
    }

    public Result ingresar() {
        return TODO;
    }
}
