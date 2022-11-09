package com.atguigu.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.order.entity.PmsAttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author Sugar_Dvn
 * @email th15986581153@gmail.com
 * @date 2022-11-09 10:54:45
 */
public interface PmsAttrGroupService extends IService<PmsAttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

