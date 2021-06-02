package com.eloancn.bt.service.MoShi.VisitorPattern2;

import com.eloancn.bt.service.IRRTest;

import java.math.BigDecimal;

/**
 * 客户端代码
 */
public class ClientMain {




    public static void main(String[] args) {



        // 构建报表
        BusinessReport report = new BusinessReport();
        System.out.println("=========== CEO看报表 ===========");
        report.showReport(new VisitorCEO());
        System.out.println("=========== CTO看报表 ===========");
        report.showReport(new VisitorCTO());
    }
}
