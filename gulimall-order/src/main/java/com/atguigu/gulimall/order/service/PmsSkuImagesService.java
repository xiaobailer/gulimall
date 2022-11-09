package com.atguigu.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.order.entity.PmsSkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author Sugar_Dvn
 * @email th15986581153@gmail.com
 * @date 2022-11-09 10:54:45
 */
public interface PmsSkuImagesService extends IService<PmsSkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

