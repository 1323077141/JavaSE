package day08.com.atguigu.TestGeneralClass;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 与实践相关的类:
 * 1.System类:currentTimeMillis()
 * 2.Date类:java.util.Date以及其子类java.sql.Date
 * 3.simpleDateFormat类:java.text.SimpleDateFormat(易于国际化)
 * 4.Calender类:
 *
 */
public class TestDate {

    @Test
    public void test3(){
        Calendar c = Calendar.getInstance();
        c.get(Calendar.DAY_OF_MONTH);
        c.add(Calendar.DAY_OF_MONTH,-2);

        c.set(Calendar.DAY_OF_MONTH,23);
        Date d = c.getTime();
        System.out.println(d);

    }


    @Test
    public void test2() throws Exception{
        //格式1
        SimpleDateFormat sdf = new SimpleDateFormat();
        String date = sdf.format(new Date());
        System.out.println(date);
        //格式2
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = sdf.format(new Date());
        System.out.println(date1);

        //3.解析:
        Date date2 = sdf.parse(date1);
        System.out.println(date2);
    }


    @Test
    public void test1(){
        Date d1 = new Date();
        System.out.println(d1.toString());



    }

}
