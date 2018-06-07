package day08.com.atguigu.TestException;

/**
 *  java.lang.Object
 *      |----java.lang.Throwable
                 |-------java.lang.Error：错误，java程序对此无能为力，不显式的处理
                 |-------java.lang.Exception:异常。需要进行处理
                     |------RuntimeException:运行时异常
                        |-----ArrayIndexOutOfBoundsException/NullPointerException/ArithmeticException/ClassCastException
                     |------非RuntimeException:编译时异常
                        |-----SQLException/ClassNotFoundException/IOException
 *
 * Error错误
 */
public class TestError {

    public static void main(String[] args){
        main(args);    //java.lang.StackOverFlowError(Stack)
        byte[] b = new byte[1024*1024*600];   //java.lang.OutOfMemoryError(Heap)
    }
}
