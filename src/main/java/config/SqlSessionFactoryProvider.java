package config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by andrea on 16/04/16.
 */
public class SqlSessionFactoryProvider {

    private static SqlSessionFactory sqlSessionFactory;

    @Produces
    @ApplicationScoped
    public static SqlSessionFactory produceFactory() throws IOException {
        String resource = "database-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

}
