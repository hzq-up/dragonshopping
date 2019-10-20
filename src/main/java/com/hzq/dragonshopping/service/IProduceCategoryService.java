package com.hzq.dragonshopping.service;

import com.hzq.dragonshopping.entity.ProduceCategoryExampleEntity;

import java.util.List;

public interface IProduceCategoryService {

    /**
     * 查询分类商品详细信息
     * @return
     */
    List<ProduceCategoryExampleEntity> selectProduceCategoryExample();

    /**
     * 根据商品id查询商品分类信息
     * @param produceId
     * @return
     */
    ProduceCategoryExampleEntity selectProduceCategoryExampleByProduceId(int produceId);

    /**
     * 根据商品类别id查询所有商品详情
     * @param id
     * @return
     */
    List<ProduceCategoryExampleEntity> selectProduceCategoryExampleByCategoryId(int id);
}
