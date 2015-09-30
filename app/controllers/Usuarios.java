package controllers;

import models.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;



public class Usuarios extends Controller {

    public Result postear() {
        return TODO;
    }

    public Result puntuar() {
        return TODO;
    }

    public Result create() {
        Form<Usuario> usuarioForm = Form.form(Usuario.class);
        return ok(views.html.usuarios.create.render(usuarioForm));
    }


    public Result save() {
        Form<Usuario> usuarioForm = Form.form(Usuario.class).bindFromRequest();
        if ( usuarioForm.hasErrors() ) {
            return badRequest( views.html.usuarios.create.render(usuarioForm) );

        } else {
            usuarioForm.get().save();
            return redirect(routes.Application.list());
        }
    }
}
