package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.SmsSeckillSkuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动商品关联
 * 
 * @author Sugar_Dvn
 * @email th15986581153@gmail.com
 * @date 2022-11-09 10:54:44
 */
@Mapper
public interface SmsSeckillSkuRelationDao extends BaseMapper<SmsSeckillSkuRelationEntity> {
	
}
