package com.hzq.dragonshopping.service;

import com.hzq.dragonshopping.entity.CommentEntity;
import org.springframework.stereotype.Service;

public interface ICommentService {
    /**
     * 添加评论
     * @param commentEntity
     * @return
     */
    int addComment(CommentEntity commentEntity);
}
