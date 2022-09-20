package main2;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static main2.Tool.rb;
import static main2.Tool.rb_sql;


public class UserDaoImpl implements IUserDao{
    @Override
    public List<User> findAll() throws Exception {
        Class.forName(rb.getString("jdbc"));

        var conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("pwd"));

        var pst = conn.prepareStatement(rb_sql.getString("select"));

        var x = pst.executeQuery();

        var list = new ArrayList<User>();
        while ( x.next() ) {
            var user = new User();

            user.setUserid(x.getInt(1));
            user.setAccount(x.getString(2));
            user.setPasswd(x.getString(3));
            list.add(user);
        }
        return list;
    }
}
