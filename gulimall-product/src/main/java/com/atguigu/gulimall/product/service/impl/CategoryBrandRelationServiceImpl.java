package com.atguigu.gulimall.product.service.impl;

import com.atguigu.gulimall.product.dao.BrandDao;
import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.BrandService;
import jdk.nashorn.internal.ir.annotations.Reference;
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

import com.atguigu.gulimall.product.dao.CategoryBrandRelationDao;
import com.atguigu.gulimall.product.entity.CategoryBrandRelationEntity;
import com.atguigu.gulimall.product.service.CategoryBrandRelationService;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {
    @Autowired
    BrandDao brandDao;
    @Autowired
    CategoryDao categoryDao;

    @Autowired
    CategoryBrandRelationDao relationDao;

    @Autowired
    BrandService brandService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                new QueryWrapper<CategoryBrandRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveDetail(CategoryBrandRelationEntity categoryBrandRelation) {
        //获取品牌的id
        Long brandId = categoryBrandRelation.getBrandId();
        System.out.println("brandId:"+brandId);
        //获取分类的id
        Long catelogId = categoryBrandRelation.getCatelogId();
        //获取品牌实体类
        BrandEntity brandEntity = brandDao.selectById(brandId);
        //获取分类实体类
        CategoryEntity categoryEntity = categoryDao.selectById(catelogId);
        //为品牌分类关联表附上冗余字段值
        categoryBrandRelation.setBrandName(brandEntity.getName());
        categoryBrandRelation.setCatelogName(categoryEntity.getName());
        this.save(categoryBrandRelation);
    }

    @Override
    public void updateBrandName(Long brandId, String name) {
        //获取实体类
        CategoryBrandRelationEntity entity = new CategoryBrandRelationEntity();
        //对实体类中的字段进行赋值
        entity.setBrandName(name);
        entity.setBrandId(brandId);
        //更新到品牌与分类的数据库
        this.update(entity, new QueryWrapper<CategoryBrandRelationEntity>().eq("brand_id", brandId));
    }

    @Override
    public void updateCategoryName(Long catId, String name) {
       /* 实现方式1
       //获取实体类
        CategoryBrandRelationEntity entity = new CategoryBrandRelationEntity();
        entity.setCatelogId(catId);
        entity.setCatelogName(name);
        this.update(entity, new QueryWrapper<CategoryBrandRelationEntity>().eq("catelog_id", catId));*/

       //实现方式2
        this.baseMapper.updateCategoryName(catId, name);
    }

    /**
    *@Description:获取品牌信息
    *@Parameter:[catId]
    *@Return:java.util.List<com.atguigu.gulimall.product.entity.BrandEntity>
    *@Author:Sugar
    *@Date:2022/12/4
    **/
    @Override
    public List<BrandEntity> getBrandByCatId(Long catId) {
        List<CategoryBrandRelationEntity> catBrandRelationEntity = relationDao.selectList(new QueryWrapper<CategoryBrandRelationEntity>().eq("catelog_id", catId));
        List<BrandEntity> collect = catBrandRelationEntity.stream().map((entity) -> {
            Long brandId = entity.getBrandId();
            BrandEntity brandEntity = brandService.getById(brandId);
            return brandEntity;
        }).collect(Collectors.toList());
        return collect;
    }

}