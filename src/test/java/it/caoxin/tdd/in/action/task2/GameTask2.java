package it.caoxin.tdd.in.action.task2;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/9
 * 功能描述:
 * 修改日期:2020/5/9
 * 修改描述:
 */
public class GameTask2 {
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    private int rawNumber;

    public GameTask2(int rawNumber) {
        this.rawNumber = rawNumber;
    }

    public String answer() {
        if(isRelateTo(3) && isRelateTo(5)) return FIZZ+BUZZ;
        if (isRelateTo(3)) return FIZZ;
        if (isRelateTo(5)) return BUZZ;
        return String.valueOf(rawNumber);
    }

    private boolean isRelateTo(int i) {
        return rawNumber % i == 0 || String.valueOf(rawNumber).contains(String.valueOf(i));
    }

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println(new GameTask2(i).answer());
        }
    }
}
