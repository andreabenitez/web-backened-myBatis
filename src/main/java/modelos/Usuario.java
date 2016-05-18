package modelos;

/**
 * Created by andrea on 17/05/16.
 */
public class Usuario {

    private String username;
    private String nombre;
    private String password;
    private RolGrupo rolGrupo;

    public Usuario(){
    }

    public Usuario(String username, String nombre, String password, RolGrupo rolGrupo) {
        this.username = username;
        this.nombre = nombre;
        this.password = password;
        this.rolGrupo = rolGrupo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolGrupo getRolGrupo() {
        return rolGrupo;
    }

    public void setRolGrupo(RolGrupo rolGrupo) {
        this.rolGrupo = rolGrupo;
    }
}
