package com.harry.tech.daily.questions.extend;

/**
 * @Description: 知识点
 * 继承 多态
 * 重载 和 重写
 * 方法的重写(Overriding)和重载(Overloading)是java多态性的不同表现，重写是父类与子类之间多态性的一种表现，重载可以理解成多态的具体表现形式。
 * (1)方法重载是一个类中定义了多个方法名相同,而他们的参数的数量不同或数量相同而类型和次序不同,则称为方法的重载(Overloading)。
 * (2)方法重写是在子类存在方法与父类的方法的名字相同,而且参数的个数与类型一样,返回值也一样的方法,就称为重写(Overriding)。
 * (3)方法重载是一个类的多态性表现,而方法重写是子类与父类的一种多态性表现
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
