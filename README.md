### Java注意事项

#### 变量

long类型的变量，为了防止整数过大，在定义时需要加L

例：

```java
long x = 10000000L
```

Float类型的变量，在定义时需要加F

例：

```java
float x = 13.14F
```

#### 类型转换

强制类型转换（不建议）：

例：

```java
int x = (int)88.88;
```

#### 数据输入

导入包

```java
import java.util.Scanner;
```

创建对象

```java
Scanner sc = new Scanner(System.in);
```

接收输入数据

```java
//nextInt()表示只读取数值类型的输入
//next()表示只读取到空格
//nextLine()表示读取到回车
int x = sc.nextInt();
```

##### 一些报警

有时会显示 Resource leak: 'Scanner' is never closed

##### 原因

Scanner（system.in）在Scanner中接受的是键盘 输入，当调用close（）方法时，Scanner的关闭会导致System.in的关闭。

**System.in是标准输入（键盘输入），只能关一次，关闭后不能再打开。**

忽略此报警即可。

#### 生成随机数

导入包

```java
import java.util.Random;
```

创建对象

```java
Random r = new Random();
```

接收随机数

```java
//range处输入随机范围，输入10则是随机0-9int x = r.nextInt(range);
```

#### 数组

定义

```java
//方法一int[] arr;//方法二int arr[];
```

初始化

```java
// 动态初始化// 数据类型[] 变量名 = new 数据类型[数组长度]int[] arr = new int[3];// 静态初始化// 数据类型[] 变量名 = new 数据类型[]{数组元素,数组元素,......}int[] arr = new int[] { 1, 2, 3 };//静态初始化简化写法//数据类型[] 变量名 = {数组元素,数组元素,......}int[] arr = {1,2,3};
```

访问

```java
int[] arr = new int[3];// 数组本身直接使用变量名，直接访问会得到内存地址System.out.println(arr);// 数组中的元素，索引从0开始，变量名[索引]，初始化时不赋值则自动赋值为默认值int firstNum = arr[0];
```

数组长度

```java
//通常用于遍历//数组名.lengthint[] arr = {1,2,3,4,5,6,7,8,9};int len = arr.length;
```

数组最值

```java
int[] arr = { 5, 3, 6, 9, 8, 7, 1, 2, 4 };// 定义参数接收最大值int max = 0;for (int i = 0; i < arr.length; i++) {    if (max < arr[i]) {        max = arr[i];    }}System.out.println("maxNum:" + max);
```

#### 方法

##### 方法定义

**方法与main函数同级，不能嵌套定义**

```java
/*public static void 方法名(形参){    //方法体}//形参可以没有，若需要设置形参，必需有参数类型和参数名，多个参数用,隔开*/public static int isfun(int a,int b){    return a*b;}//在return返回中，返回值是什么参数类型，在定义函数时需要设置指定参数类型//例如此处函数返回值为int类型，在定义函数时则设置为int类型
```

##### 方法调用

```
//方法名(实参)int result = isfun(5,10);
```

#### 方法重载

条件

- 多个方法在同一个类中
- 多个方法具有相同的方法名
- 多个方法的参数不相同，类型不同或数量不同

```java
public static void main(String[] args) {
    int result = add(15, 20);
    System.out.println(result);
    result = add(15, 20, 35);
    System.out.println(result);
    result = add(15, 25, 36, 20);
    System.out.println(result);
}

public static int add(int a, int b) {
    return a + b;
}

public static int add(int a, int b, int c) {
    return a + b + c;
}

public static int add(int a, int b, int c, int d) {
    return a + b + c + d;
}
```

#### 类的定义

下列代码中，x、y为成员变量，add和together为成员方法

```java
public class calc {
    int x;
    int y;
    public void add(){
        System.out.println(x+y);
    }
    public void together(){
        System.out.println(x*y);
    }
}
```

#### 对象的使用

##### 创建对象

```java
//类名 对象名 = new 类名()
calc cc = new calc();
```

##### 使用对象

```java
//使用成员变量 对象名.变量名
cc.x
//使用成员方法 对象名.方法名()
c
```

#### private关键字

是一个权限标识符，用于保护成员不被别的类使用，被private修饰的成员只能在本类中访问

提供get变量名()、set变量名(参数)两个方法用于获取、设置成员变量，方法用public修饰

例如

```java
private int x;
//提供get与set方法
public int getx(){
	return x
}
public void setx(int newx){
    //可在此处对定义的异常数据进行处理
	x=newx
}
```

#### This关键字

