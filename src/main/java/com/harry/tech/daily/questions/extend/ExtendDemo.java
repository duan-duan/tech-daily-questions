package com.harry.tech.daily.questions.extend;

/**
 * @Description: 知识点
 * 继承 多态
 * 重载 和 重写
 * @author: wangruirui
 * @date: 2019/08/22
 */
public class ExtendDemo {
    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        a.show(b);

    }
}

class A {

    public void show(C obj){
        System.out.println("A and C");
    }

    public void show(A obj){
        System.out.println("A and A");
    }

    public void show(B obj){
        System.out.println("A and B");
    }

}

class B extends A{

    public void show(C obj){
        System.out.println("B and C");
    }


    public void show(A obj){
        System.out.println("B and A");
    }

}

class C extends B {
}
