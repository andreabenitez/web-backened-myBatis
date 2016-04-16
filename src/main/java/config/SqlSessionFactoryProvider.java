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

    @Produces
    @ApplicationScoped
    public SqlSessionFactory produceFactory() throws IOException {
        String resource = "database-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

}
