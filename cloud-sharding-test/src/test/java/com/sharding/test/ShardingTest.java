package com.sharding.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sharding.entity.Course;
import com.sharding.entity.Dict;
import com.sharding.entity.User;
import com.sharding.mapper.CourseMapper;
import com.sharding.mapper.DictMapper;
import com.sharding.mapper.UserMapper;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingTest {

    @Resource
    CourseMapper courseMapper;

    @Resource
    DictMapper dictMapper;

    @Resource
    UserMapper userMapper;

    @Test
    public void addCourse(){

        for (int i = 0; i < 10; i++) {
            Course course = new Course();
//            course.setCid(Long.valueOf(i));
            course.setCname("shardingSphere");
            course.setCstatus("1");
            course.setUserId(Long.valueOf(1000+i));
            courseMapper.insert(course);
        }
    }

    @Test
    public void queryCourse(){
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("cid");
        List<Course> courses = courseMapper.selectList(wrapper);
        courses.forEach(course -> System.out.println(course));
    }

    @Test
    public void rangeQueryCourse(){
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("cid");
        wrapper.between("cid",661531275361783808L,661531275642802177L);
        List<Course> courses = courseMapper.selectList(wrapper);
        courses.forEach(course -> System.out.println(course));
    }

    @Test
    public void rangeQueryCourse1(){
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.between("cid",661531275361783808L,661531275642802177L);
        wrapper.eq("user_id",1004L);
        List<Course> courses = courseMapper.selectList(wrapper);
        courses.forEach(course -> System.out.println(course));
    }

    @Test
    public void queryCourseHint(){
        HintManager hintManager = HintManager.getInstance();
        hintManager.addTableShardingValue("course",2);
        List<Course> courses = courseMapper.selectList(null);
        courses.forEach(course -> System.out.println(course));
        hintManager.close();
    }


    /**
     * 广播表
     */
    @Test
    public void addDict(){
        Dict d1 = new Dict();
        d1.setUstatus("1");
        d1.setUvalue("正常");
        dictMapper.insert(d1);

        Dict d2 = new Dict();
        d2.setUstatus("0");
        d2.setUvalue("不正常");
        dictMapper.insert(d2);

        for(int i = 0 ; i < 10 ; i ++){
            User user = new User();
            user.setUsername("user No "+i);
            user.setUstatus(""+(i%2));
            user.setUage(i*10);
            userMapper.insert(user);
        }
    }

    /**
     * 主从-读写分离
     */
    @Test
    public void addDictMS(){
        Dict d1 = new Dict();
        d1.setUstatus("1");
        d1.setUvalue("正常");
        dictMapper.insert(d1);
    }

    @Test
    public void queryDictMS(){

        List<Dict> dicts = dictMapper.selectList(null);
        dicts.forEach(dict -> System.out.println(dict));
    }
}
