package com.atguigu.mybatis_plus;

import com.atguigu.mybatis_plus.entity.User;
import com.atguigu.mybatis_plus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CRUDTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("lyf");
        user.setAge(18);
        user.setEmail("lyf@163.com");

        int result = userMapper.insert(user);

        System.out.println(result);
        System.out.println(user);
    }

    @Test
    public void testUpdateById() {
        User user = new User();
        user.setId(1L);
        user.setAge(8);

        int result = userMapper.updateById(user);
        System.out.println(result);
    }
    /**
     * 测试乐观锁
     */
    @Test
    public void testOptimisticLocker() {
        User user = userMapper.selectById(1L);
        user.setName("haha1");
        user.setEmail("haha1@qq.com");

        User user1 = userMapper.selectById(1L);
        user1.setName("xxx");
        user1.setEmail("xxx@qq.com");
        userMapper.updateById(user1);

        userMapper.updateById(user);

    }
    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1L);

        System.out.println(user);

    }

    @Test
    public void testSelectBatchById() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));

        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap() {

        HashMap<String, Object> map = new HashMap<>();

        map.put("name", "xxx");
        map.put("age", 8);

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectPage() {
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);

        List<User> pages = page.getRecords();
        pages.forEach(System.out::println);

        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getCurrent());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());

    }

    @Test
    public void testSelectMapsPage() {

        Page<User> page = new Page<>(1, 5);
        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, null);

        List<Map<String, Object>> maps = mapIPage.getRecords();
        maps.forEach(System.out::println);

        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasPrevious());
        System.out.println(page.hasNext());
    }

    @Test
    public void testDeleteById() {

        int result = userMapper.deleteById(1149183144604270593L);

        System.out.println(result);

    }
    @Test
    public void testDeleteBatcherIds() {

        int i = userMapper.deleteBatchIds(Arrays.asList(1, 1149182993106001922L));

        System.out.println(i);
    }

    @Test
    public void testDeleteByMap() {

        HashMap<String, Object> map = new HashMap<>();

        map.put("name", "Billie");
        map.put("age", 24);

        int result = userMapper.deleteByMap(map);

        System.out.println(result);
    }

    @Test
    public void testLogicDelete() {
        int i = userMapper.deleteById(2L);

        System.out.println(i);
    }




}
