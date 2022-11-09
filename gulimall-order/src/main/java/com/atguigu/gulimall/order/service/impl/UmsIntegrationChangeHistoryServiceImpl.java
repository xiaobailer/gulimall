package com.atguigu.gulimall.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.order.dao.UmsIntegrationChangeHistoryDao;
import com.atguigu.gulimall.order.entity.UmsIntegrationChangeHistoryEntity;
import com.atguigu.gulimall.order.service.UmsIntegrationChangeHistoryService;


@Service("umsIntegrationChangeHistoryService")
public class UmsIntegrationChangeHistoryServiceImpl extends ServiceImpl<UmsIntegrationChangeHistoryDao, UmsIntegrationChangeHistoryEntity> implements UmsIntegrationChangeHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsIntegrationChangeHistoryEntity> page = this.page(
                new Query<UmsIntegrationChangeHistoryEntity>().getPage(params),
                new QueryWrapper<UmsIntegrationChangeHistoryEntity>()
        );

        return new PageUtils(page);
    }

}