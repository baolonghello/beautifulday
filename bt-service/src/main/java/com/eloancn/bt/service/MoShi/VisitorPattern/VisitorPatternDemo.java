package com.eloancn.bt.service.MoShi.VisitorPattern;

/**
 * @ Description   :  VisitorPatternDemo
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/4/14$ 9:17 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/4/14$ 9:17 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
