# JAVA	

## 简要	

Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的类的多继承、指针等概念，因此Java语言具有功能强大和简单易用两个特征。Java语言作为静态面向对象编程语言的代表，极好地实现了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程 。Java具有简单性、面向对象、分布式、健壮性、安全性、平台独立与可移植性(java代码是运行在jvm中，因而跨平台性好)、多线程、动态性等特点。Java可以编写桌面应用程序、Web应用程序、分布式系统和嵌入式系统应用程序等。区分大小写 

### 1 程序执行过程

<img src="/Users/olic/work/图片库/Java执行过程.png" alt="Java执行过程"  />

**说明：** 

- public static void main(String[] args) 方法是Java程序的入口
- 在一个Java源文件中可以声明多个class或接口时，如果需要声明public时，只能一个类或接口声明为public且要求该类名或接口名必须和源文件名同名；如果不需要声明public时，无需类名或接口名和文件名一样。多个class或接口情况则会生成多个字节码文件，字节码文件名与源文件中的类名或接口相同
- 编译完成源程序后，生成一个或者多个字节码文件(磁盘中)。我们使用JVM中类加载器和解释器对生成的字节码解释运行，意味需要将字节码文件对应的类加载到内存中，此过程涉及内存解析

### 2 计算机底层存储

**存储说明：**计算机要准确的处理各种字符集文字，需要进行字符编码，以便计算机能够识别和存储各种文字。计算机底层是以补码形式存储数据

**常见字符集：**ASCII字符集、GB2312字符集、BIG5字符集、GB18030字符集、Unicode字符集等

**符号位：**0代表正；1代表负

**补码计算规则：**正数：三码合一； 负数：补码 = 反码(除符号位其他位置取反) +1

**数据结构：**链表和数组是真实存在的存储数据的结构

### 3 值传递机制

**赋值刨析：**如果变量是基本数据类型，此时赋值的是变量所保存的数据值；如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址。**Java中都是值传递机制**

### 4 单元测试

**单元测试执行过程：**junit集成了main方法，会创建该类的对象，随后调用相应测试方法。单元测试方法相当于一个执行入口

**满足单元测试要求：** 

- 类是权限是public

- 类中提供公共无参构造器
- 方法权限是public

### 5 Jdk

**查看jdk路径：**/usr/libexec/java_home -V

**jdk下目录：** 

- bin：开发工具。如javac 文件名进行编译、java 类名进行运行
- jre：运行时环境。里面包含jvm、src源码
- lib：存放jar包	

<img src="/Users/olic/work/图片库/jdk.png" alt="jdk" style="zoom:67%;" />

**说明：**通常windows配置环境变量的原因就是要保证我们在不同目录下可以执行java、javac等。建立中间变量JAVA_HOME是为了满足服务器的需要

### 6 Jvm

**组件：**类加载器、运行时数据区、执行引擎、本地库接口

<img src="/Users/olic/work/图片库/虚拟机.png" alt="虚拟机" style="zoom:130%;" />

**组件的作用：**首先通过类加载器(ClassLoader)会把 Java 代码转换成字节码，运行时数据区(Runtime Data Area)再把字节码加载到内存中，而字节码文件只是 JVM 的一套指令集规范，并不能直接交个底层操作系统去执行，因此需要特定的命令解析器执行引擎(Execution Engine)，将字节码翻译成底层系统指令，再交由 CPU 去执行，而这个过程中需要调用其他语言的本地库接口(Native Interface)来实现整个程序的功能

**类的加载过程：** 

1. **加载：**将java文件导入jvm中生成class文件
2. **检查：**检查加载的class文件的正确性
3. **准备：**给类中的静态变量分配内存空间
4. **解析：**虚拟机将常量池中的符号引用替换成直接引用的过程
5. **初始化：**对类的静态变量、静态方法和静态代码块执行初始化工作

**jvm中变量加载位置：**

- 虚拟机栈：局部变量
- 堆：new出来的结构(如，Integer i = 5)、成员变量
- 方法区：字符串常量池、类、静态变量

## 面向过程

### 1 变量

**类型：**

- **基本类型：**整型(byte、short、int、long)  浮点型(float、double)  字符型(char)  布尔型(boolean)
- **引用类型：**类(class)[字符串(string)等]、接口(interface)、数组([])

**运算时类型转换：** 

- **自动类型提升：**当容量小的类型变量与容量大的类型做运算时，结果自动提升容量大的 类型。特别的，当byte、short、char三种类型做运算时(即使是相同类型)结果都是int型
- **强制类型转换：**需要使用强转符号 ()。强制类型转换可能导致精度损失

**全局变量：**在整个程序中都生效的变量。静态变量和成员变量就是全局变量

**局部变量：**声明在函数|方法内，只在函数|方法内生效，这个函数就是这个变量的作用域，需要手动赋值

**静态变量(类变量)：**由static修饰的变量称为静态变量

**成员变量(实例变量)：**没有被静态修饰的内容，其实是属于对象的特殊描述

**随机数：**[B,A]区间整数表述  (int)(Math.random()*(A-B+1)+B)

**null：**引用数据类型值为null代表无指针指向

**说明：** 

- 变量声明赋值之后才可以被使用
- 声明long型变量时，必须以'l'或'L'结尾(有时需要考虑自动提升情况)，声明float型变量时，必须以'f'或'F'结尾
- 容量大小表示数的范围。如float容量大于long
- 整型常量默认类型是int型；浮点型常量默认类型是double型
- char使用单引，String使用双引

### 2 运算符

**一元运算符：**++，--

**二元运算符：**+，-，*，/，%(取余)

**三目运算：**类型 max = (a>b)?a:b。 编译时需要a和b类型统一，编译器可自动类型提升

**赋值：**=，+=，-=，*=，/=，%=	

**比较：**==，!=，<，>，<=，>=，instanceof 

**逻辑：** 

- **&：**两个数值的个位分别相与，同时为1才得1，只要一个为0就为0 。和&&运算结果相同

- **&&(短路与)：**只要“&&”前面是false，无论“&&”后面是true还是false，结果都将返“&&”前面的值；只要“&&”前面是true，无论“&&”后面是true还是false，结果都将返“&&”后面的值

- **|：**两个位只要有一个为1，那么结果都为1。否则就为0，和||运算结果相同

- **||(短路或)：**只要“||”前面为false,不管“||”后面是true还是false，都返回“||”后面的值；只要“||”前面为true,不管“||”后面是true还是false，都返回“||”前面的值

- **!：**取反

- **^(异或)：**变量值相同时结果为false，变量值不相同时结果为true

- **位运算：** **<<(左移)：**空位用0填充

​						 **>>(右移)：**空位用0或1补充，取决于原数的正负

​						**>>>(无符号右移)：**空位用0补充

​						**&：**对应bit位进行&运算

​						**｜：**对应bit位进行|运算

​						**^：**对应bit位进行^运算

​						**～：**对应bit位进行取反运算，最高位也会进行取反	 	

**非数字型变量算术运算：**拼接 + 

**说明：** 

- double d = 5/2 结果为2.0，修改为double d = 5/(2+0.0) 结果为2.5
- 取余操作结果值的正负取决于被模数
- ++，--，+=，-= 等不会改变变量本身的数据类型。如byte i = 1; i+=1。结果i的类型仍然是byte
- 逻辑和位运算中相同符号区别在于：逻辑符号两边类型是布尔，位运算是数字
- 三目运算可以嵌套使用，且能用三目运算的地方都可以改写成if-else形式		  

### 3 命名

**标识符：**变量名、函数名、类名、接口名、源文件名、包名等

**标识符命名规则：**字母、下划线、数字，不能以数字或特殊字符开头，不能与关键字重名

**标识符命名规范：**大、小驼峰命名规范，见名知意等。如，包名xxxyyyzzz、类或接口名XxxYyyZzz、变量或方法名xxxYyyZzz、常量名XXXYYYZZZ	     

### 4 输入输出

**文档注释：**/** @... */    **单行注释**  //    **多行注释**  /**/ 

**键盘输入：**

1. Scanner scan = new Scanner(System.in)
2. 提示信息
3. 类型 变量 = scan.方法()  

**输出：**System.out.println()

**终止虚拟机：**System.exit(0)

### 5 转义字符

**在控制台输出一个制表符，保证垂直方向对齐：**\t

**在控制台输出一个换行符：**\n

**单引：**\ '

**双引：**\ ""	

**回车：**\r

**反斜杠：**\ \

**说明：**

- '\t'和"\t"效果一样
- 在java中要输出'\n'或'\t'或'\r'等可以使用\进行转译

### 6 关键字

**定义：**被Java语言赋予了特殊含义，专用用途的字符串

**种类：** 

- **数据类型关键字**  int、class、enum、interface
- **流程控制关键字**  if、switch、for、while
- **权限修饰符关键字**  private、default、protected、public
- **类、函数、变量修饰符关键字**  abstract、final、static、synchronized
- **类/接口和类/接口之间关系关键字**  extends、implements
- **建立实例、引用实例、判断示例关键字**  new、this、super、instanceof
- **异常处理关键字**  try、catch、finally、throw、throws
- **包的关键字**  package、import
- **其它**  native、strictfp、transient、volatile、assert

### 7 判断

**switch语句说明：**

- 根据switch表达式中的值，依次匹配各个case中的常量，一旦匹配成功则进入相应case结构中，执行该case结构中的代码。执行完成后，则仍然继续向下执行其他case结构中的执行语句，直到遇到break关键字(不会执行default)或执行完成该switch模块
- switch表达式中的值只能是这六种类型：byte，short，char， int，枚举，String
- break在switch-case模块可选，可以和if-else嵌套使用

```java
// 输入年月日，输出本年的第多少天
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("年份：");
        int year = scan.nextInt();
        System.out.println("月份：");
        int month = scan.nextInt();
        System.out.println("日：");
        int day = scan.nextInt();

        int sumday = 0;
        switch(month){
            case 12:
                sumday += 30;
            case 11:
                sumday += 31;
            case 10:
                sumday += 30;
            case 9:
                sumday += 30;
            case 8:
                sumday += 31;
            case 7:
                sumday += 30;
            case 6:
                sumday += 31;
            case 5:
                sumday += 30;
            case 4:
                sumday += 31;
            case 3:
                // 平闰年不同处判断
                if((year % 4 == 0 && year % 100 !=0) || (year % 400 == 0)){
                    sumday += 29; //闰
                }else{
                    sumday += 28; //平
                }
            case 2:
                sumday += 31;
            case 1:
                sumday += day;
        }
        System.out.println(year+"年"+"第"+sumday+"天");
    }
}
```

### 8 循环

**关键字：**break 当满足某一条件时，退出循环；continue 当满足某一条件时，不执行后续的代码，其他条件正常执行 

**说明：**

- **标签:for()   break 标签或continue 标签**  该操作可以对指定循环进行控制

- do-while循环至少会执行一次循环体。三种循环语法都可以处理不知道循环次数的循环逻辑

```java
// 不确定输入次数，输入0则退出，最后统计输入的正负数的个数
import java.util.Scanner;
public class Test5 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入数字：");
        int pNumberTotle = 0;
        int nNumberTotle = 0;

					//while循环实现     
//        while(true){
//            int number = scan.nextInt();
//            if(number>0){
//                pNumberTotle++;
//            }else if(number<0){
//                nNumberTotle++;
//            }else{
//                break;
//            }
//        }
//        System.out.println("正数个数："+pNumberTotle+", 负数个数："+nNumberTotle);

        //for循环实现
        for(;;){
            int number = scan.nextInt();
            if(number>0){
                pNumberTotle++;
            }else if(number<0){
                nNumberTotle++;
            }else{
                break;
            }
        }
        System.out.println("正数个数："+pNumberTotle+", 负数个数："+nNumberTotle);
    }
}


// 素数
public class Test7 {
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        for(int i=2; i<100000; i++){
            boolean isFlag = true;
            for(int j=2; j<=Math.sqrt(i); j++){  //开方后的数字介于任意两约数乘积之间，因而只需要判断到该数字即可
                if(i%j == 0){
                    isFlag = false;
                    break;
                }
            }
            if(isFlag){
                System.out.println(i);
            }
        }
        long end = System.currentTimeMillis();
        long time = end-start;
        System.out.println(time);
    }
}

// 核心处修改使用另一种方式
lb:for(int i=2; i<100000; i++){
       boolean isFlag = true;
       for(int j=2; j<=Math.sqrt(i); j++){  
            if(i%j == 0){
            		isFlag = false;
            		continue lb;
       			}
    	}
    	if(isFlag){
          System.out.println(i);
      }
  }
```

### 9 递归

**条件：** 

1. 方法内部自己调用自己
2. 设置递归出口条件

```java
// 已知f(0)=1,f(1)=4,f(n+2)=2f(n+1)+f(n)
public class Test14 {
    public static void main(String[] args) {
        System.out.println(f(10));
    }
    public static int f(int n){
        if(n==0){
            return 1;
        }else if(n==1){
            return 4;
        }else{
            return 2*f(n-1)+f(n-2);  // 变通点
        }
    }
}

/**
     * 获取下拉菜单树
     * @param menu
     * @return
     */
    @Override
    public List<SysMenuVo> treeSelect(SysMenu menu) {
        List<SysMenuVo> resultList = new ArrayList<>();
        List<SysMenuVo> sysMenuVoList = null;
        //条件下全部菜单
        sysMenuVoList = sysMenuMapper.selectTree(menu);
//        if(CollectionUtils.isEmpty(sysMenuVoList)){
//            return null;
//        }
//        Optional<SysMenuVo> tmp = sysMenuVoList.stream().filter(item->item.getParentId()==0).findFirst();
//        if(!tmp.isPresent()){
//            return null;
//        }
        // 先定位所有的一级菜单, 集合为空时不会遍历，resultList为空时表示没有一级菜单，直接返回null
        resultList = sysMenuVoList.stream().filter(item-> item.getParentId()==0).collect(Collectors.toList());
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (SysMenuVo sysMenuVo : resultList) {
            sysMenuVo.setChildrenMenus(getChild(sysMenuVo.getMenuId(), sysMenuVoList));
        }
        return resultList;
    }

    /**
     * 递归查找子菜单
     * @param menuId    当前菜单id
     * @param sysMenuVoList 要查找的列表
     * @return
     */
    private List<SysMenuVo> getChild(long menuId, List<SysMenuVo> sysMenuVoList) {
        // 子菜单
        List<SysMenuVo> childList = new ArrayList<>();
        for (SysMenuVo sysMenuVo : sysMenuVoList) {
            // 遍历所有节点，将父菜单id与传过来的全部菜单的父id比较
            if (sysMenuVo.getParentId() != null) {
                if (sysMenuVo.getParentId().equals(menuId)) {
                    childList.add(sysMenuVo);
                }
            }
        }
        // 把子菜单的子菜单再遍历一次
        for (SysMenuVo sysMenuVo: childList) {
            // 递归
            sysMenuVo.setChildrenMenus(getChild(sysMenuVo.getMenuId(), sysMenuVoList));
        }
        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
}
```

### 10 数组

**一维数组：**

- 数组元素类型[]  数组名 = new 数组元素类型[]{数组元素1, 数组元素2...}


- 数组元素类型[]  数组名 = new 数组元素类型[数组长度]


**二维数组：**

- 数组元素类型\[][] 数组名 = new 数组元素类型\[][]{{元素1,元素2},{元素1,元素2,元素3}...}


- 数组元素类型\[][] 数组名 = new 数组元素类型\[长度1][长度2]


**说明：**

- new 数组元素类型[]部分可以省略
- 二维数组中的长度2可以省略。长度就是元素个数
- []可以写到数组名之后
- 数组是Object的一个子类

**特点：**内存空间连续，数组元素(分量)必须是相同数据类型，初始化完成长度确定并不可修改

**数组元素默认初始值：** **一维数组：**

​														数组元素是整型 0

​													    数组元素是浮点型 0.0

​													 	数组元素是char型 0 

​													 	 数组元素是boolean型 false

​													 	 数据元素是引用数据类型 null

​										**二维数组：**

​														外层数组元素：地址值或null

​														内层数组元素：

​																数组元素是整型 0

​													 	    	数组元素是浮点型 0.0

​													 	    	数组元素是char型 0 

​													 	    	数组元素是boolean型 false

​													 	    	数据元素是引用数据类型 null

**说明：**对象数组, 就有可能出现null。 取出时不会出错, 用的话就会报空指针异常

**属性：**length

**Arrays工具类：**equals(数组名1,数组名2)  比较数组里面内容是否相；toString(数组名)  返回数组内容；fill(数组名,指定值)  把数组中的每一个元素替换成指定值；sort(数组名)  排序,底层是快排；binarySearch(数组名, 查找值)  二分查找

**遍历：**普通for循环，增强for循环都可以对数组进行遍历

**说明：**print()输出char型数组时，会打印数组内容，其他则输出地址

```java
// 赋值    
public class Test12 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5},{7,8,9}};
        int[][] arr2 = arr;
        arr2[1][1] = 10;
        System.out.println(arr[1][1]);  // 10
    }
}

// 复制
// 此算法实现有点类似于python中的深拷贝原理(两层new)
public class Test12 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5},{7,8,9}};
        int[][] arr2 = new int[arr.length][];
        for(int i=0; i< arr.length; i++){
            arr2[i] = new int[arr[i].length];
            for(int j=0; j<arr[i].length; j++){
                arr2[i][j] = arr[i][j];
            }
        }
        arr2[1][1] = 10;
        System.out.println(arr[1][1]);  // 5
    }
}
// 此算法实现有点类似于python中的浅拷贝原理
public class Test12 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5},{7,8,9}};
        int[][] arr2 = new int[arr.length][];
        for(int i=0; i< arr.length; i++){
            arr2[i] = arr[i];
        }
        arr2[1][1] = 10;
        System.out.println(arr[1][1]);  // 10
    }
}

//反转
public class Test12 {
    public static void main(String[] args) {
        String[] arr = new String[]{"aa", "bb", "cc", "dd", "ee"};
        for(int i=0; i<arr.length/2; i++){
            String temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }
}

// 二分查找(有序数组,时间复杂度o(log2n))
public class Test12 {
    public static void main(String[] args) {
        int[] arr = new int[]{-3,-2, 0, 3, 8, 15, 20};
        int start = 0;
        int end = arr.length-1;
        boolean flag = true;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid] == 8){
                flag = false;
                System.out.println("找到了，要查找的数字索引位置为"+mid);
                break;
            }else if(arr[mid] > 8){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        if(flag){
            System.out.println("查无此数据");
        }
    }
}

// 冒泡(时间复杂度o(n**2))
public class BubbleSort{
    public static void main(String[] args) {
        int[] num = new int[]{12, 3, 2, 7 ,6,10};
        BubbleSort.bubbleSort(num);
        System.out.println(Arrays.toString(num));
    }
    public static void bubbleSort(int[] arr) {
        for(int i=1; i<arr.length; i++) {  // i轮数
            for(int j=0; j<arr.length-i; j++) { 
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
// 改进后的冒泡排序最佳时间复杂度位o(n)
public class BubbleSort{
    public static void main(String[] args) {
        int[] num = new int[]{12, 3, 2, 7 ,6,10};
        BubbleSort.bubbleSort(num);
        System.out.println(Arrays.toString(num));
    }
    public static void bubbleSort(int[] arr) {
        for(int i=1; i<arr.length; i++) {
          	boolean didSwap = false;
            for(int j=0; j<arr.length-i; j++) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    didSwap = true;
                }
            }
            if(didSwap == false)  //第n轮遍历发现原本数组元素顺序已经满足结果，无需进行其他轮
                return;
        }
    }
}

// 快排(时间复杂度o(nlog2n))  
public class QuickSort {
    private static int count;
    public static void main(String[] args) {
        int[] num = {3,45,78,64,52,11,64,55,99,11,18};
        System.out.println(Arrays.toString(num));
        QuickSort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
        System.out.println("数组个数："+num.length);
        System.out.println("循环次数："+count);
    }
    private static void QuickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if(left>=right) {
            return;
        }
        //设置最左边的元素为基准值
        int key=num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i=left;
        int j=right;
        while(i<j){
            //j向左移，直到遇到比key小的值
            while(num[j]>=key && i<j){
                j--;
            }
            //i向右移，直到遇到比key大的值
            while(num[i]<=key && i<j){
                i++;
            }
            //i和j指向的元素交换
            if(i<j){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        num[left]=num[i];
        num[i]=key;
        count++;
        QuickSort(num,left,i-1);
        QuickSort(num,i+1,right);
    }
}
```

### 11 字符串

**String str = “abc”  字面量方式创建过程：**

1. 首先在常量池中查找是否存在内容为"abc"字符串对象
2. 如果不存在则在常量池中创建"abc"，并让str引用该对象(创建1个对象)
3. 如果存在则直接让str引用该对象(创建0个对象)
4. 如果String str2 = "abc"，则str2也指向abc，以便复用地址

**String str = s1+"def"  String s1 = "abc"  变量方式创建过程：**

1. 首先在堆中创建一个指定的对象"abcdef"，并让str引用指向该对象(创建第1个对象)
2. 在字符串常量池中查看是否存在内容为"abcdef"的字符串对象
3. 若存在，则让堆中创建好的字符串对象对字符串常量池的对象进行引用(只创建1个对象)
4. 若不存在，则在常量池中添加一个内容为"abcdef"的字符串对象，并将堆中的String对象进行引用(创建2个对象)。说明：**常量和常量的拼接在常量池中**(如Sting str2="abc"+"def"创建1个或者0个对象)

