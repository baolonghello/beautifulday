package com.eloancn.bt.service.biz;

/**
 * @ Description   :  MyLock
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/5/14$ 9:33 上午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/5/14$ 9:33 上午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class MyLock2 {

    private boolean isLocked = false;
    Thread lockedBy = null;//临界资源被哪个线程锁住了
    int lockedCount = 0;

    public synchronized void lock() throws InterruptedException {
        //加锁时，先获取当前线程。（识别谁需要锁）
        Thread thread = Thread.currentThread();
        //当临界资源已被锁上，但当前请求锁的线程又不是之前锁上临界资源的线程。那么当前请求锁的线程需要等待。
        while (isLocked && lockedBy != thread) {
            //当请求线程请求不到锁的时候，就wait
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = thread;
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            lockedCount--;
            if (lockedCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }
}
