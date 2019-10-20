package com.hzq.dragonshopping.service;

import com.hzq.dragonshopping.entity.ProduceCategoryExampleEntity;
import com.hzq.dragonshopping.mapper.ProduceCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProduceServiceCategory")
public class ProduceCategoryServiceImpl implements IProduceCategoryService{

    @Autowired
    private ProduceCategoryMapper produceCategoryMapper;

    @Override
    public List<ProduceCategoryExampleEntity> selectProduceCategoryExample() {
        List<ProduceCategoryExampleEntity> produceCategoryExampleEntitiesList = produceCategoryMapper.selectProduceCategoryExample();
        //只要ProduceEntities前三条数据
        for(int i =0;i < produceCategoryExampleEntitiesList.size(); i++){
            if(produceCategoryExampleEntitiesList.get(i).getProduceEntities().size() >2 ){
                int size = produceCategoryExampleEntitiesList.get(i).getProduceEntities().size();

//                //被移除的大小
                size = produceCategoryExampleEntitiesList.get(i).getProduceEntities().size();
                for(int j = 3;j < size;size--){
                    produceCategoryExampleEntitiesList.get(i).getProduceEntities().remove(size-1);
                    System.out.println("===="+produceCategoryExampleEntitiesList.get(i).getProduceEntities().size()+"======");
                }
                System.out.println("一类商品显示的个数"+size);
            }
        }
        return produceCategoryExampleEntitiesList;
    }

    @Override
    public ProduceCategoryExampleEntity selectProduceCategoryExampleByProduceId(int produceId) {
        return produceCategoryMapper.selectProduceCategoryExampleById(produceId);
    }

    @Override
    public List<ProduceCategoryExampleEntity> selectProduceCategoryExampleByCategoryId(int id) {
        return produceCategoryMapper.selectAllProduceByCategoryId(id);
    }
}
