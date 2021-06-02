package com.eloancn.bt.service.MoShi.VisitorPattern2;

/**
 * 员工-经理
 */
public class StaffManager extends Staff {


    public StaffManager(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // 工程师一年的代码数量
    public int getProducts() {
        return 200;
    }

}