**String str = new String(“abc”)  new方式创建过程：**

1. 首先在堆中创建一个指定的对象"abc"，并让str引用指向该对象(创建第1个对象)
2. 在字符串常量池中查看是否存在内容为"abc"的字符串对象
3. 若存在，则让堆中创建好的字符串对象对字符串常量池的对象进行引用(只创建1个对象)
4. 若不存在，则在常量池中添加一个内容为"abc"的字符串对象，并将堆中的String对象进行引用(创建2个对象)

**String不可变性：**由于String类底层实现是final类型的char型数组，因而无法修改原有的字符串对象

**方法：**intern() 返回常量池里面的字符串地址；length() 返回字符串长度；charAt(索引) 返回索引处的字符；indexof(指定字符串,指定索引开始位置) 指定索引位置从前往后找返回第一次出现的开始索引；lastIndexof(指定字符串,指定索引开始位置) 指定索引位置从后往前找返回第一次出现的开始索引；isEmpty() 判断是否是空字符串；toLowerCase() 将字符串所有字符小写；toUpperCase() 将字符串所有字符大写；trim() 去除字符串前后空白；equals() 比较字符串内容是否相同；equalsIgnoreCase() 忽略大小写，比较字符串内容concat() 连接；compareTo() 比较字符串大小，返回ascii数值差。实现了Comparable接口中的方法；substring(开始索引,结束索引) 截取。可指定开始索引和结束索引；endsWith(指定字符) 判断字符串是否以指定的后缀结尾；startsWith(指定字符,开始索引,结束索引) 判断指定索引的字符串是否以指定的前缀开始；contains() 判断字符串1中是否包含字符串2；replace(旧串,新串) 替换；replaceAll(String 正则,新值) 全局替换；matches(String 正则) 匹配；split(String 正则) 切分；join() 连接给定字符串或者通过分隔符连接列表数据

**转换：**  

- 基本数据类型、包装类转换为字符串：String.valueOf(基本数据类型变量或包装类对象引用)
- 字符串转换为包装类或基本数据类型：包装类名.parseXxx(字符串)
- char[]转换为字符串：new String(char[],开始索引,长度)
- 字符串转换到char[]：toCharArray()
- byte[]转换到字符串：new String(byte[],编码集)  即称为解码
- 字符串转换到byte[]：getBytes(编码集)   即称为编码	

**StringBuffer：**可变字符序列，线程安全，效率低

**StringBuilder：**可变字符序列，线程不安全，效率高。开发中若不存在线程安全问题，推荐使用

**源码分析：**使用空参构造器默认容量为16，如果append()添加的数据底层容量盛不下，那就需要扩容底层的数组，默认情况下，扩容为原来容量的2倍+2或扩容为现有的数据长度，同时将原有的数据中的元素复制到新的数组中；为了避免扩容，建议在开发中使用StringBuffer(int capacity)或StringBuilder(int capacity)直接指定容量。使用StringBuffer(String str)构造器，会先扩容为原来容量+16，然后再调用append()

**方法：**append() 拼接；delete(开始索引,结束索引) 删除指定位置的字符串； replace(开始索引,结束索引,新字符串)替换；insert(索引,插入的字符串) 插入； reverse() 反转；indexof(指定字符串,指定索引开始位置) 指定索引位置从前往后找返回第一次出现的开始索引； substring(开始索引,结束索引) 返回子串，有返回值；charAt(索引) 查询索引处的字符；setChatAt(索引,新字符) 指定位置修改；length() 长度

**与String相互转换：** **1、**StringBuffer---> String：调用构造器、toString()；**2、**String--->StringBuffer：调用构造器、append()

### 12 常用类

- **object：**

**方法：**clone()：克隆； equals()：判断引用是否一样；toString()：输出引用变量保存的地址；hashCode() 返回对象的哈希值；wait()：线程进入阻塞状态，并释放同步监视器；nofity()：唤醒被wait的线程，被唤醒的线程进入就绪状态；nofityall()：唤醒所有被wait的线程，被唤醒的线程进入就绪状态；finalized()：垃圾回收

- **System：**

**方法：**currentTimeMillis() 时间戳；exit() 退出。参数0代表正常退出，非0代表异常退出；gc() 垃圾回收，系统是否立即回收取决于系统中的垃圾回收算法的实现，以及系统执行时情况； getProperty(属性名) 获取系统中属性信息

- **Math：**

**方法：**sqrt() 开方，abs() 绝对值等

- **Date：**

**构造器：**new Date()  当前时间    new Date(指定毫秒数)  指定时间

**方法：**getTime()  时间戳

**转换：**Date 转java.sql.Date：new java.sql.Date((new Date()).getTime() )

**java.sql.Date：**

**构造器**  new java.sql.Date(指定毫秒数)  指定时间

- **SimpleDateFormat：**  

**格式化：**日期--->字符串   (new SimpleDateFormat(指定格式)).format(new Date())

**解析：**字符串--->日期(Date类型)   (new SimpleDateFormat(指定格式).parse(格式化的日期字符串))

**说明：**指定格式如“yyyy-MM-dd”，“yyyy/MM/dd”等和字符串格式一致

```java
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String dateStr = sdf.format(woAbnormalEventVO.getCreatedTime()==null?"":woAbnormalEventVO.getCreatedTime());

//数据库中时间类型比较 
DATE_FORMAT(ws.transaction_time,'%Y-%m-%d') <![CDATA[ >= ]]> STR_TO_DATE(#{transactionStartTime},'%Y-%m-%d')
  
// 对像转json时该属性格式
@JsonFormat(pattern = "yyyy-MM-dd")
private Date transactionStartTime;
```

- **Calendar：**可变性

**方法：**  set()；get()；getTime() 返回Date类型数据； setTime(date) 设置时间

- **LocalDateTime、LocalDate、LocalDate：**不可变性

**获取对象：**LocalDateTime localDateTime = LocalDateTime.now()

**方法：**withXxx()、getXxx()

- **Comparable：**排序

- **Comparator：**当元素的类型没有实现Comparable接口而又不方便修改代码或者实现了Comparable接口规则不适合当前需要的排序规则。此时考虑Comparator

```java
/**
 * @author olic
 * @date 2020/11/165:36 下午
 * @Comparable 内部比较器
 * @Arrays.sort()元素需要重写排序方法
 */
public class Test36 {
    @Test
    public void test(){
        Good[] goodArray = new Good[4];
        goodArray[0] = new Good(35, "BB");
        goodArray[1] = new Good(33, "aa");
        goodArray[2] = new Good(34, "dd");
        goodArray[3] = new Good(34, "Cc");
        Arrays.sort(goodArray);
      	// 根据compareTo排序规则打印输出
        System.out.println(Arrays.toString(goodArray));
        int r = new Good(35, "BB").compareTo(new Good(33, "aa"));
        System.out.println(Arrays.toString(goodArray)); //-1
    }
}

class Good implements Comparable<Good>{
    private int price;
    private String name;
    public Good(int price, String name) {
        this.price = price;
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return price == good.price &&
                Objects.equals(name, good.name);
    }
    @Override
    public String toString() {
        return "Good{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public int compareTo(Good g) {
        if(this.price > g.price){
            return -1;  //价格从大到小
        }else if(this.price < g.price){
            return 1;
        }else{
            return this.name.compareToIgnoreCase(g.name); // 名称从小到大
        }
    }
}


/**
 * @author olic
 * @date 2020/11/165:58 下午
 * @Comparator 外部比较器
 */
public class Test37 {
    @Test
    public void test(){      
      	List<Goods> list = Stream.of(new Goods(35, "BB"), new Goods(33, "aa"),new Goods(34, "dd"))
        								.sorted(new Comparator<Goods>(){
            										@Override
            										public int compare(Goods g1, Goods g2) {
                										if (g1.getPrice() > g2.getPrice()) {
                    										return -1;  //价格从大到小
                										} else if (g1.getPrice() < g2.getPrice()) {
                    										return 1;
                										} else {
                    										return g1.getName().compareToIgnoreCase(g2.getName()); //名称从小到大
                										}
            										}
                        }).collect(Collectors.toList());
      	System.out.println(list);
    }
}

class Goods{
    private int price;
    private String name;
    public Goods(int price, String name) {
        this.price = price;
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods good = (Goods) o;
        return price == good.price &&
                Objects.equals(name, good.name);
    }
    @Override
    public String toString() {
        return "Goods{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
```

### 13 包

**关键字：**package

**import：**导入指定包下的类、接口

**说明：**同一个包下面，不能命名同名的接口、类。java.lang下面定义的可以不用导入

## 面向对象

### 1 类

**说明：**当使用类的时候，类才会加载到内存中。但Jvm允许预加载某些类，无需等到使用该类时，如jar中的.class文件

**static：**

- 可以修饰属性、方法、代码块、内部类
- 多个对象共享同一个静态事物，静态事物加载一次
- 静态结构中只能调用静态结构
- 静态方法中不能使用this和super关键字

**final：**

- 用来修饰类、方法、属性
- 修饰类则此类不能被其他类继承。如，String、System、StringBuffer
- 修饰方法则此方法不能被重写可以被继承。如，getClass()
- 修饰变量则此变量就变成一个常量。final 修饰的变量叫常量，常量必须初始化，初始化之后值就不能被修改。修饰属性时，可以考虑赋值的位置有显示初始化、代码块中初始化、构造器中初始化。修饰局部变量时，如修饰形参时，给形参赋值一个实参，方法体内不能进行修改

**属性：** **静态变量(类变量)和成员变量(实例变量)**，都属于全局变量，默认会初始化；方法的形参和方法内的变量属于局部变量需要赋值

**赋值顺序：**默认初始化->显示初始化，代码块中初始化->构造器中初始化->对象.方法或对象.属性

**静态变量：**静态变量随着类的加载而加载

**实例变量：**随着对象的创建而加载

**内部类：**允许将类A声明到类B中，如大脑。分为属性内部类和局部内部类。当第三方代码调用时，如下情况：

- **实例化：**

**静态属性内部类实例化：**外部类名.内部类名  引用名 = new 外部类名.内部类名()

**非静态属性内部类实例化：**外部类名.内部类名  引用名  = 外部类引用.new 内部类名()

- **重名调用：**


**调用外部类的非静态属性：**外部类对象.属性名

**调用外部类的静态属性：**外部类名.属性名

**调用内部类的静态属性：**外部类名.内部类.属性名

**代码块：**用于初始化类和对象

- **静态代码块：**static{

​										代码

​								}

- **非静态代码块：**{

​										代码

​								  }

**说明：**

- 静态代码块随着类的加载而执行(执行次数和类的加载次数一致)；初始化类的信息；只能调用静态结构；优先于非静态代码块的执行；多个静态代码块顺序执行

- 非静态代码块随着对象的创建而执行(执行次数和对象的创建次数一致)；初始化对象的属性等；既可以调用静态的属性和方法也可以调用非静态的属性和方法；多个非静态代码块顺序执行

```java
// 由父及子，静态先行
class Per{
    {
        System.out.println("per非静态");
    }
    static {
        System.out.println("per静态");
    }
    public Per(){
        System.out.println("per无参构造器");  // 默认子类super()调用
    }
    public Per(String name){
        System.out.println("per有参构造器");  // 得通过调用
    }
}

public class Stu extends Per{ //使用了Per类
    {
        System.out.println("stu非静态");
    }
    static {
        System.out.println("stu静态");
    }
  	public Stu() {
        System.out.println("stu无参构造器");
    }
    public static void main(String[] args) {  //main是Stu类中的一个方法，使用了Stu类
        System.out.println("......."); 
        new Stu();
        new Stu();
    }
}

// 输出
per静态
stu静态
.......
per非静态
per无参构造器
stu非静态
stu无参构造器
per非静态
per无参构造器
stu非静态
stu无参构造器
```

### 2 对象

**匿名对象：**new 类名(参数)

**this：** 

- this.属性用于解决方法形参与属性重名的情况，就近查找

- this(形参)方式，调用本类中其他构造器，放至首行

**说明：**

- 匿名对象只能调用一次

- 每次new则会在堆内存中开辟一个地址空间

### 3 身份运算符

**==：**在基本数据类型中用于比较数值的大小。引用数据类型中比较地址是否相等

**equals()：**在Object中比较的是地址，因为源码中调用了==；在String、Date、File、包装类中比较的是内容值。因为重写了equal()方法

**instanceof：**用于判断对象的类型  

```java
// 手动重写equal方法。一般实际开发中无需手动重写可以编译器代码生成
class Animal{
    String name;
    int age;
    public Animal() {
    }
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object obj) {
      	//先比较地址
        if (this == obj) return true;  

//        if(obj instanceof Animal){ //此时最好使用getClass() != o.getClass()判断
      
				//判断俩变量是否属于一种类
        if(obj == null || getClass() != obj.getClass()) return false;  
        //向下转型，使得可以使用自己的属性和特有方法
        Animal o = (Animal)obj;  
      	//name是字符串，里面已经重写了equal比较内容值
        return this.age == o.age && this.name.equals(o.name); 
    }
}

class Cat2 extends Animal{  
    public Cat2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Test21 {
    public static void main(String[] args) {
        Cat2 cat2 = new Cat2("Tom", 2);
        Animal animal = new Animal("Tom", 2);
      	//若不做getClass() != o.getClass()，输出结果错误 为true
        System.out.println(animal.equals(cat2));  
    }
}
```

### 4 重载

**定义：**在同一个类中允许方法同名，只要它们的参数个数或者参数类型不同即可，编译期行为

### 5 多值方法

**原来的语法：**权限修饰符 返回值类型 方法名(参数类型1 参数, 参数类型[] 参数){

​									方法体;

​						}

**新特性语法：**权限修饰符 返回值类型 方法名(参数类型1 参数, 参数类型 ... 参数){

​									方法体;

​						}

**说明：** 

- 优先会考虑参数个数准确的函数，最后才会考虑多值函数
- 多值方法的方法名和本类中方法名相同形参个数或类型不同的方法构成重载
- 可变参数形参应当放到参数列表末尾

### 6 封装

**定义：**隐藏对象内部的复杂性，只对外公开简单的接口

**权限修饰符：**private(同类)、缺省(同包)、protected(不同包下面的子类)、public(不同包)

**用途：** 

- 都可以用来修饰类的内部结构：属性、方法、构造器、内部类
- 修饰类的话只能是缺省或public

**说明：**在不同包下面的子类中，不能调用父类的private和default权限的属性和方法

**应用：**私有化属性、不对外暴露的私有方法(本类内部使用)、构造器私有化等

**私有化属性：**

```java
public class Test15 {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(-5);
        System.out.print(p.getAge());
    }
}

class Person{
    private int age;  //私有化属性，不给外界直接访问
    public void setAge(int a){  //外界访问时可以设置逻辑判断
        if(a>=0&&a<=130){
            age = a;
        }else{
            System.out.print("传入的数据非法");
        }
    }
    public int getAge(){  //外界访问时可以设置逻辑判断
        return age;
    }
}


// 理解protected
父类所在的包
父类(父类属性1，protected 父类属性2，父类方法1，protected 父类方法2)
子类所在的包
子类(父类属性2，父类方法2均可直接使用) // 虽然子类继承了父类属性1和父类方法2但由于权限影响不能被子类直接使用
```

### 7 继承

**定义：**继承就是子类继承父类的所有特征和行为，使得子类对象具有父类的属性和方法。父类中声明的private的属性和方法，子类中也已经继承，只不过由于private权限影响导致在子类中不能直接使用。java中类只允许单继承，接口可以多继承接口。属性不会被覆盖(堆空间中会存在相同名称的变量)，方法会被覆盖；子类实例化时需要调用父类的构造方法

**关键字：**extends

**查看继承关系：**子类引用.getClass().getSuperclass().getSuperclass()   class类型

**重写：**

- 子类重写的方法名和形参列表和父类的相同
- 子类重写的方法的权限修饰符权限不小于父类的权限(子类不能重写父类中private权限的方法)
- 父类方法的返回值类型是void，则子类重写的方法的返回值类型只能是void；父类方法的返回值类型是基本数据类型，则子类重写的方法的返回值类型只能是相同的基本数据类型；父类方法的返回值类型是引用数据类型，则子类重写的方法的返回值类型可以是该类型也可以是该类型的子类
- 子类重写的方法抛出的异常类型不大于父类被重写方法抛出的异常类型
- 父类中static方法不能被重写
- 运行时行为

**super：**解决子父类属性同名问题的一种标识，无同名问题可以隐式使用

- super.父类属性   super.父类方法。需要父类中属性或方法权限大小合适方可使用
- 子类构造器中  super(参数列表) ，调用父类的构造器，放至首行 

**说明：** 

- 在继承中，子类构造器中会隐式调用了父类的无参构造器即super()方式
- 在类的构造器中至少有一个构造器中使用了super

```java
// 以下代码仅为了说明this(参数)和super(参数)的使用
class Person2{
    String name;
    int age;

    public Person2() {
    }
    public Person2(int age) {
        this.age = age;
    }
    public Person2(String name, int age) {
        this(age);  // 减少代码冗余
        this.name = name;
    }

}

class Student2 extends Person2{
    public Student2(String name, int age) {
        super(name, age);  // 调用父类对应参数的构造器
    }
    public void show(){
        System.out.print("姓名："+super.name+"  年龄："+super.age);
    }
}

public class Test19 {
    public static void main(String[] args) {
        Student2 student2 = new Student2("olic", 25);
        student2.show();  // olic 25
    }
}
```

### 8 多态

**定义：**一个事物的多种形态，父类引用指向子类对象(向上转型)，实现代码的通用性。多态性只适用于方法中，不适用于属性

**语法：**父类类型 父类引用 = new 子类名()    

**说明：** 父类引用.getClass() 结果是子类的全类名

**前提：** 

1. 有类的继承关系
2. 要有方法的重写

**结论：**

- 使用多态时，内存中实际加载了子类特有的属性和方法。由于变量是父类类型，导致编译时，子类特殊的属性和方法不能调用 
- 方法：编译看左，运行看右；属性：编译看左，运行看左(因为属性不能被重写)

### 9 向下转型

**场景：**继多态之后实现调用子类特有的方法和属性 	

**用法：**子类类型 子类引用 = (子类类型)父类引用

**说明：** 

- 对于引用数据类型有子父类关系才可以进行强转，否则编译报错，前提new的是子类。若new的父类，则无法进行强转
- 运行时可能会发生类型转换异常。可以使用instanceof判断避免该异常发生

```java
Person p = new Man()
// 为了避免向下转型发生类型转换异常，我们使用instanceof进行判断
if(p instanceof Woman){
  Woman w = (Woman)p
}
if(p instanceof Man){
  Man m = (Man)p
}
```

### 10 包装类

**由来：**针对八种基本数据类型，Java中使用了包装类对基本数据类型进行了包装，使得他们具有类的特征实现真正的面向对象

**类型：** Byte、Short、Integer、Long、Float、Double、Boolean、Character

**关联情况：**前六种类的共同直接父类是Number, Number父类是Object。后两种直接父类是Object

**自动装箱：**Integer i = 3    **自动拆箱：**int s = i

**基本数据类型、包装类转换为字符串：**String.valueOf(基本数据类型变量或包装类对象引用)

**字符串转换为包装类或基本数据类型：**包装类名.parseXxx(字符串)

### 11 抽象类

**定义：**抽象类不能实例化，由子类去完成实例化。其实抽象类和普通类最大的区别在于抽象类中必须含有一个没有被私有化构造器。如果有抽象方法，该抽象方法不能被final，private，static修饰，其他和普通类没区别

**abstract：**修饰类和方法

**说明：** 

- abstract不能用来修饰私有方法、静态方法、final修饰的类和方法，因为私有方法、静态方法和被final修饰的方法都不能被重写
- 抽象类中一定有构造器

**修饰类：**此类不能被实例化

**修饰方法：**

- 只有方法声明没有方法体
- 包含抽象方法的类一定是抽象类。反之，抽象类中可以没有抽象方法
- 若子类重写了父类中所有的抽象方法后，子类方可被实例化
- 若子类没有重写父类的所有的抽象方法，子类也是一个抽象类
- 抽闲类中的非抽象方法可以通过子类继承后直接使用。和接口中默认实现方法对应

**匿名类：** **匿名子类的匿名对象 **new 抽象类名(){

​																重写的抽象方法

​													 }

**说明：**由于new后面无法确定具体的子类，因而使用父类进行匿名代替

### 12 接口

**定义：**接口是一个抽象类型，是抽象方法的集合。接口并不是类，和类是并列的结构。接口中没有构造器，无法被实例化。在Java中，接口可以被类多实现，也可以被其他接口多继承

**说明：** 

- 如果实现类实现了接口所有的抽象方法，则此实现类可以实例化，如果实现类没有实现接口所有的抽象方法，则此实现类仍是一个抽象类
- 接口中的属性和方法可被实现类继承(定义的静态方法除外)
- 如果子类(实现类)继承的父类和实现的接口中有相同方法，若未重写则默认调用父类中的方法
- 实现类中调用接口中的默认方法：接口名.super.方法名
- 接口可以多继承接口

**关键字：**interface

