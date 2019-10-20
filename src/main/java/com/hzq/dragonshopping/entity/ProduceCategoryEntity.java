package com.hzq.dragonshopping.entity;

/**
 * 商品分类实体
 */
public class ProduceCategoryEntity {

    private Integer id;
    //商品类别名称
    private String name;
    //商品类别描述
    private String describe;
    //商品种类编号
    private String sortnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getSortnum() {
        return sortnum;
    }

    public void setSortnum(String sortnum) {
        this.sortnum = sortnum;
    }

    public ProduceCategoryEntity(Integer id, String name, String describe, String sortnum) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.sortnum = sortnum;
    }

    public ProduceCategoryEntity() {
        super();
    }
}
