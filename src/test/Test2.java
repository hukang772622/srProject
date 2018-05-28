package test;

import damain.Message;

import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2018/4/24.
 */
public class Test2 {
    public static void main(String[] args) throws SQLException {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        Connection connection = dataSource.getConnection();
//        System.out.println(connection);
//        connection.close();
        Message message = new Message();
        message.setMessage("再来试一次");
        message.setMobile("13913167747");
        message.setPort(12);
        message.setTime(60000);
        DBConnectionPool test = new DBConnectionPool();
        try {
            test.executeSQL("INSERT INTO MSG_Outbox VALUES (?,?,?,?,?,?,?,?,?)", new Object[]{1, 2,"",message.getMobile(),0,message.getMessage(),"",new Timestamp(System.currentTimeMillis() + 10000),message.getPort()});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}