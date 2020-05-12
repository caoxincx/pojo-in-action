package it.caoxin.tdd.in.action.task4;

import java.util.HashMap;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/12
 * 功能描述:
 * 修改日期:2020/5/12
 * 修改描述:
 */
public class Bank {
    HashMap<Pair, Integer> rates = new HashMap<>();

    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public int rate(String from, String to) {
        if (from.equals(to)) {
            return 1;
        }
        return rates.get(new Pair(from, to));
    }
    public void addRate(String chf, String usd, int i) {
        rates.put(new Pair(chf, usd), i);
    }
}
