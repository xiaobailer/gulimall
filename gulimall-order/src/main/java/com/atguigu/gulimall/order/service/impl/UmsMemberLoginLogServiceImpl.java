package com.atguigu.gulimall.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.order.dao.UmsMemberLoginLogDao;
import com.atguigu.gulimall.order.entity.UmsMemberLoginLogEntity;
import com.atguigu.gulimall.order.service.UmsMemberLoginLogService;


@Service("umsMemberLoginLogService")
public class UmsMemberLoginLogServiceImpl extends ServiceImpl<UmsMemberLoginLogDao, UmsMemberLoginLogEntity> implements UmsMemberLoginLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsMemberLoginLogEntity> page = this.page(
                new Query<UmsMemberLoginLogEntity>().getPage(params),
                new QueryWrapper<UmsMemberLoginLogEntity>()
        );

        return new PageUtils(page);
    }

}