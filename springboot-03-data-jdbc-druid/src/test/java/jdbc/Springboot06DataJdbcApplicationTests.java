package jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot06DataJdbcApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads()  throws Exception{
        System.out.println(dataSource.getClass());
        System.out.println("123");
        System.out.println(dataSource.getConnection());
    }

}
