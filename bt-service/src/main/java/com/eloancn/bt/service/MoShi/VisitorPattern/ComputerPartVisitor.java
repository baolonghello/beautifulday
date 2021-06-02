package com.eloancn.bt.service.MoShi.VisitorPattern;

/**
 * 访问者的接口
 */
public interface ComputerPartVisitor {

    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
}
