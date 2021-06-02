package com.eloancn.bt.service.biz;

import java.util.HashMap;

/**
 * @ Description   :  TreadLocalTest
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/3/17$ 8:20 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/3/17$ 8:20 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class ThreadLocalTest {


    //HashMap-线程不安全
    static HashMap<String, Object> baseMap = new HashMap();

    static void printMap(String str) {
        System.out.println(str + ":" + baseMap.get("key"));
    }

    //ThreadLocal-线程安全
    static ThreadLocal<String> baseThreadLocal = new ThreadLocal<String>();

    static void printThreadLocal(String str) {
        System.out.println(str + ":" + baseThreadLocal.get());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new MyThread2(i));
            t.start();
        }
    }
}

class MyThread1 implements Runnable {

    int i = 0;

    MyThread1(int a) {
        i = a;
    }

    @Override
    public void run() {
        ThreadLocalTest.baseMap.put("key", "thread" + i);
        try {
            long sleepTime = 1000;
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadLocalTest.printMap("thread" + i);
    }
}

class MyThread2 implements Runnable {

    int i = 0;

    MyThread2(int a) {
        i = a;
    }

    @Override
    public void run() {
        ThreadLocalTest.baseThreadLocal.set("thread" + i);

        try {
            long sleepTime = 1000;
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadLocalTest.printThreadLocal("thread" + i);
    }
}
