package it.caoxin.tdd.in.action.task6;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/13
 * 功能描述:
 * 修改日期:2020/5/13
 * 修改描述:
 */
public class Arguement {
    public Object value;
    private String lable;
    private String type;


    public Arguement(String param) {
        this.lable = param.split(":")[0];
        this.type = param.split(":")[1];
    }

    public String label() {
        return lable;
    }

    public String type() {
        return type;
    }

    public Object value() {
        return value;
    }
}
