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
public class Sum implements Expression{
    Expression augend;
    Expression addend;

    public Sum(Expression aguend, Expression addend) {
        this.augend = aguend;
        this.addend = addend;
    }

    @Override
    public Money reduce(Bank bank,String to) {
        int amount = augend.reduce(bank,to).amount + addend.reduce(bank,to).amount;
        return new Money(amount,to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this,addend);
    }
}
