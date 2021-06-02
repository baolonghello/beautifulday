package com.eloancn.bt.service.biz;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ Description   :  LockTest
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/4/1$ 4:46 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/4/1$ 4:46 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class LockTest2 {


    public static void main(String[] args) throws InterruptedException {
        //设置当前为true公平锁
        //final MyService1 myService = new MyService1(true);
        //设置当前为false非公平锁
        final MyService1 myService = new MyService1(false);
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("线程名："+Thread.currentThread().getName()+"运行了");
                myService.serviceMethod();
            }
        };
        Thread[] threads = new Thread[10];
        for(int i = 0;i < 10; i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
            //Thread.sleep(100);
        }
        for(int i = 0;i < 10; i++) {
            threads[i].start();
            //Thread.sleep(100);
        }

    }


}
/*
 * 非公平锁
 * */
class MyService1{
    private ReentrantLock lock;
    public MyService1(boolean isFair) {
        super();
        lock = new ReentrantLock(isFair);
    }
    public void serviceMethod() {
        try {
            lock.lock();
            //Thread.sleep(1000);
            System.out.println("线程名："+Thread.currentThread().getName()+"获得锁定");
        }  finally {
            lock.unlock();
        }
    }


}