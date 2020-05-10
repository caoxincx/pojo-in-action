package it.caoxin.tdd.in.action.task1;


import org.junit.Before;
import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/8
 * 功能描述:
 * 打印出从1到100的数字
 * 将其中3的倍数替换成“Fizz”
 * 5的倍数替换成“Buzz”
 * 既能被3整除、又能被5整除的数则替换成“FizzBuzz”
 * 修改日期:2020/5/8
 * 修改描述:
 */
public class TddTask1 {
    private Game game;
    @Before
    public void setup() {
        game = new Game();
    }
    @Test
    public void testGame() {
        String str = game.answer(1);
        assertEquals("编译通过","1",str);
    }

    @Test
    public void can_individed_by_3() {
        String str = game.answer(3);
        String str1 = game.answer(6);
        String str2 = game.answer(12);
        assertEquals("能被3整除", "Fizz", str);
        assertEquals("能被3整除", "Fizz", str1);
        assertEquals("能被3整除", "Fizz", str2);

    }

    @Test
    public void can_individed_by_5() {
        String str1 = game.answer(5);
        String str2 =game.answer(10);

        assertEquals("能被5整除","Buzz",str1);
        assertEquals("能被5整除","Buzz",str2);
    }

    @Test
    public void can_individed_by_3_and_5() {
        String str1 =game.answer(15);
        String str2 =game.answer(45);

        assertEquals("能被3和5整除","FizzBuzz",str1);
        assertEquals("能被3和5整除","FizzBuzz",str2);

    }
}
