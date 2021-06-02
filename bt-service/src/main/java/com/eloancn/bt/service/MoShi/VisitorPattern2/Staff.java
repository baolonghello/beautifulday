package com.eloancn.bt.service.MoShi.VisitorPattern2;

/**
 * 员工基础类
 */
public abstract class Staff {

    public String name;
    public int kpi;

    public Staff(String name) {
        this.name = name;
        this.kpi = 80;
    }

    // 核心方法，接受Visitor的访问
    public abstract void accept(Visitor visitor);

}
