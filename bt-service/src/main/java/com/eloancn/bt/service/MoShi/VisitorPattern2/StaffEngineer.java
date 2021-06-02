package com.eloancn.bt.service.MoShi.VisitorPattern2;

/**
 * 员工-工程师
 */
public class StaffEngineer extends Staff {


    public StaffEngineer(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // 工程师一年的代码数量
    public int getCodeLines() {
        return 100;
    }

}
