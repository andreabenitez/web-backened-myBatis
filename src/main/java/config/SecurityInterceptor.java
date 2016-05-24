package config;

import modelos.RolGrupo;
import modelos.Roles;
import modelos.RolesGrupoRol;
import modelos.Usuario;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;
import servicios.UsuarioServicioMapperImpl;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by andrea on 19/05/16.
 */
@Provider
@ServerInterceptor
public class SecurityInterceptor implements PreProcessInterceptor
{

    @Inject
    private UsuarioServicioMapperImpl usuarioServicioMapper;

    private static final String AUTHORIZATION_PROPERTY = "Authorization";
    private static final String AUTHENTICATION_SCHEME = "Basic";
    private static final ServerResponse ACCESS_DENIED = new ServerResponse("Access denied for this resource", 401, new Headers<Object>());;
    private static final ServerResponse ACCESS_FORBIDDEN = new ServerResponse("Nobody can access this resource", 403, new Headers<Object>());;
    private static final ServerResponse SERVER_ERROR = new ServerResponse("INTERNAL SERVER ERROR", 500, new Headers<Object>());;

    @Override
    public ServerResponse preProcess(HttpRequest request, ResourceMethod methodInvoked) throws Failure, WebApplicationException
    {
        Method method = methodInvoked.getMethod();

        //Access allowed for all
        if(method.isAnnotationPresent(PermitAll.class))
        {
            return null;
        }
        //Access denied for all
        if(method.isAnnotationPresent(DenyAll.class))
        {
            return ACCESS_FORBIDDEN;
        }

        //Get request headers
        final HttpHeaders headers = request.getHttpHeaders();

        //Fetch authorization header
        final List<String> authorization = headers.getRequestHeader(AUTHORIZATION_PROPERTY);

        //If no authorization information present; block access
        if(authorization == null || authorization.isEmpty())
        {
            return ACCESS_DENIED;
        }

        /*//Get encoded username and password
        final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");

        //Decode username and password
        String usernameAndPassword;
        try {
            usernameAndPassword = new String(Base64.decode(encodedUserPassword));
        } catch (IOException e) {
            return SERVER_ERROR;
        }*/

        final String access_token = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");

        /*//Split username and password tokens
        final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
        final String username = tokenizer.nextToken();
        final String password = tokenizer.nextToken();

        //Verifying Username and password
        System.out.println(username);
        System.out.println(password);*/


        //Verify user access
        if(method.isAnnotationPresent(RolesAllowed.class))
        {
            RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
            Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));

            //Is user valid?
            if( ! isUserAllowed(access_token, rolesSet))
            {
                return ACCESS_DENIED;
            }
        }

        //Return null to continue request processing
        return null;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    private boolean isUserAllowed(/*final String username, final String password,*/String access_token,	final Set<String> rolesSet)
    {
        boolean isAllowed = false;

        Usuario usuario = usuarioServicioMapper.getUsuarioByAccessToken(access_token);

        if(usuario != null) {
            RolGrupo rolGrupo = usuario.getRolGrupo();

            List<RolesGrupoRol> rolesGrupoRolList = usuarioServicioMapper.getRolesGrupoRol(rolGrupo.getRol_grupo_id());
            List<Roles> rolesListUsuario = new ArrayList<>();
            for (RolesGrupoRol rolesGrupoRol : rolesGrupoRolList){
                rolesListUsuario.add(rolesGrupoRol.getRole_id());
            }

            for(Roles roles : rolesListUsuario ){
                if (rolesSet.contains(roles.getNombre())) {
                    System.out.println("username:" + usuario.getUsername() + " operacion:" + roles.getNombre());
                    isAllowed = true;
                }
            }

        }

        return isAllowed;
    }

}

