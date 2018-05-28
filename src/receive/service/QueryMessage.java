package receive.service;

import java.util.Date;
import java.util.Map;

/**
 * 消息查询
 */
public interface QueryMessage {

    /**
     * 根据手机号,时间段,端口号查询记录
     * @param mobile
     * @param startTime yyyy-MM-dd HH:mm:ss
     * @param endTime yyyy-MM-dd HH:mm:ss
     * @param port
     * @return
     */
    Map<String, String> query(String mobile, Date startTime, Date endTime, Integer port);
}
