package utils;

import java.sql.PreparedStatement;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2018/4/24.
 */
public class InsertUtil {
    /**
     * 发送短信参数封装
     * @param i
     * @param mobile
     * @param statement
     * @param message
     * @param port
     * @throws Exception
     */
    public static void insert(int i, String mobile, PreparedStatement statement, String message, Integer port, Integer time) throws Exception{
        statement.setInt(1, i + 1);
        statement.setInt(2, 2);
        statement.setString(3, "");
        statement.setString(4, mobile);
        statement.setInt(5, 0);
        statement.setString(6, message);
        statement.setString(7, "");
        statement.setTimestamp(8, new Timestamp(System.currentTimeMillis() + time));
        statement.setInt(9, port);
        statement.execute();
    }
}