**语法：**interface 接口名{

​							全局常量(必须是public static final)

​							抽象方法(必须是public abstract)

​							静态方法(只能使用接口名调用)

​							默认方法实现

​			}

**匿名类：** **匿名实现类的匿名对象**  new 接口名(){

​																重写的抽象方法

​														}      //该过程中实际上产生了一个匿名实现类

```java
//定义通用接口,实现多态性
interface PCI{
    public abstract void close();
    public abstract void open();
}
//通过通用接口实现多态性
class NetBoard implements PCI{
    @Override
    public void close() {
        System.out.println("PCI runing");
    }
    @Override
    public void open() {
        System.out.println("PCI closed");
    }
}
//通过通用接口实现多态性
class VoiceBoard implements PCI{
    @Override
    public void close() {
        System.out.println("VoiceBoard runing");
    }
    @Override
    public void open() {
        System.out.println("VoiceBoard closed");
    }
}

class MainBoard{
    public void run() {
        System.out.println("MainBoard runing");
    }
    //接口多态性具体使用方式
    public void usePCI(PCI pci) {  
        pci.open();
        pci.close();
    }
}

public class MyComputer {
    public static void main(String [] args) {
        MainBoard board = new MainBoard();
        board.run();
        board.usePCI(new NetBoard());
        board.usePCI(new VoiceBoard());
    }
}
```

### 13 设计模式

#### 13.1单例模式

私有化构造器，内部创建类的对象，提供静态方法。减少系统性能开销

- **饿汉模式：**提前生成对象，内存占用时间过长，线程安全

- **懒汉模式：**延迟对象创建，用时创建

**应用：**网站计数器、数据库连接池、回收站等

```java
/**
 * @author olic
 * @date 2020/11/2510:08 上午
 * @饿汉模式
 */
class Banks{
    private Banks(){
    }
    private static Banks instance = new Banks();
    public static Banks getInstance(){
        return instance;
    }
}
// 饿汉模式其他写法
class Banks{
    private Banks(){
    }
    public static final Banks instance = new Banks();
}

public class Test23 {
    public static void main(String[] args) {
        Banks ins = Banks.instance;
    }
}

/**
 * @author olic
 * @date 2020/11/2510:08 上午
 * @懒汉模式
 */  
class Banks{
    private Banks(){
    }
    private static Banks instance = null;
  	//此时的默认锁是当前类本身，已经线程安全。如果不加锁那么就有可能new多次对象
    public synchronized static Banks getInstance(){ 
        if(instance == null) {
            instance = new Banks();
        }
        return instance;
    }
}

public class Test23 {
    public static void main(String[] args) {
        Banks b = Banks.getInstance();
    }
}
// 懒汉模式的优化--双重检查机制
public class Singleton {
    private volatile static Singleton singleton;
    private Singleton (){}
    public static Singleton getSingleton() {
				if (singleton == null) {  //它只是第一次创建实例的时候同步，以后就不需要同步了
	    			synchronized (Singleton.class) {
								if (singleton == null) {
		    						singleton = new Singleton();
								}
	    			}
				}
				return singleton;
    }
}
```

#### 13.2模版方法模式

整体步骤很固定、通用，这些步骤已经在父类中写好了。但是某些部分易变，易变部分可以抽象出来，供不同的子类实现

```java
abstract class BankTemplate{
    public final void takeNumber(){
        System.out.println("取号。。。");
    }
    // 办理具体的业务
    public abstract void transact();
    public final void evaluate(){
        System.out.println("评价。。。");
    }

    // 模版  无需子类重写
    public final void process(){
        takeNumber();
        transact();
        evaluate();
    }
}

class Per1 extends BankTemplate{
    @Override
    public void transact() {
        System.out.println("我要取钱。。。");
    }
}

class Per2 extends BankTemplate{
    @Override
    public void transact() {
        System.out.println("我要理财。。。");
    }
}

public class Test25 {
    public static void main(String[] args) {
        // 多态
        BankTemplate b1 = new Per1();
        BankTemplate b2 = new Per2();
        b1.process();
        System.out.println("***********");
        b2.process();
    }
}
```

#### 13.3代理模式

为其他对象提供一种代理以控制这个对象的访问。代理类和被代理类要实现同一套接口，代理控制其他对被代理类的访问控制

```java
/**
 * @author olic
 * @date 2020/11/249:58 下午
 * @静态代理
 */
interface PhoneFactory{
    void sell();
}

//被代理类
class Mi implements PhoneFactory{
    @Override
    public void sell() {
        System.out.println("为发热而生的小米");
    }
}

//代理类
class BrandStore implements PhoneFactory{
    private Mi mi;
    public BrandStore(Object obj) {
        this.mi = (Mi)obj;
    }
    @Override
    public void sell() {
        System.out.println("售前活动");
        mi.sell();
        System.out.println("售后服务");
    }
}

public class Test25 {
    @Test
    public void test(){
        PhoneFactory mi = new Mi();
        PhoneFactory brandStore = new BrandStore(mi);
        brandStore.sell();
    }
}


/**
 * @author olic
 * @date 2020/11/2510:08 上午
 * @动态代理
 * java动态代理是利用反射机制生成一个实现代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理
 */

interface Human{
    void getBelieve();
    String eat(String food);
}

//被代理类
class SuperMan implements Human{
    @Override
    public void getBelieve() {
        System.out.println("I believe I can fly");
    }

    @Override
    public String eat(String food) {
        System.out.println("超级热爱"+food);
        return food;
    }
}

//非定制代理类
class ProFactoy{
    //动态获取代理对象
    public static Object dynamicGetProxyInstance(Object obj){
        //参数一为被代理类对象，参数二为被代理类的方法，参数三为参数
         InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, 																	IllegalAccessException {
                System.out.println("-----此处可以进行方法增强-----");
                return method.invoke(obj, args);
            }
        };
        //参数一是和被代理类使用同一套类加载器；参数二是实现同一套接口；参数三是代理类调用方法时，会自动执行invoke()
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

public class Test26 {
    @Test
    public void test(){
        SuperMan superMan = new SuperMan();
        System.out.println(ProFactoy.dynamicGetProxyInstance(superMan) instanceof SuperMan); //false
        System.out.println(ProFactoy.dynamicGetProxyInstance(superMan) instanceof Human);  //true
        Human proFactoy = (Human) ProFactoy.dynamicGetProxyInstance(superMan); 
      	//代理对象调用他的invoke方法
        proFactoy.getBelieve(); //已被增强。I believe I can fly
        proFactoy.eat("西红柿"); //已被增强。超级热爱西红柿
    }
}
```

#### 13.4工厂模式

创建者和调用者分离，实现编译期解耦

```java
// IOC的目的就是为了解耦，控制反转的意思说白了就是把创建对象的权限移交出去。这里我们介绍的是Spring的IOC，那肯定是移交给Spring框架。下面的例子是移交给我们自己写的工厂对象
public class BeanFactory {
    private static Properties properties = new Properties();
    private static HashMap<String,Object> beanMap = new HashMap();

    //加载配置文件
    static{
        InputStream inputStream =    BeanFactory.class.getClassLoader().getResourceAsStream("beanFactory.properties");
        try {
            properties.load(inputStream);
            Enumeration<Object> keys = properties.keys();
            while (keys.hasMoreElements()){
                String key = (String) keys.nextElement();
                String property = properties.getProperty(key);
                Object value = Class.forName(property).newInstance();
                beanMap.put(key,value);
            }
        } catch (IOException e) {
            throw new ExceptionInInitializerError();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static<T> T getBean(String className){
        T t;
        t= (T) beanMap.get(className);
        return t;
    }
}
```

#### 13.5适配器模式

将一个接口转换成客户希望的另一个接口，使接口不兼容的那些类可以一起工作，这种类型的设计模式属于结构型模式。主要解决在软件系统中，常常要将一些"现存的对象"放到新的环境中，而新环境要求的接口是现对象不能满足的

```Java
/**
 * @author olic
 * @date 2020/11/2510:08 上午
 * @基于类的适配器模式
 */
// 源角色
public class AC220V {
    /**
     * 获取220V电压
     * @return
     */
    public int output220v() {
        int output220v = 220;
        return output220v;
    }
}
// 目标角色 
public interface DC5V {
    int dc5v();
}
// 适配器角色
public class Adapter extends AC220V implements DC5V {
    @Override
    public int dc5v() {
        int output220v = output220v();
        return (output220v / 44);
    }
}
// 测试
public class Test {
    @Test
    public void test(){
        DC5V dc5V =  new Adapter();
        int dc5 = dc5V.dc5v();
        System.out.println("转换后的电压为：" + dc5 + " 伏...");
    }
}

/**
 * @author olic
 * @date 2020/11/2510:08 上午
 * @基于对象的适配器模式
 */
// 源角色
public class AC220V {
    /**
     * 获取220V电压
     * @return
     */
    public int output220v() {
        int output220v = 220;
        return output220v;
    }
}
// 目标角色 
public interface DC5V {
    int dc5v();
}
// 适配器
public class Adapter implements DC5V {
    private AC220V ac220V;
    public Adapter(AC220V ac220V) {
        this.ac220V = ac220V;
    }
    @Override
    public int dc5v() {
        int output220v = ac220V.output220v();
        return (output220v / 44);
    }
}
// 测试
public class Test {
    @Test
    public void test(){
        DC5V dc5V =  new Adapter(new AC220V());
        int dc5 = dc5V.dc5v();
        System.out.println("输入的电压为：" + new AC220V().output220v() + " 伏...");
        System.out.println("转换后的电压为：" + dc5 + " 伏...");
    }
}
```

#### 13.6策略模式

一个类的行为或其算法可以在运行时更改，这种类型的设计模式属于行为型模式。主要解决在有多种算法相似的情况下，使用 if...else 所带来的复杂和难以维护

```java
/**
 * @ClassName: IBaseService
 * @Author: olic
 * @Description: 接口标准
 * @Date: 2021/5/10 18:54
 */
public interface IBaseService<T, B> {
     Logger LOGGER = LoggerFactory.getLogger(QyWeChatNotify.class);
    /**
     * 获取工单名称编码
     *
     * @return 工单名称编码
     */
    public String getWoNameCode();

    /**
     * 编辑各工单明细表字段
     *
     * @param b    创建对象
     * @param woId 工单号
     * @return
     */
    public T editWoDetailField(B b, Long woId);

    /**
     * 根据抄送人列表实现抄送
     *
     * @param baseInfo
     * @param handleOrderUrl
     * @param userIds
     */
    default void notifyByCcList(WoBaseInfo baseInfo, String handleOrderUrl, Long[] userIds) {
        StringBuffer sb = new StringBuffer();
        sb.append("收到抄送您的工单");
        sb.append("\n工单号：" + baseInfo.getWoId());
        sb.append("\n抄送人：" + baseInfo.getUserName());
        sb.append("\n工单名称：" + baseInfo.getWoName());
        sb.append("\n工单标题：" + baseInfo.getWoTitle());
        sb.append("\n<a href=\'" + handleOrderUrl + "\'>点击查看详情</a>");

        QyWeChatBatchNotify qyWeChatBatchNotify = SpringUtils.getBean(QyWeChatBatchNotify.class);
        qyWeChatBatchNotify.batchNotify(userIds, sb.toString());
    }
}

/**
 * 异常事件字段 Service业务层处理
 * @author olic
 * @Description: 行为一
 * @date 2021-10-20
 */
@Service
@Transactional
@Slf4j
public class WoAbnormalEventService implements IBaseService{
    @Autowired
    private WoAbnormalEventMapper woAbnormalEventMapper;

    @Autowired
    @Lazy
    private QyWeChatBatchNotify qyWeChatBatchNotify;

    @Override
    public String getWoNameCode() {
        return WoNameEnum.ABO_EVENT.getKey();
    }

    @Override
    public Object editWoDetailField(Object o, Long woId) {
        WoAbnormalEventBO eventBO = null;
        CreateWoBO createWoBO = conv2CreateBO(o);
        eventBO = (createWoBO == null) ?
                (WoAbnormalEventBO) populate(new WoAbnormalEventBO(), (Map) o) :
                createWoBO.getWoAbnormalEventBO();

        if (eventBO == null) {
            throw new CustomException("eventBO 不能为空");
        }

        WoAbnormalEvent result = selectWoAbnormalEventByWoId(woId);
        if (result != null) {
            BeanUtils.copyProperties(eventBO, result);
            List<EventProgressDTO> list = eventBO.getEventProgressList();
            if (!CollectionUtils.isEmpty(list)) {
                result.setEventProgress(StringUtils.list2String(list));
            }
            result.setCreatedBy(getNickName());
            updateWoAbnormalEvent(result);
            return result;
        }
        if (createWoBO == null) {
            throw new CustomException("createWoBO is NUll");
        }

        WoAbnormalEvent woAbnormalEvent = new WoAbnormalEvent();
        BeanUtils.copyProperties(eventBO, woAbnormalEvent);
        List<Object> list = eventBO.getServiceManager();
        if (!CollectionUtils.isEmpty(list)) {
            woAbnormalEvent.setServiceManager(StringUtils.list2String(list));
        }
        woAbnormalEvent.setWoId(woId);
        woAbnormalEvent.setCreatedBy(getNickName());
        insertWoAbnormalEvent(woAbnormalEvent);
        return woAbnormalEvent;
    }

    /**
     * 根据抄送人列表实现抄送
     *
     * @param baseInfo
     * @param handleOrderUrl
     * @param userIds
     */
    @Override
    public void notifyByCcList(WoBaseInfo baseInfo, String handleOrderUrl, Long[] userIds) {
        Long woId = baseInfo.getWoId();
        WoAbnormalEvent event = selectWoAbnormalEventByWoId(woId);
        String eventProgress = event.getEventProgress();
        String bigBusiArea = baseInfo.getBigBusiArea();
        StringBuffer sb = new StringBuffer();
        if (StringUtils.isNotBlank(eventProgress)) {
            JSONArray jsonArray = JSONArray.fromString(eventProgress);
            JSONObject jsonObject = JSONObject.parseObject(jsonArray.get(0).toString());
            sb.append("><font color=\"info\">异常事件进展更新提醒</font>");
            sb.append("\n>**您好！【" + bigBusiArea + "】异常事件更新了处理进展，请关注并提供支持：**");
            sb.append("\n>1、 异常事件标题：" + baseInfo.getWoTitle());
            sb.append("\n>2、 异常事件发生日期：" + event.getEventBeginData().substring(0, 10));
            String[] eventType = event.getEventType().split(",");
            sb.append("\n>3、 异常事件类型：" + WoEvenTypeEnum.getValByKey(eventType[0]));
            if (eventType.length > 1 && StringUtils.isNotBlank(eventType[1])) {
                sb.append("/" + WoEvenTypeEnum.getValByKey(eventType[1]));
            }
            sb.append("\n>4、 异常事件等级：" + WoEvenLevelEnum.getValByKey(event.getEventLevel()));
            sb.append("\n>5、 所属客户名称：<font color=\"info\">" + event.getCustomerName() + "</font>");
            sb.append("\n>6、 进展更新日期：" + jsonObject.getString("processTime").substring(0, 10));
            String processDesc = jsonObject.getString("processDesc");
            if (processDesc.length() > 199) {
                processDesc = processDesc.substring(0, 199) + "...";
            }
            sb.append("\n>7、 最新进展描述：<font color=\"info\">" + processDesc.replaceAll("\n", "") + "</font>");
        } else {
            sb.append("><font color=\"info\">异常事件发生提醒</font>");
            sb.append("\n>**您好！【" + bigBusiArea + "】新增1起异常事件，请关注并提供支持：**");
            sb.append("\n>1、 异常事件标题：<font color=\"info\">" + baseInfo.getWoTitle() + "</font>");
            sb.append("\n>2、 异常事件发生日期：" + event.getEventBeginData().substring(0, 10));
            String[] eventType = event.getEventType().split(",");
            sb.append("\n>3、 异常事件类型：" + WoEvenTypeEnum.getValByKey(eventType[0]));
            if (eventType.length > 1 && StringUtils.isNotBlank(eventType[1])) {
                sb.append("/" + WoEvenTypeEnum.getValByKey(eventType[1]));
            }
            sb.append("\n>4、 异常事件等级：" + WoEvenLevelEnum.getValByKey(event.getEventLevel()));
            String customerName = event.getCustomerName() == null ? "-" : event.getCustomerName();
            sb.append("\n>5、 所属客户名称：<font color=\"info\">" + customerName + "</font>");
            String detailNote = event.getDetailNote() == null ? "-" : event.getDetailNote();
            if (detailNote.length() > 199) {
                detailNote = detailNote.substring(0, 199) + "...";
            }
            sb.append("\n>6、 事件描述：<font color=\"info\">" + detailNote.replaceAll("\n", "") + "</font>");
            String riskSupport = event.getRiskSupport() == null ? "-" : event.getRiskSupport();
            if (riskSupport.length() > 199) {
                riskSupport = riskSupport.substring(0, 199) + "...";
            }
            sb.append("\n>7、 风险及所需支持：" + riskSupport.replaceAll("\n", ""));
        }
        sb.append("\n>[点击查看详情](" + String.format(redirectUrl, woId) + ")");
        qyWeChatBatchNotify.pushMarkdownMsg(userIds, sb.toString());
    }
}

/**
 * @ClassName: WoSysReportService
 * @Author: olic
 * @Description: 行为二
 * @Date: 2021/5/7 16:32
 */
@Service
@Transactional
public class WoSysReportService implements IBaseService{
    @Autowired
    private WoSysReportMapper woSysReportMapper;
    @Resource
    private WoUserProductMapper woUserProductMapper;

    /**
     * 获取工单名称编码
     *
     * @return 工单名称编码
     */
    @Override
    public String getWoNameCode() {
        return WoNameEnum.SYS_REPORT.getKey();
    }

    /**
     * 编辑各工单明细表字段
     *
     * @param o
     * @param woId
     * @return
     */
    @Override
    public Object editWoDetailField(Object o, Long woId) {
        CreateWoBO createWoBO = conv2CreateBO(o);
        WoSysReportBO sysReportBO = createWoBO.getWoSysReportBO();

        if (sysReportBO == null) {
            throw new CustomException("woInjuryFieldBO 不能为空");
        }

        WoSysReport result = selectWoSysReportByWoId(woId);
        if (result != null) {
            BeanUtils.copyProperties(sysReportBO, result);
            result.setCreatedBy(getNickName());
            updateWoSysReport(result);
            return result;
        }
        WoSysReport sysReport = new WoSysReport();
        BeanUtils.copyProperties(sysReportBO, sysReport);
        sysReport.setWoId(woId);
        sysReport.setCreatedBy(getNickName());

        // 补全系统名称
        WoUserProduct woUserProduct = woUserProductMapper.selectWoUserProductByCode(sysReport.getSystemCode());
        if(woUserProduct != null){
            sysReport.setSystemName(woUserProduct.getProductName());
        }

        insertWoSysReport(sysReport);
        return sysReport;
    }
}

/**
 * @ClassName: IStaticServiceSelectorImpl
 * @Author: olic
 * @Description: 动态选择器实现类
 * @Date: 2021/5/10 19:14
 */
@Component
public class IStaticServiceSelectorImpl implements IStaticServiceSelector {

    @Autowired
    private List<IBaseService> serviceList;

    /**
     * 根据工单名称编码动态选择对应的处理类
     *
     * @return 工单名称编码
     */
    @Override
    public IBaseService select(String woNameCode) {
        for (IBaseService service : serviceList) {
            String code = service.getWoNameCode();
            String[] split = code.split(",");
            List<String> list = Arrays.asList(split);
            if (list.contains(woNameCode)) {
                return service;
            }
        }
        throw new CustomException("暂不支持该工单名称的操作");
    }
}

// 根据工单woNameCode的值来动态选择实现，决定运行的行为
IBaseService service = serviceSelector.select(baseInfo.getWoNameCode());
service.notifyByCcList(baseInfo, handleOrderUrl, userIds);
```

### 14 异常

**异常体系图谱**  

<img src="/Users/olic/work/图片库/异常体系.png" alt="异常体系" style="zoom: 50%;" />

**说明：** 

- catch中的异常类型如果满足子父类关系，则要求子类一定声明在父类的上面
- 处理完成异常后，即使后面还有catch结构，程序也会直接跳出try...catch结构
- finally中的代码无论程序是否出现异常都会被执行。即使方法提前进行return(finally模块在return前执行)或者catch中出现异常。像数据库连接、输入输出流、Socket等资源jvm不能自动回收，需要我们手动资源释放，此时资源释放就得放在finally中
- 运行时异常，可以不用处理；编译器异常必须处理(try...catch 或throws)

**finally代码块不会被执行的情况：**

- System.exit()的作用是中止当前虚拟机，虚拟机都被中止了，finally代码块自然不会执行
- 守护(daemon)线程被中止时，那么当所有的非守护线程中止时，守护线程被kill掉，其finally代码块是不会执行的

**打印异常信息：**getMessage()、printStackTrace()

**异常的传递性：**当方法执行出现异常，会将异常(对应异常类的对象)传递到方法的调用一方，如果传递到主程序仍然没有理，程序会停止

**抛出异常 ：**throws 异常类型

**开发中异常使用场景：**

- 如果父类中被重写的方法没有使用throws方式处理异常，则子类重写的方法中也不能使用throws。意味着，此时只能使用try...catch形式处理子类中的异常
- 执行的方法a中，先后又调用了另外几个方法，这几个方法是递进关系执行的，我们建议这几个方法使用throws方式处理，执行的方法a使用try...catch集中处理

