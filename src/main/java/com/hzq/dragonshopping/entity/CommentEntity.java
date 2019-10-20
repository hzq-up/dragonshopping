package com.hzq.dragonshopping.entity;

/**
 * 评论表实体
 */
public class CommentEntity {

    private Integer comments_id;
    //评论的内容
    private String comments_centent;
    //评论的用户id
    private Integer comments_user_id;
    //评论的商品id
    private Integer comments_produce_id;
    //评论的星级
    private Integer comments_stars;
    //评论的时间
    private String comments_date;

    public Integer getComments_id() {
        return comments_id;
    }

    public void setComments_id(Integer comments_id) {
        this.comments_id = comments_id;
    }

    public String getComments_centent() {
        return comments_centent;
    }

    public void setComments_centent(String comments_centent) {
        this.comments_centent = comments_centent;
    }

    public Integer getComments_user_id() {
        return comments_user_id;
    }

    public void setComments_user_id(Integer comments_user_id) {
        this.comments_user_id = comments_user_id;
    }

    public Integer getComments_produce_id() {
        return comments_produce_id;
    }

    public void setComments_produce_id(Integer comments_produce_id) {
        this.comments_produce_id = comments_produce_id;
    }

    public Integer getComments_stars() {
        return comments_stars;
    }

    public void setComments_stars(Integer comments_stars) {
        this.comments_stars = comments_stars;
    }

    public String getComments_date() {
        return comments_date;
    }

    public void setComments_date(String comments_date) {
        this.comments_date = comments_date;
    }

    public CommentEntity(Integer comments_id, String comments_centent, Integer comments_user_id, Integer comments_produce_id, Integer comments_stars, String comments_date) {
        this.comments_id = comments_id;
        this.comments_centent = comments_centent;
        this.comments_user_id = comments_user_id;
        this.comments_produce_id = comments_produce_id;
        this.comments_stars = comments_stars;
        this.comments_date = comments_date;
    }

    public CommentEntity() {
        super();
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "comments_id=" + comments_id +
                ", comments_centent='" + comments_centent + '\'' +
                ", comments_user_id=" + comments_user_id +
                ", comments_produce_id=" + comments_produce_id +
                ", comments_stars=" + comments_stars +
                ", comments_date='" + comments_date + '\'' +
                '}';
    }
}
