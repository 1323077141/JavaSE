#### 一. Java 配置
##### 1.命令行操作
| 命令 | 作用 | 
| :---: | :---: |
| dir | 查看目录 |
| md | 创建目录 |
| rd | 删除目录 |
| cd | 进入指定目录 |
| cd.. | 到上一级目录 |
| cd/ | 退回到根目录 |
| del | 删除文件|
| exit | 退出命令行操作 |
##### 2.path环境变量
1).系统变量中增加
   JAVA_HOME：JDK中bin的上一级目录  
2).在系统变量中的Path中增加 
   %JAVA_HOME%\bin  
##### 3.Java编译运行
######源文件：  
1).源文件以.java 结尾  
2).源文件中可以声明多个类  
3).一个源文件只能有一个public的类，并且该类名与源文件名一致
###### 编译生成.class字节码:
javac 文件名(带后缀)  
###### 运行.class 文件:
java 文件名 
###### 注释文档的生成:
javadoc -d 生成的文件名 -author -version 源文件(生成在当前目录下)  
#### 二. Java 基本语法
##### 1.关键字
| 类型 | 种类 |
| :---: | :---: |
| 数据类型 | class,interface,enum,byte,short,int,long,float,double,char,boolean,void|
| 数据类型值 | true,false,null|
| 流程控制 | if,else,switch,case,default,while,do,for,foreach,break,continue,return |
| 权限修饰 | private,public,protected |
| 定义类，函数，变量 | abstract,final,static,synchronized |
| 类与类之间的关系 | extends,implement |
| 建立实例 | new,this,super,instanceof |
| 异常处理 | try,catch,finally,throw,throws |
| 包名 | package,import |
| 其他 | native,strictfp,transient,volatile,assert |
##### 2.变量内存
| 内存 | 变量类型 |
| :---: | :---: |
| 栈 | 局部变量，对象声明的引用 |
| 堆 | 类实例，数组实例(含变量成员) |
| 静态域 | 静态变量 |
| 常量池(方法区) | 字符串常量 | 
##### 3.变量数据类型分类
| 数据类型 | 种类 |
| :---: | :---: |
|byte(1字节),short(2),int(4),long(8),float(4),double(8),char(2),boolean(1)| 基本类型|
| class,interface,数组  | 引用数据类型 |
##### 4.变量之间的转换
(不考虑布尔类型,即 char byte short int long float double)  
1)自动类型转换  
char,byte,short ===> int ===> long ===> float ===> double  
PS:short 与 byte 与 char 之间运算应为 int 类型  
2)强制类型转换  
容量大的变成容量小的，会导致精度的损失.  
String  也是一猴子那个数据类型,属于类的一种.    
String 与 基本类型之间的运算，只能是连接运算.
##### 5.算数运算符
+= 与 = .. + .. 的区别:  
如short s = 10;
s = s + 3; //编译不通过  
s = (short)( s + 3) ; //易损失精度  
s += 3;  //s 本身的基础上加上3，既可以实现运算，又不会更改s的数据类型  
在switch 中的变量类型为：char,byte,short,int,String(jdk1.7以后),枚举
##### 6.数组
1) 默认值
byte,short,long,int：0；  
float,double:0.0;  
char:空格;  
boolean:false;  
引用类型为null;  
#### 三.面向对象思想
##### 1.面向对象的封装性
1)成员变量与局部变量的区别:
成员变量有默认值，而局部变量无，必须显式的赋值才能使用。  
成员变量在堆空间中，而局部变量在栈空间中。
2)方法的重载和重写:  
方法的标识为方法名和参数列表。
重载(overload): 方法名相同,参数列表(参数类型,个数,不同类型的顺序)不同,与方法返回值无关  
重写(overwrite/override)：出现与继承中,方法名，参数列表，返回值与父类相同   
2)可变个数的形参:  
格式: String ... args  
与数组是一致的,因此String[] 与 String ... 构不成重载;
若参数列表中含有其他类型，则可变参数一定要写在其他类型最后,如:int i,String ... args  
3)方法的参数值传递机制  
形参:方法定义时的参数  
形参:调用方法时传入的值  
值传递机制:
 形参是基本数据类型:形参值的变化不会改变实参的值  
 形参是引用类型:改变形参值会改变实参值  
 ##### 2.面向对象的继承性
 1)父类(或基类),父类中的方法或属性在子类中可使用super(构造器中)或this调用  
 子类可以扩展父类的方法  
 只能单继承  
 2)方法的重写  
 子类集成父类；若父类的方法对子类不使用，则子类可以对该父类方法重写、覆盖、覆写  
 要求：  
 ①返回值，方法名，参数列表与父类相同  
 ②子类方法的修饰符必须大于或等于父类的修饰符(private<default<protected<public)(class 只能用public default修饰)  
 ③若父类方法抛异常，则子类抛出的方法异常小于或等于父类的异常  
 ④子类或父类的方法必须同为static 或非 static  
 3)super关键字  
 super可访问父类的属性，调用父类的方法，在子类构造器中调用父类的构造器  
 PS:super 不限于直接父类;this 代表本类对象的引用，super代表父类的内存空间的标识
 ##### 3.面向对象的多态性