用this关键字修饰的变量就是成员变量，没有用this修饰的关键字就是局部变量

```java
private int x;
//提供get与set方法
public int getx(){
	return x
}
public void setx(int x){
    //此处的this.x表示成员变量x，x表示局部变量x
    //方法变量和成员变量同名时需要使用this，若此处形参变量名不为x而是其他名字，那么直接写x就是成员变量
    //总之在方法中调用变量，如果有定义形参则会先调用形参，而不会调用成员变量
	this.x=x
}
```

#### 封装

面向对象三大特征（封装、继承、多态）

##### 封装原则

将类的某些信息隐藏在类内部，不允许外部程序直接访问，而是通过该类提供的方法来实现对隐藏信息的操作和访问成员变量private，提供对应的getXxx和setXxx方法。

##### 封装好处

通过方法来控制成员变量的操作，提高了代码的安全性。

把代码用方法进行封装，提高了代码的复用性。

#### 构造方法

也算是初始化方法，在new对象时可以通过传入数据初始化成员变量。

语法为public 类名(参数){代码块}，在**new对象时会执行该构造方法中的代码**，该代码示例中运用了方法重载，分为无参数传入时和两个参数传入时两个方法。

如果**没有定义**构造方法，系统将会**给出一个默认的无参构造方法**，如果**定义**了方法，系统将**不再给出无参构造方法**

如果自定义了带参构造方法，还要使用无参构造方法，就必须再写一个无参构造方法重载

**推荐无论是否使用，都自己写一个无参构造方法。**

```java
public class test_private_class {
    private int age;
    private String gender;
    public test_private_class(){
        //这是一个无参构造方法
    }
    public test_private_class(String gender,int age){
        this.gender=gender;
        this.age=age;
    }
    public int getAge() {
        return age;
    }
    public String getGender(){
        return gender;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
}
```

#### 标准类制作

1.成员变量

- 使用private修饰符

2.构造方法

- 提供一个无参构造方法

- 提供一个带参构造方法

3.成员方法

- 提供每一个成员变量对应的getXxx()和setXxx()方法

- 提供一个显示对象信息的show()

#### 字符串比较

- ==比较的是字符串的地址

- equals()比较的是字符串的数据值

```java
char[] cr={"a","b","c"};
String sc1=new String(cr);
String sc2=new String(cr);
System.out.println(sc1==sc2);	//该输出为false
System.out.println(sc1.equals(sc2));		//该输出为true
```

#### 字符串方法

##### 获取字符串长度

字符串名.length()

```java
//获取数组长度
int[] arr={1,2,3,4,5}
System.out.println(arr.length)
//获取字符串长度
String st="abc";
System.out.println(st.length());
```

##### 获取字符串指定索引字符

字符串名.charAt(索引)

```java
String st="abc";
for(int i=0;i<st.length();i++){
    System.out.print(st.charAt(i)+",");
}
```

##### 字符串拼接

字符串+="需要拼接的字符"

```java
st+="abc";
```

#### StringBuilder

字符串在拼接时每次都会构建一个新的String对象，既耗时又浪费内存空间，为了解决这种问题，可以采用StringBuilder类型

String中的内容是不可变的，StringBuilder中的内容是可变的。

##### 构造对象

```java
//空白StringBuilder对象
StringBuilder sb = new StringBuilder();
//带参StringBuilder对象
StringBuilder sb2 = new StringBuilder("sb2");
```

##### 字符串拼接

字符串名.append()，拼接时没有类型限制，会改变原对象。

```java
//new空白StringBuilder对象
StringBuilder sb = new StringBuilder();
sb.append("我");
sb.append("是");
sb.append("第");
sb.append("100");
sb.append("个");
sb.append("大");
sb.append("聪");
sb.append("明");
System.out.println(sb);
//上面拼接字符方法也可写成下列形式
//链式编程,因为StringBuilder.append()的返回值是一个对象，对象还可以继续调用append()方法，所以构成下面的链式编程
StringBuilder sb2 = new StringBuilder();
sb2.append("我").append("是").append("第").append("100").append("个").append("大").append("聪").append("明");
System.out.println(sb2);
```

##### 字符串反转

字符串名.reverse()，会改变原对象。

```java
//new空白StringBuilder对象
StringBuilder sb = new StringBuilder("abcdefg1234567");
System.out.println(sb);
sb.reverse();
System.out.println(sb);
```

##### String和StringBuilder相互转换

string转换为StringBuilder

