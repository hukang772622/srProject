package receive.service.serviceImpl;

import dao.daoImpl.QueryImpl;
import receive.service.QueryMessage;

import java.util.*;

public class QueryMessageImpl implements QueryMessage {

    private QueryImpl queryImpl = new QueryImpl();

    @Override
    public Map<String, String> query(String mobile, Date startTime, Date endTime, Integer port) {
        Map<String, String> map = new HashMap<>();
        try {
            List<Map<String, Object>> list = queryImpl.query(mobile, startTime, endTime, port);
            for (Map<String, Object> m : list) {
                String key = m.get("MsgArrivedTime") + "&_&" + m.get("Sender") + "&_&" + m.get("CommPort");
                String value = map.get(key);
                if (value != null) {
                    value += m.get("MsgTitle");
                    map.put(key, value);
                } else {
                    map.put(key, (String) m.get("MsgTitle"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
