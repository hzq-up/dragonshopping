package com.hzq.dragonshopping.entity;

/**
 * 商品的实体类
 */
public class ProduceEntity {
    private Integer produce_id;
    private String produce_name;
    // 商品说明
    private String produce_explain;
    //商品种类编号
    private String produce_produce_sortnum;
    //商品库存数量
    private Integer produce_count;
    //商品进价
    private Double produce_price;
    //商品销价
    private Double produce_shop_price;
    //商品图片路径
    private String produce_imgurl;
    //商品作者
    private String produce_author;
    //已销商品数量
    private Integer produce_sale_count;
    //商品热度
    private Integer produce_hot;
    //发布商品的用户id
    private Integer produce_creat_user_id;
    //发布时间
    private String create_time;
    //更新时间
    private String update_time;

    public Integer getProduce_id() {
        return produce_id;
    }

    public void setProduce_id(Integer produce_id) {
        this.produce_id = produce_id;
    }

    public String getProduce_name() {
        return produce_name;
    }

    public void setProduce_name(String produce_name) {
        this.produce_name = produce_name;
    }

    public String getProduce_explain() {
        return produce_explain;
    }

    public void setProduce_explain(String produce_explain) {
        this.produce_explain = produce_explain;
    }

    public String getProduce_produce_sortnum() {
        return produce_produce_sortnum;
    }

    public void setProduce_produce_sortnum(String produce_produce_sortnum) {
        this.produce_produce_sortnum = produce_produce_sortnum;
    }

    public Integer getProduce_count() {
        return produce_count;
    }

    public void setProduce_count(Integer produce_count) {
        this.produce_count = produce_count;
    }

    public Double getProduce_price() {
        return produce_price;
    }

    public void setProduce_price(Double produce_price) {
        this.produce_price = produce_price;
    }

    public Double getProduce_shop_price() {
        return produce_shop_price;
    }

    public void setProduce_shop_price(Double produce_shop_price) {
        this.produce_shop_price = produce_shop_price;
    }

    public String getProduce_imgurl() {
        return produce_imgurl;
    }

    public void setProduce_imgurl(String produce_imgurl) {
        this.produce_imgurl = produce_imgurl;
    }

    public String getProduce_author() {
        return produce_author;
    }

    public void setProduce_author(String produce_author) {
        this.produce_author = produce_author;
    }

    public Integer getProduce_sale_count() {
        return produce_sale_count;
    }

    public void setProduce_sale_count(Integer produce_sale_count) {
        this.produce_sale_count = produce_sale_count;
    }

    public Integer getProduce_hot() {
        return produce_hot;
    }

    public void setProduce_hot(Integer produce_hot) {
        this.produce_hot = produce_hot;
    }

    public Integer getProduce_creat_user_id() {
        return produce_creat_user_id;
    }

    public void setProduce_creat_user_id(Integer produce_creat_user_id) {
        this.produce_creat_user_id = produce_creat_user_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public ProduceEntity() {
        super();
    }
}