**手动抛出异常：**throw new 异常类(提示信息)

### 15 函数式编程

使用函数式接口编程的过程

#### 15.1 函数式接口

**函数式接口：**仅仅包含一个抽象方法，不包括 equals这类在object中已经定义的方法，但可以包含多个默认实现的方法。@FunctionalInterface这个注解用于修饰函数式接口，即意味着接口中的抽象方法只能有一个，否则编译器会报错

**Java内置四大核心函数式接口：** 

- 消费型接口：Consumer<T>    void accept(T t)  接收一个T类型的参数，不返回值

- 供给型接口：Supplier<T>    T get() 不接受参数，返回一个T类型的结果


- 函数型接口：Function<T,R>   R apply(T t) 接收一个T类型的参数，返回一个R类型的结果
- 断定型接口：Predicate<T>   boolean test(T t) 接收一个T类型的参数，返回一个boolean类型的结果

**Consumer：**表示一个方法接收参数但不产生返回值

接收一个参数：

| interface      | functional method         | 说明                               |
| -------------- | ------------------------- | ---------------------------------- |
| Consumer<T>    | void accept(T t)          | 接收一个泛型参数，无返回值         |
| IntConsumer    | void accept(int value)    | 以下三个类，接收一个指定类型的参数 |
| LongConsumer   | void accept(long value)   |                                    |
| DoubleConsumer | void accept(double value) |                                    |

接收两个参数：

| interface            | functional method              | 说明                                             |
| -------------------- | ------------------------------ | ------------------------------------------------ |
| BiConsumer<T,U>      | void accept(T t, U u)          | 接收两个泛型参数                                 |
| ObjIntConsumer<T>    | void accept(T t, int value)    | 以下三个类，接收一个泛型参数，一个指定类型的参数 |
| ObjLongConsumer<T>   | void accept(T t, long value)   |                                                  |
| ObjDoubleConsumer<T> | void accept(T t, double value) |                                                  |

**Supplier：**返回一个结果，并不要求每次调用都返回一个新的或者独一的结果

| interface       | functional method      | 说明                       |
| --------------- | ---------------------- | -------------------------- |
| Supplier<T>     | T get()                | 返回类型为泛型T            |
| BooleanSupplier | boolean getAsBoolean() | 以下三个接口，返回指定类型 |
| IntSupplier     | int getAsInt()         |                            |
| LongSupplier    | long getAsLong()       |                            |
| DoubleSupplier  | double getAsDouble()   |                            |

**Predicate：**根据接收参数进行断言，返回boolean类型

| interface        | functional method          | 说明                             |
| ---------------- | -------------------------- | -------------------------------- |
| Predicate<T>     | boolean test(T t)          | 接收一个泛型参数                 |
| IntPredicate     | boolean test(int value)    | 以下三个接口，接收指定类型的参数 |
| LongPredicate    | boolean test(long value)   |                                  |
| DoublePredicate  | boolean test(double value) |                                  |
| BiPredicate<T,U> | boolean test(T t, U u)     | 接收两个泛型参数，分别为T，U     |

**Function：**表示一个方法接收参数并返回结果

接收单个参数：

| Interface            | functional method                            | 说明                                                     |
| -------------------- | -------------------------------------------- | -------------------------------------------------------- |
| Function<T,R>        | R apply(T t)                                 | 接收参数类型为T，返回参数类型为R                         |
| IntFunction<R>       | R apply(int value)                           | 以下三个接口，指定了接收参数类型，返回参数类型为泛型R    |
| LongFunction<R>      | R apply(long value)                          |                                                          |
| Double<R>            | R apply(double value)                        |                                                          |
| ToIntFunction<T>     | int applyAsInt(T value)                      | 以下三个接口，指定了返回参数类型，接收参数类型为泛型T    |
| ToLongFunction<T>    | long applyAsLong(T value)                    |                                                          |
| ToDoubleFunction<T>  | double applyAsDouble(T value)                |                                                          |
| IntToLongFunction    | long applyAsLong(int value)                  | 以下六个接口，既指定了接收参数类型，也指定了返回参数类型 |
| IntToDoubleFunction  | double applyAsLong(int value)                |                                                          |
| LongToIntFunction    | int applyAsLong(long value)                  |                                                          |
| LongToDoubleFunction | double applyAsLong(long value)               |                                                          |
| DoubleToIntFunction  | int applyAsLong(double value)                |                                                          |
| DoubleToLongFunction | long applyAsLong(double value)               |                                                          |
| UnaryOperator<T>     | T apply(T t)                                 | 特殊的Function，接收参数类型和返回参数类型一样           |
| IntUnaryOperator     | int applyAsInt(int left, int right)          | 以下三个接口，指定了接收参数和返回参数类型，并且都一样   |
| LongUnaryOperator    | long applyAsInt(long left, long right)       |                                                          |
| DoubleUnaryOperator  | double applyAsInt(double left, double right) |                                                          |

接收两个参数：

| interface               | functional method                            | 说明                                                         |
| ----------------------- | -------------------------------------------- | ------------------------------------------------------------ |
| BiFunction<T,U,R>       | R apply(T t, U u)                            | 接收两个参数的Function                                       |
| ToIntBiFunction<T,U>    | int applyAsInt(T t, U u)                     | 以下三个接口，指定了返回参数类型，接收参数类型分别为泛型T, U |
| ToLongBiFunction<T,U>   | long applyAsLong(T t, U u)                   |                                                              |
| ToDoubleBiFunction<T,U> | double appleyAsDouble(T t, U u)              |                                                              |
| BinaryOperator<T>       | T apply(T t, T u)                            | 特殊的BiFunction, 接收参数和返回参数类型一样                 |
| IntBinaryOperator       | int applyAsInt(int left, int right)          |                                                              |
| LongBinaryOperator      | long applyAsInt(long left, long right)       |                                                              |
| DoubleBinaryOperator    | double applyAsInt(double left, double right) |                                                              |

#### 15.2 lambda表达式

##### 15.2.1概念

**作为函数式接口的实例**。λ表达式由三部分组成：1.参数列表，2.操作符(—> )，3.一个表达式或语句块，其中表达式是指的是一句代码，语句块是用大括号"{}"包起来的一系列代码，**而λ本身必须是函数接口才能使用λ表达式**。lambda 语法本质上是一个匿名方法是【语法糖】，由编译器推断并帮助你转换包装为常规代码。说白了lambad表达式就是把函数定义从原来的标准定义方式给简化了，这是因为编译器可以根据表达式内容来推断入参、出参。因此使用lambda可以使用更少的代码来实现相同功能。**左边** lambda形参列表的参数类型可以省略(类型推断)，如果lambda形参列表只有一个参数，其参数类型和()可以省略；**右边** lambda体应该使用一对{}包裹；如果只有一条执行语句(可能是return语句)，其{}和return都可以省略。**如：**(o1,o2) —> Integer.compare(o1,o2)	

```java
// 以前的排序
List<Goods> list = Stream.of(new Goods(35, "BB"), new Goods(33, "aa"),new Goods(34, "dd"))
           .sorted(new Comparator<Goods>(){
           @Override
           public int compare(Goods g1, Goods g2) {
                   if (g1.getPrice() > g2.getPrice()) {
                        return -1;  //价格从大到小
                   } else if (g1.getPrice() < g2.getPrice()) {
                        return 1;
                   } else {
                        return g1.getName().compareToIgnoreCase(g2.getName()); //名称从小到大
                   }
               }
           }).collect(Collectors.toList());
System.out.println(list);

// lambda改造
List<Goods> list = Stream.of(new Goods(35, "BB"), new Goods(33, "aa"),new Goods(34, "dd"))
           .sorted(((o1, o2) -> {
                if (o1.getPrice() > o2.getPrice()) {
                      return -1;  //价格从大到小
                } else if (o1.getPrice() < o2.getPrice()) {
                      return 1;
                } else {
                      return o1.getName().compareToIgnoreCase(o2.getName()); //名称从小到大
                }
           })).collect(Collectors.toList());
System.out.println(list);
```

##### 15.2.2作用域

Lambda表达式不会从超类(supertype)中继承任何变量名，也不会引入一个新的作用域。Lambda表达式基于词法作用域，也就是说lambda表达式函数体里面的变量和它外部环境的变量具有相同的语义(也包括lambda表达式的形式参数)。此外，this关键字及其引用，在Lambda表达式内部和外部也拥有相同的语义	

##### 15.2.3 λ表达式的使用

- λ表达式主要用于替换以前广泛使用的内部匿名类，各种回调，比如事件响应器、传入Thread类的Runnable等。看下面的例子：


```java
Thread oldSchool = new Thread( new Runnable () {
        @Override
        public void run() {
            System.out.println("This is from an anonymous class.");
        }
    } );
    
    Thread gaoDuanDaQiShangDangCi = new Thread( () -> {
        System.out.println("This is from an anonymous method (lambda exp).");
    } );
```

注意第二个线程里的λ表达式，你并不需要显式地把它转成一个Runnable，因为Java能根据上下文自动推断出来：一个Thread的构造函数接受一个Runnable参数，而传入的λ表达式正好符合其run()函数，所以Java编译器推断它为Runnable。从形式上看，λ表达式只是为你节省了几行代码。但将λ表达式引入Java的动机并不仅仅为此。Java8有一个短期目标和一个长期目标。短期目标是：配合“集合类批处理操作”的内部迭代和并行处理；长期目标是将Java向函数式编程语言这个方向引导(并不是要完全变成一门函数式编程语言，只是让它有更多的函数式编程语言的特性)

- λ表达式与集合类批处理操作(或者叫块操作)

上文提到了集合类的批处理操作。这是Java8的另一个重要特性，它与λ表达式的配合使用乃是Java8的最主要特性。集合类的批处理操作API的目的是实现集合类的“内部迭代”，并期望充分利用现代多核CPU进行并行计算。Java8之前集合类的迭代(Iteration)都是外部的，即客户代码。而内部迭代意味着改由Java类库来进行迭代，而不是客户代码。例如：

```java
for(Object o: list) { // 外部迭代
        System.out.println(o);
    }
// 可以写成：
list.forEach(o -> {System.out.println(o);}); //forEach函数实现内部迭代
```

集合类（包括List）现在都有一个forEach方法，对元素进行迭代(遍历)，所以我们不需要再写for循环了。forEach方法接受一个函数接口Consumer做参数，所以可以使用λ表达式。

Java8为集合类引入了另一个重要概念：流(stream)。一个流通常以一个集合类实例为其数据源，然后在其上定义各种操作。流的API设计使用了管道(pipelines)模式。对流的一次操作会返回另一个流。如同IO的API或者StringBuffer的append方法那样，从而多个不同的操作可以在一个语句里串起来，如下

```java
List<Shape> shapes = ...
    shapes.stream()
      .filter(s -> s.getColor() == BLUE)
      .forEach(s -> s.setColor(RED));
```

-  λ表达式的更多用法


嵌套的λ表达式

```java
Callable<Runnable> c1 = () -> () -> { System.out.println("Nested lambda"); };
c1.call().run();
```

用在条件表达式中

```java
Callable<Integer> c2 = true ? (() -> 42) : (() -> 24);
System.out.println(c2.call());
```

定义一个递归函数，注意须用this限定

```java
protected UnaryOperator<Integer> factorial = i -> i == 0 ? 1 : i * this.factorial.apply( i - 1 );
System.out.println(factorial.apply(3));	
```

#### 15.3 方法引用

##### 15.3.1概念

**作为函数式接口的实例**。方法引用是用来直接访问类或者实例的已经存在的方法或者构造方法。方法引用提供了一种引用而不执行方法的方式，它需要由兼容的函数式接口构成的目标类型上下文。计算时，方法引用会创建函数式接口的一个实例。当Lambda表达式中只是执行一个方法调用时，不用Lambda表达式，直接通过方法引用的形式可读性更高一些。方法引用是一种更简洁易懂的Lambda表达式

```java
/**
 * @Description: 定义一个包含了各种类型方法的类
 * @author: lsh
 * @date 2021/8/29 上午11:30
 */
public class DoubleColon {
    public static void printStr(String str) {
        System.out.println("printStr : " + str);
    }

    public void toUpper() {
        System.out.println("toUpper: " + this.toString());
    }

    public int toInt(String str) {
        System.out.println("toInt: " + str);
        return 1;
    }

    public void printInteger(Integer i) {
        System.out.println("printInteger: " + i);
    }
}

/**
 * @Description: 测试类
 * @author: lsh
 * @date 2019/8/29 上午11:37
 */
public class DoubleColonTest {
    @Test
    public void testColon() {
        // =========静态方法==========
        // 静态方法因为jvm已有对象，直接接收入参。
        Consumer<String> printStrConsumer = DoubleColon::printStr;
        printStrConsumer.accept("printStrConsumer");

        // =========非静态方法==========

        // 方法参数个数=函数式接口参数个数，通过【new 类的实例::方法名】引用
        // 使用的时候，直接传入需要的参数即可
        Consumer<Integer> toPrintConsumer = new DoubleColon()::printInteger;
        toPrintConsumer.accept(123);
        
        // 方法参数个数=函数式接口参数个数-1，通过【类的实例::方法名】引用
        // 使用的时候，传入的第一个参数是类的实例，后面是方法的参数
        Consumer<DoubleColon> toUpperConsumer = DoubleColon::toUpper;
        toUpperConsumer.accept(new DoubleColon());
      
       	// 构造器引用
      	// 构造器参数列表要与接口中抽象方法的参数列表一致
 				Supplier<Student> studentSupplier = DoubleColon::new;
 				System.out.println(studentSupplier.get());
    }
}
```

##### 15.3.2使用要求

接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型一致(构造器引用和方法引用类似 类名 :: new)

##### 15.3.3语法格式

- 对象 :: 非静态方法
- 类 :: 静态方法
- 类名::new
- 类 :: 非静态方法

##### 15.3.4特殊情况

非静态方法的函数引用定义和使用就有点让人很困惑了，明明函数式接口里面是1参数，可是非静态方法里面是0个参数，这个是怎么实现的呢？其实这个不一致是有要求的，就是函数式接口的参数个数-非静态方法参数个数=0或者1，我这里叫它为参数差，这个参数差取值范围不能变，如果大于1或者小于0都会报错。

**参数差=0：**方法参数个数相等，那么直接通过一个类的实例来调用这个方法即可，因此方法引用就是【实例::方法名】，使用的时候也是直接传递所需要的参数即可

**参数差=1：**说明非静态方法少一个参数，这是就不能保证接口参数和实现方法参一一对应了，这很明显有问题。这时候我们通过【类::方法名】来定义(这种定义方式也是jdk的规定，记住就好)。因为这个方法不是静态方法，定义的时候也没有给它传递类的实例，所以我们需要在使用的时候给这个方法传递一个宿主(类的实例)，这个宿主永远是接口的第一个参数，因此就会出现下面的这种定义和使用的方式

#### 15.4  Stream API

**说明：**Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象，是数据的渠道，用于操作数据源(集合、数组等) 所生成的元素序列。Stream讲的是一种计算，自己不会存储元素，不会改变源对象，相反他们会返回一个持有结果的Stream，Stream操作是延迟执行，只要你没有调用终止操作，中间的这些操作都不会被执行，一旦执行了终止操作该Stream对象就不能再次调用中间操作了

**数据源：**通过集合、数组、IO、产生器等

**生成流：**stream()，parallelStream()，Stream.of(T...values)

**聚合操作：**filter，map，reduce，find，match，sorted等	

### 16 jdbc

**定义：**java程序各种操作数据库的一种接口规范，接口存在于JDK_1.8.jar下java.sql包

**分类：**

java.sql.DriverManager类：这个类存在于JDK_1.8下。负责将数据库厂商提供Driver接口实现进行注册负责在Java工程与MySql服务器之间建立一个【连接通道】
java.sql.Connection接口：负责管理Java工程与数据库服务器之间【连接通道】

```java
//获取连接方式一
Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "admin")
//获取连接方式二
//1、先在配置文件中指定连接池。完整配置参考下方的配置
spring:
  datasource:
    type: com.zaxxer.hikari.HikariDataSource    
//2、自动注入配置好的连接池，再获取连接
@Resource
private DataSource dataSource;
Connection c = dataSource.getDataSource().getConnection();
```

java.sql.PreparedStatement接口：负责管理在【连接通道】 上进行往返交通的【交通工具】
java.sql.ResultSet接口：负责管理数据库服务器返回【临时表】

**数据库驱动：**对于具体jdbc接口规范的一种实现。如com.mysql.jdbc.Driver

**数据源：**用于管理jdbc，可以是连接池的形式。如c3p0

<img src="/Users/olic/work/图片库/jdbc.png" alt="jdbc" style="zoom:95%;" />

```yaml
# 通常将jdbc配置到数据源中，再从数据源中获取连接
spring:
  profiles:
    active: dev
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: ${mysql.username}
    password: ${mysql.password}
    type: com.zaxxer.hikari.HikariDataSource
    url: jdbc:mysql://${mysql.host}:${mysql.port}/${mysql.database}?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai
    hikari:
      auto-commit: true
      connection-test-query: SELECT 1
      connection-timeout: 10000
      idle-timeout: 30000
      max-lifetime: 900000
      maximum-pool-size: 30
      minimum-idle: 10
      pool-name: HikariCP
      validation-timeout: 1000 
```

## Java高级

### 1 线程

在Jvm中，每个线程拥有自己独立的虚拟机栈和程序计数器，多个线程共享一个进程中的堆和方法区。在Java中高优先级的线程可以抢占低优先级线程执行资源

#### 1.1生命周期

包括新建、就绪、运行、阻塞、死亡等状态。内部枚举类记录线程状态

<img src="/Users/olic/work/图片库/线程状态转换图.png" alt="线程状态转换图" style="zoom:75%;" />

#### 1.2线程优先级

MIN_PRIORITY = 1  NORM_PRIORITY = 5  MAX_PRIORITY = 10 

**设置线程优先级：** setPriority()  getPriority() 

#### 1.3创建线程

- 继承线程类Thread，run方法没返回值
- 实现Runnable接口，run方法没返回值
- 实现Callable接口，call方法有返回值的，是一个泛型，和Future、FutureTask配合可以用来获取异步执行的结果
- 线程池方式(响应速度提高；重复利用率提高；便于管理)

**常用方法：**

strat() 启动线程并调用当前线程的run()方法，等待cpu分配资源

 join() 在线程a中调用线程b中的join()方法，此时线程a就进入阻塞状态，直到线程b完全执行完之后，线程a才结束阻塞状态，线程a等待cpu分配资源

sleep() 设置线程睡眠时间，线程进入阻塞状态不释放锁或同步监听器。睡眠完成后，进入就绪状态

wait() 线程进入阻塞状态，并释放同步监视器。只出现同步代码块中

nofity() 唤醒被wait的线程，被唤醒的线程进入就绪状态(此时自身为正在运行的状态)。只出现同步代码块中

nofityAll() 唤醒所有被wait的线程，被唤醒的线程进入就绪状态(自己进入阻塞状态并释放同步监视器)。只出现同步代码块中

isAlive() 判断此线程是否存活

setDaemon() 设置守护线程，可以把线程a设置为线程b的守护线程，当线程b结束时，线程a也同时结束

setName() 设置线程名。也可以使用构造器命名

Thread.currentThread() 当前线程

yield() 释放当前cpu执行权，随后等待cpu分配资源

#### 1.4线程池

线程池在任务提交的时候创建线程

##### 1.4.1jdk线程池体系

<img src="/Users/olic/work/图片库/线程池体系结构.jpg" alt="线程池体系结构" style="zoom:100%;" />

##### 1.4.2处理流程

<img src="/Users/olic/work/图片库/线程池处理流程.jpg" alt="线程池处理流程" style="zoom:80%;" />

1. 查看核心线程池是否已满，不满就创建一条线程并执行任务，否则执行第二步
2. 查看任务队列是否已满，不满就将任务存储在任务队列中，否则执行第三步
3. 查看线程池是否已满，即就是是否达到最大线程池数，不满就创建一条线程执行任务，否则就按照策略处理无法执行的任务

**拒绝策略：**

AbortPolicy：用于被拒绝任务的处理程序，它将抛出RejectedExecutionException

CallerRunsPolicy：用于被拒绝任务的处理程序，它直接在execute方法的调用线程中运行被拒绝的任务

DiscardOldestPolicy：用于被拒绝任务的处理程序，它放弃最旧的未处理请求，然后重试execute

DiscardPolicy：用于被拒绝任务的处理程序，默认情况下它将丢弃被拒绝的任务

##### 1.4.3ThreadPoolTaskExecutor

这个类则是spring包下的，是sring为我们提供的线程池类

```java
// 基本配置
@Configuration
public class ExecturConfig {
    @Bean("taskExector")
    public Executor taskExector() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        int i = Runtime.getRuntime().availableProcessors(); //获取到服务器的cpu内核
        executor.setCorePoolSize(i*2); //核心池大小
        executor.setMaxPoolSize(100); //最大线程数
        executor.setQueueCapacity(1000); //队列程度
        executor.setKeepAliveSeconds(1000); //线程空闲时间。当前线程池线程总数达到核心线程数时，终止多余的空闲线程的时间
        executor.setThreadNamePrefix("tsak-asyn"); //线程前缀名称
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy()); //配置拒绝策略
        return executor;
    }
}
```

