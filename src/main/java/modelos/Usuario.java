package modelos;

/**
 * Created by andrea on 17/05/16.
 */
public class Usuario {

    private String username;
    private String nombre;
    private String password;
    private RolGrupo rolGrupo;
    private String access_token;

    public Usuario(){
    }

    public Usuario(String username, String access_token, RolGrupo rolGrupo, String password, String nombre) {
        this.username = username;
        this.access_token = access_token;
        this.rolGrupo = rolGrupo;
        this.password = password;
        this.nombre = nombre;
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

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
