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
  A类是B类的子类，G是带泛型声明的类或接口。那么G<A>不是G<B>的子类！  
  5.通配符:?  
  A类是B类的子类，G是带泛型声明的类或接口。则G<?> 是G<A>、G<B>的父类！  
  ①以List<?>为例，能读取其中的数据。因为不管存储的是什么类型的元素，其一定是Object类的或其子类的。  
  ①以List<?>为例，不可以向其中写入数据。因为没有指明可以存放到其中的元素的类型！唯一例外的是：null   
  6*.  List<？ extends A> :可以将List<A>的对象或List<B>的对象赋给List<? extends A>。其中B 是A的子类  
         ? super A:可以将List<A>的对象或List<B>的对象赋给List<? extends A>。其中B 是A的父类  
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
  URL的编程：统一资源定位符一个URL的对象，对应着互联网上一个资源。  
  //我们可以通过URL的对象调用其相应的方法，将此资源读取（“下载”）  
  
  
  
  

    
  
  
 


