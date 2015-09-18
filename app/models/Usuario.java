package models;

import java.util.*;
import javax.persistence.*;
import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.*;


@Entity
public class Usuario extends Model {

    @Id
    public Long id;

    @Constraints.Required(message = "Requerido")
    public String usuario;

    @Constraints.Required(message = "Requerido")
    public String password;


    // para las queries
    public static Finder<Long, Usuario> find = new Finder<Long, Usuario>(Usuario.class);




}