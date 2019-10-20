package com.hzq.dragonshopping.mapper;

import com.hzq.dragonshopping.entity.ProduceCategoryExampleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProduceCategoryMapper {
    /**
     * 查询分类商品详细信息
     * @return
     */
    public List<ProduceCategoryExampleEntity> selectProduceCategoryExample();

    /**
     * 根据商品id查询商品详细信息
     * @param produceId
     * @return
     */
    public ProduceCategoryExampleEntity selectProduceCategoryExampleById(int produceId);

    /**
     * 根据商品种类id查询改类别下的所有商品详情
     * @param id
     * @return
     */
    public List<ProduceCategoryExampleEntity> selectAllProduceByCategoryId(int id);
}
