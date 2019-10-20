package com.hzq.dragonshopping.service;

import com.hzq.dragonshopping.entity.CommentEntity;
import com.hzq.dragonshopping.mapper.ProduceCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CommentService")
public class CommentServiceImpl implements ICommentService{

    @Autowired
    private ProduceCommentMapper produceCommentMapper;


    @Transactional
    @Override
    public int addComment(CommentEntity commentEntity) {
        return produceCommentMapper.insertComment(commentEntity);
    }
}
