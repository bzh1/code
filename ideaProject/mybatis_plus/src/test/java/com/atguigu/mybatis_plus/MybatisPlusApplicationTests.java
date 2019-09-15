package com.atguigu.mybatis_plus;

import com.atguigu.mybatis_plus.entity.User;
import com.atguigu.mybatis_plus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {

        List<User> users = userMapper.selectList(null);

        users.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();

        user.setAge(18);
        user.setEmail("lyf@163.com");

        int result = userMapper.insert(user);

        System.out.println(result);
        System.out.println(user);
    }

    @Test
    public void test() {
        User user = new User();
        user.setId(1L);
        user.setAge(8);

        int result = userMapper.updateById(user);
        System.out.println(result);
    }

}