**自定义异步线程池并开启异步：**

配置类上面添加`@EnableAsync`注解， 这样Spring就会开启异步线程池

- 重新实现AsyncConfigurer接口
- 继承AsyncConfigurerSupport
- 配置由自定义的TaskExecutor替代内置的任务执行器

#### 1.5线程的通信

- 共享数据。可以使用在安全基础上使用wait()、notify()方法进行交替通信
- 消息队列

#### 1.6并发访问线程安全问题

某个线程在操作**共享数据**时，尚未操作完成，其他线程也参与了进来

**同步代码块：**

synchronized(同步监视器){

​		需要被同步的代码(操作共享数据的代码)

}

**说明：**同步监视器(锁)，任何一个类的对象都可以充当锁。前提：多个线程必须共用同一把锁

**同步方法(方法里面完全是共享代码块)：**

权限修饰符 synchronized 返回值 方法名(){

​		需要被同步的代码(操作共享数据的代码)

}

**说明：** 

- 对于非静态方法，系统默认指定锁为this。对于静态方法，系统默认指定锁为当前类
- wait() 、nofity()、nofityAll()必须被同步监视器调用，这三个方法封装在object类中

**Lock显式锁：**  

1. 实例化ReentrantLock锁  
2. 加锁：lock()  
3. 解锁：unlock()

**说明：**synchronized机制自动释放同步监视器，Lock需要手动启动同步和结束同步；他们都是进程级别单机锁

#### 1.7死锁

多个进程在运行过程中因争夺资源而造成的一种僵局，当进程处于这种僵持状态时，若无外力作用，它们都将无法再向前推进

**产生死锁的必要条件：** 

**1、互斥条件：**进程要求对所分配的资源进行排它性控制，即在一段时间内某资源仅为一进程所占用

**2、请求和保持条件：**当进程因请求资源而阻塞时，对已获得的资源保持不放

**3、不剥夺条件：**进程已获得的资源在未使用完之前，不能剥夺，只能在使用完时由自己释放

**4、环路等待条件：**在发生死锁时，必然存在一个进程--资源的环形链

**死锁预防：** 

- 破坏必要条件
- 银行家算法

**基本使用：**

```java
// 同步方式一
class Windows extends Thread{
    private static int tickets = 1; // 此处必须标记为静态才能保证共享变量唯一
    // private static Object obj = new Object(); // 此处必须标记为静态才能保证锁对象唯一
    @Override
    public void run() {
        while (true) {
            synchronized(this.getClass()) { // 类也是对象
                if (tickets <= 100) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "正在出售：第" + tickets + "张票");
                    tickets++;
                } else {
                    break;
                }
            }
        }
    }
}

public class Test3 {
    public static void main(String[] args) {
        Windows w1 = new Windows();
        Windows w2 = new Windows();
        Windows w3 = new Windows();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
      
      	// 匿名方式
      	new Thread(){
        		private static int tickets = 1;
    				@Override
    				public void run() {
        				while (true) {
            				synchronized(this.getClass()) { // 类也是对象
                				if (tickets <= 100) {
                    				try {
                        				Thread.sleep(200);
                    				} catch (InterruptedException e) {
                        				e.printStackTrace();
                    				}
                    			System.out.println(getName() + "正在出售：第" + tickets + "张票");
                    			tickets++;
                			} else {
                    			break;
                			}
            			}
        			}
    			}
      	}
    }
}


// 同步方式二 
// 优点：多实现同时也有效解决共享变量的问题
class Windows2 implements Runnable{
    private int tickets = 1;
    // private Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized(this) {
                if (tickets <= 100) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售：第" + tickets + "张票");
                    tickets++;
                } else {
                    break;
                }
            }
        }
    }
}

public class Test4 {
    public static void main(String[] args) {
        Windows2 windows2 = new Windows2();
        Thread t1 = new Thread(windows2);
        Thread t2 = new Thread(windows2);
        Thread t3 = new Thread(windows2);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
      
      	// 匿名方式
      	new Thread(new Runnable(){
          	private int tickets = 1;
          	public void run() {
        				while (true) {
            				synchronized(this) {
                				if (tickets <= 100) {
                    				try {
                        				Thread.sleep(200);
                    				} catch (InterruptedException e) {
                        					e.printStackTrace();
                    				}
                    				System.out.println(Thread.currentThread().getName() + "正在出售：第" + tickets + "张票");
                    				tickets++;
                				} else {
                    				break;
                				}
            				}
        				}
    				}
        }).start();
    }
}

// 同步方式三
class Windows3 implements Runnable{
    private int tickets = 1;
    private ReentrantLock rLock = new ReentrantLock(true);  // 参数为true代表公平分配资源
    @Override
    public void run() {
        while (true) {
            try{
                rLock.lock();
                if (tickets <= 100) {
                    System.out.println(Thread.currentThread().getName() + "正在出售：第" + tickets + "张票");
                    tickets++;
                } else {
                    break;
                }
            }finally {
                rLock.unlock();
            }
        }
    }
}

public class Test5 {
    public static void main(String[] args) {
        Windows3 windows3 = new Windows3();
        Thread t1 = new Thread(windows3);
        Thread t2 = new Thread(windows3);
        Thread t3 = new Thread(windows3);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

// 同步，交替输出。notifyAll()、notify()、wait()必须出现在同步代码块或同步方法中，调用者必须是监视器
class Windows4 implements Runnable{
    private int tickets = 1;
    @Override
    public void run() {
        while (true) {
            synchronized(this) {
                notifyAll(); // 唤醒所有被wait的所有线程(结合wait可以解决一个窗口出现连续卖票的问题)
                if (tickets <= 100) {
                    System.out.println(Thread.currentThread().getName() + "正在出售：第" + tickets + "张票");
                    tickets++;
                } else {
                    break;
                }
                try {
                    wait();  // 进入阻塞状态并释放同步监视器
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class Test6{
    public static void main(String[] args) {
        Windows4 windows4 = new Windows4();
        Thread t1 = new Thread(windows4);
        Thread t2 = new Thread(windows4);
        Thread t3 = new Thread(windows4);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

// 线程池方式
class Sum implements Runnable{
    private int sum;
    @Override
    public void run() {
        for(int i=0; i<100; i++){
            if(i%2 != 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}

public class Test8 {
    public static void main(String[] args) {
        // 提供指定数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;

        // 实现类中设置线程池属性
        //threadPoolExecutor.setCorePoolSize(); // 核心池大小
        //threadPoolExecutor.setMaximumPoolSize(); //最大线程数
        //threadPoolExecutor.setKeepAliveTime();  // 线程没有任务最多保持多长时间终止

        // 执行任务
        threadPoolExecutor.execute(new Sum());  // 适用于Runnable
				//threadPoolExecutor.submit(); //适用于Callable
        
        // 关闭连接池
        threadPoolExecutor.shutdown();
    }
}
```

**生产者-消费者模式：**

```java
class Clerk{
    private int products = 0;
    public synchronized void put() {  //此时同步方法使用了同一把锁即this
        if(products<20){
            products++;
            System.out.println(Thread.currentThread().getName()+"生产了第"+products+"个产品");
            notifyAll();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void get() {
        if(products>0){
            System.out.println(Thread.currentThread().getName()+"消费了第"+products+"个产品");
            products--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable{
    private Clerk clerk;
    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while(true){
            clerk.put();
        }
    }
}

class Consumer implements Runnable{
    private Clerk clerk;
    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true){
            clerk.get();
        }
    }
}

public class Test7 {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        Thread p = new Thread(producer);
        Thread c = new Thread(consumer);
        Thread c2 = new Thread(consumer);

        p.setName("生产者");
        c.setName("消费者");
        c2.setName("消费者2");

        p.start();
        c.start();
        c2.start();
    }
}
```

### 2 枚举类

**定义：**类的对象是有限个的、确定的

**语法：**enum 类名{

​					1、提供当前枚举类对象(多个对象使用","分开末尾使用";"结束。写在最前面)

​					2、私有化构造器

​			}

**说明：**非自定义枚举类默认继承Enum类，Enum类继承Object类。单例模式也是一种自定义枚举类

**方法：**values()  返回枚举类中的所有对象数组。编译器插入到枚举类中的静态方法，Enum类中没有	

**使用场景：**

```java
/**
 * 工单名称枚举类
 *
 * @param
 * @Author olic
 * @return
 * 示例一
 */
public enum WoNameEnum {
    SALARY_ACCOUNT("salary_account", "薪酬核算", OmpTaskType.WOM_SALARY_CALCULATE),

    SALARY_PAYMENT("salary_payment", "薪酬发放", OmpTaskType.WOM_SALARY_PAY),

    EMP_TAX_CALCUL("emp_tax_calcul", "员工个税申报", OmpTaskType.WOM_EMPLOYEE_TAX_REPORT),

    private final String key;
    private final String value;
    private final OmpTaskType ompTaskType;

    WoNameEnum(String key, String value, OmpTaskType ompTaskType) {
        this.key = key;
        this.value = value;
        this.ompTaskType = ompTaskType;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public OmpTaskType getOmpTaskType() {
        return ompTaskType;
    }

    public static String getValueByCode(String woNameCode) {
        for (WoNameEnum e : WoNameEnum.values()) {
            if (woNameCode.equals(e.getKey())) {
                return e.getValue();
            }
        }
        return null;
    }

    public static OmpTaskType getValue(String woNameCode) {
        for (WoNameEnum e : WoNameEnum.values()) {
            if (woNameCode.equals(e.getKey())) {
                return e.getOmpTaskType();
            }
        }
        return null;
    }

}


/**
 * @author olic 
 * 示例二
 */
// 业务类
public class HandleService {
    public static String method1(String e){
        return e + ":method1";
    }

    public static String method2(String e){
        return e + ":method2";
    }

    public static String method3(String e){
        return e + ":method3";
    }

}

public enum HandleEnum {

    HANDL_EONE(1,HandleService::method1),
    HANDL_ETWO(2,HandleService::method2),
    HANDLE_ETHREE(3,HandleService::method3); 

    private int type;
    private Function<String,String> function;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Function<String, String> getFunction() {
        return function;
    }

    public void setFunction(Function<String, String> function) {
        this.function = function;
    }

    HandleEnum(int type, Function<String, String> function) {
        this.type = type;
        this.function = function;
      	System.out.println("nihao...");
    }

    public static Function<String,String> getFunctionByType(int type){
        Function<String,String> function = null;
        HandleEnum[] values = HandleEnum.values();  // 将枚举类转变为一个枚举类型的数组，获取所有对象
        for(HandleEnum value : values){  // 简化switch...case判断的地方
            if(value.type==type){
                function = value.function;
            }
        }
        return function;
    }
}

// 调用方
HandleEnum.getFunctionByType(int type).applay("d")  // 不用管里面的处理逻辑，交给HandleEnum类去管。实现解耦合

// 验证枚举类型创建了几次对象
System.out.println(HandleEnum.HANDL_EONE);
System.out.println(HandleEnum.HANDL_ETWO);
System.out.println(HandleEnum.HANDL_EONE);
System.out.println(HandleEnum.HANDL_EONE);
// 输出  说明：输出了三个nihao...表明枚举类型加载就创建完成对象并且以后不会再次创建
nihao...
nihao...
nihao...
HANDL_EONE 
HANDL_ETWO
HANDL_EONE
HANDL_EONE
```

### 3 注解

**定义：**Annotation其实就是代码里面的特殊标记，这些标记可以在编译、类加载、运行时被读取，并执行相应的处理

**基本注解：** 

- **@Override：**添加该注解则一定会在编译时期校验是不是重写，不是重写则报错
- **@Deprecated：**过时提示
- **@SuppressWarnings：**抑制编译期警告

**自定义注解：** 

1. 注解声明关键字**@interface**
2. 内部成员，通常使用xxx()表示
3. 可以指定成员默认值，使用default定义
4. 自定义注解没有成员时，表明是一个标识

**元注解：**修饰注解的注解

- **@Retention：**指所修饰的注解的生命周期：SOURCE、CLASS(默认)、RUNTIME只有生命为RUNTIME生命周期的注解才能通过反射获取
- **@Target：**指明所修饰的注解所能修饰的结构
- **@Documented：**表示所修饰的注解在被javadoc解析时，保留在下来
- **@Inherited：**表明所修饰的注解有继承性，父类上面声明，子类自动继承

### 4 集合

**说明：**数组中提供的方法非常有限，对于添加、删除、插入、获取数组实际元素个数等操作非常不便；还有数组存储特点有序、可重复，对于无序、不可重复的需求不能满足。集合就可以满足以上需求。封装了自动扩容机制和增删改方法等

**工具类：**Collections 用于操作Collection和Map

#### 4.1Collection

用于存储一个个对象。需要参数对象重写equals()

​							<img src="/Users/olic/work/图片库/集合体系图谱.png" alt="集合体系图谱" style="zoom:67%;" />

**常用方法：**add() 添加。addAll() 插入集合中所有的元素；size() 元素个数；isEmpty() 判断集合是否有元素；clear() 清空集合元素； contains() 判断是否包含。containsAll() 判断指定集合的所有元素是否都存在于该集合中；remove(Object obj) 移除。removeAll() 移除指定集合的所有元素；retainAll() 交集，并修改原集合引用；equals() 比较元素是否相同；hashCode() 返回对象的哈希值；toArray() 集合转数组；Arrays.asList(数组)  数组转集合。数组即可变参数 , Arrays.asList(T ... a)；iterator() 用于遍历集合元素

 **迭代器：**Iterator：hasNext() 判断是否有下一个元素。next() 指针下移并将集合位置上的元素返回

##### 4.1.1List

存储有序的、可重复的数据。也称动态数组

###### 4.1.1.1ArrayList

底层是数组，线程不安全，效率高 

 **源码分析：**jdk8中，对于ArrayList() ，底层Object[] elementData 初始化为{}，并没有创建长度为10的数组，第一次是调用add操作，底层才创建了长度为10的数组，在连续使用add或者使用addAll添加操作导致底层数组的容量不够，则进行扩容，扩容为原来/合并之后集合长度的1.5倍；如果第一次是调用addALL操作的时候，底层不会创建长度为10的数组，而是直接扩容为合并之后集合长度的1.5倍；建议使用ArrayList(int initialCapacity)  

###### 4.1.1.2LinkedList

底层是链表(因而不涉及扩容问题)，使用用于频繁的插入、删除操作

###### 4.1.1.3Vector

底层是数组，线程安全，效率低 

 **源码分析：**jdk7和8中，对于Vector()，底层Object[] elementData 初始化为10的数组。调用add操作时，如果此次添加导致底层数组的容量不够，则进行扩容，原来/合并之后集合长度的2倍，同时将原有数组的数据复制到新的数组中

**遍历：**迭代器方式、增强for循环、普通for循环、forEach()

**说明：**当单机遇到线程安全问题时，我们一般使用Collections.synchronizedList(array list)方式

##### 4.1.2Set

存储无序的、不可重复的数据、其中HashSet按照特定顺序遍历，LinkedHashSet可以按照添加顺序遍历，TreeSet按照大小排序遍历。源码详见Map结构  

**无序：**存储到内存中地址位置无序

**不可重复** 值相同的元素只能添加一个

**源码分析：**对于hashSet和LinkedHashSet添加等操作数据时，为了提高效率，会先根据hash()哈希值再加散列算法得出来的地址值若一样再比对hashCode，若哈希一样再比对equals()；对于TreeSet而言，如果compareTo()或者compare()返回值是0则表示元素一样，因而就不会添加到容器中(二叉树结构中)

###### 4.1.2.1HashSet

底层是数组+单向链表+红黑树，源码里面调用HashMap，添加值时底层调用map里面的put方法，key为要添加的值，value为静态私有化常量PRESENT初始化值为new object()；需要重写equals()和添加hashCode()

###### 4.1.2.2LinkedHashSet

底层是数组+双向链表+红黑树，需要重写equals()和hashCode()

###### 4.1.2.3TreeSet

底层是红黑树(排序二叉树)结构，元素是相同类对象并需要重写 compareTo()或者compare()	

#### 4.2Map

用于存储一对一对的数据，其中HashMap按照特定顺序遍历，LinkedHashMap可以按照添加顺序遍历，TreeMap按照大小排序遍历。需要参数对象重写hashCode()和equals()；

- **key：**无序的、不重复的，使用set存储所有的key

- **value：**无序的、可重复的，使用collection存储

- **Entry(键值对)：**无序的、不重复的，使用set存储所有的键值对

​					<img src="/Users/olic/work/图片库/集合体系图谱2.png" alt="集合体系图谱2"  />

**常用方法：**put() 增/改。 putAll() 添加集合中所有的元素；remove(key) 移除；clear() 清空；size() 元素个数；get(key) 查询；containsKey(key) 判断是否有key；containsValue(value) 判断是否有value；isEmpty() 判断是否为空；equals() 比较元素是否相同

**遍历：**keyset() 获取所有的key；values() 获取所有的value；entrySet() 获取所有的键值对

##### 4.2.1HashMap

底层是数组+单向链表+红黑树，线程不安全，效率高。可以存储为null的key或者value，当遇到线程安全问题时，我们一般使用Collections.synchronizedMap(hashmap)方式

**源码分析：**首先，调用hashCode()计算key1哈希值，此哈希值经过某种算法计算后，先判断table长度是不是为空，为空则创建table，再得到在底层table数组上的位置，如果此位置上的数据为空则数据添加成功；如果此位置上数据不为空，则一一进行比对哈希值，如果哈希值和已存在此位置上的数据的哈希值不相同，此时数据添加成功；如果哈希值和此位置上面数据的哈希值存在相同，则进行equals()比较，返回true则替换，返回false则添加成功

**说明**：使用put方法时，底层创建为16的数组，若存储长度超过16*加载因子时会扩容，扩容为原来的两倍。Jdk8中如果底层数组桶中链表长度超过8。若底层数组长度超过64，则桶中的node就会被树化，若底层数组长度未超过64，则数据扩容										

##### 4.2.2LinkedHashMap

底层是数组+双向链表+红黑树

**源码分析：**LinkedHashmap.Entry类继承了HashMap.Node类(实现了Map.Entry接口)并新增了before和after属性，相当于是一种双向指向。进而可以实现按照添加顺序遍历

##### 4.2.3TreeMap

底层是红黑树(排序二叉树)，元素是相同类对象并需要重写compareTo()或者compare()	

##### 4.2.4HashTable

线程安全，效率低。不能存储为null的key或者value

##### 4.2.5Properties

常用来处理配置文件，key和value都是String类型

```java
// set经典面试题
class Person{
    private String name;
    private int age;

    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class Test12 {
    @Test
    public void test(){
        HashSet set = new HashSet();
        Person p1 = new Person("AA", 20);
        Person p2 = new Person("BB", 30);
        set.add(p1);
        set.add(p2);
        
        //[Person{name='AA', age=20}, Person{name='BB', age=30}]
        System.out.println(set);  
        p1.setName("CC"); 
        
        //set为了提高效率会先hashCode，再根据此时的散列值寻找该对象。相应地址位置没数据
        set.remove(p1); 
        // [Person{name='CC', age=20}, Person{name='BB', age=30}]
        System.out.println(set);  
        
        //相应地址位置没有数据，可以存入
        set.add(new Person("CC", 20));
        // [Person{name='CC', age=20}, Person{name='CC', age=20}, Person{name='BB', age=30}]
        System.out.println(set);

        //哈希值不同，可以存入
        set.add(new Person("AA", 20));
        // [Person{name='CC', age=20}, Person{name='CC', age=20}, 
      	//    Person{name='AA', age=20}, Person{name='BB', age=30}]
        System.out.println(set); 
    }
}

// Map的遍历
HashMap<String, Integer> hashMap = new HashMap<>(); //类型推断
hashMap.put("liu", 100);
hashMap.put("zhang", 78);
hashMap.put("lu", 89);
//方式一
Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
while (iterator.hasNext()){
    Map.Entry<String, Integer> next = iterator.next();
    System.out.println(next.getKey() + ":" + next.getValue());
}
//方式二
Set<String> strings = hashMap.keySet();
Iterator<String> iterator1 = strings.iterator();
while (iterator1.hasNext()){
    String s = iterator1.next();
    System.out.println(s+":"+hashMap.get(s));
}

// 避坑
Long l = 12345678L;
Map<Long,Integer> m = new HashMap(2);
m.put(l,123);
String s = JSONObject.toJSONString(m);
// ------------------------ 网络传输对象
Map<Long,Integer> r = JSONObject.parseObject(s); // 虽然指定的值是Long，但是JSONObject还是用Integer接收了key值，因而建议封装dto对象进行传输
System.out.println(r.get(l)) // 此时得到的值为null
```

### 5 泛型

**背景：**JAVA推出泛型以前，程序员可以构建一个元素类型为Object的集合，该集合能够存储任意的数据类型对象，而在使用该集合的过程中，需要程序员明确知道存储每个元素的数据类型，否则很容易引发ClassCastException异常

**概念：**Java泛型是JDK5中引入的一个新特性，泛型提供了编译时类型安全监测机制，该机制允许我们在编译时检测到非法的类型数据结构。泛型的本质就是参数化类型，也就是所操作的数据类型被指定为一个参数。编译期行为

**好处：**

- 类型安全
- 消除了强制类型的转换

**应避免该情况发生：**

