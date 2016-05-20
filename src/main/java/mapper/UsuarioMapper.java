package mapper;

import modelos.RolesGrupoRol;
import modelos.Usuario;

import java.util.List;

/**
 * Created by sonia on 18/05/16.
 */
public interface UsuarioMapper {

    List<Usuario> getUsuarios(Integer id);
    Usuario getUsuarioByUsername(String username);
    Usuario getUsuarioByAccessToken(String accessToken);
    List<RolesGrupoRol> getRolesGrupoRol (Integer id);
    int modificarUsuario(Usuario usuario);


}
