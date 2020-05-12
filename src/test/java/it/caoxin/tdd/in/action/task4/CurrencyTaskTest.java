package it.caoxin.tdd.in.action.task4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/11
 * 功能描述:
 * 修改日期:2020/5/11
 * 修改描述:
 */
public class CurrencyTaskTest {
    @Test
    public void should_dollar_mul() {
        Money five = Money.dollar(5);
        assertEquals("乘法测试", Money.dollar(10), five.times(2));
        assertEquals("乘法测试", Money.dollar(15), five.times(3));
    }

    @Test
    public void should_equals_5_equals_5() {
        assertEquals("测试相等", Money.dollar(5), Money.dollar(5));
    }

    @Test
    public void should_franc_mul() {
        Money five = new Money(5, "CHF");
        assertEquals("乘法测试", Money.franc(10), five.times(2));
        assertEquals("乘法测试", Money.franc(15), five.times(3));
    }

    @Test
    public void should_dollar_equals_franc() {
        assertFalse("美元与法郎相等", Money.dollar(5).equals(Money.franc(5)));
    }

    @Test
    public void should_dollar_and_franc_has_currency() {
        assertEquals("USD是美元的货币", "USD", Money.dollar(5).getCurrency());
        assertEquals("CHF是法郎的货币", "CHF", Money.franc(5).getCurrency());
    }

    @Test
    public void should_test_different_class_equality() {
        assertTrue("测试两个类不相等", new Money(10, "CHF").equals(new Money(10, "CHF")));
        assertTrue("测试两个类不相等", new Money(10, "USD").equals(new Money(10, "USD")));
    }

    @Test
    public void should_simple_add() {
        Money five = Money.dollar(5);
        Expression result = five.plus(Money.dollar(5));
        Bank bank = new Bank();
        Money reduce = bank.reduce(result, "USD");
        assertEquals("普通加分", Money.dollar(10), reduce);
    }

    @Test
    public void should_add_return_sum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals("被加数", five, sum.augend);
        assertEquals("加数", five, sum.addend);
    }

    @Test
    public void should_reduce_sum() {
        Sum sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals("是否相等", Dollar.dollar(7), result);
    }

    @Test
    public void should_test_reduce_money() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals("是否相等", Money.dollar(1), result);
    }

    @Test
    public void should_reduce_money_different_currency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals("两法郎变成一美元", Money.dollar(1), result);
    }

    @Test
    public void should_test_indentity_rate() {
        assertEquals("测试两个汇率相等", 1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void should_Mixed_add() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFranc = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFranc), "USD");
        assertEquals("最终测试混合假发", Money.dollar(10), result);
    }

    @Test
    public void should_test_sum_plus_money() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFranc = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFranc).plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");
        assertEquals("最终测试混合假发", Money.dollar(15), result);

    }


}
