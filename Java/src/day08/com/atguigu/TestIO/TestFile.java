package day08.com.atguigu.TestIO;

import org.junit.Test;

import java.io.File;
import java.util.Date;

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
     * 文件操作相关:
     * createNewFile() 创建文件
     * delete() 删除文件
     *
     * 目录操作相关:
     * mkDir() 创建文件目录,只在上层目录存在时创建成功
     * mkDirs() 创建多级目录，若上层目录不存在，一并创建
     * list() 返回值为String[]
     * listFiles() 返回值为File[]
     *
     */
    @Test
    public void test3() throws Exception{
        File file1 = new File("F:\\MyFiles\\hello.txt");
        System.out.println(file1.delete());
        if (!file1.exists()){
            Boolean flag = file1.createNewFile();
            System.out.println(flag);
        }

        File file2 = new File("F:\\MyFiles\\io\\io2");
        if (!file2.exists()){
            System.out.println(file2.mkdir());
        }

        File file3 = new File("F:\\MyFiles");
        String [] list = file3.list();
        for (int i = 0; i < list.length ; i++){
            System.out.println(list[i]);
        }
        System.out.println();
        File[] files = file3.listFiles();
        for (int i = 0; i < files.length ; i++){
            System.out.println(files[i].getName());
        }

    }

    /**
     * 文件检测：
     * exits() 是否存在
     * canWrite() 是否可写
     * canRead() 是否可读
     * isFile() 是否为文件
     * isDirectory() 是否为文件夹
     *
     * 获取常规文件信息:
     * lastModified()  最后修改时间
     * length()  文件内容长度
     *
     */
    @Test
    public void test2(){
        File file1 = new File("F:\\MyFiles\\hello.txt");   //D:/Java/MyProject/others/Mysql.txt
        File file2 = new File("hello.txt");
        File file3 = new File("F:\\MyFiles\\io");

        System.out.println(file1.exists()); //false,true
        System.out.println(file1.canWrite());//false,true
        System.out.println(file1.canRead());//false，true
        System.out.println(file1.isFile());//false，true
        System.out.println(file1.isDirectory());//false
        System.out.println(new Date(file1.lastModified())); //0，1529675945348(Fri Jun 22 21:59:05 CST 2018)
        System.out.println(file1.length()); //0，6
        System.out.println();
        System.out.println(file3.exists());//true
        System.out.println(file3.canWrite());//true
        System.out.println(file3.canRead());//true
        System.out.println(file3.isFile());//false
        System.out.println(file3.isDirectory());//true
        System.out.println(file3.lastModified());//1529675967841
        System.out.println(file3.length());//0


    }


    /**
     * 绝对路径
     * 相对路径 当前文件目录下的文件的路径
     * 访问文件名:
     * getName()
     * getPath()
     * getAbsolutionFile()
     * getAbsolutionPath()
     * getParent()
     * renameTo(File newName)
     *
     */
    @Test
    public void test1(){
        File file1 = new File("F:\\MyFiles\\hello.txt");   //D:/Java/MyProject/others/Mysql.txt
        File file2 = new File("hello.txt");

        File file3 = new File("F:\\MyFiles\\io");
        System.out.println(file1.getName());  //hello.txt
        System.out.println(file1.getPath());  //F:\MyFiles\hello.tx
        System.out.println(file1.getAbsoluteFile());//F:\MyFiles\hello.tx
        System.out.println(file1.getAbsolutePath());//F:\MyFiles\hello.tx
        System.out.println(file1.getParent());//F:\MyFiles

        System.out.println();
        System.out.println(file3.getName()); //hello.txt
        System.out.println(file3.getPath()); //hello.txt
        System.out.println(file3.getAbsoluteFile());//D:\soft\IDEA\codes\JavaSE\Java\hello.txt
        System.out.println(file3.getAbsolutePath());//D:\soft\IDEA\codes\JavaSE\Java\hello.txt
        System.out.println(file3.getParent());//null

        System.out.println();
        System.out.println(file2.getName());  //hello.txt
        System.out.println(file2.getPath());  //F:\MyFiles\hello.tx
        System.out.println(file2.getAbsoluteFile());//F:\MyFiles\hello.tx
        System.out.println(file2.getAbsolutePath());//F:\MyFiles\hello.tx
        System.out.println(file2.getParent());//F:\MyFiles

        //file1重命名为file2，要求file1文件一定存在，file2要求一定不存在,且file1与file2同为文件或文件目录，才能重命名成功
        //Boolean file1.renameTo(file2);


    }

}
