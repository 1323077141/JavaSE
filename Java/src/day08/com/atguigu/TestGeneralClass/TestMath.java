package day08.com.atguigu.TestGeneralClass;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TestMath {

    @Test
    public void test1(){
        BigInteger bi = new BigInteger("123456789");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        System.out.println(bd.divide(bd2,BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2,15,BigDecimal.ROUND_HALF_UP));


    }

}
