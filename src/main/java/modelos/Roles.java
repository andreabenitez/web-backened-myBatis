package modelos;

/**
 * Created by andrea on 17/05/16.
 */
public class Roles {

    private Integer rol_id;
    private String nombre;

    public Roles(){}

    public Roles(Integer rol_id, String nombre) {
        this.rol_id = rol_id;
        this.nombre = nombre;
    }

    public Integer getRol_id() {
        return rol_id;
    }

    public void setRol_id(Integer rol_id) {
        this.rol_id = rol_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
