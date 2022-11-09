package com.atguigu.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.order.entity.PmsCategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author Sugar_Dvn
 * @email th15986581153@gmail.com
 * @date 2022-11-09 10:54:45
 */
public interface PmsCategoryBrandRelationService extends IService<PmsCategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

