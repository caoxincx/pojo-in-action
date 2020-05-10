package it.caoxin.tdd.in.action.task2;

import org.junit.Before;
import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/9
 * 功能描述:
 * 写一个程序，打印出从1到100的数字，
 * 将其中3的倍数替换成“Fizz”，
 * 5的倍数替换成“Buzz”。
 * 既能被3整除、又能被5整除的数则替换成“FizzBuzz”。
 * 修改日期:2020/5/9
 * 修改描述:
 */
public class TddTask2 {
    private GameTask2 game;

    @Before
    public void setup() {
        game = new GameTask2(1);
    }

    @Test
    public void answer() {
        String str =  game.answer();
        assertEquals("测试通过","1",str);
    }

    @Test
    public void can_divied_by_3() {
        String str1 = new GameTask2(3).answer();
        String str2 = new GameTask2(6).answer();
        assertEquals("能被3整除","Fizz",str1);
        assertEquals("能被3整除","Fizz",str2);
    }

    @Test
    public void can_divied_by_5() {
        String str1 = new GameTask2(5).answer();
        String str2 = new GameTask2(10).answer();
        assertEquals("能被5整除", "Buzz", str1);
        assertEquals("能被5整除", "Buzz", str2);
    }

    @Test
    public void can_divied_by_3_and_5() {
        String str1 =new GameTask2(15).answer();
        String str2 =new GameTask2(45).answer();
        assertEquals("能被3和5整除","FizzBuzz",str1);
        assertEquals("能被3和5整除","FizzBuzz",str2);
    }

    @Test
    public void can_relate_to_3_or_5() {
        String str1 =new GameTask2(13).answer();
        String str2 =new GameTask2(53).answer();
        String str3 =new GameTask2(25).answer();
        assertEquals("与3有关","Fizz",str1);
        assertEquals("5有关","Buzz",str3);
        assertEquals("与3与5有关","FizzBuzz",str2);
    }
}
