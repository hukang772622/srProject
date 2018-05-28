package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/4/25.
 */
public class JDBCUtil {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    /**
     * 返回一个连接对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 返回连接池对象
     * @return
     */
    public static DataSource getDataSource() {
        return dataSource;
    }
}
