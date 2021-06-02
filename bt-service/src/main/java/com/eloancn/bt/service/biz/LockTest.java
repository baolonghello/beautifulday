package com.eloancn.bt.service.biz;

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
public class LockTest {


    public static void main(String[] args) {
        MyService myService = new MyService();
        Thread1 thread1 = new Thread1(myService);
        Thread2 thread2 = new Thread2(myService);
        thread1.start();
        thread2.start();

    }


}
/*
 * 读写/写读互斥,
 * */
class MyService{
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void read() {
        try {
            //读锁
            lock.readLock().lock();
            System.out.println("线程名: "+Thread.currentThread().getName()+"获取读锁，获得时间:"+System.currentTimeMillis() );
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //释放读锁
            lock.readLock().unlock();
        }
    }
    public void write() {
        try {
            //写锁
            lock.writeLock().lock();
            System.out.println("线程名: "+Thread.currentThread().getName()+"获取写锁，获得时间："+System.currentTimeMillis() );
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //释放写锁
            lock.writeLock().unlock();
        }
    }
}
//线程1
class Thread1 extends Thread{
    private MyService myService;
    public Thread1(MyService myService) {
        super();
        this.myService = myService;
    }
    public void run() {
        myService.read();
    }
}
//线程2
class Thread2 extends Thread{
    private MyService myService;
    public Thread2(MyService myService) {
        super();
        this.myService = myService;
    }
    public void run() {
        myService.write();
    }
}
