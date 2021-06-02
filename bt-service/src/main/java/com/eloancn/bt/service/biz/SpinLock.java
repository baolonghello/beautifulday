package com.eloancn.bt.service.biz;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @ Description   :  SpinLock
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/5/14$ 1:40 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/5/14$ 1:40 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class SpinLock {
    private AtomicReference<Thread> sign = new AtomicReference<>();

    public void lock() {
        Thread current = Thread.currentThread();
        while (!sign.compareAndSet(null, current)) {
        }
        
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
    }
}
