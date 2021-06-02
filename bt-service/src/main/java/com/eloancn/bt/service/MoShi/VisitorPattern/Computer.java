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
public class Computer implements ComputerPart {
    ComputerPart[] parts;

    public Computer(){
        parts = new ComputerPart[] {new Mouse(), new Keyboard()};
    }


    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
