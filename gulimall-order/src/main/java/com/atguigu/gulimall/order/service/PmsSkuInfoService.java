package com.atguigu.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.order.entity.PmsSkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author Sugar_Dvn
 * @email th15986581153@gmail.com
 * @date 2022-11-09 10:54:45
 */
public interface PmsSkuInfoService extends IService<PmsSkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

