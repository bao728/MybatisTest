package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import pojo.User;
import util.MybatisUtiil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void test1(){
        SqlSession sqlsession = MybatisUtiil.getSqlsession();
        System.out.println(sqlsession);

        UserMapper userDao = sqlsession.getMapper(UserMapper.class);
        List<User> users = userDao.selectUser();
        for(User user : users){
            System.out.println(user);
        }
        sqlsession.close();
    }

    @Test
    //根据id查询
    public void test3(){
        SqlSession sqlsession = MybatisUtiil.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlsession.close();
    }


    @Test
    //添加用户
    public void test2(){
        SqlSession sqlsession = MybatisUtiil.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        int i = mapper.addUser(new User(4, "宝", "baoge"));
        if(i>0){
            System.out.println("插入成功");
            sqlsession.commit();
        }
        sqlsession.close();
    }

    @Test
    //修改
    public void test4(){
        SqlSession sqlsession = MybatisUtiil.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        int i = mapper.updateUser(new User(4, "金", "123456"));
        if(i>0){
            System.out.println("修改成功");
            sqlsession.commit();
        }
        sqlsession.close();
    }

    @Test
    //删除用户
    public void test5(){
        SqlSession sqlsession = MybatisUtiil.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(4);
        if(i>0){
            System.out.println("删除 ");
            sqlsession.commit();
        }
        sqlsession.close();
    }
    @Test
    //测试map
    public void test6(){
        SqlSession sqlsession = MybatisUtiil.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        Map map = new HashMap();
        map.put("id",1);
        User userById2 = mapper.getUserById2(map);
        System.out.println(userById2);
        sqlsession.close();
    }


    @Test
    //测试模糊查询
    public void test7(){
        SqlSession sqlsession = MybatisUtiil.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        List<User> users = mapper.getUserByLike("李");
        for(User user: users){
            System.out.println(user);
        }
        sqlsession.commit();
    }



}
