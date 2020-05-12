package it.caoxin.tdd.in.action.task4;

import java.util.Objects;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/12
 * 功能描述:
 * 修改日期:2020/5/12
 * 修改描述:
 */
public class Pair {
    private String from;
    private String to;

    public Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return Objects.equals(from, pair.from) &&
                Objects.equals(to, pair.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
