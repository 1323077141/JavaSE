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
 ######1)父类(或基类),父类中的方法或属性在子类中可使用super(构造器中)或this调用  
 子类可以扩展父类的方法  
 只能单继承  
 ######2)方法的重写  
 子类集成父类；若父类的方法对子类不使用，则子类可以对该父类方法重写、覆盖、覆写  
 要求：  
 ①返回值，方法名，参数列表与父类相同  
 ②子类方法的修饰符必须大于或等于父类的修饰符(private<default<protected<public)(class 只能用public default修饰)  
 ③若父类方法抛异常，则子类抛出的方法异常小于或等于父类的异常  
 ④子类或父类的方法必须同为static 或非 static  
 ######3)super关键字  
 super可访问父类的属性，调用父类的方法，在子类构造器中调用父类的构造器  
 PS:super 不限于直接父类;this 代表本类对象的引用，super代表父类的内存空间的标识  
 ①构造器内部，super必须在第一行  
 ②在构造器内部，this 和super只能出现一个  
 ③在构造器中，不显示的调用this(形参) 或super(形参),默认调用父类空参构造器
 ##### 3.面向对象的多态性(向上转型,强转为向下转型)
 1)什么是多态性:  
 方法的重写与重载;子类对象的多态性;父类的引用指向子类的实体
 2)多态的实现  
 要有类的继承;子类必须对父类的方法进行重写;子类新添加的方法不能通过多态进行调用  
 3)程序运行时:  
 编译时，"看左边",将此引用变量理解为父类的类型  
 运行时，"看右边",关注真正对象的实体,即子类的对象，那么执行的方法就是子类重写的。  
 4)子类对象的多态性并不适用与属性  
 ##### 4.基本类
 #####1)Object 类及其equals方法  
 对于"=="号来说:
  ①基本数据类型：判断基本数据类型的值是否相等  
  ②引用数据类型:比较引用类型变量的地址值是否相等  
  equals:  
  ①只能处理引用类型变量
  ②在Object类的equals方法中仍然是比较地址值，因此，当要调用equals，子类要重写equals方法。  
 #####2）String 类(存放在字符串常量值)  
 ①如String str = "AA" ,于方法区的字符串常量池开辟空间  
 ②String str = new String("AA") ,于堆开辟空间,但是str指向的空间的值存储的是字符串常量池中"AA"的地址  
 #####3)toString():  
 ①Object 中的toString():return getClass().getName + "@" + Integer.toHexString(hasCode());//该对象所在堆空间实体的首地址  
 ②子类必须重写toString()方法  
 #####4)包装类的使用  
   ①.包装类和基本数据类型互相转换:  
   装箱：new Integer(value);自动装箱    
   拆箱: xxxValue();自动拆箱    
   ②.基本数据类型和String类:  
   基本数据类型->String:String.valueOf(value)  
   String -> 基本数据类型:parseXXX(str);boolean b = new Boolean("true");    
   ③.包装类和String类:  
   包装类 -> String：toString()    
   String -> 包装类:Integer i = new Integer(str)  
 #####5)static关键字  
  static 可以修饰方法，属性，代码块(或初始化块)，内部类  
  ①static修饰属性(类变量):存放在静态域中；随着类的加载而加载，而且只加载一次  
  ②static修饰方法(类方法):随着类的加载而加载，在内存中独一份;可以直接通过"类.类方法"调用;
  内部可以调用静态的方法和属性,不能调用非静态属性和方法;反之，非静态方法可以调用静态方法和属性(初始化的时间早);  
   注:静态结构(static的属性，方法，代码块，内部类)的生命周期要早于非静态结构,同时，被回收也要晚于非静态结构;  
   因此,static的方法是不可以有this,或super关键字;   
 #####6)初始化块  
  ①关于属性赋值的操作:默认的初始化;显示的初始化或初始化块(此处两个结构按照顺序执行);构造器中;通过方法对对象的属性进行修改;  
  ②初始化块:{},初始化块如果有修饰符，则只有static;   
  ③静态代码块(static{})：静态代码块只加载一次；加载要早于非静态代码块与构造器;多个静态代码块之间按照顺序执行  
  ④非静态代码块:可以有输出语句;可以对属性值进行操作;一个类中可以有多个非静态代码块;多个代码块之间按照顺序结构执行;
  非静态代码块在每次创建对象时都会执行;**静态代码块在构造器之前执行**;静态代码块中只能执行静态的结构(属性和方法);    
 #####7)final
  final 修饰类：该类不能被继承.如:String类，StringBuffer类,System类  
  final 修饰方法：不能被重写.如，Object的getClass()方法      
  final 修饰属性: 此属性为常量，用大写字符表示,一旦初始化，就不能再赋值。
  (此常量不能使用默认初始化;可以显示的赋值、代码块、构造器)；
  变量用static,final修饰，则为全局常量
 #####8)abstract
  abstract修饰类(抽象类):  
  ①不可被实例化;  
  ②抽象类有构造器 (凡是类都有构造器);  
  ③抽象方法所在的类，一定是抽象类;  
  ④抽象类中可以没有抽象方法  
  abstract修饰方法(抽象方法):  
  ①格式：没有方法体，包括{}.如：public abstract void eat();  
  ②抽象方法只保留方法的功能，而具体的执行，交给继承抽象类的子类，由子类重写此抽象方法;  
  ③若子类继承抽象类，并重写了所有的抽象方法，则此类是一个"实体类",即可以实例化;  
  ④若子类继承抽象类，没有重写所有的抽象方法，意味着此类中仍有抽象方法，则此类必须声明为抽象的  
  其他:  
  abstract 不能修饰属性，构造器(构造器不能被重写)，private(子类不能重写private方法),final ,static  
 #####9)interface
  1.接口可以看做是一个特殊的抽象类。是常量与抽象方法的一个集合，不能包含变量、一般的方法。  
  2.接口是没有构造器的。  
  3.接口定义的就是一种功能。此功能可以被类所实现（implements）。  
  4.实现接口的类，必须要重写其中的所有的抽象方法，方可实例化。若没有重写所有的抽象方法，则此类仍为一个抽象类  
  5.类可以实现多个接口。----java 中的类的继承是单继承的  
  6.接口与接口之间也是继承的关系，而且可以实现多继承  
  7.接口与具体的实现类之间也存在多态性  
  
 #####10)内部类
  1.相当于说，我们可以在类的内部再定义类。外面的类：外部类。里面定义的类：内部类  
  2.内部类的分类：成员内部类（声明在类内部且方法外的）vs 局部内部类(声明在类的方法里)  
  3.成员内部类：  
   3.1是外部类的一个成员：①可以有修饰符（4个）②static final ③可以调用外部类的属性、方法  
   3.2具有类的特点：①abstract ②还可以在其内部定义属性、方法、构造器  
  4.局部内部类：  
  5.关于内部类的创建,调用变量,局部内部类的使用：  
  ①内部类的创建:  
  创建静态内部类对象,可以直接通过外部类调用静态内部类的构造器(new Person.Dog()) ;
  非静态内部类，必须先创建外部类的对象，铜鼓哦外部类的对象调用内部类的构造器(p.new Bird())   
  ②如何区分调用外部类、内部类的变量(尤其是变量重名时):  
  this.name:内部类属性;  
  外部类.this.name：外部类的属性  
  ③局部内部类的使用 （见TestInnerClass1.java）:  
  
  
 #####11)设计模式
  ①单例模式：饿汉式:直接创建实例，懒汉式(线程安全问题):使用时才创建实例;  
  ②模板方法模式:(定义一个操作的算法的框架，而将一些步骤延迟到子类中。使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤):
  方法: 基本方法(由子类实现)与模板方法(实现对基本方法的调度，完成固定的逻辑,一般都加上final关键字) 
  使用场景:
  多个子类有公有的方法，并且逻辑基本相同时;  
  重要、复杂的算法，可以把核心算法设计为模板方法，周边的相关细节功能则由各个子类实现;  
  重构时，模板方法模式是一个经常使用的模式，把相同的代码抽取到父类中，然后通过钩子函数约束其行为。  
  钩子函数:影响模板方法的逻辑，属于基本方法，但不影响模板方法逻辑  
  ③工厂模式(定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类)  
   适用性:当一个类不知道它所必须创建的对象的类的时候；当一个类希望由子类创建对象的时候；当类将创建对象委托给多个子类的时候  
   
  
  ④代理模式(为其他对象提供一种代理以控制和这个对象的访问)  
  
  #### 5.异常
  ##### 1) 体系结构
   java.lang.Object  
   |----java.lang.Throwable  
   &nbsp;&nbsp;&nbsp;&nbsp;|-------java.lang.Error：错误(JVM内部错误,资源耗尽)，不显式的处理(StackOverFlowError/OutOfMemoryError)  
   &nbsp;&nbsp;&nbsp;&nbsp;|-------java.lang.Exception:异常。需要进行处理  
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|------RuntimeException:运行时异常:  
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   |-----ArrayIndexOutOfBoundsException/NullPointerException/ArithmeticException/ClassCastException  
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|------非RuntimeException:编译时异常  
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-----SQLException/ClassNotFoundException/IOException  
  ##### 2).因为java程序分为javac.exe和java.exe两个过程，在每个过程中，都有可能出现异常。故分为编译时异常、运行时异常
   2.1 对于运行时异常比较常见，可以不显式的来处理(数组越界，类型转换，空指针,)。  
   2.2 对于编译时异常，必须要显式的处理:  
       编译时异常，不是说有异常才处理，而是存在异常的隐患，必须在编译前，提示程序出现异常如何处理.  
  ##### 3).处理异常
  1."抛"：当我们执行代码时，一旦出现异常，就会在异常的代码处生成一个对应的异常类型的对象，并将此对象抛出。(自动抛出/手动抛出):  
   一旦抛出此异常类的对象，那么程序就终止执行;此异常类的对象抛给方法的调用者。  
  2."抓"：抓住上一步抛出来的异常类的对象:java 提供了两种方式用来处理一个异常类的对象:
  ①try...catch...finally...形式:  
  finally是可选的;可以有多个catch语句，try中抛出的异常类对象从上往下去匹配catch中的异常类的类型，一旦满足
   就执行catch中的代码。执行完，就跳出其后的多条catch语句;
   若catch中多个异常类型是"并列"关系，孰上孰下都可以,若catch中多个异常类型是"包含"关系，须将子类放在父类的上面，进行处理。否则报错;
   finally中存放的是一定会被执行的代码  
  ②在方法的声明处，显式的使用throws + 异常类型:异常的对象可以逐层向上抛，直至MAIN方法，当然在向上抛的过程中，可以通过try-catch-finally进行处理   
  ~~~
    public void method1()  throws Exception1 e1,Exception2 e2{
    		//可能出现异常（尤其是编译时异常，一定要处理）
         }
        
        public void method2() throws Exception1 e1,Exception2 e2{
    		method1();
        }
         public void method3(){
    	try{
    		method2();
    	 }catch(Exception1 e1){
    		System.out.println(e1.getMessage());    
    	}catch(Exception2 e2){
    		System.out.println(e2.getMessage());    
    	}
    
         }
  ~~~
  ##### 4).手动抛出一个异常
  在方法的内部，可以使用  throw + 异常类对象，来手动抛出一个异常   
  ~~~
    public int compareTo(Object obj) throws Exception{
    		if(this == obj){
    			return 0;
    		}
    		else if(obj instanceof Circle){
    			Circle c = (Circle)obj;
    			if(this.radius > c.radius){
    				return 1;
    			}else if(this.radius == c.radius){
    				return 0;
    			}else{
    				return -1;
    			}
    		}else{
    			throw new MyException("传入的类型有误！");
    		}
    	}
  ~~~
  ##### 5).自定义一个异常类
  手动抛出一个异常，除了抛出的是现成的异常类的对象之外，还可以抛出一个自定义的异常类的对象  
  ①自定义的异常类继承现有的异常类  
  ②提供一个序列号，提供几个重载的构造器  
  ③子类抛出的异常类小于父类抛出的异常
  ~~~
  public class MyException extends Exception{
  	
  	static final long serialVersionUID = -70348975766939L;
  	
  	public MyException(){
  		
  	}
  	public MyException(String msg){
  		super(msg);
  	}
  }
  ~~~
  #### 6.集合
  ##### 1).  集合概述
  存储对象:数组（基本数据类型  & 引用数据类型）;集合（引用数据类型）
  数组存储对象:一旦创建长度不可变，不知道具体的的数组个数  
  ##### 2).
  Java集合分为Collection和Map体系
  Collection接口
   set:元素无序，不可重复
        TreeSet
   HashSet
        LinkedHashSet
   List:元素有序，可重复
    Vector
    ArrayList
        LinkedList
   Map接口：key-value 键值对
   HashMap
        LinkedHashMap
   HashTable
        Properties
   TreeMap
  ##### 3).Iterator
  Iterator:hasNext();next();  
  Iterator起始位置指向第一个元素前
  
  #### 7.泛型
  1.对象实例化时不指定泛型，默认为：Object。  
  2.泛型不同的引用不能相互赋值。  
  3.加入集合中的对象类型必须与指定的泛型类型一致。  
  4.静态方法中不能使用类的泛型。  
  5.如果泛型类是一个接口或抽象类，则不可创建泛型类的对象。  
  6.不能在catch中使用泛型  
  7.从泛型类派生子类，泛型类型需具体化  
  4.泛型与继承的关系  
  A类是B类的子类，G是带泛型声明的类或接口。那么G(A)不是G(B)的子类！  
  5.通配符:?  
  A类是B类的子类，G是带泛型声明的类或接口。则G(?) 是G(A)、G(B)的父类！  
  ①以List(?)为例，能读取其中的数据。因为不管存储的是什么类型的元素，其一定是Object类的或其子类的。  
  ①以List(?)为例，不可以向其中写入数据。因为没有指明可以存放到其中的元素的类型！唯一例外的是：null   
  6*.  List(？ extends A) :可以将List(A)的对象或List(B)的对象赋给List(? extends A)。其中B 是A的子类  
   ? super A:可以将List(A)的对象或List(B)的对象赋给List(？ extends A)。其中B 是A的父类  
  #### 8.枚举与注解
  一、枚举类
  1.如何自定义枚举类。 枚举类：类的对象是有限个的，确定的。  
   1.1 私有化类的构造器，保证不能在类的外部创建其对象   
   1.2 在类的内部创建枚举类的实例。声明为：public static final   
   1.3 若类有属性，那么属性声明为：private final 。此属性在构造器中赋值。  
  2.使用enum关键字定义枚举类  
  	2.1其中常用的方法：values()  valueOf(String name);  
  	2.2枚举类如何实现接口：  
  	①让类实现此接口，类的对象共享同一套接口的抽象方法的实现。  
  	①让类的每一个对象都去实现接口的抽象方法，进而通过类的对象调用被重写的抽象方法时，执行的效果不同  
  二、注解Annotation  
   1.JDK提供的常用的三个注解  
   @Override: 限定重写父类方法, 该注释只能用于方法  
   @Deprecated: 用于表示某个程序元素(类, 方法等)已过时  
   @SuppressWarnings: 抑制编译器警告  
   2.如何自定义注解  
   以SuppressWarnings为例进行创建即可:  
   @interface MyAnnotation  
   3.元注解：可以对已有的注解进行解释说明。(对其他注解添加注解)    
   Retention:SOURCE,CLASS(默认),RUNTIME :被修饰的注解的生命周期    
   Target:指明被修饰的注解能用于修饰哪些程序元素    
   Documented:javadoc（Retention必须设置为RUNTIME）  
   Inherited:被该注解修饰的Annotation具有继承性  
  #### 9.IO
  1).抽象基类(所有IO流都继承于此)  
  字节流(8 bit):InputStream,OutputStream  
  字符流(16 bit):Reader,Writer  
  2)节点流(4个)  
  FileInputStream,FileOutputStream,FileReader,FileWriter  
  3)处理流:  
  ①缓冲流:BufferedInputStream,BufferedOutputStream,BufferedReader,BufferedWriter  
  ②转换流(字节流与字符流之间的转换):InputStreamReader,OutputStreamWriter(字节流中的数据都是字符时，转换为字符流更有效)  
  编码:字符串-->字符数组 解码:字符数组-->字符串  
  ③标准输入输出流  
  System.in;System.out;  
  ④打印流  
  PrintStream字节流;PrintWriter 字符流  
  ⑤数据流  
  DataInputStream;DataOutputStream(处理基本数据类型,String,字节数组数据)  
  ⑥对象流  
  ObjectInputStream;ObjectOutputStream;  
  (序列化:Serialize;反序列化:Deserialize;不能序列化和反序列化static与transient成员)  
  序列化机制:允许把内存中的JAVA对象转换成与平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，或通过额昂罗将这种二进制流传输到另一个网络节点。  
  当其他程序获取这种二进制流时，就可以恢复成原来的Java对象  
  要实现序列化则必须继承Serializable,Externalizable接口之一  
  ⑦RandomAccessFile类  
  支持随机访问，程序可以直接跳到文件的任意位置来读，写文件  
  mode:r 只读;rw 读写；rwd 读写，同步文件内容的更新;rws 读写，同步文件内容和元数据的更新  
  #### 10.多线程
  ①理解程序、进程、线程的概念  
  程序可以理解为静态的代码  
  进程可以理解为执行中的程序  
  线程可以理解为进程的进一步细分，程序的一条执行路径  
  ②创建java程序的线程  
  方式一：继承于Thread类  
  方式二：实现Runnable接口  
  ③两种方式的对比：联系：class Thread implements Runnable  
  比较哪个好？实现的方式较好。  
  ①解决了单继承的局限性。  
  ②如果多个线程有共享数据的话，建议使用实现方式，同时，共享  
  数据所在的类可以作为Runnable接口的实现类。  
  ④线程里的常用方法：  
  start() run() currentThread() getName() setName(String name) yield() join() sleep()  
   isAlive() getPriority() setPriority(int i) wait() notify() notifyAll()  
  ⑤线程的生命周期  
  新建---(start)---就绪-----(获取CPU/失去CPU执行权)运行-----(正常执行结束;Error/Exception未处理;stop)死亡  
  运行-----(sleep;等待同步锁;wait/join;suspend,即挂起)---阻塞  
  阻塞-----(sleep时间到;获取同步锁;notify/notifyAll;resume,即释放)----就绪  
  ⑥线程同步  
  1.存在原因：  
  由于一个线程在操作共享数据时，未执行完毕的情况下，了另外的线程参与进来，导致共享数据存在了安全问题  
  2.解决办法  
  必须让一个线程操作共享数据完毕后，其他线程才有机会参与共享数据的操作  
  3.JAVA实现线程安全------线程同步  
  方式1：同步代码块  
  synchronized(同步监视器){  
  //需要被同步的代码块  
  }  
  1.共享数据:多个线程共同操作一个数据  
  2.同步监视器:由一个类的对象来充当，哪个线程获取此监视器，谁流执行被同步的代码块,  
  俗称，锁(任何类的对象都可充当该锁)。但是该锁在多线程中必须唯一.
  在一般方法内，可以使用this;在静态方法内，使用当前类本身充当锁  
  方式2：同步方法  
  将共享数据的方法声明为synchronized，即此方法为同步方法，能够保证当一个线程执行此方法时，其他线程在外等待，直至次线程完成方法  
  ⑦线程的通信  
  wait;notify;notifyAll 这三者只有在synchronized方法或代码块中使用，否则出现java.lang.IllegalMonitorStateException  
  wait():当在同步中，执行到此方法，则此线程“等待”，直至其他线程执行notify()的方法，将其唤醒，唤醒后继续其wait()后的代码  
  notify()/notifyAll():在同步中，执行到此方法，则唤醒其他的某一个或所有的被wait的线程。  
  #### 11.常用类
  1.String,StringBuffer,StringBuilder  
  1.1 String类：不可变的字符序列（如：String str = "atguigu"; str += "javaEE"）  
  	1.关注于String常用的方法！  
  	2.String类与基本数据类型、包装类；与字符数组、字节数组；  
  2.1 字符串 与基本数据类型、包装类之间转换  
  	①字符串 --->基本数据类型、包装类:调用相应的包装类的parseXxx(String str);  
  	①基本数据类型、包装类--->字符串:调用字符串的重载的valueOf()方法  
  2.2 字符串与字节数组间的转换   
  	①字符串---->字节数组:调用字符串的getBytes()  
  	②字节数组---->字符串：调用字符串的构造器  
  2.3 字符串与字符数组间的转换  
   ①字符串---->字符数组：调用字符串的toCharArray();  
   ②字符数组---->字符串:调用字符串的构造器  
  2.4 String与StringBuffer的转换  
  ①String --->StringBuffer：使用StringBuffer的构造器：new StringBuffer(String str);  
  ②StringBuffer----->String:使用StringBuffer的toString()方法  
   StringBuffer类：可变的字符序列  
   StringBuilder类：可变的字符序列，jdk5.0新加入的，效率更高，线程不安全。  
   常用的方法：添加：append(...) 删除 delete(int startIndex, int endIndex) 修改：setCharAt(int n ,char ch) 查询：charAt(int index)  
  插入:insert(int index, String str) 反转reverse() 长度：length()  
  注：String类的不可变性：  
  ②System,Date,SimpleDateFormat,Calender  
  2.1System类  
  currentTimeMillis()：返回当前时间的long型值。此long值是从1970年1月1日0点0分00秒开始到当前的毫秒数。  
  此方法常用来计算时间差。  
  2.2 Date类：java.util.Date  
  1.Date  d = new Date();//返回当前时间的Date：Mon May 12 15:17:01 CST 2014  
  Date d1 = new Date(15231512541241L);//返回形参处此long型值对应的日期  
  //getTime()：返回当前日期对应的long型值。toString()  
  2.3SimpleDateFormat:java.text.SimpleDateFormat  
  格式化 ：日期--->文本 使用SimpleDateFormat的format()方法     
  解析：文本--->日期 使用SimpleDateFormat的parse()方法  
  //1.格式化1  
  SimpleDateFormat sdf = new SimpleDateFormat();  
  String date = sdf.format(new Date());  
  System.out.println(date);//14-5-12 下午3:24  
  //2.格式化2  
  SimpleDateFormat sdf1 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");  
  date = sdf1.format(new Date());  
  System.out.println(date);//星期一, 12 五月 2014 15:29:16 +0800  
  //3.解析：  
  Date date1 = sdf.parse("14-5-12 下午3:24");  
  System.out.println(date1);  
  date1 = sdf1.parse("星期一, 12 五月 2014 15:29:16 +0800");  
  //date1 = sdf1.parse("14-5-12 下午3:24");  
  System.out.println(date1);  
  2.4 Calendar:日历类  
  2.4.1获取实例：Calendar c = Calendar.getInstance();  
  2.4.2 get()/set()/add()/date getTime()/setTime()  
  ③Math类  
  ④BigInteger,BigDecimal  
  #### 12.反射
  1.如何创建Class的实例(重点)  
  1.1过程：源文件经过编译(javac.exe)以后，得到一个或多个.class文件。.class文件经过运行(java.exe)这步，  
  	就需要进行类的加载（通过JVM的类的加载器），记载到内存中的缓存。每一个放入缓存中的.class文件就是一个Class的实例！  
  1.2 Class的一个对象，对应着一个运行时类。相当于一个运行时类本身充当了Class的一个实例。  
  1.3 java.lang.Class是反射的源头。    
  接下来涉及到反射的类都在java.lang.reflect子包下。如：Field  Method Constructor  Type Package..  
  当通过Class的实例调用getMethods() --->Method , getConstructors() ---->Constructor  
  1.4实例化Class的方法(三种):  
  ~~~
       // 1.调用运行时类的.class属性  
       Class clazz1 = Person.class;
       System.out.println(clazz1);
  		Class clazz2 = Creator.class;
  		System.out.println(clazz2);
  		// 2.通过运行时类的对象，调用其getClass()方法
  		Person p = new Person();
  		Class clazz3 = p.getClass();
  		System.out.println(clazz3);
  		// 3.调用Class的静态方法forName(String className)。此方法报ClassNotFoundException
  		String className = "com.atguigu.java.Person";
  		Class clazz4 = Class.forName(className);
  		System.out.println(clazz4);
  		 //4.通过类的加载器
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class clazz = classLoader.loadClass(className);
        System.out.println(clazz.getName());
  ~~~
  2.有了Class实例以后，可以做什么？应用一：  
  可以创建对应的运行时类的对象(重点)  
  ~~~
  	//获取运行时类的对象：方法一
  	@Test
  	public void test1() throws Exception{
  		Class clazz = Class.forName("com.atguigu.review.Animal");
  		Object obj = clazz.newInstance();
  		Animal a = (Animal)obj;
  		System.out.println(a);
  	}
  	//调用指定的构造器创建运行时类的对象
  	@Test
  	public void test2() throws Exception{
  		Class clazz = Animal.class;
  		Constructor cons = clazz.getDeclaredConstructor(String.class,int.class);
  		cons.setAccessible(true);
  		Animal a = (Animal)cons.newInstance("Tom",10);
  		System.out.println(a);
  	}
  ~~~
  3.有了Class实例以后，可以做什么？
  应用二：获取对应的运行时类的完整的类的结构：属性、方法、构造器、包、父类、接口、泛型、注解、异常、内部类  
  ~~~
  属性:
  Field[] getFields只能获取到运行时类及其父类中声明为Public 的属性（包含其父类中的声明的public）
  Field[] getDeclaredFields:获取运行时类本身声明的所有的属性（①任何权限修饰符修饰的都能获取②不含父类中的）
  String Modifier.toString(field.getModifiers()):获取属性的权限修饰符
  Class field.getType() : 获取属性的类型
  方法:
  Method[] clazz.getMethods() :获取到对应的运行时类中声明的权限为public的方法（包含其父类中的声明的public）
  Method[] clazz.getDeclaredMethods()：获取到对应的运行时类中声明的所有的方法（①任何权限修饰符修饰的都能获取②不含父类中的）
  Class method.getReturnType() :方法的返回值
  Class[] method.getParameterTypes() : 方法形参
  Class[] method.getExceptionTypes(): 异常类型
  
  Constructor[] clazz.getDeclaredConstructors():获取构造器
  Class  clazz.getSuperclass(); 获取父类
  Type clazz.getGenericSuperclass(); 获取带泛型的父类
  
  ParameterizedType param = (ParameterizedType)type; 获取父类的泛型
  Type[] args = param.getActualTypeArguments();
  System.out.println(((Class)args[0]).getName());
  
  Class[] clazz.getInterfaces(); 获取实现的接口
  Package clazz.getPackage(); 获取所在的包
  Annotation[] clazz.getAnnotations(); 获取注释
  ~~~
  4.有了Class实例以后，可以做什么？  
  应用三：调用对应的运行时类中指定的结构（某个指定的属性、方法、构造器）(重点)  
  ~~~
  //调用指定属性
  @Test
  public void test3() throws Exception{
  	Class clazz = Class.forName("com.atguigu.review.Animal");
  	Object obj = clazz.newInstance();
  	Animal a = (Animal)obj;
  	//调用非public的属性
  	Field f1 = clazz.getDeclaredField("name");
  	f1.setAccessible(true);
  	f1.set(a, "Jerry");
  	//调用public的属性
  	Field f2 = clazz.getField("age");
  	f2.set(a, 9);
  	System.out.println(f2.get(a));
  	System.out.println(a);
  	//调用static的属性
  	Field f3 = clazz.getDeclaredField("desc");
  	System.out.println(f3.get(null));
  }
  //调用指定的方法
  @Test
  public void test4() throws Exception{
  	Class clazz = Class.forName("com.atguigu.review.Animal");
  	Object obj = clazz.newInstance();
  	Animal a = (Animal)obj;
  	
  	//调用非public的方法
  	Method m1 = clazz.getDeclaredMethod("getAge");
  	m1.setAccessible(true);
  	int age = (Integer)m1.invoke(a);
  	System.out.println(age);
  	//调用public的方法
  	Method m2 = clazz.getMethod("show", String.class);
  	Object returnVal = m2.invoke(a,"金毛");   invoke 调用后返回方法的返回值
  	System.out.println(returnVal);
  	//调用static的方法
  	Method m3 = clazz.getDeclaredMethod("info");
  	m3.setAccessible(true);
  //		m3.invoke(Animal.class);
  	m3.invoke(null);
  }
  ~~~
  5.动态代理---反射的应用。体会反射的动态性  
  代理设计模式的原理:   
  使用一个代理将对象包装起来, 然后用该代理对象取代原始对象. 任何对原始对象的调用都要通过代理. 代理对象决定是否以及何时
  将方法调用转到原始对象上  
  静态代理：要求被代理类和代理类同时实现相应的一套接口；通过代理类的对象调用重写接口的方法时，实际上执行的是被代理类的同样的
  方法的调用。  
  动态代理：在程序运行时，根据被代理类及其实现的接口，动态的创建一个代理类。当调用代理类的实现的抽象方法时，就发起对被代理类同样
  方法的调用。  
  涉及到的技术点：  
  ~~~
  ①提供一个实现了InvocationHandler接口实现类，并重写其invoke()方法
  			  ②Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),h);
  			//注：obj：被代理类对象 ； h:实现了InvocationHandler接口的实现类的对象
  例子见：TestProxy例子
  ~~~
  动态代理与AOP  
  
  #### 13.网络编程
  1.要想实现网络传输，需要考虑的问题有哪些？  
  1.1 如何才能准确的定位网络上的一台主机？  
  1.2 如何才能进行可靠的、高效的数据传输？  
  2. java如何实现的网络通信  
  2.1 使用IP地址---定位一台主机;使用端口号---定位一个应用;===>InetAddress类  
  如何创建一个InetAddress的对象？getByName("");   
  比如：InetAddress inet = InetAddress.getByName("192.168.10.165");  
  如何获取本机的一个InetAddress的对象？getLocalHost()  
  域名：getHostName();ip:getHostAddress()  
  2.2 对应有协议  
  应用层:HTTP;ftp;telnet;DNS  
  传输层:TCP;UDP  
  网络层:IP;ICMP;ARP  
  物理+数据链路层:Link  
  2.3 TCP和UDP  
  TCP协议:  
  使用TCP前，必须建立TCP协议，形成传输数据通道;  
  传输前，采用"三次握手"方式，是可靠的;  
  在TCP协议进行通信的两个应用进程:客户端、服务端;  
  在数据中进行大数据量的传输;  
  传输完毕，需释放已建立的连接，效率低.  
  UDP协议:  
  将数据、源、目的封装成数据包，不需要建立连接;  
  每个数据报的大小限制在64kb大小;  
  因无序连接，是不可靠的;  
  发送数据时无需释放资源，速度快.  
  2.4  
  TCP的编程：Socket;ServerSocket  
  例子：  
  1.客户端发送内容给服务端，服务端将内容打印到控制台上。  
  2.客户端发送内容给服务端，服务端给予反馈。  
  3.从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接。  
  UDP的编程：DatagramSocket;DatagramPacket  
  UDP数据报DatagramPacket 通过数据报套接字DatagramSocket发送和接收;  
  DatagramPacket对象封装了UDP数据报，在数据报中包含了发送端的IP地址和端口号以及接收端的IP地址和端口号  
  URL的编程：统一资源定位符一个URL的对象，对应着互联网上一个资源。  
  //我们可以通过URL的对象调用其相应的方法，将此资源读取（“下载”）  
  
