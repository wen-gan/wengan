package com.wengan.codeblock_;

public class CodeBlockDetail01 {
    public static void main(String[] args) {
        System.out.println(DD.n1);//8888, 静态模块块一定会执行
    }
}

class DD {
    public static int n1 = 8888;//静态属性
    //静态代码块
    static {
        System.out.println("DD 的静态代码1被执行...");//
    }
    {
        System.out.println("DD 的普通代码块...");
    }
}

class Animal {
    //静态代码块
    static {
        System.out.println("Animal 的静态代码1被执行...");//
    }
}

class Cat extends Animal {

    public static  int n1 = 999;//静态属性

    //静态代码块
    static {
        System.out.println("Cat 的静态代码1被执行...");//
    }
}

class BB {
    //静态代码块
    static {
        System.out.println("BB 的静态代码1被执行...");//1
    }
}

class AA extends BB {


    //静态代码块
    static {
        System.out.println("AA 的静态代码1被执行...");//2
    }
}
