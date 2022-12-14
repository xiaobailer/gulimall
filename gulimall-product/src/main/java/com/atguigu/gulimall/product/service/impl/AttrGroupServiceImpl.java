package com.atguigu.gulimall.product.service.impl;

import com.atguigu.gulimall.product.entity.AttrAttrgroupRelationEntity;
import com.atguigu.gulimall.product.entity.AttrEntity;
import com.atguigu.gulimall.product.service.AttrService;
import com.atguigu.gulimall.product.vo.AttrGroupWithAttr;
import com.atguigu.gulimall.product.vo.AttrRelationGroupVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.AttrGroupDao;
import com.atguigu.gulimall.product.entity.AttrGroupEntity;
import com.atguigu.gulimall.product.service.AttrGroupService;

@Slf4j
@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {
//
//    @Override
//    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
//        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();
//        String key = String.valueOf(params.get("key"));
//        if (!StringUtils.isEmpty(key)) {
//            wrapper.and((obj) -> {
//                obj.eq("attr_group_id", key).or().like("attr_group_name", key);
//            });
//        }
//        if (catelogId == 0) {
//            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params));
//            return new PageUtils(page);
//        }else {
//            wrapper.eq("catelog_id", catelogId);
//            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),wrapper);
//            return new PageUtils(page);
//        }
//    }


    @Autowired
    AttrService attrService;

    @Autowired
    AttrGroupDao attrGroupDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        String key = (String) params.get("key");
        //select * from pms_attr_group where catelog_id=? and (attr_group_id=key or attr_group_name like %key%)
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>();
        if(!StringUtils.isEmpty(key)){
            wrapper.and((obj)->{
                obj.eq("attr_group_id",key).or().like("attr_group_name",key);
            });
        }

        if( catelogId == 0){
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    wrapper);
            return new PageUtils(page);
        }else {
            wrapper.eq("catelog_id",catelogId);
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    wrapper);
            return new PageUtils(page);
        }
    }

    /**
    *@Description:????????????id???????????????????????????????????????????????????
    *@Parameter:[catelogId]
    *@Return:java.util.List<com.atguigu.gulimall.product.vo.AttrGroupWithAttr>
    *@Author:Sugar
    *@Date:2022/12/5
    **/
    @Override
    public List<AttrGroupWithAttr> getAttrGroupWithAttr(Long catelogId) {
        //??????????????????
        List<AttrGroupEntity> attrGroupEntities = this.list(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));
        //??????????????????
        List<AttrGroupWithAttr> collect = attrGroupEntities.stream().map((entity) -> {
            AttrGroupWithAttr attrsVo = new AttrGroupWithAttr();
            BeanUtils.copyProperties(entity, attrsVo);
            List<AttrEntity> attrEntities = attrService.attrRelation(entity.getAttrGroupId());
            attrsVo.setAttrs(attrEntities);
            return attrsVo;
        }).collect(Collectors.toList());
        return collect;
    }
}