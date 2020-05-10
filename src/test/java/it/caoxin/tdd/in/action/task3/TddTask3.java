package it.caoxin.tdd.in.action.task3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/11
 * 功能描述:
 * 写一个程序，打印出从1到100的数字，
 * 将其中3的倍数替换成“Fizz”，
 * 5的倍数替换成“Buzz”。
 * 既能被3整除、又能被5整除的数则替换成“FizzBuzz”。
 * 修改日期:2020/5/11
 * 修改描述:
 */
public class TddTask3 {
    @Test
    public void should_game_can_test() {
        NumGame numGame = new NumGame(1);
        String str = numGame.answer();
        assertEquals("测试普通情况", "1", str);
    }

    @Test
    public void should_divided_by_3() {
        NumGame numGame1 = new NumGame(3);
        NumGame numGame2 = new NumGame(6);
        String answer1 = numGame1.answer();
        String answer2 = numGame2.answer();
        assertEquals("能被3整除","Fizz",answer1);
        assertEquals("能被3整除","Fizz",answer2);
    }

    @Test
    public void should_divided_by_5(){
        NumGame numGame1 = new NumGame(5);
        NumGame numGame2 = new NumGame(10);
        String answer1 = numGame1.answer();
        String answer2 = numGame2.answer();
        assertEquals("能被5整除","Buzz",answer1);
        assertEquals("能被5整除","Buzz",answer2);
    }
    @Test
    public void should_divided_by_3_and_5(){
        NumGame numGame1 = new NumGame(15);
        NumGame numGame2 = new NumGame(30);
        String answer1 = numGame1.answer();
        String answer2 = numGame2.answer();
        assertEquals("能被3和5整除","FizzBuzz",answer1);
        assertEquals("能被3和5整除","FizzBuzz",answer2);
    }
    @Test
    public void should_relate_to_3_5(){
        NumGame numGame1 = new NumGame(31);
        NumGame numGame2 = new NumGame(52);
        NumGame numGame3 = new NumGame(35);
        String answer1 = numGame1.answer();
        String answer2 = numGame2.answer();
        String answer3 = numGame3.answer();
        assertEquals("与3相关联","Fizz",answer1);
        assertEquals("与5相关联", "Buzz", answer2);
        assertEquals("与3和5相关联", "FizzBuzz", answer3);

    }


}

