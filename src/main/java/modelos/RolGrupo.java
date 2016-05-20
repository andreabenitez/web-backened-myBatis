package modelos;

/**
 * Created by andrea on 17/05/16.
 */
public class RolGrupo {

    private Integer rol_grupo_id;
    private String nombreRolGrupo;
    //private List<RolesGrupoRol> rolesGrupoRolList;

    public RolGrupo(){
    }

    public RolGrupo(Integer rol_grupo_id, String nombre) {
        this.rol_grupo_id = rol_grupo_id;
        this.nombreRolGrupo = nombre;
    }

    public Integer getRol_grupo_id() {
        return rol_grupo_id;
    }

    public void setRol_grupo_id(Integer rol_grupo_id) {
        this.rol_grupo_id = rol_grupo_id;
    }

    public String getNombre() {
        return nombreRolGrupo;
    }

    public void setNombre(String nombre) {
        this.nombreRolGrupo = nombre;
    }

    /*public List<RolesGrupoRol> getRolesGrupoRolList() {
        return rolesGrupoRolList;
    }

    public void setRolesGrupoRolList(List<RolesGrupoRol> rolesGrupoRolList) {
        this.rolesGrupoRolList = rolesGrupoRolList;
    }*/
}
