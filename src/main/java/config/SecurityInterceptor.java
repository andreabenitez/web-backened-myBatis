package config;

/*
 * Created by andrea on 17/05/16.
 */


import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/*
 * This interceptor verify the access permissions for a user
 * based on username and passowrd provided in request
 *

*/

public class SecurityInterceptor
{
    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception
    {
        /*logger.debug("AuthorizationInterceptor - before EJB method invoke: "
                + ctx.getMethod().getName());

        try{
            authorizationCheck();
        } catch(Exception e){
            logger.debug("Authorization check failed");
            throw e;
        }*/
        System.out.println("Llego aca");

        return ctx.proceed();
    }

}
