package it.caoxin.tdd.in.action.task5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/12
 * 功能描述:
 * 修改日期:2020/5/12
 * 修改描述:
 */
public class ArgsTest {
    @Test
    public void a_to_do_list() {
        /**
         *-l -p 8080 -d /usr/logs
         * 那么对应的参数结构应该规定3个标记：l、p、d
         * -l（logging，是否记录日志）标记没有与之对应的值，
         * 这是一个布尔型的标记，如果传入了“-l”就为True，否则为False。
         *
         * -p（port，端口号）标记的值是整数型。
         *
         * -d（directory，目录）标记的值是字符串型。
         */
    }

    @Test
    public void should_get_args(){
        Schema schema = new Schema();
        Assert.assertEquals("Boolean",schema.getArg("-l"));
        Assert.assertEquals("Integer",schema.getArg("-p"));
        Assert.assertEquals("String",schema.getArg("-d"));
    }

    @Test
    public void should_get_explain_the_args() {
        final String command = "-l -p 8080 -d /usr/logs";
        Schema schema = new Schema();
        Map<String,Object> map = schema.explain(command);
        Assert.assertEquals(Boolean.TRUE,map.get("-l"));
        Assert.assertEquals(8080,map.get("-p"));
        Assert.assertEquals("/usr/logs",map.get("-d"));
    }


}
