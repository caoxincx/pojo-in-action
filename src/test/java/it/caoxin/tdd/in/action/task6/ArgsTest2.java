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
public class ArgsTest2 {
    @Test
    public void should_a_to_do_list() {
        /**
         *-l -p 8080 -d /usr/logs
         * 那么对应的参数结构应该规定3个标记：l、p、d
         * -l（logging，是否记录日志）标记没有与之对应的值，
         * 这是一个布尔型的标记，如果传入了“-l”就为True，否则为False。
         *
         * -p（port，端口号）标记的值是整数型。
         *
         * -d（directory，目录）标记的值是字符串型。
         *
         * 简单的是现在整个流程
         * 需求分析
         * 1.首先将需要解析的格式解析成schema
         * 2.输入需要解析的字符窜数组进行解析
         * 3.获取对应一个参数进行验证
         */
    }

    @Test
    public void should_get_text_parse_to_Schema() {
        // 将需要解析的参数解析成schema
        String schemaText = "l:Boolean p:Integer d:String";
        String[] params = {"-l","true","-p", "8080", "-d", "/usr/logs"};
        Schema1 schema = new Schema1(schemaText);
        schema.parse(params);
        //assertEquals("测试返回的Arguemengts", 3, arguements.size());

        assertEquals("测试返回值",true,schema.isOf("l"));
        assertEquals("测试返回值",8080,schema.isOf("p"));
        assertEquals("测试返回值","/usr/logs",schema.isOf("d"));

    }
    @Test
    public void should_string_parse_to_schema(){
        String schemaText = "l:Boolean p:Integer d:String";
        Schema1 schema = new Schema1(schemaText);
        assertEquals("测试解析的Schema参数是否是3个",3,schema.size());
    }

    @Test
    public void should_parse_string(){
        String schemaText = "l:Boolean p:Integer d:String";
        Schema1 schema = new Schema1(schemaText);
        String[] params = {"-d", "/usr/logs"};
        schema.parse(params);
        assertEquals("测试返回String的情况","/usr/logs",schema.isOf("d"));
    }
    



}
