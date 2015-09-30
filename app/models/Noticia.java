package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import org.w3c.dom.Text;
import play.data.format.Formats;

import play.data.validation.*;
import play.mvc.BodyParser;

@Entity
public class Noticia extends Model {

    @Id
    public Long id;

    @Constraints.Required(message = "Requerido")
    public String titulo;

    @ManyToOne
    public Usuario usuario;

    @Constraints.Required(message = "Requerido")
    public String enlace;

    @Formats.DateTime(pattern="dd-mm-aaaa")
    public Date fecha;

    public Long puntos;

    // hay que agregar un posteador.

    // para las queries
    public static Finder<Long, Noticia> find = new Finder<Long, Noticia>(Noticia.class);


}
