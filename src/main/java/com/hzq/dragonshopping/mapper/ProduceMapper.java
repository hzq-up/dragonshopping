package com.hzq.dragonshopping.mapper;

import com.hzq.dragonshopping.entity.ProducCommentsUserEntity;
import com.hzq.dragonshopping.entity.ProduceEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProduceMapper {
    /**
     * 查询热门商品
     * @return
     */
    public List<ProduceEntity> selectHotCommodyByHot();

    /**
     * 查询商品详情和评论详情
     * @return
     */
    public List<ProducCommentsUserEntity> selectProducCommentsUserByProducId(int producId);

    /**
     * 查询库存是否够用
     * @param produceEntity
     * @return
     */
    ProduceEntity selectProduceCount (ProduceEntity produceEntity);

    /**
     * 根据商品id更新库存数量
     * @param produceEntity
     * @return
     */
    int updateProduceProduce_count(ProduceEntity produceEntity);

    /**
     * 根据商品id查询商品库存
     * @param produceEntity
     * @return
     */
    ProduceEntity selectProduceCountByPid(ProduceEntity produceEntity);

    /**
     * 根据商品名字模糊查询商品详情
     * @param produceEntity
     * @return
     */
    List<ProduceEntity> selectAllByPN(ProduceEntity produceEntity);

}
