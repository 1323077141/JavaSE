## 目录


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
javac 文件名  
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



