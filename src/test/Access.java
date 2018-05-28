package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Access {

    public static void main(String[] args) throws Exception {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//这个驱动的地址不要改
        Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:\\酷卡\\MMSCRM.mdb","","");
        Statement stmt=con.createStatement();

        //查找数据
//        ResultSet rs = stmt.executeQuery("INSERT INTO MSG_Outbox VALUES (1,2,NULL ,'13913167747',0,'再来一次啊啊啊啊啊啊','','',12)");
//        while(rs.next()){
//            System.out.println(rs.getString("MsgTitle"));
//        }

//        //添加数据
        if(stmt.executeUpdate("INSERT INTO MSG_Outbox VALUES (1,2,NULL ,'13913167747',0,'再来一次啊啊啊啊啊啊',NULL ,NULL ,18)")>0){
            System.out.println("添加成功!!!");
        }else{
            System.out.println("添加失败!!!");
        }

        //其余的（增、删、改、查）操作和  MySQL Oracle 的基本一样
        //可以自己试验

    }
}
