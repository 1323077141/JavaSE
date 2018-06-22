package day08.TestIO;

import org.junit.Test;

import java.io.File;

/**
 * java.io.File
 * File是一个类，可以有构造器创建器对象.此对象对应文件或文件夹
 * 1.File既可以表示一个文件（.doc  .xls   .mp3  .avi   .jpg  .dat），也可以表示一个文件目录！
 * >2.File类的对象是与平台无关的。
 * >3.File类针对于文件或文件目录，只能进行新建、删除、重命名、上层目录等等的操作。如果涉及到访问文件的内容，File
 * 是无能为力的，只能使用IO流下提供的相应的输入输出流来实现。
 * >4.常把File类的对象作为形参传递给相应的输入输出流的构造器中！
 */
public class TestFile {
    /**
     * 绝对路径
     * 相对路径 当前文件目录下的文件的路径
     */
    @Test
    public void test1(){
        File file1 = new File("D:\\Java\\MyProject\\others\\Mysql.txt");   //D:/Java/MyProject/others/Mysql.txt
        File file2 = new File("hello.txt");
    }

}
