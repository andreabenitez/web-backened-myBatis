package modelos;

/**
 * Created by andrea on 18/05/16.
 */
public class MetodoRoles {

    private Integer metodo_rol_id;
    private Integer rol_id;
    private String url;
    private String metodo;

    public MetodoRoles(){}

    public MetodoRoles(Integer metodo_rol_id, Integer rol_id, String url, String metodo) {
        this.metodo_rol_id = metodo_rol_id;
        this.rol_id = rol_id;
        this.url = url;
        this.metodo = metodo;
    }

    public Integer getMetodo_rol_id() {
        return metodo_rol_id;
    }

    public void setMetodo_rol_id(Integer metodo_rol_id) {
        this.metodo_rol_id = metodo_rol_id;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getRol_id() {
        return rol_id;
    }

    public void setRol_id(Integer rol_id) {
        this.rol_id = rol_id;
    }
}
