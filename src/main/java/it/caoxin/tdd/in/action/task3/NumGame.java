package it.caoxin.tdd.in.action.task3;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/11
 * 功能描述:
 * 修改日期:2020/5/11
 * 修改描述:
 */
public class NumGame {

    private int num;

    public NumGame(int num) {
        this.num = num;
    }

    public String answer() {
        if (relateTo(3) && relateTo(5)) {
            return "FizzBuzz";
        }
        if (relateTo(3)) {
            return "Fizz";
        }
        if (relateTo(5)) {
            return "Buzz";
        }
        return String.valueOf(num);
    }

    private boolean relateTo(int i) {
        return num % i == 0 || String.valueOf(num).contains(String.valueOf(i));
    }
}
