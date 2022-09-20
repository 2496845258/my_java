package main2;

import com.mysql.cj.jdbc.Driver;

import javax.annotation.Resource;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class Mysql {


    public static void main(String[] args) throws Exception {
        var userDao = new UserDaoImpl();

        userDao.findAll().stream().forEach(System.out::println);
    }
}
