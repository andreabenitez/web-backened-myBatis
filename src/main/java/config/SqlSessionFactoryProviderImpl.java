package config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;

@Local(SqlSessionFactoryProvider.class)
@Named
@Stateless
public class SqlSessionFactoryProviderImpl implements SqlSessionFactoryProvider {
    @Produces
    @ApplicationScoped
    @Override
    public SqlSessionFactory produceFactory() throws IOException {
        String resource = "database-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
}

