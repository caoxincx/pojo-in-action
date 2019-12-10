package it.caoxin.pojo.in.action.chapter03_use_domain_model.domain;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/12/7
 * 功能描述:
 * 修改日期:2019/12/7
 * 修改描述:
 */
public class Restaurant {
    private String name;
    private String type;

    public Restaurant(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
