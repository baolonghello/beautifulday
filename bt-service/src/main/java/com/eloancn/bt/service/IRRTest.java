package com.eloancn.bt.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Description   :  Irr
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/4/25$ 4:01 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/4/25$ 4:01 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class IRRTest {
    /**
     * 迭代次数
     */
    public static int LOOPNUM = 1000;
    /**
     * 最小差异
     */
    public static final double MINDIF = 0.00000001;


    /**
     * @param cashFlow 资金流
     * @return 收益率
     * @desc 使用方法参考main方法
     */
    public static double getIrr(List<Double> cashFlow) {
        double flowOut = cashFlow.get(0);
        double minValue = 0d;
        double maxValue = 1d;
        double testValue = 0d;
        while (LOOPNUM > 0) {
            testValue = (minValue + maxValue) / 2;
            double npv = NPV(cashFlow, testValue);
            if (Math.abs(flowOut + npv) < MINDIF) {
                break;
            } else if (Math.abs(flowOut) > npv) {
                maxValue = testValue;
            } else {
                minValue = testValue;
            }
            LOOPNUM--;
        }
        return testValue;
    }

    public static double NPV(List<Double> flowInArr, double rate) {
        double npv = 0;
        for (int i = 1; i < flowInArr.size(); i++) {
            npv += flowInArr.get(i) / Math.pow(1 + rate, i);
        }
        return npv;
    }

    public static void main(String[] args) {

        List<Double> flowInArr = new ArrayList<>();
        flowInArr.add(-30000d);
        flowInArr.add(375d);
        flowInArr.add(689.42d);
        flowInArr.add(942.51d);
        flowInArr.add(1133.5d);
        flowInArr.add(1261.62d);
        flowInArr.add(1326.08d);


        System.out.println(IRRTest.getIrr(flowInArr) * 12);
    }
}
