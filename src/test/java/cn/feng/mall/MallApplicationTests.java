package cn.feng.mall;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootTest
public class MallApplicationTests {

    @Test
    public void jdbcall() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动类
        String url="jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false";
        String username="root";
        String password="microlab";
        Connection conn= DriverManager.getConnection(url,username,password);//用参数得到连接对象
        System.out.println("连接成功！");
        System.out.println(conn);
    }


}
