package it.caoxin.tdd.in.action.task4;

import java.util.Objects;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/11
 * 功能描述:
 * 修改日期:2020/5/11
 * 修改描述:
 */
public class Money implements Expression{

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    protected  Expression times(int multiplier){
        return new Money(amount * multiplier,currency);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Money money = (Money) o;
        return amount == money.amount && currency.equals(money.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    public Expression plus(Expression addend) {
        return new Sum(this,addend);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate,to);
    }
}
