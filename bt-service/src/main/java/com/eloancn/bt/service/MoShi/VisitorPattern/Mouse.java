package com.eloancn.bt.service.MoShi.VisitorPattern;

/**
 * @ Description   :  Keyboard
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/4/14$ 9:05 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/4/14$ 9:05 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
