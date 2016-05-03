package config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.io.IOException;
import java.io.InputStream;

/*@Local(SqlSessionFactoryProvider.class)
@Named
@Stateless*/
public class SqlSessionFactoryProvider {

    private static SqlSessionFactory sqlSessionFactory;

    @Produces
    @ApplicationScoped
    public static SqlSessionFactory produceFactory() throws IOException {
        String resource = "database-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
}

