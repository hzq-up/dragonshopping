package com.hzq.dragonshopping.mapper;

import com.hzq.dragonshopping.entity.CommentEntity;

public interface ProduceCommentMapper {
    /**
     * 插入评论
     * @param commentEntity
     * @return
     */
    public int insertComment(CommentEntity commentEntity);
}
