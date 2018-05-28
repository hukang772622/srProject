package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化工具
 */
public class TimeUtil {

    /**
     * 将字符串转换为时间
     * @param date yyyy-MM-dd HH:mm:ss
     * @return
     * @throws ParseException
     */
    public static Date toDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(date);
    }
}
