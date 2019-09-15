package com.atguigu.mybatis_plus;

import com.atguigu.mybatis_plus.entity.User;
import com.atguigu.mybatis_plus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryWrapperTests {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testDelete() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper
                .isNull("name")
                .ge("age",15)
                .isNotNull("email");

        int result = userMapper.delete(queryWrapper);
        System.out.println(result);

    }

    @Test
    public void testSelectOne() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("name", "");

        User user = userMapper.selectOne(queryWrapper);

        System.out.println(user);
    }

    @Test
    public void testSelectCount() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.between("age", 20, 30);

        Integer count = userMapper.selectCount(queryWrapper);
        System.out.println(count);
    }
    @Test
    public void testSelectList() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "lyf");
        map.put("age", 18);
        map.put("email", "lyf@163.com");

        queryWrapper.allEq(map);

        List<User> users = userMapper.selectList(queryWrapper);

        users.forEach(System.out::println);

    }

    @Test
    public void testSelectMaps() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper
                .like("name", "a")
                .likeRight("email", "t");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void testSelectObjs() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.inSql("id", "select id from user where id<5");

        List<Object> objects = userMapper.selectObjs(queryWrapper);

        objects.forEach(System.out::println);
    }

    @Test
    public void testUpdateWrapper() {

        User user = new User();

        user.setName("haha");
        user.setAge(100);

        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .like("name", "an")
                .or()
                .ge("age",28);
        int update = userMapper.update(user, updateWrapper);

        System.out.println(update);
    }

    @Test
    public void testUpdateWrapper2() {
        User user = new User();
        user.setName("xixi");
        user.setAge(10);

        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .like("name", "ah")
                .or(i -> i.eq("name", "lyf").ne("age", 18));
        int update = userMapper.update(user, updateWrapper);
        System.out.println(update);
    }

    @Test
    public void testSelectListOrderBy() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectListLast() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.last("limit 2");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectListSelect() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name", "age");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectListSelec() {
        User user = new User();
        user.setAge(1000);

        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .like("name", "ix")
                .set("name", "tly")
                .setSql("email='tly@123.com'");

        int update = userMapper.update(user, updateWrapper);

        System.out.println(update);
    }
}
