package com.harry.tech.daily.questions.string;


/**
 * @Description: 知识点
 *
 * 字符串是一个比较特殊的对象。
 * 字符串之所以特殊，是因为java会在内容中为String类型的对像开辟一个空间，我们叫他串池!
 * 字符串对象的创建之后会被放入到串池中。
 * 串池有一个特点，就是对于相同对象，池中只存储一份。
 * 那么串池把神马样的String看做是相同的String呢。请看：
 * String a="abc";和String b="abc" 对于这样的类型的声明方式（不是new出来的）串池把他们看做一个对象，所以池中只存储一分，只是有a 和b 两个引用罢了！
 * 对于String只要用new关键字new出来的string，都是单独的一个对象。
 * 而“==”号，他是用来比较对象的内存地址，所以只要用==号来比较string，只要不是自己比自己，那肯定是false。
 * 而String中的equls方法已经做了处理，他是比较内容，所以要比较string的内容的时候而不是地址的时候，那就用它吧！
 *
 *
 * @author: wangruirui
 * @date: 2019/08/22
 */
public class StringDemo {

    private String lock1 = "lock";
    private String lock2 = "lock";

    private int size = 0;

    public void print(){
        System.out.println();
        System.out.println(lock1==lock2);
        System.out.println(size);
    }

    void increment1(){
        synchronized(lock1){
            size++;
            System.out.println(Thread.currentThread().getName() + " start to" + " send " + size);
        }
    }

    void increment2(){
        synchronized(lock2){
            size++;
            System.out.println(Thread.currentThread().getName() + " start to" + " send " + size);
        }
    }

    public static void main(String[] args) {
        StringDemo demo = new StringDemo();

        Thread thread = new java.lang.Thread(()->{
            for (int i = 0; i < 100; i++) {
                demo.increment1();
            }
        },"interrupDemo");

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                demo.increment2();
            }
        },"222");

        t1.start();

        thread.start();

        try {
            t1.join();
            thread.join();
            demo.print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