#### 六、Java8 新特性
##### 1.速度更快
1.哈希算法:
数组-链表-红黑树(jdk1.8以后，冲突的元素放在链表中的最后),HashTree,  
ConcurrentHashMap(并发级别默认为16，jsk1.8以后只采用cas算法)  
2.JVM  
不存在永久区，取而代之的为metaSpace元空间:  
使用物理内存  
2.Lambda表达式  
Lambda是一个匿名函数，是一段可以传递的代码

  
#### 十、Linux
##### 1.Linux 的目录结构
linux 目录是树状的.最上层是根目录"/".  
根目录下:  
/root 系统管理员;/bin 系统使用的指令;/boot 启动linux使用的一些核心文件;  
/dev 管理设备;/etc 所有的系统管理所需要的配置文件和子目录;  
/home 存放普通用户信息;/var 不断变化的东西，如日志;/lib 系统开机需要的基本的动态连接共享库;  
/usr 用户的应用程序和文件;/media U盘或光驱;/mnt 让用户临时挂载别的文件(共享文件);/opt 安装软件所放的目录;/sbin super用户使用的管理程序;  
/tmp 存放临时文件;/selinux 与安全性相关;/lost+founf 系统非法关机时存放文件;/srv 一些服务启动以后需要的数据;  
/proc 内核相关，系统内存的映射，访问该目录获取系统信息;/sys 安装2.6内核中新出现的文件系统;/usr/local 安装过后的目录;/selinux[security-enhanced linux] 安全子系统,能控制程序只访问特定的系统;  
##### 2.Linux 实操
##### 1).vi 和 vim
vi和vim的三种常见模式:  
正常模式:在正常模式下，可以使用快捷键  
插入模式/编辑模式:在这个模式下，可以输入i,I,o,O,a,A,r,R进入插入模式  
命令行模式:完成读取，存储，替换，离开，显示行号等操作。    
写一个hello.java案例:  
vim 文件名.后缀   ------>一般模式  
一般模式 ---(i)--->插入模式---(esc)--->一般模式  
一般模式 ---(:或/)--->命令模式(:wq,:q,:q!) ---(esc)--->一般模式  
##### 2)命令行模式快捷键  
① 拷贝当前行 yy;拷贝当前行向下的5行 5yy;黏贴 p  
② 删除当前行 dd;删除当前行向下的5行 5dd;  
③ 文件中查找某单词: /关键字,回车查找,n就是下一个  
④ 设置文件行号 :set nu ;取消文件行号 : set nonu  
以下处于正常模式下:  
⑤ 到达文件末尾 G ;到达文件首行 gg   
⑥ 撤销 u  
⑦ 光标移动到第20行:首先:set nu,再切换正常模式： 20 + (shift + g)  
##### 3)关机&重启指令
shutdown:  
-->shutdown -h now:立即关机  
-->shutdown -h 1:1分钟后关机  
-->shutdown -r now:立即重启  
halt:  
-->直接使用，等价于关机  
reboot:  
-->重启系统  
sync:  
-->把内存的数据  
##### 4)用户登录和注销
用户登录普通用户后，可通过 su-用户名切换管理员  
输入logout可注销用户  
##### 5)用户管理
用户家目录:/home/目录下有各个创建的用户对应的家目录，当用户登录时，会自动进入到自己的家目录。  
①添加用户  
useradd 用户名  
useradd -d 指定目录 新的用户名 给创建的新用户指定家目录  
useradd -g 用户组 用户名
passwd 用户名 更新密码  
②删除用户  
userdel 用户名 删除用户名  
userdel -r 用户名 删除用户名及其家目录  
PS：在实际开发中，一般不会删除家目录  
③查询用户  
id 用户名 查询用户信息,当用户不存在时，返回无此用户  
④切换用户  
su - 用户名  
PS:高权限用户切换到低权限用户时，不用输入密码  
exit 回到原来的用户  
whoami/who am i 查看当前用户  
⑤修改用户组  
usermod -g 用户组 用户名  
usermod -d 目录名 用户名 改变该用户登录的初始目录  
##### 6)组别管理
①增加组  
groupadd 组名  
②删除组  
groupdel 组名  
##### 7)用户和组的配置文件
1. 用户配置文件(用户信息):  
/etc/passwd  
每行用户配置的含义:  
用户名:口令:用户标识号:组标识号::(::为注释性描述)家目录:登录shell  
2. 组配置信息(组信息):  
/etc/group  
每行配置的含义:  
组名:口令:组标识号:组内用户列表  
3. 口令配置文件(密码和登录信息,是加密的):  
/etc/shadow  
每行配置的含义:  
登录名:加密口令:最后一次修改的时间:最小时间间隔:最大时间间隔:警告时间:不活动时间:失效时间:标志  
##### 8)实用指令
1. 指定运行级别  
0-关机  
1-单用户(找回密码)  
2-多用户无网络服务  
3-多用户有网络服务  
4-保留级别  
5-图形界面级别  
6-重启  
用最多的是3和5  
在/etc/inittab中id:5:initdefault:这一行中的数字更改可变换默认级别  
切换到指定运行级别的指令:init[012356]  
2. 找回root密码  
进入单用户模式(root不需要输密码即可登录)，然后修改root密码:  
在开机前按enter,然后e ,再选择第二个e,然后空格+1+enter,最后输入b;  
3. 帮助指令  
man [命令或配置文件]  
ifconfig:查看网络配置  
4. 文件目录类  
pwd:显示当前工作目录路径  
ls: -a 显示当前所有文件和目录，包括隐藏的;-l 以列表的形式显示信息;-al  
cd:切换目录,cd ~或者cd 回到家目录;cd.. 上一级目录;  
mkdir 绝对路径/目录名：在该路径下创建目录名为。。的目录;-p 创建多级目录  
rmdir 要删除的空目录  
touch 文件名称:创建空文件  
cp [选项] source dest：拷贝文件到指定目录;-r 递归复制(复制整个文件夹)如,cp -r test/ zwj/;\cp 强制覆盖    
rm 移除文件和文件夹;-r 递归删除整个文件夹;-f 强制删除不提示;rm -rf 删除非空目录  
mv 移动文件或重命名;  
cat 查看文件内容(只读)；-n 显示行号;cat -n 文件 \ more 分页显示(管道命令 | more)  
more 要查看的文件(全屏方式分页显示);space 向下翻页;enter 向下翻行;q 离开;Ctrl+F 向下滚动一屏;Ctrl+B 返回上一屏;= 输出当前行;:f 输出文件名和当前行行号  
less 要查看的文件(对于大型文件具有高效率);space 向下翻页;pagedown 向下翻页;pageup 向上翻页;/字符 向下搜索(n 向下查找,N 向上查找);
?字符 向上搜索(n 向上查找,N 向下查找);q 离开  
[>] 输出重定向:会将文件原来的内容覆盖  
 ls -l [>]文件 将列表的内容写入到文件中  
 ls -al [>>]文件 将列表的内容追加到末尾  
 cat 文件1 [>] 文件2 将文件1的内容覆盖到文件2  
 echo "内容" [>>] 文件  
 ps:将当前日历追加到文件中:cal >> /home/mycal
