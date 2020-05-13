package it.caoxin.tdd.in.action.task6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/13
 * 功能描述:
 * 修改日期:2020/5/13
 * 修改描述:
 */
public class ArguementTest {

    @Test
    public void should_string_parse_to_Arguement() {
        String str = "p:Boolean";
        Arguement arguement = new Arguement(str);
        assertEquals("测试lable","p",arguement.label());
        assertEquals("测试type","Boolean",arguement.type());

    }


}