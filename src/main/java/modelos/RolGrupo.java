package modelos;

import java.util.List;

/**
 * Created by andrea on 17/05/16.
 */
public class RolGrupo {

    private Integer rol_grupo_id;
    private String nombre;
    //private List<RolesGrupoRol> rolesGrupoRolList;

    public RolGrupo(){
    }

    public RolGrupo(Integer rol_grupo_id, String nombre) {
        this.rol_grupo_id = rol_grupo_id;
        this.nombre = nombre;
    }

    public Integer getRol_grupo_id() {
        return rol_grupo_id;
    }

    public void setRol_grupo_id(Integer rol_grupo_id) {
        this.rol_grupo_id = rol_grupo_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*public List<RolesGrupoRol> getRolesGrupoRolList() {
        return rolesGrupoRolList;
    }

    public void setRolesGrupoRolList(List<RolesGrupoRol> rolesGrupoRolList) {
        this.rolesGrupoRolList = rolesGrupoRolList;
    }*/
}
