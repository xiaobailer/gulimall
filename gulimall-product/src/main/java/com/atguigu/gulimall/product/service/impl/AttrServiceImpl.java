package com.atguigu.gulimall.product.service.impl;

import com.atguigu.gulimall.product.dao.AttrAttrgroupRelationDao;
import com.atguigu.gulimall.product.dao.AttrGroupDao;
import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.AttrAttrgroupRelationEntity;
import com.atguigu.gulimall.product.entity.AttrGroupEntity;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.AttrAttrgroupRelationService;
import com.atguigu.gulimall.product.vo.AttrRespVo;
import com.atguigu.gulimall.product.vo.AttrVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.AttrDao;
import com.atguigu.gulimall.product.entity.AttrEntity;
import com.atguigu.gulimall.product.service.AttrService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {
    @Autowired
    AttrAttrgroupRelationDao relationDao;
    @Autowired
    AttrGroupDao attrGroupDao;
    @Autowired
    CategoryDao categoryDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }
    /**
     * @Author //用来保存分组中的基本数据，同时更新到分组与基本信息的关联表中
     * @Date 2022/11/25 16:12
     * @param attrvo
     * @return void
     **/
    @Transactional  //添加事务，涉及到两个表
    @Override
    public void saveAttrvo(AttrVo attrvo) {
        //1.保存分组中的基本数据，将数据存入`pms_attr`表中
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attrvo,attrEntity);
        System.out.println(attrvo);
        this.save(attrEntity);
        //2.将从前端获取到的分组id，和基本信息的id存入关联表中`pms_attr_attrgroup_relation`
        AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
        relationEntity.setAttrGroupId(attrvo.getAttrGroupId());
        relationEntity.setAttrId(attrEntity.getAttrId());
        //调用dao存入数据库
        relationDao.insert(relationEntity);
    }

    //获取规格信息
    @Override
    public PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId) {
        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<>();
        if (catelogId != 0) {
            //查询指定分类的规格信息
            wrapper.eq("catelog_id", catelogId);
        }
        String key = (String) params.get("key");
        if (StringUtils.isEmpty(key)) {
            wrapper.and((queryWrapper) -> {
                queryWrapper.eq("attr_id", key).or().like("attr_name", key);
            });
        }
        //查询所属分组

        //查询所有数据
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        List<AttrEntity> records = page.getRecords();
        List<AttrRespVo> respVo = records.stream().map((attrEntity) -> {
            AttrRespVo attrRespVo = new AttrRespVo();
            BeanUtils.copyProperties(attrEntity, attrRespVo);
            //获取所属分组名字
            AttrAttrgroupRelationEntity relationEntity = relationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attrEntity.getAttrId()));
            if (relationEntity != null) {
                AttrGroupEntity attrgroup = attrGroupDao.selectOne(new QueryWrapper<AttrGroupEntity>().eq("attr_group_id", relationEntity.getAttrGroupId()));
                attrRespVo.setGroupName(attrgroup.getAttrGroupName());
            }
            //获取所属分类名字
            CategoryEntity categoryEntity = categoryDao.selectById(attrEntity.getCatelogId());
            if (categoryEntity != null) {
                attrRespVo.setCatelogName(categoryEntity.getName());
            }
            return attrRespVo;
        }).collect(Collectors.toList());
        pageUtils.setList(respVo);
        return pageUtils;
    }

}