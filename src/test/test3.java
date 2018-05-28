package test;

import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Administrator on 2018/4/28.
 */
public class test3 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stat = null;
        try {
            con = JDBCUtil.getConnection();
            String mobile = "13913167747";
            String s = null;
            String s1 = "能不能行";
            String s2 = null;
            String sql = "insert into MSG_Outbox values('+1+','+2+','+s+','+ mobile + ','+ 0 +','+ s1 + ','+ s2 + ','+ time +','+12+')";
            stat = con.prepareStatement(sql);
            stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