```java
List<String> s1 = new ArrayList<>(2);
s1.add("s");

List s2 = s1;

List<Integer> s3 = s2;
s3.add(2);
System.out.println(s3);
// [s,2]
```

#### 5.1泛型类

- 泛型类，如果没有指定具体的数据类型，此时，操作类型是Object
- 泛型的类型参数只能是类类型，不能是基本数据类型。因为基本类型的父类不是object
- 泛型类型在逻辑上可以看成是多个不同的类型，但实际上都是相同类型

**泛型类派生子类：**

- 子类也是泛型类，子类和父类的泛型类型要一致
  `class ChildGeneric<T,E> extends Generic<T>`

- 子类不是泛型类，父类要明确泛型的数据类型
  `class ChildGeneric extends Generic<String>`

#### 5.2泛型接口

```java
interface 接口名称 <泛型标识，泛型标识，…> {
	泛型标识 方法名(); 
	.....
}
```

**泛型接口的实现类：**

- 实现类也是泛型类，实现类和接口的泛型类型要一致

- 实现类不是泛型类，接口要明确泛型的数据类型

#### 5.3泛型方法

泛型方法是在调用方法的时候指明泛型的具体类型，独立于类而产生变换，如果static方法要使用泛型能力，就必须使其成为泛型方法

**语法：**

修饰符 <T，E, ...> 返回值类型 方法名(形参列表) { 方法体... }

**特点：**

- 权限修饰符与返回值中间有泛型列表

- 只有声明了的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
- < T >表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
- 与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型

**泛型方法与可变参数：**

```java
public <E> void print(E... e){
	for (E e1 : e) {
		System.out.println(e);
	}
}
```

```java
/**
 * 获取需要发送消息人员map
 * @param map
 * @param userIds
 * @param newRoleLogo 当前角色标识
 */
 private static <K, V> void getUserMap(Map<K, V> map, Collection<K> userIds, V newRoleLogo){
     if(!CollectionUtils.isEmpty(userIds)) {
          userIds.forEach(
                 item->{
                     if (map.containsKey(item)) {
                         // 获取map中用户角色标识
                         V oldRoleLogo = map.get(item);
                         List<V> roleLogos = Stream.of(oldRoleLogo, newRoleLogo).sorted((o1, o2) -> o1.toString().compareToIgnoreCase(o2.toString())).collect(Collectors.toList());
                         map.put(item, roleLogos.get(0));
                     }else {
                         map.put(item, newRoleLogo);
                     }
                 }
         );
     }
}
```

#### 5.4类型通配符

- 类型通配符一般是使用"?"代替具体的类型实参
- 所以，类型通配符是类型实参，而不是类型形参
- 就是说在参数传递时，我们可以一次性传递多个不同类型的参数

**类型通配符的上限：**

- 语法：
  `类/接口<? extends 实参类型>`
  要求该泛型的类型，只能是实参类型，或实参类型的子类类型

**类型通配符的下限：**

- 语法：
  `类/接口<? super 实参类型>`
  要求该泛型的类型，只能是实参类型，或实参类型的父类类型

#### 5.5类型擦除

泛型是Java 1.5版本才引进的概念，在这之前是没有泛型的，但是泛型代码能够很好地和之前版本的代码兼容。那是因为，泛型信息只存在于代码编译阶段，在进入JVM之前，与泛型相关的信息会被擦除掉，我们称之为–类型擦除

**无限制类型擦除：**

<img src="/Users/olic/work/图片库/无限制类型擦除.png" alt="无限制类型擦除" style="zoom:80%;" />

**有限制类型擦除：**

<img src="/Users/olic/work/图片库/有限制类型擦除.png" alt="有限制类型擦除" style="zoom:80%;" />

### 6 IO流

**说明：**网络端或本地数据传输

<img src="/Users/olic/work/图片库/IO流.png" alt="IO流" style="zoom:75%;" />

#### 6.1File

file类的一个对象，代表一个文件或文件目录。涉及文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，如果需要读取或写入文件内容，必须使用IO流来完成

**构造器：**new File(pathname)，new File(parent, child)，new File(file, child) 

**常用方法：** getAbsolutePath()  获取文件绝对路径；getPath() 获取文件路径；getName()  获取文件名；getParent()  获取上层；length() 获取文件大小；lastModified()  获取最后一次修改时间；list()  获取指定目录下的所有文件或者文件目录的名称数组；listFiles()  获取指定目录下的所有文件或者文件目录下的file数组；removeTo()  把文件名重命名为指定的文件；isDirectory()  判断是否是文件目录；isFile()  判断是否是文件；exists()  判断是否存在；canRead()  判断是否可读；canWrite()  判断是否可写；isHidden()  判断是否可隐藏

#### 6.2IO流

**节点流：**直接操作file的流。包括 fileOutputStream、fileInputstream、fileReader、fileWriter

**缓存流：**有相应的缓存机制，使得数据传输更高效

**转换流：**提供字节流与字符流之间的转换

- new InputStreamReader(字节流, 指定字符集)   字节流转换成字符流

- new OutputStreamWriter(字符流, 指定字符集)  字符流转换成字节流

**对象流：**传输对象。传输的对象必须实现Serializable

- java.io.ObjectOutputStream：表示对象输出流

- java.io.ObjectInputStream：表示对象输入流

#### 6.3序列化

网络间以二进制进行数据传输

序列化：将对象转换成二进制；反序列化：将二进制数据换回原对象

- Java的序列化机制是通过判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体类的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常，即是InvalidCastException

- 当实现java.io.Serializable接口的类没有显式地定义一个serialVersionUID变量时候，Java序列化机制会根据编译的Class自动生成一个serialVersionUID作序列化版本比较用，这种情况下，如果Class文件(类名，方法名等)没有发生变化(增加空格，换行，增加注释等等)，就算再编译多次，serialVersionUID也不会变化的

- 如果我们不希望通过编译来强制划分软件版本，即实现序列化接口的实体能够兼容先前版本，就需要显式地定义一个名为serialVersionUID

​					![序列化](/Users/olic/work/图片库/序列化.jpeg)![反序列化](/Users/olic/work/图片库/反序列化.jpeg)

**优点：**

- 通过序列化在进程间传递对象

- 通过序列化以字节流的形式使对象在网络中进行传递和接收；如，前后端json交互(转json的字符串可以不用序列化，详见说明)	

- 保存对象，保存对象的字节序列到本地文件或者redis中；如，通过对象流把对象写进本地文件中

**说明：** 

- 当一个父类实现序列化，子类自动实现序列化；不需要显式实现Serializable
- 当一个对象的实例变量引用其他对象，序列化该对象时也把引用对象进行序列化。这是能用序列化解决深拷贝的重要原因
- 静态变量属于类的状态；因此，序列化并不保存静态变量
- transient代表对象的临时数据；因此，序列化并不保存临时数据
- 数组类不能声明显式的serialVersionUID，所以它们总是有默认计算值，但要求匹配；serialVersionUID值对于数组类是无效的
- springboot在提供接口的时候设计到网络的传输，所以传输的对象是肯定需要实现Serializable接口的，但是在使用@RestController 的时候spring已经确定使用json格式交互，故我们定义的所谓传输对象其实已经被转换成了json字符串，而json字符串是实现了Serializable接口的，传输过程中json字符串被序列化二进制进行传输。所以定义的返回值对象在@RestController 的修饰下是不需要实现序列化接口的

```java
/**
 * @author olic
 * @date 2020/11/239:38 上午
 * @ 缓冲流
 */
public void test(){
    BufferedInputStream bi = null;
    BufferedOutputStream bo = null;
    try {
        bi = new BufferedInputStream(new FileInputStream(new File("触发器.png")));
        bo = new BufferedOutputStream(new FileOutputStream(new File("触发器2.png")));
        byte[] bbuff = new byte[1024];
        int len;
        while ((len=bi.read(bbuff)) != -1){
           bo.write(bbuff,0,len);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if(bi != null){
            try {
                bi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(bo != null){
            try {
                bo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

结论 1、字节流复制文本文件时不会存在乱码问题(除非在内存层面查看(该问题可以通过转换流来处理))
		2、对于文本文件(.txt，.java，.c，.cpp) 使用字符流处理；
		3、对于非文本文件(.jpg，.mp3，.avi，.doc，.ppt) 使用字节流处理
  	4、缓存流有缓存机制更高效
  	5、关闭最外层里面的自动关闭
  

/**
 * @author olic
 * @date 2020/11/237:52 下午
 * @序列化和反序列化
 */
class Personx implements Serializable {
    public static final long serialVersionUID = 43243L;
    private String name;
    private static String hobby;
    private int age;
  	private transient double height;

    public Personx(String name, String hobby, int age, double height) {
        this.name = name;
        this.hobby = hobby;
        this.age = age;
      	this.height = height;
    }

    @Override
    public String toString() {
        return "Personx{" +
                "name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                ", age=" + age +
          			", height=" + height +
                '}';
    }
}
public class Test18 {
    @Test
    public void serializable(){
        try(ObjectOutputStream ou=new ObjectOutputStream(new FileOutputStream(new File("person.txt")));){
            ou.writeObject(new Personx("刘强东", "奶茶", 47, 176.3));
            ou.writeObject(new Personx("刘德华", "抽烟", 60, 175.2));
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @Test
    public void deserializable(){
        try(ObjectInputStream oi=new ObjectInputStream(new FileInputStream(new File("person.txt")));){
            Object o = oi.readObject();
            Personx personx = (Personx) o;
            System.out.println(personx);
          
            Object o1 = oi.readObject();
            Personx personx1 = (Personx) o1;
            System.out.println(personx1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
// 输出结果
Personx{name='刘强东', hobby='null', age=47, height=0}
Personx{name='刘德华', hobby='null', age=60, height=0}


/**
 * 生成错误文件
 * @param dataFileUrl 原excel文件地址
 * @param errorMap 错误map:键为行号，值为错误
 * @return url，错误文件地址
 */
public static String creatErrorFile(String dataFileUrl, Map<Integer, List<String>> errorMap) {
    if(StringUtils.isEmpty(errorMap)){
        return null;
    }
    File file = null;
    try {
        file = File.createTempFile("errors",".xlsx");
    } catch (IOException e) {
        log.info("生成临时文件失败：{}",e.getMessage());
        throw new CustomException("生成临时文件失败："+e.getMessage(), ResultCode.FAILURE.getCode());
    }
    R<BizFile> r;
    try(XSSFWorkbook workbook = new XSSFWorkbook(FileUtils.returnBitMap(dataFileUrl));
        OutputStream out = new FileOutputStream(file)){
        XSSFSheet sheet = workbook.getSheetAt(0);
        errorMap.forEach((key, value) -> {
            if(StringUtils.isNotEmpty(value)){
                XSSFRow row = sheet.getRow(key);
                int num = row.getPhysicalNumberOfCells();
                XSSFCell cell = row.createCell(num);
                String collect = String.join(";", value);
                cell.setCellValue(collect);
            }
        });
        workbook.write(out);
        workbook.close();
        MultipartFile multipartFile = ExcelUtil.fileToMultipartFile(file);
        RemoteFileService remoteFileService = SpringContextHolder.getBean(RemoteFileService.class);
        r = remoteFileService.uploadCosServer(multipartFile);
    }catch (IOException e){
        log.info("生成错误文件失败：{}",e.getMessage());
        throw new CustomException("生成错误文件失败："+e.getMessage(), ResultCode.FAILURE.getCode());
    }
    return r.getCode() == R.SUCCESS ? r.getData().getUrl() : String.format("错误文件上传失败:%s",r.getMsg());
}
```

### 7 反射	

**含义：**反射机制允许程序在执行期借助api取得任何类的内部信息(包括private)，并能直接操作任意对象或类的内部属性和方法。在Java中，Class类与java.lang.reflect类库一起对反射技术进行了全力的支持。在反射包中，我们常用的类主要有Constructor类表示的是Class对象所表示的类的构造方法，利用它可以在运行时动态创建对象、Field表示Class对象所表示的类的成员变量，通过它可以在运行时动态修改成员变量的属性值(包含private)、Method表示Class对象所表示的类的成员方法，通过它可以动态调用对象的方法(包含private)

**类的加载过程：**程序经过javac.exe命令以后，会生成一个或多个字节码文件，接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此运行时类，就称为Class的一个实例换句话说，Class的实例就对应着一个运行时类/数组/接口/枚举类/注解/void/基本数据类型

**获取Class实例(字节码文件的class类对象)：**

- 调用运行时类的属性(.class)：Class clazz = 类.class 

- 通过运行时类的对象：类 对象 = new 类()   Class clazz = 对象.getClass()


- 通过Class的静态方法：Class clazz = Class.forName("全类名(路径)") 运行期行为，动态性体现


- 使用类的加载器：ClassLoader cl = 类.class.getClassLoader()   Class clazz = cl.loadClass("全类名")


**创建运行时类的对象：**Class<Person> clazz = Person.class;  Person per = clazz.newInstance()

**说明：**使用clazz.newInstance()时，会调用运行类里面的空参构造器，要求运行时类里面必须有相应的空参构造器并且构造器权限要满足要求

```java
class Person{
    private String name;
    private int age;
    public Person() {
        System.out.println("Person");
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private String getNation(String name, String nation){
        System.out.println(name + "来自" + nation);
        return nation;
    }
    private static void getPrice(){
        System.out.println("恭喜你得到了一枚金币");
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/**
 * @author olic
 * @date 2020/11/244:59 下午
 * @获取运行时类对象指定的属性
 */
public class Test22 {
    @Test
    public void test() throws Exception {
        Class<Person> clazz = Person.class;
        // 1、创建运行类对象。会调用运行类里面的空参构造器。可以使用有参构造器直接给创建的对象属性赋值
        // Person per = clazz.newInstance();
        Person per = clazz.getDeclaredConstructor(String.class, int.class).newInstance("test",3);
        // 2、获取运行类指定变量
        Field name = clazz.getDeclaredField("name");
      	// 获取属性名称name
      	String n = name.getName();
        //保证当前属性可访问
        name.setAccessible(true);
        // 3、获取、设置当前对象属性值
        name.set(per, "卢照临");  // 反射修改私有属性值
        String n = (String) name.get(per);
        System.out.println(n); // 卢照临
    }
}

/**
 * @author olic
 * @date 2020/11/248:13 下午
 * @获取运行时类对象指定的方法
 */
public class Test23 {
    @Test
    public void test() throws Exception {
        Class<Person> clazz = Person.class;
        // 1、创建运行类对象
        Person p = clazz.newInstance();
        // 2、获取运行类指定方法
        Method m = clazz.getDeclaredMethod("getNation", String.class, String.class);
        Method m1 = clazz.getDeclaredMethod("getPrice");
        //保证当前属性可访问
        m.setAccessible(true);  // m.getName()可以获取方法名
        m1.setAccessible(true);
        // 3.1、对象方法
        String reV = (String)m.invoke(p,"卢照临", "汉族");
        System.out.println(reV); // 汉族
        // 3.2、静态方法  此时Person.class可省略。调用运行时类的方法无返回值，则invoke()返回null
        Object o = m1.invoke(Person.class);
        System.out.println(o);  // null
    }
}

/**
 * 反射获取指定目录下的方法
*/
// 扫包
Reflections reflections = new Reflections(new ConfigurationBuilder()
            .forPackages("com.central")
						 // 添加属性注解扫描工具
            .addScanners(new MethodAnnotationsScanner())
     );
// 获取带有特定注解对应的方法
Set<Method> methods = reflections.getMethodsAnnotatedWith(Authorization.class);

/**
 * 获取创建工单的BO列表
 *
 * @param woNextHandleBO 多节点工单下一个节点BO
 * @return
*/
protected WoBaseFiledBO getWoBaseFiledBOS(WoNextHandleBO woNextHandleBO) {
   // 利用反射获取 WoBaseFiledBO
   WoBaseFiledBO woBaseFiledBO = new WoBaseFiledBO();
   Class<? extends WoNextHandleBO> aClass = WoNextHandleBO.class;
   Field[] declaredFields = aClass.getDeclaredFields();
   for (int i = 0; i < declaredFields.length; i++) {
        Field declaredField = declaredFields[i];
        declaredField.setAccessible(true);
        Object o = null;
        try {
            o = declaredField.get(woNextHandleBO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            continue;
        }
        if (o == null || o instanceof Long || o instanceof Boolean || o instanceof String || o instanceof Date) {
            continue;
        }
        woBaseFiledBO = (WoBaseFiledBO) o;
        break;
   }
   return woBaseFiledBO;
}
```

**DynaBean：**

DynaBean是使用反射机制动态操作JavaBean的一个封装类，通过这个类，可以通过字符串传入name方式动态调用get和set方法，也可以动态创建JavaBean对象，亦或者执行JavaBean中的方法

```java
import cn.hutool.core.bean.DynaBean;

public static class User{
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String testMethod(String str){
        System.out.println(str);
    }
    @Override
    public String toString() {
        return "User [name=" + name + "]";
    }
}

// 通过DynaBean来包装并操作这个Bean
User user = new User();
DynaBean bean = DynaBean.create(user);
bean.set("name", "李华"); // 属性不存在时运行报错
String name = bean.get("name");  //李华
System.out.println(user); //李华
// 除了标准的get和set方法，也可以调用invoke方法执行对象中的任意方法
bean.invoke("testMethod", "sss");  //sss


/**
  * 对象赋值:方式一
  * @param target 目标对象
  * @param resouceMap 取值map
  * @param targetKey 目标对象中的属性值
  * @param resourceKey 取值map中的key
	*/
public static void setValue(Object target, Map<String, SysDictData> resouceMap,String targetKey,String resourceKey) {
    try{
        DynaBean bean = DynaBean.create(target);
        String value = null;
        if (null != resouceMap) {
            SysDictData sysDictData = resouceMap.get(resourceKey);
            if (null != sysDictData) {
                value = sysDictData.getDictLabel();
            }
        }
        // 属性不存在时运行报错
        bean.set(targetKey, value);
    }catch (Exception e){
        System.out.println(e);
    }
}

/**
  * 对象赋值:方式二（原字段名后拼接Desc）
  * @param target 目标对象
  * @param resouceMap 取值map
  * @param targetKey 目标对象中的属性值
  * @param resourceKey 取值map中的key
  */
public void setDictValueDesc(Object target, Map<String, SysDictData> resouceMap, String targetKey, String resourceKey) {
    SysDictData sysDictData = typeMap.get(resourceKey);
    if (sysDictData != null) {
        String dictLabel = sysDictData.getDictLabel();
        Map<String, Object> objectMap = BeanUtils.beanToMap(target);
        objectMap.put(targetKey + "Desc", dictLabel);
        BeanUtils.mapToBean(objectMap, target);
    }
}

// resouceMap内存结构
{
  "@type": "java.util.HashMap",
  "1": {
    "@type": "com.junrunrenli.common.core.domain.entity.SysDictData",
    "createBy": "admin",
    "createTime": 1619707095000,
    "default": false,
    "dictCode": 177,
    "dictLabel": "创建",
    "dictSort": 0,
    "dictType": "business_voucher_status",
    "dictValue": "1",
    "isDefault": "N",
    "params": {
      "@type": "java.util.HashMap"
    },
    "status": "1"
  },
  "2": {
    "@type": "com.junrunrenli.common.core.domain.entity.SysDictData",
    "createBy": "admin",
    "createTime": 1619707095000,
    "default": false,
    "dictCode": 178,
    "dictLabel": "已开票",
    "dictSort": 2,
    "dictType": "business_voucher_status",
    "dictValue": "2",
    "isDefault": "N",
    "params": {
      "@type": "java.util.HashMap"
    },
    "status": "1"
  }
```

**ReflectUtil：**

```java
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.annotation.AnnotationUtil;

Map<String, Field> fieldMap = ReflectUtil.getFieldMap(BusinessSocialSecurityDetailDTO.class);
String[] values = AnnotationUtil.getAnnotationValue(field, ExcelProperty.class,"value");
```

### 8 RESTful风格

请求资源状态转换。所有资源都共享统一的接口来对资源进行访问。使用的是标准的 HTTP 方法，比如 GET、PUT、POST、DELETE

