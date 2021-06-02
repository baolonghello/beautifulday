package com.eloancn.bt.service.biz;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ Description   :  TicketLock
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/5/14$ 1:01 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/5/14$ 1:01 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class TicketLock {


    private AtomicInteger serviceNum = new AtomicInteger();
    private AtomicInteger ticketNum = new AtomicInteger();
    private static final ThreadLocal<Integer> LOCAL = new ThreadLocal<Integer>();

    public void lock() {

        int myticket = ticketNum.getAndIncrement();
        LOCAL.set(myticket);
        while (myticket != serviceNum.get()) {

        }
    }

    public void unlock() {
        int myticket = LOCAL.get();
        serviceNum.compareAndSet(myticket, myticket + 1);
    }
}
