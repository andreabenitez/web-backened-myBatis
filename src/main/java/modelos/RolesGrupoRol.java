package modelos;

/**
 * Created by andrea on 17/05/16.
 */
public class RolesGrupoRol {

    private Integer roles_grupo_rol_id;
    private Integer rol_grupo_id;
    private Integer role_id;

    public RolesGrupoRol(){}

    public Integer getRoles_grupo_rol_id() {
        return roles_grupo_rol_id;
    }

    public void setRoles_grupo_rol_id(Integer roles_grupo_rol_id) {
        this.roles_grupo_rol_id = roles_grupo_rol_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getRol_grupo_id() {
        return rol_grupo_id;
    }

    public void setRol_grupo_id(Integer rol_grupo_id) {
        this.rol_grupo_id = rol_grupo_id;
    }
}
