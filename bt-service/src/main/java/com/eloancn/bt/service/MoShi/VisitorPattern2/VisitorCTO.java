package com.eloancn.bt.service.MoShi.VisitorPattern2;

/**
 * CTO访问者
 */
public class VisitorCTO implements Visitor {
    @Override
    public void visit(StaffEngineer engineer) {
        System.out.println("工程师: " + engineer.name + ", 代码行数: " + engineer.getCodeLines());
    }

    @Override
    public void visit(StaffManager manager) {
        System.out.println("经理: " + manager.name+ ", 新产品数量: " + manager.getProducts());
    }
}
