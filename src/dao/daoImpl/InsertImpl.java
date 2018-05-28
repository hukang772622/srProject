package dao.daoImpl;

import damain.Message;
import dao.Insert;
import org.apache.commons.dbutils.QueryRunner;
import utils.JDBCUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 添加消息
 */
public class InsertImpl implements Insert{

    public void insert(List<Message> listMessages) {

        try {
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            Object[] params;
            String sql = "INSERT INTO MSG_Outbox VALUES (?,?,?,?,?,?,?,?,?)";
            Message message;
            Integer time;
            for (int i = 0; i < listMessages.size(); i++) {
                message = listMessages.get(i);
                time = message.getTime();
                if (time == null){
                    time = 60 * 1000;
                }
                params = new Object[]{i + 1, 2,"",message.getMobile(),0,message.getMessage(),"",new Timestamp(System.currentTimeMillis() + time),message.getPort()};
                queryRunner.update(sql, params);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
