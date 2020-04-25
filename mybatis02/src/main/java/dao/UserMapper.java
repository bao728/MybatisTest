package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectUser();
    User getUserById(int id);
    //插入一个用户
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);

    User getUserById2(Map<String, Object> map);

    //模糊查询
    List<User> getUserByLike(String value);
}