```java
/**
 * 系统产品 controller
 * @author olic
 * @version 1.0
 * @date 2022/1/18 10:02
 */
@Api(value = "系统产品相关API", tags = {"系统产品相关API"})
@RestController
@RequestMapping("/product")
public class WoUserProductController extends BaseController {

    @Resource
    private IWoUserProductService woUserProductService;

    @Resource
    private IWoUserProductService woUserProductService;

    /**
     * 系统产品--列表查询
     */
    @ApiOperation(value = "系统产品-列表查询(分页)", notes = "系统产品-列表查询(分页)", httpMethod = "GET")
    @PreAuthorize("@ss.hasPermi('system:product:list')")
    @GetMapping("/page")
    public TableDataInfo page(WoUserProduct woUserProduct){
        startPage();
        List<WoUserProduct> list = woUserProductService.selectWoUserProductList(woUserProduct);
        return getDataTable(list);
    }

    /**
     * 系统产品--列表查询
     */
    @ApiOperation(value = "系统产品-列表查询", notes = "系统产品-列表查询", httpMethod = "GET")
    @PreAuthorize("@ss.hasPermi('system:product:list')")
    @GetMapping("/list")
    public AjaxResult list(WoUserProduct woUserProduct){
        return AjaxResult.success(woUserProductService.selectWoUserProductList(woUserProduct));
    }

    /**
     * 系统产品--新增
     */
    @Log(title = "新增系统产品", businessType = BusinessType.INSERT)
    @ApiOperation(value = "系统产品-新增", notes = "系统产品-新增", httpMethod = "POST")
    @PreAuthorize("@ss.hasPermi('system:product:add')")
    @PostMapping
    public AjaxResult add(@RequestBody WoUserProduct woUserProduct){
        if(woUserProduct.getProductCode() == null){
            logger.error("系统产品编号不能为空！");
            return AjaxResult.error("系统产品编号不能为空！");
        }
        WoUserProduct wp = woUserProductService.selectByProductCode(woUserProduct);
        if(wp != null){
            logger.error("已经存在相同的系统产品编号！");
            return AjaxResult.error("已经存在相同的系统产品编号！");
        }
        return AjaxResult.success(woUserProductService.insertWoUserProduct(woUserProduct));
    }

    /**
     * 系统产品--查询
     */
    @Log(title = "查询系统产品详情", businessType = BusinessType.OTHER)
    @ApiOperation(value = "系统产品-详情查询", notes = "系统产品-详情查询", httpMethod = "GET")
    @PreAuthorize("@ss.hasPermi('system:product:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id){
        return AjaxResult.success(woUserProductService.selectById(id));
    }

    /**
     * 系统产品--修改
     */
    @Log(title = "修改系统产品", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "系统产品-修改", notes = "系统产品-修改", httpMethod = "PUT")
    @PreAuthorize("@ss.hasPermi('system:product:edit')")
    @PutMapping
    public AjaxResult edit(@RequestBody WoUserProduct woUserProduct) {
        if(woUserProduct.getId() == null){
            logger.error("请选择要修改的系统产品！");
            return AjaxResult.error("请选择要修改的系统产品！");
        }
        return toAjax(woUserProductService.updateWoUserProduct(woUserProduct));
    }

    /**
     * 系统产品--删除
     */
    @Log(title = "删除系统产品", businessType = BusinessType.DELETE)
    @ApiOperation(value = "系统产品-删除", notes = "系统产品-删除", httpMethod = "DELETE")
    @PreAuthorize("@ss.hasPermi('system:product:remove')")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        if(ids == null){
            logger.error("请选择要删除的系统产品！");
            return AjaxResult.error("请选择要删除的系统产品！");
        }
        return toAjax(woUserProductService.deleteWoUserProduct(ids));
    }
}
```

### 9 幂等性

幂等性是分布式环境下常见的问题。就是用户对于同一操作发起的一次请求或者多次请求的结果是一致的，不会因为多次点击而产生了副作用



## javaWeb

### 1 servlet  

用来接收和响应来自客户端的请求		

### 2 cookie和session

- **cookie：**服务器通知客户端保存键值对的一种技术。客户端有了cookie之后每次请求都发送给服务器

- **session：**存放在服务器的内存中的一份数据,基于cookie的一种技术。 **session生命周期：**第一次使用时创建，session超时(客户端两次请求的最大时常)或调用invalidate()方法销毁使得session失效  **session钝化：**当服务器正常关闭时，还存活着的session(在设置时间内没有销毁) 会随着服务器的关闭被以文件(“SESSIONS.ser”)的形式存储在tomcat 的work 目录下  **session活化：**当服务器再次正常开启时,服务器会找到之前的“SESSIONS.ser” 文件，从中恢复之前保存起来的Session 对象			

<img src="/Users/olic/work/图片库/cookie,session.jpg" alt="cookie,session" style="zoom:67%;" />

### 3 filter

拦截请求，过滤响应。多个filter的执行顺序是由他们在web.xml里面的顺序决定

```xml
<!-- 配置中文乱码过滤器 -->
<filter>
  <filter-name>characterEncodingFilter</filter-name>
  <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
  <init-param>
    <param-name>encoding</param-name>
    <param-value>UTF-8</param-value>
  </init-param>
</filter>
<filter-mapping>
  <filter-name>characterEncodingFilter</filter-name>
  <!-- /*：匹配所有url包括带扩展名的。一般用于过滤器上面 
			 /：匹配所有url包括带扩展名的静态资源，动态.jsp等资源不匹配。一般用于前端控制器上面-->
  <url-pattern>/*</url-pattern> 
</filter-mapping>
```

### 4 listener

- **监听ServletContext事件：**  

  ServletContextLinstener：监听ServletContext对象的生命周期。服务器启动、停止做一些操作

​	   ServletContextAttributeLinstener：监听ServletContext域中属性的变化

- **监听HttpSession事件：**

​		HttpSessionLinstener：监听HttpSession对象的生命周期

​		HttpSessionAttributeLinstener：监听所有对象在HttpSession域中属性的变化

​		HttpSessionActivitionLinstener：监听某个对象随着HttpSession活化钝化的过程

​		HttpSessionBindingLinstener：监听某个对象保存(绑定)或移除(解绑)或修改在session中的过程

- **监听ServletRequest事件：**

​		ServletRequestLinstener：监听request对象的生命周期

​		ServletRequestAttributeLinstener：监听request域中属性的变化

## 框架

### 1 spring

**架构图：**

<img src="/Users/olic/work/图片库/spring架构模块.png" alt="spring架构模块" style="zoom:75%;" />

#### 1.1IOC

容器，控制反转(创建对象权交给框架，一般使用工厂模式根据配置文件反射创建象集中放到map中管理)。降低程序耦合

**Bean的作用域：**

- **singleton：**单例模式、默认状态，只生成一个实例，每次从spring容器内获取的都是同一个bean
- **prototype：**每次从spring容器内获取，都会产生一个新的bean
- **request：**一次http请求级别
- **session：**会话级别
- **global session**

**Bean对象生命周期：**

- **单例对象：**单例对象的生命周期和容器相同

- **多例对象：**多例对象当我们使用的时候spring帮我们创建，当对象长时间不用且没有被别的对象引用时，由java垃圾回收器回收

**加入容器：** 

- **@Controller：**控制器，推荐给servlet使用

- **@Service：**业务逻辑，推荐给service层使用

- **@Repository：**数据库操作，推荐给dao层使用

- **@Component：**推荐给不属于以上几层使用 

**自动装配：**

-  **@Autowired：**自动按照类型注入。如果我们想使用按照名称(byName)来装配，可以结合@Qualifier注解一起使用
-  **@Qualifier：**按照名称注入
-  **@Resource：**默认按照ByName自动注入。如果同时指定name和type属性，则找到唯一匹配的bean装配，未找到则抛异常；如果指定name属性，则按照名称(by-name)装配，未找到则抛异常；如果指定type属性，则按照类型(by-type)装配，未找到或者找到多个则抛异常；既未指定name属性，又未指定type属性，则按照名称(by-name)装配；如果未找到，则按照类型(by-type)装配

**Spring的一个特殊的注入功能：**

- 当注入一个Map的时候，value泛型为MaoService，则注入后Spring会将实例化后的bean放入value，key则为实现类的小驼峰命名
- 当注入一个List的时候，List的泛型为MaoService，则注入后Spring会将实例化的bean放入List中

```java
@Autowired
Map<String, IReportExportService> reportExportServiceMap;
@Autowired
List<IReportExportService> reportExportServices;
```

**spring并发访问的线程安全性：**

**问题：**spring默认controller、service、dao都是单实例的，那就有可能会出现会发生窜数据的问题。比如：如果控制器是使用单例形式，且controller中有一个私有的变量a；所有请求到同一个controller时，使用的a变量是共用的，即若是某个请求中修改了这个变量a，则在别的请求中能够读到这个修改的内容

**解决方式：**我们在Controller和service中声明 @Scope("prototype")，每次都创建新的controller和Service；dao层用默认singleton就行，虽然Service类也有dao这样的属性，但dao这些类都是没有状态信息的

**spring中重要的接口：**

- InitializingBean：目的就是进一步调整实例的状态
- DisposableBean：当bean使用完毕后，容器将检查singleton类型的bean，看其是否实现了DisposableBean接口，接口中有一个方法提供了singleton类型的对象实例销毁之前执行的销毁逻辑
- ApplicationContextAware：感知容器，继承该接口，实现其中的setApplicationContext方法，在容器启动后，就可以获取容器

**循环注入解决方式：**

Aware接口(感知)：该接口是一个标志接口，没有任何的方法，作用是实现该接口的接口，都可以感知响应的事物，例如ApplicationContextAware接口，就可以感知容器，继承该接口，实现其中的setApplicationContext方法，在容器启动后，就可以获取容器，使用applicationContext.getBean(clazz)获取代理对象。例如：可以自行封装SpringContextHolder类实现ApplicationContextAware接口，通过SpringContextHolder.getBean(name)或者SpringContextHolder.getBean(clazz)获取代理对象

```java
package com.jr.common.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {
    private static final Logger log = LoggerFactory.getLogger(SpringContextHolder.class);
    private static ApplicationContext applicationContext = null;

    public SpringContextHolder() {
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
	
    // 此处用来获取容器对象
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static <T> T getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    public static void clearHolder() {
        if (log.isDebugEnabled()) {
            log.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
        }

        applicationContext = null;
    }

    public static void publishEvent(ApplicationEvent event) {
        if (applicationContext != null) {
            applicationContext.publishEvent(event);
        }
    }

    public void destroy() {
        clearHolder();
    }
}

//获取请求
((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
```

#### 1.2AOP

面向切面编程。降低程序耦合

**定义：**将某段代码动态的切入到指定代码的指定位置的编程方式，比如静态代理、动态代理、javaagent等

**应用：**spring aop是通过动态代理实现的，比如事务、日志、异步等

**术语：** 

- **连接点(Joinpoint)：**类中可以被增强的方法
- **切点(Pointcut)也叫切入点：**类中有四个方法可以被增强，这四个是连接点，实际操作中实际增强的方法就是切入点
- **增强(Advice)增强的逻辑：**比如日志功能，日志功能即为增强
- **切面(Aspect)：**把增强用到切入点的过程

**spring创建代理：** 

- 被代理类有实现接口时，通过实现接口创建代理对象

- 被代理类没有实现接口时，cglib帮我们创建好代理对象

**JDK动态代理和CGLIB字节码生成的区别？**

- JDK动态代理是利用反射机制生成一个实现代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理。只能对实现了接口的类生成代理，而不能针对类

- CGLIB动态代理是利用asm开源包，对代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。是针对类实现代理，因为是继承，所以该类或方法最好不要声明成final 
- 性能对比。创建代理方面，JDK要比CGLib好很多；动态代理的运行速度方面，在1.6和1.7的时候JDK动态代理的速度要比CGLib动态代理的速度要慢，在JDK1.8的时候，JDK动态代理的速度已经比CGLib动态代理的速度快很多

**通知类型：** 

- **@Before：**在目标方法执行之前运行

- **@AfterThrowing：**在目标方法发生异常后运行

- **@AfterReturning：**在目标方法正常执行后运行

- **@After：**在目标方法结束之后运行

- **@Around**：环绕通知。可以在代码中手动控制增强方法何时执行。使用以上基于注解的通知时执行顺序会有些问题，环绕通知的执行顺序与基于xml的aop执行顺序一致

<img src="/Users/olic/work/图片库/环绕通知.png" alt="环绕通知" style="zoom:20%;" />

**多切面通知执行顺序：**

- **正常情况：**切面1环绕前置===切面1@Before===切面2环绕前置===切面2@Before===目标方法执行===切面2@AfterReturning===切面2@After===切面2环绕返回===切面2环绕最终===切面1@AfterReturning===切面1@After===切面1环绕返回===切面1环绕最终

- **异常情况：**切面1环绕前置===切面1@Before===切面2环绕前置===切面2@Before===目标方法执行===切面2@AfterThrowing===切面2@After===切面2环绕异常===切面2环绕最终===切面1@AfterThrowing===切面1@After===切面1环绕异常===切面1环绕最终
- 可以使用@Order注解指定先后顺序，数字越小，优先级越高，先进后出	

**通配符：** 

- **..** ：匹配任意个数任意类型的参数、任意多层路径 
- ***** ：匹配任意类型 、匹配一层路径 、代替任意返回值类型

**spring声明式事务：**所谓声明式事务，就是通过配置或注解的方式省去很多代码，从而让Spring来帮你管理事务

**事务的传播机制：** REQUIRED、SUPPORTS、MANDATORY、REQUIRES_NEW、NOT_SUPPORTED、NEVER、NESTED

- **【REQUIRED】**: spring事务的默认机制，当前没有事务，则创建一个事务，如果存在事务，则加入到该事务中

```java
// 例1
@Transactional(propagation = Propagation.REQUIRED)
public void testMain(){
    A(a1);  //调用A入参a1
    testB();    //调用testB
}

@Transactional(propagation = Propagation.REQUIRED)
public void testB(){
    B(b1);  //调用B入参b1
    throw Exception;     //发生异常抛出
    B(b2);  //调用B入参b2
}
//testMain和testB方法都声明了required事务，testMain中调用了testB方法，所以testB会加入到testMain的事务中，共享一个事务。当testB中抛出异常后，B(b1)操作回滚，testMain在同一个事务，所以也需要回滚。所以a1、b1都不会插入，b2由于在异常后面，所以也不会插入成功

//例2
public void testMain(){
    A(a1);  //调用A入参a1
    testB();    //调用testB
}
@Transactional(propagation = Propagation.REQUIRED)
public void testB(){
    B(b1);  //调用B入参b1
    throw Exception;     //发生异常抛出
    B(b2);  //调用B入参b2
}
//a1插入成功，b1和b2都失败。因为testMain没有声明事务，testB声明了required，testB自己会创建一个，其抛出异常，只会回滚自己的，调用方不受影响。所以a1能插入成功

//例3
@Transactional(propagation = Propagation.REQUIRED)
public void testMain(){
    A(a1);  //调用A入参a1
    try{
    	testB();    //调用testB
    }catch(Exception e){
      
    }
  	A(a2);
}
@Transactional(propagation = Propagation.REQUIRED)
public void testB(){
    B(b1);  //调用B入参b1
    throw Exception;     //发生异常抛出
    B(b2);  //调用B入参b2
}
//a1,a2插入成功，b1,b2插入失败。因为内部的代理对象的事务连接中已经添加了标记，无论是否catch异常都要回滚
//效果如下：
public void testMain(){
    A(a1);
  	try{
      	throw Exception;   
    }catch(Exception e){
      	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
    A(a2);
}
```

- 【**SUPPORTS**】: 如果当前存在事务，则加入当前事务，如果当前没有事务，则以非事务执行


```java
public void testMain(){
    A(a1);  //调用A入参a1
    testB();    //调用testB
}
@Transactional(propagation = Propagation.SUPPORTS)
public void testB(){
    B(b1);  //调用B入参b1
    throw Exception;     //发生异常抛出
    B(b2);  //调用B入参b2
}
//a1和b1都插入成功，b2失败。由于testMain没有声明事务，testB声明的support，所以testB也没有事务，testB的异常未对testMain产生影响，a1和b1都不用回滚；但是，如果testMain声明required事务机制，那么testMain和testB都会放到同一个事务中，两个都要回滚
```

- 【**MANDATORY**】：当前存在事务，则加入事务，如果不存在事务，则抛出异常


```java
public void testMain(){
    A(a1);  //调用A入参a1
    testB();    //调用testB
}
@Transactional(propagation = Propagation.MANDATORY)
public void testB(){
    B(b1);  //调用B入参b1
    throw Exception;     //发生异常抛出
    B(b2);  //调用B入参b2
}
//a1插入成功，b1和b2失败。testMain没有声明事务，所以testB的异常与否不会影响a1的插入操作；由于testMain没有声明事务，所以执行testB()的时候会抛出异常，b1的操作都没有执行，所以b1和b2都不会成功。
```

- 【**REQUIRES_NEW**】: 无论如何，都要创建一个新的事务，如果当前存在事务，则挂起不管


```java
@Transactional(propagation = Propagation.REQUIRED)
public void testMain(){
    A(a1);  //调用A入参a1
    testB();    //调用testB
    throw Exception;     //发生异常抛出
}
@Transactional(propagation = Propagation.REQUIRES_NEW)
public void testB(){
    B(b1);  //调用B入参b1
    B(b2);  //调用B入参b2
}
//a1插入失败，b1和b2成功。testMain声明的required，本来可以让testB共享其事务，但是testB声明的requires_new，自己单独创建了一个事务，不和testMain搞一起，所以testMain中抛出异常对testB没有丝毫影响。反而testMain自己要回滚
```

- 【**NOT_SUPPORTED**】： 无论如何，都不创建事务，即使当前存在事务，也挂起不用


```java
@Transactional(propagation = Propagation.REQUIRED)
public void testMain(){
    A(a1);  //调用A入参a1
    testB();    //调用testB
}
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public void testB(){
    B(b1);  //调用B入参b1
    throw Exception;     //发生异常抛出
    B(b2);  //调用B入参b2
}
//b1插入成功，a1和b2失败。testMain声明required开启事务，testB抛出异常，所以a1插入回滚；testB声明not_supported，不开启事务，所以其抛出异常，b1 不用回滚 
```

- 【**NEVER**】: 始终不开启事务，如果当前存在事务，则报错；当前不存在事务也不会创建事务


```java
@Transactional(propagation = Propagation.REQUIRED)
public void testMain(){
    A(a1);  //调用A入参a1
    testB();    //调用testB
}
@Transactional(propagation = Propagation.NEVER)
public void testB(){
    B(b1);  //调用B入参b1
    B(b2);  //调用B入参b2
}
//都不成功；testMain开启了事务，testB不允许开启事务，所以直接报错，b1和b2都不会执行，然而a1被回滚
```

- 【**NESTED**】: 如果当前存在事务，则嵌套其中，如果不存在则创建一个事务。**和【REQUIRED_NEW】的区别：**REQUIRED_NEW是无论如何都自己开启一个事务，和其他事务没有关系；而nested是父事务开启一个嵌套事务（子事务），如果父事务回滚了，那么子事务也会回滚；**和【REQUIRED】的区别：**REQUIRED是关联操作都放在一个事务里，当前事务无论是否catch异常，所有操作都要回滚(内部事务连接中已经添加了回滚标记)；而nested是子事务抛出异常回滚了，父事务如果catch住了，那么父事务无需回滚


```java
// 例1
@Transactional(propagation = Propagation.REQUIRED)
public void testMain(){
    A(a1);  //调用A入参a1
    testB();    //调用testB
    throw Exception;     //发生异常抛出
}
@Transactional(propagation = Propagation.NESTED)
public void testB(){
    B(b1);  //调用B入参b1
    B(b2);  //调用B入参b2
}
//所有操作都回滚了。testMain声明的required，testB与其共享一个事务，所以testMain异常时，父子事务都要回滚

// 例2
@Transactional(propagation = Propagation.REQUIRED)
public void testMain(){
    A(a1);  //调用A入参a1
    try{
        testB();    //调用testB
    }catch（Exception e){

    }
    A(a2);
}
@Transactional(propagation = Propagation.NESTED)
public void testB(){
    B(b1);  //调用B入参b1
    throw Exception;     //发生异常抛出
    B(b2);  //调用B入参b2
}
//a1和a2插入成功。testB声明的nested，抛出异常，b1回滚，但是testMain中对testB抛出的异常catch了，不影响testMain的事务，所以a1和a2能插入成功 		
```

### 2 springMvc

**运行流程图：**

<img src="/Users/olic/work/图片库/springMVC的运行流程.png" alt="springMVC的运行流程" style="zoom:18%;" />

#### 2.1前端控制器(DispatcherServlet)

请求任务分派 

#### 2.2处理器映射器(HandlerMapping)

完成请求URL和Handler的映射匹配

**@RequestMapping：**用于建立请求url和处理请求方法之间的对应关系

#### 2.3处理器适配器(HandlerAdapter)

执行Handler处理器并返回执行结果ModelAndView对象。适配器执行目标方法过程中使用参数解析器进行参数解析以及使用返回值处理器处理返回值(其中可以写出去某些数据)，目标方法无论怎么写适配器处理方法将执行的信息封装成ModelAndView(包含模型和数据信息)返回，根据ModelAndView中的信息转发到具体页面，并且在请求域中取出ModelAndView模型数据

**@RequestParam：**把请求中指定名称的参数给控制器中的形参赋值

**@RequestBody：**主要用来接收前端传递给后端的json字符串、xml、自定义等数据类型。根据json字符串中的key来匹配对应实体类的属性，如果匹配一致且json中的该key对应的值，符合(或可转换为)实体类的对应属性的类型要求时，会调用实体类的setter方法将值赋给该属性

**@PathVariable：**用于绑定url中的占位符，应用于REST编码风格中

**@RequestHeader：**用于获取某一个请求头信息

**@CookieValue：**用于获取cookie信息

**@RequestPart：**文件上传解析文件数据

**@ModelAttribute：**在方法上时，方法会在控制器方法执行之前执行；在参数上时，获取指定数据给参数赋值

**@SessionAttributes：**存储值到seesion域中

**@ResponseBody：**根据找到的可以处理标有@ResponseBody注解的返回值处理器，再根据客户端和服务器端内容协商管理器协商的结果找出合适的消息转换器，把数据转换成协商后的数据类型(例如，将自定义对象数据写成json类型)，最后再写出去

**@Param：**指定命名

