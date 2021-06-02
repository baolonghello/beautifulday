package com.eloancn.bt.service.MoShi.VisitorPattern2;

import java.util.LinkedList;
import java.util.List;

/**
 * 业务报表
 */
public class BusinessReport {
    private List<Staff> mStaffs = new LinkedList<>();

    public BusinessReport() {
        mStaffs.add(new StaffManager("经理-A"));
        mStaffs.add(new StaffManager("经理-B"));
        mStaffs.add(new StaffEngineer("工程师-A"));
        mStaffs.add(new StaffEngineer("工程师-B"));
        mStaffs.add(new StaffEngineer("工程师-C"));
        mStaffs.add(new StaffEngineer("工程师-D"));
    }
    /**
     * 为访问者展示报表
     * @param visitor 公司高层，如CEO、CTO
     */
    public void showReport(Visitor visitor) {
        for (Staff staff : mStaffs) {
            staff.accept(visitor);
        }
    }

}
