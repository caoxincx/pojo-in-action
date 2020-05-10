package it.caoxin.tdd.in.action.task1;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/8
 * 功能描述:
 * 修改日期:2020/5/8
 * 修改描述:
 */
public class Game {
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public String answer(int num) {
        if (isDividedBy3(num) && isDividedBy5(num)) return FIZZ+BUZZ;
        if (isDividedBy3( num)) return FIZZ;
        if (isDividedBy5( num)) return BUZZ;
        return num+"";
    }

    private boolean isDividedBy5(int i) {
        return i % 5 == 0;
    }

    private boolean isDividedBy3(int i) {
        return i % 3 == 0;
    }

    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 1; i < 100; i++) {
            System.out.println(game.answer(i));
        }
    }
}