[>>]追加:不会覆盖原文件的内容  
echo：输出内容到控制台.输出环境变量:echo $PATH;echo "Hello"  
head:显示文件的开头部分,默认显示前10行.head -n 10 文件:查看该文件前10行  
tail:显示文件尾部内容，默认显示后10行.tail -n 5 文件:查看文件后5行;
*tail -f 文件:实时追踪该文档的所有更新(ctrl + c 退出实时监控)*  
 ln 软链接(类似快捷方式,主要存放连接其他文件的路径):  
 ln -s [原文件目录][软连接名];用pwd查看所在目录时，显示的为软链接所在目录;
 删除软链接:rm -rf 软连接(最后不带/:rm -rf linkToRoot)  
 history 查看已经执行过的指令，也可以执行历史指令
 `
 案例:  
 显示所有的历史指令:history
 最近使用过的10个指令：history 10
 执行历史编号为5的指令: !5
 `   
 5. 时间日期类  
 date:显示当前日期.date;date +%Y:显示年份;date +%m:显示月份;date +%d:显示当前是哪一天;
 date "+%Y-%m-%d %H:%M:%S"/date "+%Y年%m月%d日 %H时%M分%S秒":年月日时分秒;date "+%Y %m %d":年月日;  
 date -s 设置时间:date -s "时间";  
 cal [选项]:显示日历.cal 2020:显示2020年的日历  
 6. 搜索查找类  
 find 从指定目录从上到下递归的遍历各个子目录.find 搜索范围 选项.选项：-name<查询方式> 文件名:指定的文件名查找;
 -user<用户名> 用户名:查找指定用户名所有文件;-size<文件大小> 大小(+n 大于n,- 小于n,n 等于n):指定的文件大小查找.  
 locate 快速定位文件路径(查询速度快，必须定期更新locate) 在第一次运行前，必须使用updatedb指令创建locate数据库.    
 grep和管道符号| 在文件内部查找关键字.grep [选项] 查找内容 源文件.选项:-n 显示匹配行及行号;-i 忽略大小写  
 管道指令|:将前一个指令的结果传给后面的指令处理  
 `
 cat hello.txt | grep -n yes
 `  
 7. 压缩和解压缩  
 ①压缩为.gz文件：  
 gzip 压缩(不会保留源文件).  
 gunzip 解压  
 ②压缩为.zip文件:  
 zip [选项] 文件名 要压缩的文件:压缩;选项:-r 压缩目录  
 unzip [选项] 解压文件存放的目录 文件名 :解压;选项:-d 指定解压之后文件的存放目录  
 ③tar .tar.gz  
 tar [选项] 压缩名 打包的内容.选项:-c 产生.tar打包文件;-v 显示详细信息;-f 指定压缩后的文件名;-z 打包同时压缩;-x 解压.tar文件  
 `
 压缩多个文件:tar -zcvf 打包后的文件名 要打包的文件1 要打包的文件2 ...  
 打包/home目录下所有文件打包:tar -zcvf myhome.tar.gz /home/  
 解压: tar -zxvf 压缩包  
 解压到指定目录:tar -zxvf 压缩包 -C 指定路径(该目录必须存在)  
 `  
 8. 组管理和权限管理  
 在linux 中的每个用户必须属于一个组，不能独立于组外。在linux 中每个文件  
 有所有者、所在组、其它组的概念。  
 1) 所有者:一般为文件的创建者,谁创建了该文件，就自然的成为该文件的所有者:  
 查看文件的所有者:  
 ls -ahl(包括隐藏文件)  
 修改文件所有者:  
 chown 用户名 文件名(然而并不改变所在组)  
 2) 所在组:当某个用户创建了一个文件后，默认这个文件的所在组就是该用户所在的组:  
 修改文件所在组:  
 chgrp 组名 文件名  
 3) 其它组:除文件的所有者和所在组的用户外，系统的其它用户都是文件的其它组  
 9. 权限管理  
 ls -l 显示的内容如下:-rwxrw-r-- 1 root root 1213 Feb 2 09:39 abc  
 一. -rwxrw-r--中的0-9位说明:(- rwx rw- r--)  
 1)第0 位确定文件类型(d 目录, - 普通文件, l 软链接, c 字符设备(键盘，鼠标), b 块文件，硬盘)  
 2)第1-3 位确定所有者（该文件的所有者）拥有该文件的权限。---User  
 3)第4-6 位确定所属组（同用户组的）拥有该文件的权限，---Group  
 4)第7-9 位确定其他用户拥有该文件的权限---Other  
 ① rwx 权限详解  
 1)作用到文件  
     [ r ]代表可读(read): 可以读取,查看  
     [ w ]代表可写(write): 可以修改,但是不代表可以删除该文件,删除一个文件的前提条件是对该
     文件所在的*目录*有写权限，才能删除该文件.  
     [ x ]代表可执行(execute):可以被执行  
 2)作用到目录  
     [ r ]代表可读(read): 可以读取，ls 查看目录内容  
     [ w ]代表可写(write): 可以修改,目录内创建+删除+重命名目录  
     [ x ]代表可执行(execute):可以进入该目录  
 ②10 个字符确定不同用户能对文件干什么  
     第一个字符代表文件类型： 文件(-),目录(d),链接(l)  
     其余字符每3个一组(rwx) 读(r) 写(w) 执行(x)  
     第一组rwx : 文件拥有者的权限是读、写和执行   
     第二组rw- : 与文件拥有者同一组的用户的权限是读、写但不能执行  
     第三组r-- : 不与文件拥有者同组的其他用户的权限是读不能写和执行  
     可用数字表示为: r=4,w=2,x=1 因此rwx=4+2+1=7  
 二. 剩下的1 root root 1213 Feb 2 09:39 abc：  
 1 文件：硬连接数;目录：子目录数  
 root 用户  
 root 组  
 1213 文件大小(字节)，如果是文件夹，统一显示4096 字节  
 Feb 2 09:39 最后修改日期  
 abc 文件名  
 三. 修改权限  
 ①. +,-,=变更权限  
 u 所有者, g 所有组,o 其他人,a 所有人(a,g,o总和)  
 chmod u=rwx,g=rwx,o=rx 文件目录名 修改权限  
 chmod o+w 文件目录名 增加权限  
 chmod a-x 文件目录名 去除权限  
 ②. 通过数字修改权限  
 chmod 751 相当于chmod u=rwx,g=rwx,o=rx  
 ③. 修改文件所有者  
 chown newowoner file 改变文件的所有者  
 chown newowner:newgroup file 改变文件的所有者和所在组  
 -R 如果是目录，则使其下所有目录所有的子文件或目录递归生效  
 ④. 修改文件所在组  
 chgrp newgroup file 改变文件的所在组;-R 递归修改  
 9. 定时任务调度  
 crond [选项].选项:-e 编辑定时任务;-l 查询任务;-r 删除当前用户所有的定时任务  
 service crond restart [重启任务调度]
 cron -e：*/1 * * * * ls -l /etc >> /tmp/to.txt：  
 五个占位符的说明:  
 第一个*:一小时当中的第几分钟 0-59  
 第二个*:一天当中的第几小时 0-23  
 第三个*:一个月当中的第几天 1-31  
 第四个*:一年当中的第几月 1-12  
 第五个*:一周当中的星期几 0-7(0,7都代表星期天)  
 特殊符号的说明:  
 *:代表任何时间(第一个*代表一个小时中每分钟都执行)  
 ,:代表不连续的时间(0 8,6,14 * * *)  
 -:代表连续的时间范围  
 */n:代表每隔多久执行一次  
 `
 每天凌晨2:00将mysql 数据库testdb备份到文件中mydb.bak。
 1) 先编写一个文件/home/mytask3.sh
 /usr/local/mysql/bin/mysqldump -u root -proot testdb > /tmp/mydb.bak
 2) 给mytask3.sh 一个可以执行权限
 chmod 744 /home/mytask3.sh
 3) crontab -e
 4) 0 2 * * * /home/mytask3.sh
 `  
 10. 磁盘分区,挂载  
 1)分区的方式:  
 ①.mbr 分区:  
 最多支持四个主分区   
 系统只能安装在主分区  
 扩展分区要占一个主分区  
 MBR 最大只支持2TB，但拥有最好的兼容性  
 ②.gtp 分区  
 支持无限多个主分区（但操作系统可能限制，比如windows 下最多128 个分区）  
 最大支持18EB 的大容量（1EB=1024 PB，1PB=1024 TB ）  
 windows7 64 位以后支持gtp  
 2)Linux 分区:  
 Linux 来说无论有几个分区，分给哪一目录使用，它归根结底就只有一个根目录，一个独立且
 唯一的文件结构, Linux 中每个分区都是用来组成整个文件系统的一部分。  
 Linux 采用了一种叫“载入”的处理方法，它的整个文件系统中包含了一整套的文件和目录，
 且将一个分区和一个目录联系起来。这时要载入的一个分区将使它的存储空间在一个目录下获得。  
 3)硬盘说明:  
 Linux 硬盘分IDE 硬盘和SCSI 硬盘，目前基本上是SCSI 硬盘  
 对于IDE 硬盘，驱动器标识符为“hdx~”,其中“hd”表明分区所在设备的类型，这里是指IDE 硬
 盘了。“x”为盘号（a 为基本盘，b 为基本从属盘，c 为辅助主盘，d 为辅助从属盘）,“~”代表分区，
 前四个分区用数字1 到4 表示，它们是主分区或扩展分区，从5 开始就是逻辑分区。例，hda3 表示为
 第一个IDE 硬盘上的第三个主分区或扩展分区,hdb2 表示为第二个IDE 硬盘上的第二个主分区或扩展
 分区。  
 对于SCSI 硬盘则标识为“sdx~”，SCSI 硬盘是用“sd”来表示分区所在设备的类型的，其余则
 和IDE 硬盘的表示方法一样。  
 4)查看当前系统的分区情况:  
 lsblk -f 查看系统的分区和挂载的情况.结果为分区情况+分区类型+标识符+挂载点  
 5)挂载的经典案例:  
 Linux 系统增加一个新的硬盘，并且挂载到/home/newdisk:  
 ①虚拟机添加硬盘:  
 在【虚拟机】菜单中，选择【设置】，然后设备列表里添加硬盘，然后一路【下一步】，中间只
 有选择磁盘大小的地方需要修改，至到完成。然后重启系统  
 ②分区fdisk /dev/sdb:  
 分区命令fdisk /dev/sdb  
 开始对/sdb 分区  
 •m 显示命令列表  
 •p 显示磁盘分区同fdisk –l  
 •n 新增分区  
 •d 删除分区  
 •w 写入并退出  
 开始分区后输入n，新增分区，然后选择p ，分区类型为主分区。两次回车默认剩余全部空间。
 最后输入w 写入分区并退出，若不保存退出输入q  
 ③格式化mkfs -t ext4 /dev/sdb1,其中ext4 是分区类型  
 ④挂载先创建一个/home/newdisk:  
 挂载:mount 设备名称挂载目录;mount /dev/sdb1 /home/newdisk;  
 卸载:umount 设备名称或者挂载目录   
 ⑤设置可以自动挂载(永久挂载，当你重启系统，仍然可以挂载到/home/newdisk):  
 永久挂载: 通过修改/etc/fstab 实现挂载:  
 vim /etc/fstab;/dev/sdb1 /home/newdisk ext4 defaults 0 0  
 添加完成后执行mount –a 即刻生效  
 5)磁盘情况查询:  
 ①.查询系统整体磁盘使用情况:df -lh  
 ②.查询指定目录的磁盘占用情况:du -h /目录  
 查询指定目录的磁盘占用情况，默认为当前目录  
 -s 指定目录占用大小汇总;-h 带计量单位;-a 含文件;--max-depth=1 子目录深度;-c 列出明细的同时，增加汇总值(du -ach --max-depth=1 /opt)  
 ③.磁盘情况-工作实用指令:  
 统计/home 文件夹下文件的个数:ls -l /home | gerp "^_" | wc -l  
 统计/home 文件夹下目录的个数:ls -l /home | gerp "^d" | wc -l  
 统计/home 文件夹下文件的个数，包括子文件夹里的:ls -lR /home | gerp "^_" | wc -l  
 统计文件夹下目录的个数，包括子文件夹里的:ls -lR /home | gerp "^d" | wc -l  
 以树状显示目录结构:tree  
 11. 网络配置  
 1). Linux网络环境配置  
 ①自动获取(System eth()):  
 缺点: linux 启动后会自动获取IP,缺点是每次自动获取的ip 地址可能不一样。
 这个不适用于做服务器，因为我们的服务器的ip 需要时固定的  
 2).指定固定的ip  
 直接修改配置文件来指定IP,并可以连接到外网,编辑vi /etc/sysconfig/network-scripts/ifcfg-eth0(ifcfg-Auto-eth0)    
 项目说明:  
 DEVICE=eth0 接口名  
 HWADDR MAC设备名  
 TYPE 网络类型  
 UUID 随机id  
 ONBOOT系统启动时网络接口是否有效  
 BOOTPROTO IP配置方法(none(不使用协议)|static(静态分配IP)|bootp(BOOTP协议)|dhcp(DHCP协议))  
 IPADDR IP地址  
 GATEWAY 网关  
 DNS1 域名解析器  
 修改后，一定要重启服务  
 1) service network restart  
 2) reboot 重启系统  
 12. 进程管理  
 1). 显示系统执行的进程  
 ps ,一般来说使用的参数是ps -aux  
 显示参数:  
 PID 进程识别号  
 MEM 占用内存情况  
 CPU 占用CPU  
 VSZ 占用虚拟内存情况  
 RSS 使用物理内存情况  
 STAT S:休眠,R:运行  
 START 启动时间  
 TTY 终端机号  
 TIME 此进程占用CPU总计时间  
 COMMAND 正在执行的命令或进程名  
 PPID 父进程  
 例子:  
 ps -aux | more  
 ps -aux | grep xxx(过滤)  
 ps -ef | more:查看父进程  
 2)终止进程  
 kill [选项]进程号(通过进程号杀死进程)  
 killall 进程名称(通过名称杀死进程)  
 kill -9 进程名(强制杀死进程)  
 pstree [选项]进程树:-p 显示进程的PID，-u 显示进程的所属用户  
 3)服务管理  
 服务的本质就是进程，通常会监听某个端口，等待其他程序的请求，因此又称为守护进程。  
 ①service 服务名 start|stop|restart|reload|status  
 centos7.0之后，不是service,而是systemctl  
 例子:  
 查看防火墙转态:service iptables status  
 关闭防火墙:service iptables stop  
 开启防火墙:service iptables start  
 重启防火墙:service iptables restart  
 telnet ip 端口号:检测端口是否在监听并且可以访问  
 设置某个服务永久自启动或者永久关闭:chkconfig指令  
 ②查看服务名  
 setup -> 系统服务(图形模式)  
 ls -l /etc/init.d/(文本模式)  
 ③运行级别  
 修改运行级别:vim /etc/inittab  
 修改服务运行级别:chkconfig 给每个服务的各个运行级别设置自启动或关闭  
 chkconfig --list | grep xxx : 查看服务  
 chkconfig 服务名 --list: 查看服务  
 chkconfig --level 5 服务名 on/off:设置某个服务在运行级别为5的情况下，是否自启动  
 chkconfig设置完，需重启  
 4)监控服务
 ①动态监控进程  
  top [选项] :与ps的区别在于执行一段时间可以更新正在运行的进程  
  选项:-d 秒数 : 指定top更新的时间;-i 使top不显示任何闲置或僵死进程;
  -p 通过指定监控进程ID来仅仅监控某个进程的状态  
  交互操作说明:  
  P 以CPU使用率排序，默认就是此项  
  M 以内存使用率排序  
  N 以PID进行排序  
  q 退出top  
  案例:  
  监视特定用户:输入u，再输入用户名  
  终止指定的进程:输入k，再输入进程号  
  指定系统状态更新的时间(默认是3秒):top -d 10  
 ②查看系统网络情况netstat  
 netstat [选项]  
 选项:-an 按一定顺序排列输出;-p 显示哪个进程在调用  
 netstat -anp | more  
 netstat -anp | grep sshd  
 12.RPM和YUM包  
 1).RPM:Redhat Package Manager,用于互联网下载包的打包和安装工具,生成.rpm文件  
 rpm -qa | grep xxx 查询已安装的RPM列表  
 查询结果:软件名-版本.在适用于centos 6.0x的64位系统  
 rpm -q 软件包名:查询是否安装软件  
 rpm -qi 软件包名:查询软件包信息  
 rpm -ql 软件包名:查询软件包安装的文件  
 rpm -qf 文件全路径名：查询文件所属的软件包  
 卸载rpm 包  
 rpm -e RPM包名  
 PS:当要删除的包被另外的包使用时，删除失败.此时 rpm -e --nodeps 包名  
 安装rpm包  
 rpm -ivh RPM包名  
 i=install,v=version(提示),h=hash(进度条)  
 PS:安装firefox:  
 ①先挂载上安装的ISO文件，进入media目录  
 ②cp 安装包 /opt/  
 ③rpm -ivh 包名.rpm  
 2)YUM包(能从指定服务器下载安装包，可以自动处理依赖性关系)  
 yum list | grep xx 软件列表:查询是否有xx软件包  
 yum install xxx 下载安装:安装指定的YUM包  
 13.JAVAEE  
 /opt 目录(存放安装软件)  
 通过ftp将软件包放入opt目录下  
 1)jdk安装  
 解压缩 tar -zxvf w文件包  
 配置环境变量 vim /etc/profile:  
 JAVA_HOME=/opt/jdk-10.0.2  
 PATH=/opt/jdk-10.0.2/bin:$PATH  
 export JAVA_HOME PATH  
 注销用户后，配置生效(3：logout;5: 图形注销)  
 2)Tomcat  
 解压缩到/opt下:  
 启动tomcat ./startup.sh:进入bin目录后,执行./startup.sh.此时本地http://localhost:8080/可以访问  
 开放端口 vim /etc/sysconfig/iptables:  
 yy p复制一行,再修改为8080端口  
 重启防火墙:service iptables restart  
 至此，能从windows访问linux上的服务器  
 3)Mysql  
 ①安装:  
 查询是否有mysql:rpm -qa | grep mysql  
 卸载mysql:rpm -e --nodeps mysql-libs  
 安装GCC：yum -y install make gcc-c++ cmake bison-devel ncurses-devel  
 解压缩mysql包,进入mysql目录后，进行源码编译:  
 cmake -DCMAKE_INSTALL_PREFIX=/usr/local/mysql -DMYSQL_DATADIR=/usr/local/mysql/data 
 -DSYSCONFDIR=/etc -DWITH_MYISAM_STORAGE_ENGINE=1 -DWITH_INNOBASE_STORAGE_ENGINE=1 
 -DWITH_MEMORY_STORAGE_ENGINE=1 -DWITH_READLINE=1 
 -DMYSQL_UNIX_ADDR=/var/lib/mysql/mysql.sock -DMYSQL_TCP_PORT=3306 
 -DENABLED_LOCAL_INFILE=1 -DWITH_PARTITION_STORAGE_ENGINE=1 
 -DEXTRA_CHARSETS=all -DDEFAULT_CHARSET=utf8 
 -DDEFAULT_COLLATION=utf8_general_ci  
 编译安装:make && make install  
 ②配置MySQL  
 设置权限:  
 cat /etc/passwd 查看用户列表  
 cat /etc/group  查看用户组列表  
 若无，则创建:  
 groupadd mysql  
 useradd -g mysql mysql  
 修改/usr/local/mysql权限:  
 chown -R mysql:mysql /usr/local/mysql  
 初始化配置:  
 cd /usr/local/mysql  
 scripts/mysql_install_db --basedir=/usr/local/mysql --datadir=/usr/local/mysql/data --user=mysql  
 ls -l /etc/my.cnf:若有，则mv /etc/my.cnf  
 启动mysql:(在 /usr/local/mysql 下执行)cp support-files/mysql.server /etc/init.d/mysql;  
 chkconfig mysql on;  
 service mysql start  
 修改密码:  
 cd /usr/local/mysql/bin  
 ./mysql -u root -p ,此时默认密码为空  
 mysql> SET PASSWORD = PASSWORD('root');  
 配置mysql环境变量:  
 vim /etc/profile:PATH=/opt/jdk-10.0.2/bin:/usr/local/mysql/bin/:$PATH  
 刷新配置: source /etc/profile  
 5)Eclipse  
 解压缩到/opt  
 启动eclipse,配置JRE和server:  
 ①进入到eclipse文件，执行./eclipse  
 ②图形界面方式  
 14.大数据  
 shell:命令解释器,驱动linux内核;应用程序调用shell命令  
 1).Shell脚本的执行方式  
 脚本格式要求：  
 脚本以#!/bin/bash开头;脚本需要可执行权限  
 脚本的常用执行方式:  
 ①赋予权限，执行:chmod 7xx yyyy.sh  
 ②直接执行:sh ./myShell.sh  
 执行:相对路径 ./myShell.sh;绝对路径：/root/shell/myShell.sh
 2)Shell变量  
 变量分为系统变量(如$HOME,$PWD,$SHELL,$USER)和用户自定义变量(set指令显示当前shell中所有变量)  
 ①定义:  
 定义变量:变量=值;  
 撤销变量：unset变量;  
 声明静态变量:readonly变量，不能unset  
 全局环境变量，可供其他shell程序使用:export 变量名=变量值  
 将命令的返回值赋值给变量:A=`ls -l /home`等价于A=$(ls -l /home)  
 等号两边不能有空格;  
 多行注释::<<!.....!
 ②设置环境变量  
 将shell变量输出为环境变量:export 变量名=变量值  
 让修改后的配置信息立即生效:source 配置文件  
 查询环境变量值:echo $变量名  
 3)位置参数变量  
 当我们执行一个 shell 脚本时，如果希望获取到命令行的参数信息，就可以使用到位置参数变量，
 比如 ： ./myshell.sh100200, 这个就是一个执行 shell 的命令行，
 可以在 myshell 脚本中获取到参数信息   
 $n（功能描述：n 为数字，$0 代表命令本身，$1-$9 代表第一到第九个参数，十以上的参数，十以上的参数需要用大括号包含，如${10}）  
 $*（功能描述：这个变量代表命令行中所有的参数，$*把所有的参数看成一个整体）  
 $@（功能描述：这个变量也代表命令行中所有的参数，不过$@把每个参数区分对待）  
 $#（功能描述：这个变量代表命令行中所有参数的个数）  
 4)预定义变量  
 就是 shell 设计者事先已经定义好的变量，可以直接在 shell 脚本中使用  
 $$（功能描述：当前进程的进程号（PID））  
 $!（功能描述：后台运行的最后一个进程的进程号（PID））  
 $？（功能描述：最后一次执行的命令的返回状态。如果这个变量的值为 0，证明上一个命令 正确执行；如果这个变量的值为非 0（具体是哪个数，由命令自己来决定），则证明上一个命令
 执行不正确了。）  
 5)运算符  
 “$((运算式))”或“$[运算式]”   
 expr m + n 注意 expr 运算符间要有空格   
 expr m - n   
 expr \*,/,%(乘，除，取余)  
 6)条件判断  
 [ condition ]（注意 condition 前后要有空格）  
 `#非空返回 true，可使用$?验证（0 为 true，>1 为 false）`  
 常用判断条件:  
 ①两个整数的比较  
 = 字符串比较  
 -lt 小于  
 -le 小于等于  
 -eq 等于  
 -gt 大于  
 -ge 大于等于  
 -ne 不等于   
 ②按照文件权限进行比较  
 -r 有读的权限 [-r 文件 ]  
 -w 有写的权限  
 -x 有执行的权限  
 ③按照文件类型进行判断  
 -f 文件存在并且是一个常规的文件  
 -e 文件存在  
 -d 文件存在并是一个目录
 7)流程控制  
 ①if,if与中括号之间也必须有空格    
 `if[ 条件判断式 ];then
 程序
 fi`
 或  
 `if[ 条件判断式 ] then
 程序 elif[条件判断式]
 then
 程序
 fi `  
 注意事项：  
 (1)[ 条件判断式 ]，中括号和条件判断式之间必须有空格  
 (2) 推荐使用第二种方式
 ②case  
 `
 case$变量名 in "值 1"） 如果变量的值等于值 1，则执行程序 1 ;; "值 2"） 如果变量的值等于值 2，则执行程序 2 ;;
 …省略其他分支… *）
 如果变量的值都不是以上的值，则执行此程序
 ;;
 esac
 `  
 ③for循环  
 `
 for 变量 in 值 1 值 2 值 3… do 
 程序 done
 或
 for(( 初始值;循环控制条件;变量变化 )) do
 程序 done
 `
 ④while循环  
 `
 while[ 条件判断式 ] do
 程序 done
 `
 ⑤read控制台读入  
 `
 -p：指定读取值时的提示符； -t：指定读取值时等待的时间（秒），如果没有在指定的时间内输入，就不再等待了。。
 参数
 变量：指定读取值的变量名 
 `  
 ⑥函数  
 系统函数:  
 1.basename 基本语法 
 功能：返回完整路径最后 / 的部分，常用于获取文件名  
 basename [pathname] [suffix]  
 basename [string] [suffix] （功能描述：basename 命令会删掉所有的前缀包括最后一个（‘/’）
 字符，然后将字符串显示出来。  
 选项:suffix 为后缀，如果 suffix 被指定了，
 basename 会将 pathname 或 string 中的 suffix 去掉。  
 2.dirname 基本语法  
 功能：返回完整路径最后 / 的前面的部分，常用于返回路径部分 dirname 文件绝对路径   
 （功能描述：从给定的包含绝对路径的文件名中去除文件名（非目录的部分），
 然后返回剩下的路径（目录的部分））   
 系统函数:  
 基本语法  
 [ function ] funname[()] 
 {
    Action; 
    [return int;]
 }
 调用直接写函数名：funname [值]
 案例:  
 需求分析  
 1)每天凌晨 2:10 备份 数据库 atguiguDB 到 /data/backup/db  
 2)备份开始和备份结束能够给出相应的提示信息  
 3)备份后的文件要求以备份时间为文件名，并打包成 .tar.gz 的形式，
 比如： 2018-03-12_230201.tar.gz   
 4) 在备份的同时，检查是否有 10 天前备份的数据库文件，如果有就将其删除。  
 `
 在/usr/sbin目录创建数据库备份脚本:mysql_db_backup.sh(必须拥有相当高的权限):
 echo "=========开始备份============"
 echo "数据库备份的路径是 $BACKUP/$DATETIME.tar.gz"
 
 #本机
 HOST=localhost
 #用户名
 DB_USER=root
 #密码
 DB_PWD=root
 #备份数据库名
 DATEBASE=myDB
 #创建备份的路径
 #若备份的路径存在，则使用；否则创建
 [ ! -d "$BACKUP/$DATETIME" ] && mkdir -p "$BACKUP/$DATETIME"
 
 #执行mysql的备份数据库指令
 mysqldump -u$DB_USER -p$DB_PWD --host=$HOST $DATEBASE | gzip > $BACKUP/$DATETIME/$DATETIME.sql.gz
 
 #打包备份文件
 cd $BACKUP
 tar -zcvf $DATETIME.tar.gz $DATETIME
 
 #删除临时目录
 rm -rf $BACKUP/$DATETIME
 
 
 #删除十天前的备份文件
 find $BACKUP -mtime + 10 -name "*.tar.gz" -exec rm -rf {} \;
 echo "===========备份文件成功=============="

 
 将sh脚本加入至定时任务:
 crontab -e:
 10 2 * * * /usr/sbin/mysql_db_backup.sh
 
 `
 
 15.Python  
 
 
 
 
 
 
 

 
 
 
 
 
 
 
