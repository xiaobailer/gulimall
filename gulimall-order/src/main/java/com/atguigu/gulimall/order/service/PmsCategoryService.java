package com.atguigu.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.order.entity.PmsCategoryEntity;

import java.util.Map;

/**
 * 商品三级分类
 *
 * @author Sugar_Dvn
 * @email th15986581153@gmail.com
 * @date 2022-11-09 10:54:45
 */
public interface PmsCategoryService extends IService<PmsCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

