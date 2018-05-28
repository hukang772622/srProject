package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/24.
 */
public class TestTime {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        String s = "2018:04:24 15:20:00";
        Date d = sdf.parse(s);
        System.out.println(d);
    }
}
