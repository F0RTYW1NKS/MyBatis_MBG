package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageHelperTest {

    @Test
    public void testPageHelper(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //Page<Object> page = PageHelper.startPage(2, 4);
            PageHelper.startPage(2, 4);
            List<Emp> emps = mapper.selectByExample(null);
            PageInfo<Emp> empPageInfo = new PageInfo<>(emps, 5);
            System.out.println(empPageInfo);

            //for(Emp emp : emps){
            //    System.out.println(emp);
            //}
            //根据条件查询
            //EmpExample empExample = new EmpExample();
            //empExample.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThan(20);
            //empExample.or().andDidIsNotNull();
            //List<Emp> emps1 = mapper.selectByExample(empExample);
            //System.out.println(emps1);





        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
