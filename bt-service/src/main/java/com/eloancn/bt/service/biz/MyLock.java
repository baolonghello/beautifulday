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
public class MyLock {

    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}
