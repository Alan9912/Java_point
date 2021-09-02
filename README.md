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
public static void main(String[] args) {    int result = add(15, 20);    System.out.println(result);    result = add(15, 20, 35);    System.out.println(result);    result = add(15, 25, 36, 20);    System.out.println(result);}public static int add(int a, int b) {    return a + b;}public static int add(int a, int b, int c) {    return a + b + c;}public static int add(int a, int b, int c, int d) {    return a + b + c + d;}
```

#### 类和对象

##### 类

具有共同属性和行为的事物的抽象，是对象的抽象

##### 对象

是真实存在的实体，是类的实体

##### 属性

对象的属性

##### 行为

对象的行为

以上多个名词下面以实际生活进行解释

比如说手机，手机拥有品牌、价格的属性，拥有打电话、发信息的行为，但没有具体到哪一部手机，就只是一个概念。

对于每一部具体的手机，例如小米、苹果，他都具有手机的通性，但每一处细节都又有差别。

这里手机就是一个类，小米就是一个对象，每一个对象都拥有各自的属性和行为。

下图可以进行更直观的解释说明

