package servicios;

import config.SqlSessionFactoryProvider;
import excepciones.NotAuthorizedException;
import mapper.UsuarioMapper;
import modelos.RolesGrupoRol;
import modelos.Usuario;
import org.apache.ibatis.session.SqlSession;
import utils.UsuarioUtil;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;
import java.util.UUID;

/**
 * Created by sonia on 18/05/16.
 */

@Stateless
public class UsuarioServicioMapperImpl {

    @EJB
    private SqlSessionFactoryProvider sqlSessionFactoryProvider;

    @EJB
    private UsuarioServicioMapperImpl usuarioServicioMapper;

    public List<Usuario> getUsuarios() {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            return sqlSession.selectList("getUsuarios");
        } finally {
            sqlSession.close();
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Usuario getUsuarioByUsername(String username) {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
            Usuario usuario = usuarioMapper.getUsuarioByUsername(username);
            return usuario;
        } finally {
            sqlSession.close();
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Usuario getUsuarioByAccessToken(String accessToken) {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
            Usuario usuario = usuarioMapper.getUsuarioByAccessToken(accessToken);
            return usuario;
        } finally {
            sqlSession.close();
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int modificarUsuario(Usuario usuario){
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            return sqlSession.update("modificarUsuario", usuario);
        } finally {
            sqlSession.close();
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<RolesGrupoRol> getRolesGrupoRol(Integer id) {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
            return usuarioMapper.getRolesGrupoRol(id);
        } finally {
            sqlSession.close();
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String authorization(UsuarioUtil usuarioUtil) throws NotAuthorizedException, Exception{
        boolean isAllowed = false;

        Usuario usuario = usuarioServicioMapper.getUsuarioByUsername(usuarioUtil.getUsername());
        if (usuarioUtil.getPassword() != null && usuario.getPassword() != null) {
            if (usuarioUtil.getPassword().equals(usuario.getPassword())) {
                if(usuario.getAccess_token() == null) {
                    String authToken = UUID.randomUUID().toString();
                    usuario.setAccess_token(authToken);
                    usuarioServicioMapper.modificarUsuario(usuario);
                }
                isAllowed = true;
            }
        }
        if (isAllowed){
            return usuario.getAccess_token();
        }else{
            throw new NotAuthorizedException("El username y password no son validos");
        }
    }

}
