package com.eloancn.bt.service.MoShi.VisitorPattern2;

/**
 * CEO访问者
 */
public class VisitorCEO implements Visitor {
    @Override
    public void visit(StaffEngineer engineer) {
        System.out.println("工程师: " + engineer.name + ", KPI: " + engineer.kpi);
    }

    @Override
    public void visit(StaffManager manager) {
        System.out.println("经理: " + manager.name + ", KPI: " + manager.kpi);
    }
}