**传入原生API对象：**HttpServletRequest 请求对象，HttpServletResponse 响应对象，HttpSession 会话对象，InputStream 请求字节流，OutputStream 响应字节流，Reader 请求字符流，Writer 响应字符流，HttpEntity<String> 获取请求头和请求体信息，Exception等

**传入其他对象：**Map、ModelMap、Model。传入这三个引用本质上使用的都是他们的实现类BindingAwareModelMap，SpringMVC 会该对象中的数据放到request域中

**返回值可以写成ModelAndView：**ModelAndView既包含视图信息也包含模型数据，SpringMVC会该对象中的数据放到request域中

#### 2.4视图解析器(ViewResovler)

根据ModelAndView模型数据解析出最终显示数据的视图对象。视图对象进行渲染视图

**封装POJO：**SpringMVC会按请求参数名和 POJO 属性名进行自动匹配，自动为该对象填充属性值(通过调用request.getParameter()从map中取值)。支持级联属性。如：dept.deptId等

#### 2.5异常解析器(HandlerExceptionResolver)

springmvc无法处理的异常会直接被抛给tomcat服务器

- **ExceptionHandlerExceptionResolver：**找到使用@ExceptionHandler 注解的方法，然后使用该方法进行异常处理。如果在当前 Handler 中找不到使用@ExceptionHandle注解的方法则将去使用@ControllerAdvice注解标记的类中查找@ExceptionHandler标记的方法来处理异常

- **ResponseStatusExceptionResolver：**在异常及异常父类中找到 @ResponseStatus注解，然后使用这个注解的属性进行处理。处理自定义异常

- **DefaultHandlerExceptionResolver：**SpringMVC的一些特定的异常进行处理

#### 2.6文件解析器(MultipartResolver)

```java
/*
 * springmvc配置
*/
// 该组件id值必须为"multipartResolver" 
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
    <property name="maxUploadSize" value="#{1024*1024*20}"></property>
    <!-- 设置默认编码 -->
    <property name="defaultEncoding" value="utf-8"></property>
</bean>
  
/*
 * 表单
*/
<form action="fileUploadTest" method="post" enctype="multipart/form-data">
    图片1<input type="file" name="photoAlbum">
    图片2<input type="file" name="photoAlbum">
    用户名<input type="text" name="username">
    <input type="submit" value="提交">
</form>  

/**
 * 多文件上传，目标方法
*/
@RequestMapping(path="/fileUploadTest")
public String fileUpload(@RequestParam(value = "username") String username,
                         @RequestPart(value = "photoAlbum") MultipartFile[] file,
                         Model model){
    for(MultipartFile mt: file){
         if(!mt.isEmpty()){
             try {
                 mt.transferTo(new File("/Users/olic/test/"+mt.getOriginalFilename()));
                 model.addAttribute("msg", "上传成功");
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
    }
    return "success";
}
```

#### 2.7拦截器(HandlerInterceptor)

拦截器允许在运行目标方法之前进行一些拦截工作，或者目标方法之后进行一些处理。要想实现拦截器必须实现HandlerInterceptor接口

**拦截器的正常拦截流程：**

拦截器1的preHandle方法运行→→拦截器2的preHandle方法运行→→目标方法执行→→拦截器2的postHandle方法运行→→拦截器1的postHandle方法运行→→页面显示→→拦截器2的afterCompletion方法运行→→拦截器1的afterCompletion方法运行

**说明：**拦截器的执行顺序由配置文件顺序决定，放行了的拦截器(preHandle方法返回true)它的afterCompletion方法必执行 

```java
// 拦截器
public class FirstInterceptor implements HandlerInterceptor {
 
	/**
	 * 渲染视图之后被调用. 释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion");
	}
 
	/**
	 * 调用目标方法之后, 但渲染视图之前. 
	 * 可以对请求域中的属性或视图做出修改. 
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle");
	}
 
	/**
	 * 该方法在目标方法之前被调用.
	 * 若返回值为 true, 则继续调用后续的拦截器和目标方法. 
	 * 可以考虑做权限. 日志, 提前查询等. 
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("preHandle");
		return true;
	}
}

// springmvc配置文件
<mvc:interceptors>
<!--        <bean class="com.study.interceptor.secondInterceptor"></bean>-->
        <mvc:interceptor>
          	<!-- 只拦截/user/interceptorTest请求 -->
            <mvc:mapping path="/user/interceptorTest"/>
            <bean class="com.study.interceptor.FirstInterceptor"></bean>
        </mvc:interceptor>
    </mvc:interceptors>
```

**防止表单重复提交：**

```java
/**
 * 自定义注解防止表单重复提交
 * @author lsh
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit {

    /**
     * 重复提交返回的提示语
     * @return
     */
    String warnStr() default "";

    /**
     * 超时时间,默认10秒
     * @return
     */
    int timeout() default 10;

    /**
     * 超时时间单位,默认10秒
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * 重复提交判断类型（0：根据URL；1：根据登录人；）
     */
    RepeatSubmit.Type type() default RepeatSubmit.Type.LOGIN_USER;

    enum Type {
        URL(0), LOGIN_USER(1);
        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }
}

/**
 * 防止重复提交拦截器
 * @author lsh
 */
@Component
public abstract class RepeatSubmitInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            RepeatSubmit annotation = method.getAnnotation(RepeatSubmit.class);
            if (annotation != null) {
                if (this.isRepeatSubmit(request,annotation)) {
                    String warnStr = "不允许重复提交，请稍后再试";
                    if (null != annotation.warnStr() && !"".equals(annotation.warnStr())) {
                        warnStr = annotation.warnStr();
                    }
                    AjaxResult ajaxResult = AjaxResult.error(warnStr);
                    ServletUtils.renderString(response, JSONObject.toJSONString(ajaxResult));
                    return false;
                }
            }
            return true;
        } else {
            return super.preHandle(request, response, handler);
        }
    }

    /**
     * 验证是否重复提交由子类实现具体的防重复提交的规则
     *
     * @param request
     * @param annotation
     * @return
     * @throws Exception
     */
    public abstract boolean isRepeatSubmit(HttpServletRequest request, RepeatSubmit annotation);
}


/**
 * 判断请求url和数据是否和上一次相同
 * 如果和上次相同，则是重复提交表单。 有效时间为10秒内
 * @author lsh
 */
@Component
public class SameUrlDataInterceptor extends RepeatSubmitInterceptor {
    public final String REPEAT_PARAMS = "repeatParams";

    public final String REPEAT_TIME = "repeatTime";

    // 令牌自定义标识 Authorization
    @Value("${token.header}")  
    private String header;

    @Autowired
    private RedisService redisService;

    @SuppressWarnings("unchecked")
    @Override
    public boolean isRepeatSubmit(HttpServletRequest request, RepeatSubmit annotation) {
        String nowParams = "";
        if (request instanceof RepeatedlyRequestWrapper) {
            RepeatedlyRequestWrapper repeatedlyRequest = (RepeatedlyRequestWrapper) request;
            nowParams = HttpHelper.getBodyString(repeatedlyRequest);
        }

        // body参数为空，获取Parameter的数据
        if (StringUtils.isEmpty(nowParams)) {
            nowParams = JSONObject.toJSONString(request.getParameterMap());
        }
        Map<String, Object> nowDataMap = new HashMap<String, Object>();
        nowDataMap.put(REPEAT_PARAMS, nowParams);
        nowDataMap.put(REPEAT_TIME, System.currentTimeMillis());

        // 请求地址（作为存放cache的key值）
        String url = request.getRequestURI();
        // 唯一值（没有消息头则使用请求地址）
        String submitKey = request.getHeader(header);
        // 唯一标识（指定key + url）
        String cache_repeat_key = Constants.REPEAT_SUBMIT_KEY + url;
        // 参数hashCode
        int hashCode = nowParams.hashCode();
        if (annotation.type() == RepeatSubmit.Type.LOGIN_USER) {
            if (StringUtils.isNotBlank(submitKey)) {
                // 唯一标识（指定key + url + token + 参数hashCode）
                cache_repeat_key = cache_repeat_key + submitKey + hashCode;
            }
        }

        Map<String, Object> cacheMap = new HashMap<String, Object>();
        cacheMap.put(url, nowDataMap);
        boolean isSuccess = redisService.setCacheObjectIfAbsent(cache_repeat_key, cacheMap, annotation.timeout(), annotation.timeUnit());

        if (!isSuccess) {
            // 设置失败说明key已经存在,进一步判断请求参数是否相同
            Object sessionObj = redisService.getCacheObject(cache_repeat_key);
            if (sessionObj != null) {
                Map<String, Object> sessionMap = (Map<String, Object>) sessionObj;
                if (sessionMap.containsKey(url)) {
                    Map<String, Object> preDataMap = (Map<String, Object>) sessionMap.get(url);
                    if (compareParams(nowDataMap, preDataMap)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 判断参数是否相同
     */
    private boolean compareParams(Map<String, Object> nowMap, Map<String, Object> preMap) {
        String nowParams = (String) nowMap.get(REPEAT_PARAMS);
        String preParams = (String) preMap.get(REPEAT_PARAMS);
        return nowParams.equals(preParams);
    }
}
```

**分页类Page：**

```java
// 手写分页
public class Page<T>{

    /**
     * current request page
     */
    private int currentPage = 1;
    /**
     * current request page size
     */
    private int pageSize = 10;
    /**
     * the start offset of the request record, this needed to be calculate by the page and rows
     */
    private int offset = 0;
    /**
     * total pages of this request
     */
    private int totalPages = 0;
    /**
     * total records of this records
     */
    private int totalCount = 0;
    /**
     * thd searchByPage request obj which used for where condition
     */
    private T   obj;
    
    public Page() {
        
    }
    
    public Page(Page<?> page) {
        this.currentPage = page.currentPage;
        this.offset = page.getOffset();
        this.pageSize = page.getPageSize();
        this.totalCount = page.getTotalCount();
        this.totalPages = page.getTotalPages();
    }
    
    public Page(Page<?> page, T t) {
        this.currentPage = page.currentPage;
        this.offset = page.getOffset();
        this.pageSize = page.getPageSize();
        this.totalCount = page.getTotalCount();
        this.totalPages = page.getTotalPages();
        this.obj = t;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 根据总记录数、当前页及每页的大小，计算倒序显示记录的数据的偏移量，这样可以解决通过order by倒序显示数据增加数据库负担的问题<br>
     * 如满足要求的记录总数有405条，每页显示10条，则第一页取的数据就是从第396条开始取取到第406条数据，第二页从386条取到395条，其它依次类推。
     * @param totalCount
     * @return 计算好的page结果
     */
    public Page<T> reverseDisplayCalculate(int totalCount) {
        if (totalCount == 0) {
            return this;
        }
        this.totalCount = totalCount;
        /**
         * Calculate total pages
         */
        int mod = totalCount % pageSize;
        totalPages = totalCount / pageSize;
        if (mod > 0) {
            totalPages++;
        }
        // 如果当前页面大于了总页数，是查不出来数据的，如这里用户输入页码为4时，是不会有结果的，直接返回0记录
        if (currentPage > totalPages) {
            offset = 0;
            pageSize = 0;
            totalPages = 0;
            totalCount = 0;
            return this;
        }

        offset = totalCount - currentPage * pageSize;
        if (offset < 0) {
            offset = 0;
        }

        if (offset == 0) {
            pageSize = totalCount - ((currentPage - 1) * pageSize);
        }
        return this;
    }
    
    /**
     * 根据总记录数、当前页及每页的大小，按查询到的结果得到顺序分页显示结果
     * @param totalCount
     * @return
     */
    public Page<T> sequentialDisplayCalculate(int totalCount) {
        if (totalCount == 0) {
            return this;
        }
        this.totalCount = totalCount;
        /**
         * Calculate total pages
         */
        int mod = totalCount % pageSize;
        totalPages = totalCount / pageSize;
        if (mod > 0) {
            totalPages++;
        }
        // 如果当前页面大于了总页数，是查不出来数据的，如这里用户输入页码为4时，是不会有结果的，直接返回0记录
        if (currentPage > totalPages) {
            currentPage=totalPages;
            return this;
        }

        offset = (currentPage - 1) * pageSize;
        return this;
    }
}

// 利用PageHelper分页
1、PageHelper.startPage(pageNum, pageSize, orderBy)
2、获取数据总数，new PageInfo(list).getTotal()
```

### 3 mybatis

#### 3.1缓存

经常查询且不经常改变，数据的正确与否对结果影响不大

##### 3.1.1缓存和事务的关系

同一事务中，不管调用多少次mapper里的方法，最终都是用得同一个 sqlSession，即一个事务中使用的是同一个sqlSession；如果没有开启事务，调用一次mapper里的方法将会新建一个sqlSession来执行方法

##### 3.1.2一级缓存

当发起查询请求后，mybatis会将查询结果以map的形式将数据缓存一份到sqlSession中，下次发起同样的查询请求时，mybatis优先从sqlSession中获取数据。当发生数据修改、添加、删除或sqlSession的commit(),close(),clearCache()会清空sqlSession缓存

**缓存级别：**sqlSession级别

**查询时清除缓存：**`<select id="selectById"  flushCache="true" resultMap="userMap">sql</select>`，这样再查询是总是清除缓存，每次都执行查询操作

##### 3.1.3二级缓存

由同一个工厂创建的sqlsession共享其缓存。当发生数据修改、添加、删除或sqlSession的commit(),close(),clearCache()会清空sqlSession缓存

**开启二级缓存：**`<cache eviction="LRU" flushInterval="100000" readOnly="true" size="1024"/>`

**缓存级别：**sqlSessionFactory级别

##### 3.1.4缓存调用顺序

获取数据先去二级缓存获取，如果有得到，写入(更新)一级缓存；若没有得到，再去一级缓存，如果仍没有，再去数据库

**优先级：**二级缓存--->一级缓存--->数据库

#### 3.2懒(延迟)加载的原理

在真正使用数据时才发起查询，不用的时候不查询，即按需加载。使用CGLIB创建目标对象的代理对象，当调用目标方法时，进入拦截器方法，比如调a.getB().getName()，拦截器invoke()方法发现a.getB()是null值，那么就会单独发送事先保存好的查询关联B对象的sql，把B查询上来，然后调用a.setB(b)，于是a的对象b属性就有值了，接着完成a.getB().getName()方法的调用

**springboot配置mybatis懒加载：** 

`mybatis.configuration.lazy-loading-enabled=true`，`mybatis.configuration.aggressive-lazy-loading=false`

若个别需要关闭，可用 fetchType=“eager”在mapper文件中关闭

#### 3.3mybatis-plus配置

**日志输出：**`mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl`

**指定扫描xml：**`mybatis-plus.mapper-locations=classpath*:mapper/**/*Mapper.xml`

**Mapper文件扫描：**

添加@MapperScan(“xx”)注解以后，xx包下面的接口类，在编译之后都会生成相应的实现类

**主键回填：**添加完数据之后，操作对象内会封装刚刚添加的数据id

- `useGeneratedKeys="true" keyProperty="主键名"`
- `<selectKey keyProperty="主键名" order="AFTER" resultType="主键类型">  SELECT LAST_INSERT_ID() </selectKey>`

#### 3.4返回值

若方法返回值是list时，sql没查到数据则list的值为[]；若方法返回值是普通对象，sql没查到数据则对象值为null

**一对一或多对一查询：**使用association关联对象(**方式：**多表联合查询或者子查询)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd"> 
<mapper namespace="com.mybatis.entities.StudentMapper">
  
	 <!-- 测试 联合查询 -->
	 <!-- 由于返回值中有一个对象, 所以只用别名来映射不可用, 这里就使用一个自定义一个返回值类型来映射 -->
	 <select id="getStudent1" parameterType="int" resultMap="getStundet1Map">
	 	SELECT t.t_id, t.t_name, s.s_id, s.s_name, s.t_id 
	 	FROM teacher t, student s 
	 	WHERE t.`t_id`=s.`t_id` AND s.`s_id`=#{id}
	 </select>
	 <resultMap type="Student" id="getStundet1Map">
	         <!-- id: 这个表对应的主键 -->
	 	<id column="s_id" property="id"/>
	 	<!-- result: 一个一般的字段 -->
	 	<result column="s_name" property="name"/>
	 	<!-- 利用这个标签, 来映射一个对象, 其中jdbcTyp是返回值类型 -->
	 	<association property="teacher" javaType="Teacher">
	 		<id column="t_id" property="id"/>
	 		<result column="t_name" property="name"/>
	 	</association>
	 </resultMap>
	 
	 <!-- 测试 子查询 -->
	 <!-- 由于返回值中有一个对象, 所以只用别名来映射不可用, 这里就使用一个自定义一个返回值类型来映射 -->
	 <select id="getStudent2" parameterType="int" resultMap="getStudent2Map">
	 	SELECT s_id, s_name, t_id FROM student WHERE s_id=#{s_id}
	 </select>
	 <!-- 这里使用别名来映射实体类中的属性 -->
	 <select id="getTeacher" parameterType="int" resultType="Teacher">
	 	SELECT t_id id, t_name name FROM teacher WHERE t_id=#{t_id}
	 </select>
	 <resultMap type="Student" id="getStudent2Map">
	 	<id column="s_id" property="id"/>
	 	<result column="s_name" property="name"/>
	 	<!-- 
	 	    select: 执行 select id为 getTeacher 中的 sql.
	 	    column: 因为 select id为 getTeacher 中的 sql 语句需要一个t_id
	 	            所以这里传给它一个 t_id
	 	 -->
	 	<association property="teacher" column="t_id" select="getTeacher">
	 	</association>
	 </resultMap>
	 
</mapper>
```

**一对多查询：**使用collection关联集合对象(**方式：**多表联合查询或者子查询)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd"> 
<mapper namespace="com.mybatis.entities.BossMapper">
	 
	 <!-- 测试 联合查询 -->
	 <!-- 由于返回值中有一个对象, 所以只用别名来映射不可用, 这里就使用一个自定义一个返回值类型来映射 -->
	 <select id="getBoss1" parameterType="int" resultMap="getBoss1Map">
	 	SELECT * FROM boss b, manager m WHERE b.b_id=m.b_id AND b.b_id=#{b_id}
	 </select>
	 <!-- 
	 	id: 必须与上面的 resultMap="getStundet1Map" 对应起来
	 	type: 指定返回值类型, 可以理解为 select标签的resultType
	  -->
	 <resultMap type="Boss" id="getBoss1Map">
	 	<id column="b_id" property="id"/>
	 	<result column="b_name" property="name"/>
	 	<!-- ofType指定students集合中的对象类型 -->
	 	<collection property="mgrs" ofType="Manager">
	 		<id column="m_id" property="id"/>
	 		<result column="m_name" property="name"/>
	 	</collection>
	 </resultMap>
	 
	 <!-- 测试 子查询 -->
	 <!-- 由于返回值中有一个对象, 所以只用别名来映射不可用, 这里就使用一个自定义一个返回值类型来映射 -->
	 <select id="getBoss2" parameterType="int" resultMap="getBoss2Map">
	 	SELECT b_id, b_name FROM boss WHERE b_id=#{b_id}
	 </select>
	 <!-- 这里使用别名来映射实体类中的属性 -->
	 <select id="getManager" parameterType="int" resultType="Teacher">
	 	SELECT m_id id, m_name name FROM manager WHERE b_id=#{b_id}
	 </select>
	 <resultMap type="Boss" id="getBoss2Map">
	 	<id column="b_id" property="id"/>
	 	<result column="b_name" property="name"/>
	 	<collection property="mgrs" column="b_id" ofType="Manager" select="getManager"></collection>
	 </resultMap>
	 
</mapper>
```

**类型处理：**

```java
// mapper文件中添加该属性
typeHandler="com.central.admin.config.ArrayTypeHandler"

/**
 * 数组类型处理(List<T>)
 * @author omp
 */
public class ArrayTypeHandler<T> extends BaseTypeHandler<Object> {

    public static final String emptyFlg = "null";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, JSONObject.toJSONString(parameter));
    }

    @Override
    public List<T> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        if(value == null || value.isEmpty() || value.equals(emptyFlg)){
            return null;
        }
        return (List<T>)JSONObject.parseArray(value, Object.class);
    }

    @Override
    public List<T> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        if(value == null || value.isEmpty() || value.equals(emptyFlg)){
            return null;
        }
        return (List<T>)JSONObject.parseArray(rs.getString(columnIndex), Object.class);
    }

    @Override
    public List<T> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        if(value == null || value.isEmpty() || value.equals(emptyFlg)){
            return null;
        }
        return (List<T>)JSONObject.parseArray(value, Object.class);
    }
}

// mapper文件中添加该属性
typeHandler="com.central.admin.config.JsonTypeHandler"
/**
 * json类型处理
 * @author omp
 */
public class JsonTypeHandler<T> extends BaseTypeHandler<Object> {

    public static final String emptyFlg = "null";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, JSONObject.toJSONString(parameter));
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        if(value == null || value.isEmpty() || value.equals(emptyFlg)){
            return null;
        }
        return (T)JSONObject.parseObject(value, Object.class);
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        if(value == null || value.isEmpty() || value.equals(emptyFlg)){
            return null;
        }
        return (T)JSONObject.parseObject(rs.getString(columnIndex), Object.class);
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        if(value == null || value.isEmpty() || value.equals(emptyFlg)){
            return null;
        }
        return (T)JSONObject.parseObject(value, Object.class);
    }
}
```

