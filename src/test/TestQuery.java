package test;

import receive.service.QueryMessage;
import receive.service.serviceImpl.QueryMessageImpl;
import utils.TimeUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2018/4/24.
 */
public class TestQuery {
    private static QueryMessage queryMessage = new QueryMessageImpl();
    public static void main(String[] args) throws ParseException {
//        test();
        test2();
    }

    public static void test2() throws ParseException {
//        String mobile = "13913167747";
        String s = "2018-04-24 9:49:33";
        String e = "2018-04-24 19:49:33";
        Date startTime = TimeUtil.toDate(s);
        Date endTime = TimeUtil.toDate(e);
//        int port = 12;

        Map<String, String> messages = queryMessage.query(null,startTime,endTime,null);
        Set<String> set = messages.keySet();
        for (String key : set) {
            System.out.println(messages.get(key).replace("\n",""));
        }
    }

    public static void test() throws ParseException {
        String mobile = "106593111";
        String s = "2018-04-24 9:49:33";
        String e = "2018-04-24 9:49:33";
        Date startTime = TimeUtil.toDate(s);
        Date endTime = TimeUtil.toDate(e);
        int port = 12;

        Map<String, String> messages = queryMessage.query(mobile,startTime,endTime,port);
        Set<String> set = messages.keySet();
        for (String key : set) {
            System.out.println(messages.get(key));
        }
    }
}
