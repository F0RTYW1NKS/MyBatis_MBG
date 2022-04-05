package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.DeptExample;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MBGTest {
    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
            //List<Emp> emps = mapper.selectByExample(null);
            //for(Emp emp : emps){
            //    System.out.println(emp);
            //}
            //根据条件查询
            EmpExample empExample = new EmpExample();
            empExample.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThan(20);
            empExample.or().andDidIsNotNull();
            List<Emp> emps1 = mapper.selectByExample(empExample);
            System.out.println(emps1);
            System.out.println("hot-fix test");

            //修改
            mapper.updateByPrimaryKey(new Emp(1, "admin", 22, "女", "123@qq.com", 3));




        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
