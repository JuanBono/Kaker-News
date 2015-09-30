package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.Formats;

import play.data.validation.*;


@Entity
public class Noticia extends Model implements play.mvc.PathBindable<Noticia> {

    @Override
    public Noticia bind(String key, String value) {
        return findByTitulo(value);
    }

    @Override
    public String unbind(String key) {
        return this.titulo;
    }

    @Override
    public String javascriptUnbind() {
        return this.titulo;
    }

    @Id
    public Long id;

    @Constraints.Required(message = "Requerido")
    public String titulo;

    @ManyToOne
    public Usuario usuario;

    @Constraints.Required(message = "Requerido")
    public String enlace;

    @Formats.DateTime(pattern = "dd-mm-aaaa")
    public Date fecha;

    public Long puntos = 0L;


    // para las queries
    public static Finder<Long, Noticia> find = new Finder<Long, Noticia>(Noticia.class);


    public Noticia findByTitulo(String titulo) {
        return find.where().eq("titulo", titulo).findUnique();
    }


}
