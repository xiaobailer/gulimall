package com.atguigu.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.order.entity.PmsSpuImagesEntity;

import java.util.Map;

/**
 * spu图片
 *
 * @author Sugar_Dvn
 * @email th15986581153@gmail.com
 * @date 2022-11-09 10:54:44
 */
public interface PmsSpuImagesService extends IService<PmsSpuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

