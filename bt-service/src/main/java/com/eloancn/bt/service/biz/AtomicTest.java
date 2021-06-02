package com.eloancn.bt.service.biz;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ Description   :  AutoMicTest
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/4/7$ 9:14 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/4/7$ 9:14 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public  class  AtomicTest {

    public static volatile int count = 0;

    public static void increase() {
        count++;
    }

    public static void main(String[] args) {

        Thread[] threads = new Thread[200];
        for (int i = 0; i < 200; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println("并发结果count=" + count);
    }
}
