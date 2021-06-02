package com.eloancn.bt.service;

import java.util.*;

/**
 * @ Description   :  Irr
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/4/25$ 4:01 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/4/25$ 4:01 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class IRRTest2 {
    /**迭代次数*/
    public static int LOOPNUM=1000;
    /**最小差异*/
    public static final double MINDIF=0.0001;

    public static final String IRR = "irr";

    public static final String REPAYMENTlIST = "repaymentList";

    /**
     * @desc 使用方法参考main方法
     * @param cashFlow  资金流
     * @return 收益率
     */
    private static double getIrr(List<Double> cashFlow){
        double flowOut=cashFlow.get(0);//投资金额
        double minValue=0d;
        double maxValue=1d;
        double testValue=0d;
        while(LOOPNUM>0){

            testValue=(minValue+maxValue)/2;
            System.out.println("testValue="+testValue);
            System.out.println("flowOut="+flowOut);
            double npv=NPV(cashFlow,testValue);
            System.out.println("npv="+npv);
            if(Math.abs(flowOut+npv)<MINDIF){
                break;
            }else if(Math.abs(flowOut)>npv){
                maxValue=testValue;
            }else{
                minValue=testValue;
            }
            LOOPNUM--;
        }
        return testValue;
    }

    private static double NPV(List<Double> flowInArr,double rate){
        double npv=0;
        for(int i=1;i<flowInArr.size();i++){
            npv+=flowInArr.get(i)/Math.pow(1+rate, i);
        }
        return npv;
    }



    public static void main(String[] args) {

        List<Double> repaymentList=new ArrayList<Double>();

        repaymentList.add(375.00d);
        repaymentList.add(689.00d);
        repaymentList.add(942.00d);
        repaymentList.add(1133.00d);
        repaymentList.add(1261.00d);
        repaymentList.add(1326.00d);

        System.out.println("原始还款计划："+repaymentList);
        System.out.println("原始年化IRR:"+IRRTest2.getIrr(30000d,0d,repaymentList));

        //Map<String,Object> map = getMap(sumAccount,shouQi,repaymentList);
        //System.out.println("改良后的IRR&还款计划==>"+map.get(IRR) +":" + map.get(REPAYMENTlIST));
    }

    /**
     * 计算年化IRR
     * @param sumAccount 放款金额
     * @param shouQi 首期一次性费用
     * @param repyaymentList 按月敏期费用（息+费+...）
     * @return
     */
    public static Double  getIrr(Double sumAccount,Double shouQi,List<Double> repyaymentList){
        List<Double> oldList = new ArrayList<Double>();
        oldList.add(shouQi-sumAccount);
        oldList.addAll(repyaymentList);
        Double realIrr = IRRTest2.getIrr(oldList)*12;
        return realIrr;
    }

    /**
     * 每期减少1%，重新生成并返回还款计划
     * @param sumAccount
     * @param shouQi
     * @param repyaymentList
     * @return
     */
    public static List<Double> getNewRepaymentList(Double sumAccount,Double shouQi,List<Double> repyaymentList){
        List<Double> newList = new ArrayList<Double>();
        Iterator<Double> it = repyaymentList.iterator();
        while(it.hasNext()){
            newList.add(it.next()*0.99);
        }
        return newList;
    }

    /**
     * 重新生成不高于年化0.15的还款计划
     * @param sumAccount
     * @param shouQi
     * @param repyaymentList
     * @return Map 两个元素：irr,repaymentList，分别为年化IRR和还款计划
     */
    public static Map<String,Object> getMap(Double sumAccount,Double shouQi,List<Double> repyaymentList){
        Map<String,Object> map = new HashMap<>();

        Double realIrr = getIrr(sumAccount, shouQi, repyaymentList);

        if(realIrr <= 0.15){
            System.out.println("原始IRR不超，直接返回。");
            map.put(IRR,realIrr);
            map.put(REPAYMENTlIST,repyaymentList);
            return map;
        }
        List<Double> finalList = new ArrayList<Double>();
        finalList.addAll(repyaymentList);
        while(realIrr > 0.15){
            finalList = getNewRepaymentList(sumAccount, shouQi, finalList);
            realIrr = getIrr(sumAccount, shouQi, finalList);
            System.out.println("重新计算后的年化IRR===>"+realIrr);
        }

        map.put(IRR,realIrr);
        map.put(REPAYMENTlIST,finalList);
        return map;
    }
}
