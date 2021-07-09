package com.demo.reactor.reactor8;

import java.util.Observable;

/**
 * @ Description   :  ObserverDemo
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/7/9$ 上午9:45$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/7/9$ 上午9:45$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class ObserverDemo extends Observable {
    public static void main(String[] args) {
        ObserverDemo observer = new ObserverDemo();
        //观察者
        observer.addObserver((o,arg)->{
            System.out.println("...发生变化");
        });
        observer.addObserver((o,arg)->{
            System.out.println("...手动被观察者通知，准备改变");
        });
        observer.setChanged();//数据变化
        observer.notifyObservers();//通知
    }
}
