package com.eloancn.bt.service.MoShi.VisitorPattern2;

/**
 * 访问者
 */
public interface Visitor {
    // 访问工程师类型
    void visit(StaffEngineer engineer);

    // 访问经理类型
    void visit(StaffManager manager);
}
