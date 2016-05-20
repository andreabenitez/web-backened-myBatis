package servicios;

import config.SqlSessionFactoryProvider;
import mapper.UsuarioMapper;
import modelos.RolesGrupoRol;
import modelos.Usuario;
import org.apache.ibatis.session.SqlSession;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by sonia on 18/05/16.
 */

@Stateless
public class UsuarioServicioMapperImpl {

    @EJB
    private SqlSessionFactoryProvider sqlSessionFactoryProvider;

    @EJB
    private UsuarioServicioMapperImpl usuarioServicioMapper;

    public List<Usuario> getUsuarios()  {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
            return sqlSession.selectList("getUsuarios");
        } finally {
            sqlSession.close();
        }
    }

    public Usuario getUsuarioByUsername(String username)  {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
            Usuario usuario = usuarioMapper.getUsuarioByUsername(username);
            return usuario;
        } finally {
            sqlSession.close();
        }
    }

    public List<RolesGrupoRol> getRolesGrupoRol (Integer id) {
        SqlSession sqlSession = sqlSessionFactoryProvider.getSqlSessionFactory().openSession();
        try {
            UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
            return usuarioMapper.getRolesGrupoRol(id);
        } finally {
            sqlSession.close();
        }
    }

}
