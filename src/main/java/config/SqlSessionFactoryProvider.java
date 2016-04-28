package config;

import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

/**
 * Created by andrea on 16/04/16.
 */

public interface SqlSessionFactoryProvider {

    SqlSessionFactory produceFactory() throws IOException;
}