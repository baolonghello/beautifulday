package com.eloancn.bt.service.biz;


/**
 * @ Description   :  LockAgin
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/5/14$ 9:20 上午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/5/14$ 9:20 上午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class LockAgin {

    MyLock lock = new MyLock();
    public void methodA() throws InterruptedException {
        lock.lock();
        // ...........;
        methodB();
        //...........;
        lock.unlock();
    }
    public void methodB() throws InterruptedException {
        lock.lock();
        //...........;
        lock.unlock();
    }
}