```java
String s="intelligent";
StringBuilder sb=new StringBuilder(s);
```

StringBuilder转换为String

```java
StringBuilder sb = new StringBuilder("abcdefg1234567");
String s=sb.toString();
```

#### 集合ArrayList\<E>

使用该集合类型需要导入包java.util，该类型是可调整大小的数组实现。

\<E>是一种特殊的数据类型，泛型，在出现E的地方使用引用数据类型替代即可。

例如ArrayList\<String>、ArrayList\<Student>

##### ArrayList构造

使用前需先导入包java.util.ArrayList

ArrayList<String> 数组名= new ArrayList<String>();

```java
ArrayList<String> array = new ArrayList<String>();
```

##### ArrayList添加

该方法具有方法重载。

array.add(元素);				//在数组末尾添加指定元素

array.add(索引,元素);		//在数组指定索引位置插入指定元素，索引不可越界（超出数组最大长度）

##### ArrayList删除

该方法具有方法重载。

array.remove(元素);			//指定元素

array.remove(索引);			//删除指定索引元素,返回被删除的元素，索引不可越界（超出数组最大长度）

##### ArrayList修改

array.set(索引,元素);			//修改指定索引元素，返回被修改的元素，索引不可越界（超出数组最大长度）

##### ArrayList获取

array.get(索引);				//返回指定索引元素，索引不可越界（超出数组最大长度）

##### ArrayList长度

array.size();				//返回集合中元素个数

```java
import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args){
        //创建一个新的ArrayList对象，在堆内存中开辟内存空间
        ArrayList<String> array = new ArrayList<String>();
        //向ArrayList中添加新的元素
        array.add("This");
        array.add("is");
        array.add("a");
        array.add("ArrayList");
        //打印该ArrayList
        System.out.println(array);
        //向ArrayList指定位置插入元素,index值就是所插入元素的位置
        array.add(3,"new");
        System.out.println(array);
        //删除指定元素
        array.remove("new");
        System.out.println(array);
        String result;
        //删除指定索引元素,返回被删除的元素
        result=array.remove(3);
        System.out.println(result);
        System.out.println(array);
        //修改指定索引元素，返回被修改的元素
        result=array.set(2,"nothing");
        System.out.println(result);
        System.out.println(array);
        //返回指定索引元素
        result=array.get(2);
        System.out.println(result);
        System.out.println(array);
        //返回集合中元素个数
        int len;
        len=array.size();
        System.out.println(len);
    }
```

下面为System.out.println()的打印结果

```java
[This, is, a, ArrayList]
[This, is, a, new, ArrayList]
[This, is, a, ArrayList]
ArrayList
[This, is, a]
a
[This, is, nothing]
nothing
[This, is, nothing]
3
```

#### 快捷键Alt+Insert

该快捷键可以快速生成构造方法和get、set方法。

#### 退出JVM虚拟机

```java
System.exit(0)
```

#### 继承

面向对象三大特征（封装、继承、多态）

##### 继承的格式

public class 子类 extends 父类名{}

```java
public class child extends parent{}
//parent是父类，也称为基类，超类
//child是子类，也称为派生类
```

##### 继承的好处与弊端

好处：

- 提高了代码的复用性

- 提高了代码的维护性

弊端：

- 类之间的耦合性增强，降低了类的独立性，当父类发生变化时，子类不得不发生改变

##### 继承参数传递

与javaScript原型链相同

子类局部范围->子类成员范围->父类成员范围

##### Super关键字

倘若三个位置都有同一个变量age、构造方法、成员方法add

子类局部范围->子类成员范围->父类成员范围

```java
age->this.age->super.age			访问变量

this()->super()					访问构造方法

this.add()->super.add()				访问成员方法
```

##### 继承中构造方法的访问特点

子类中所有的构造方法都会默认访问父类中的**无参**构造方法

因为子类有可能会使用到父类的数据，所以在子类初始化之前要先初始化父类

每一个子类构造方法的第一句都默认是super()，无论有没有写该语句、是无参构造方法和带参构造方法，若要调用父类中的带参构造方法，可在子类构造方法中写入super(参数)。

推荐自己在父类中创建无参构造方法。

##### 方法重写

当子类既需要父类中的功能，又需要有自己的特有内容时，可以重写父类中的方法，既沿袭了父类的功能，又定义了特有的功能。

- 父类中私有方法无法重写

在方法前加@override可以注解下方代码为代码重写

```java
@override
public void afun(){
	System.out.println("this is a children fun");
	super.afun();
}
```



##### final关键字

