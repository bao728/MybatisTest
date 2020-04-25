package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtiil {
    private static SqlSessionFactory sqlSessionFactory = null;
    static{
        // 获取mybatis的sqlsessionfactory的对象
        String resource = "mybatis-config.xml";
        try{
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //获取sqlsession的对象
    public static SqlSession getSqlsession(){
        return sqlSessionFactory.openSession();
    }
}
