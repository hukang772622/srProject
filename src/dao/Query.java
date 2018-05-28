package dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 消息查询
 */
public interface Query {

    /**
     * 根据手机号,时间段,端口号查询记录
     * @param mobile
     * @param startTime
     * @param endTime
     * @param port
     * @return
     */
    List<Map<String, Object>> query(String mobile, Date startTime, Date endTime, Integer port);
}
