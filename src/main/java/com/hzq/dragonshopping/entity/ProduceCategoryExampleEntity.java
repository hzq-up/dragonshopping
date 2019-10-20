package com.hzq.dragonshopping.entity;

import java.util.List;

public class ProduceCategoryExampleEntity {

    private Integer id;
    //商品类别名称
    private String name;
    //商品类别描述
    private String describe;
    //商品种类编号
    private String sortnum;
    //分类下的商品
    private List<ProduceEntity> produceEntities;

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

    public List<ProduceEntity> getProduceEntities() {
        return produceEntities;
    }

    public void setProduceEntities(List<ProduceEntity> produceEntities) {
        this.produceEntities = produceEntities;
    }

    public ProduceCategoryExampleEntity(Integer id, String name, String describe, String sortnum, List<ProduceEntity> produceEntities) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.sortnum = sortnum;
        this.produceEntities = produceEntities;
    }

    public ProduceCategoryExampleEntity() {
        super();
    }

    @Override
    public String toString() {
        return "ProduceCategoryExampleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", sortnum='" + sortnum + '\'' +
                ", produceEntities=" + produceEntities +
                '}';
    }
}
