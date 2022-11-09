package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.SmsCouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author Sugar_Dvn
 * @email th15986581153@gmail.com
 * @date 2022-11-09 10:54:44
 */
@Mapper
public interface SmsCouponHistoryDao extends BaseMapper<SmsCouponHistoryEntity> {
	
}