####Java实战  

 
 
 
 
 
  
  

#### 三.MySQL
#### 1.Mysql命令                                          
#### 2.查询

    
### JavaWeb
####一.WEB基础
#####1.开发目录
WEB根目录/WEB-INF/classes(编译后的.class文件),lib(lib文件),web.xml(配置文件)  
可通过Java Build Path将 Default output folder改为classes文件下  
#####2.Servlet
1.Servlet运行在Servlet容器中,Servlet容器负责Servlet和客户的通信以及调用Servlet方法  
Servlet 可完成:创建并返回基于 客户请求的动态HTML页面;创建可嵌入到现有HTML页面中的部分HTML页面;
与其他服务器资源(数据库或者基于JAVA的程序应用)进行通信.  
2.Servlet容器响应客户请求的过程  
1)Servlet引擎检查是否已经装载并创建了该Servlet的实例对象。  
如果是，则直接执行第四步，否则直接执行第二步  
2)装载并创建该Servlet的一个实例对象:调用该Servlet的构造器  
3)调用Servlet实例对象的init()方法  
4)创建一个用于封装请求的ServletRequest对象和一个代表响应消息的ServletResponse对象，
然后调用Servlet的service()的方法并将请求和响应对象作为参数传递进去。  
5)WEB应用程序被停止或重新启动之前，Servlet引擎将卸载Servlet,
并在卸载之前调用Servlet的destroy()方法。 
3.Servlet实例  
1)创建一个Servlet接口的实现类(implements Servlet)  
2)在web.xml中配置和映射这个Servlet(通过WEB访问JAVA类)  
`
    <servlet>
        <servlet-name>helloServlet</servlet-name>
        <servlet-class>servlet.com.atguigu.servlet1.HelloServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>helloServlet</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
或者
    <servlet>
        <servlet-name>helloServlet</servlet-name>
        <servlet-class>servlet.com.atguigu.servlet1.HelloServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>
    ps:/hello中的/代表WEB根目录，与http://localhost:8080/web/等同.
`
一个Servlet可以有多个Servlet-mapping
<<<<<<< HEAD
4.Servlet生命周期  
=======
4.Servlet生命周期   
>>>>>>> cd8c192298b822e8630633ce0462c91c1233b513
Servlet容器可以创建Servlet,并调用Servlet的相关生命周期方法;  
JSP,Filter,Listener,Tag...与Servlet相同  
生命周期相关方法:  
1).构造器:只被调用一次。只有第一次请求Servlet时创建Servlet实例，调用构造器(单实例,线程安全)  
2).init():只被调用一次。在创建好实例后，立即被调用，用于初始化当前Servlet.  
3).service():被多次调动，每次请求都会调用Service方法。用于响应请求的。  
4).destroy():只被调用一次，在当前Servlet所在的WEB应用被卸载前调用，用于释放当前Servlet所占用的资源.   

