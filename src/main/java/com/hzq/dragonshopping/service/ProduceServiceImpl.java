package com.hzq.dragonshopping.service;

import com.hzq.dragonshopping.entity.ProducCommentsUserEntity;
import com.hzq.dragonshopping.entity.ProduceEntity;
import com.hzq.dragonshopping.mapper.ProduceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProduceService")
public class ProduceServiceImpl implements IProduceService{

    @Autowired
    private ProduceMapper produceMapper;

    @Override
    public List<ProduceEntity> showHotCommody() {
        return produceMapper.selectHotCommodyByHot();
    }

    @Override
    public List<ProducCommentsUserEntity> selectProducDetailsAndComments(int producId) {
        return produceMapper.selectProducCommentsUserByProducId(producId);
    }

    @Override
    public List<ProduceEntity> searchProduce(ProduceEntity produceEntity) {
        return produceMapper.selectAllByPN(produceEntity);
    }
}
