package it.caoxin.tdd.in.action.task4;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/12
 * 功能描述:
 * 修改日期:2020/5/12
 * 修改描述:
 */
public interface Expression {
    Money reduce(Bank bank, String to);

    Expression plus(Expression addend);
}