5.load-on-startup 参数:指定被Servlet创建的时机  
1).配置在Servlet节点中  
2).可以指定Servlet被创建的时机，若为负数，则不在加载容器时，而在第一次请求时被创建;
若为0或正数,则在当前WEB应用被Servlet容器加载时被创建实例,且数值越小越早被创建.  

6.ServletConfig:封装Servlet的配置信息，并且可以获取ServletContext对象  
方法： 
1)配置初始化参数:  
`
<servlet>
    <!--必须在 load-on-startup 节点前-->
    <init-param>
        <param-name>user</param-name>
        <param-value>root</param-value>
    </init-param>
    
    <init-param>
        <param-name>password</param-name>
        <param-value>1230</param-value>
    </init-param>
    
    <load-on-startup>-1</load-on-startup>
</servlet>
`
2).获取初始化参数:  
①getInitParameter(String name):获取指定参数名的初始化参数  
②getInitParameterNames():获取参数名组成的Enumeration对象  
3).获取Servlet的配置名称(了解)    
getServletName():获取WEB.xml中Servlet注册的名字  
4).重要:getServletContext()：获取Servlet上下文  
7.ServletContext:获取Servlet上下文  
1).由ServletConfig获取到  
2).Servlet引擎为每个WEB应用程序都创建一个对应的的ServletContext对象,
由于一个WEB应用中所有的Servlet都共享同一个ServletContext对象，所以，ServletContext对象
被称为application对象(WEB应用程序对象)  
①配置当前WEB应用的初始化参数：  
`
<context-param>
    <param-name>driver</param-name>
    <param-value>com.mysql.jdbc.Driver</param-value>
</context-param>
<context-param>
    <param-name>user</param-name>
    <param-value>root</param-value>
</context-param>
`  
①获取当前WEB应用的初始化参数:  
`
servletContext.getInitParameter("driver");
Enumeration<String> names =  servletContext.getInitParameterNames();
while (names.hasMoreElements()){
     String name = names.nextElement();
     System.out.println(servletConfig.getInitParameter(name));
}
`  
ps:Servlet中的初始化参数是局部的，只有当前Servlet能使用，
Context中的初始化参数是全局的，任何Servlet能使用  

