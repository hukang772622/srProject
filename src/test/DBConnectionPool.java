package test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

/**
 * c3p0 的 jdbc连接池
 *
 * @author 森森
 *
 */
public class DBConnectionPool {
    protected DBConnectionPool() {
    }

    protected static synchronized Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.hxtt.sql.access.AccessDriver"); //JDBC-ODBC桥接器
            con = DriverManager.getConnection("jdbc:Access:///d:/酷卡/MMSCRM.mdb","","");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
    /**
     * 查询通用方法
     *
     * @param sql
     * @param params
     * @return
     */
    public ResultSet query(String sql, Object[] params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn = this.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    /**
     * 修改 增加 删除通用方法
     *
     * @param sql
     * @param params
     * @return
     */
    public int executeSQL(String sql, Object[] params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        conn = this.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}