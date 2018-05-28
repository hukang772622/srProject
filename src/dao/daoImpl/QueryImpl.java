package dao.daoImpl;

import dao.Query;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import utils.JDBCUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 消息查询
 */
public class QueryImpl implements Query{

    /**
     * 根据手机号,时间段,端口号查询记录
     * @param mobile
     * @param startTime
     * @param endTime
     * @param port
     * @return
     */
    public List<Map<String, Object>> query(String mobile, Date startTime, Date endTime, Integer port) {
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            List<Object> params = new ArrayList<>();
            StringBuilder sql = new StringBuilder("SELECT * FROM MSG_Inbox WHERE 1=1");
            if (mobile != null && !mobile.trim().isEmpty()) {
                sql.append(" and Sender like ?");
                params.add("%" + mobile + "%");
            }
            if (startTime != null) {
                sql.append(" and MsgArrivedTime >= ?");
                params.add(new Timestamp(startTime.getTime()));
            }
            if (endTime != null) {
                sql.append(" and MsgArrivedTime <= ?");
                params.add(new Timestamp(endTime.getTime()));
            }
            if (port != null) {
                sql.append(" and CommPort = ?");
                params.add(port);
            }
            list = queryRunner.query(sql.toString(), new MapListHandler(), params.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