③获取当前WEB应用的某一个文件的绝对路径  
getRealPath("/note.txt");  
//D:\soft\IDEA\codes\JavaSE\WebContent\note.txt   
获取到的是部署后的路径。  

④获取当前WEB应用的名称  
getContextPath():/JavaWeb  

⑤获取当前WEB应用的某一个文件对应的输入流：  
getResourceAsStream(String path):path的/为当前WEB应用的根目录  

⑥和attribute相关的重要方法:  
getAttribute();getAttributeNames();removeAttribute();setAttribute()  

8.从Servlet中获取请求信息     
在Servlet中获取请求信息:  
1)Servlet中的service() 方法用于应答请求：每次请求都会调用 service() 方法  
ServletRequest:封装了请求信息.可以从其中获取到任何的请求信息.  
ServletResponse:封装了响应信息.如果给用户什么响应，就使用该接口的方法实现.  
这两个接口的实现类都是服务器给与的，并在服务器调用service时传入  
2)ServletRequest:  
①获取请求参数:  
String getParameter(String name):根据请求参数的名字，返回参数值;
当同名的请求参数有多个时，该方法只能获取一个提交的值  
String[]  getParameterValues(String name):
根据请求参数名获取请求参数对应的字符串数组(多选);
当同名的请求参数有多个时，该方法能获取全部值    
Enumeration getParameterNames():返回参数名对应的Enumeration对象,
类似于ServletConfig(或ServletContext)的getInitParameterNames()  
Map getParameterMap():返回请求参数的键值对(key:参数名 value:参数值(数组类型))   
与HTTP请求相关的方法可以强转为HttpServletRequest:  
②获取请求的URL：  
HttpServletRequest.getRequestURI
③获取请求方式
HttpServletRequest.getMethod  
④和 attribute 相关的方法:  
  
3)HttpServletRequest:是SerletRequest的子接口，针对于HTTP请求所定义，
里边包含了大量获取HTTP请求相关的方法  




 










