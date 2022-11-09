package com.atguigu.gulimall.order.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.gulimall.order.entity.PmsCategoryBrandRelationEntity;
import com.atguigu.gulimall.order.service.PmsCategoryBrandRelationService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;



/**
 * 品牌分类关联
 *
 * @author Sugar_Dvn
 * @email th15986581153@gmail.com
 * @date 2022-11-09 10:54:45
 */
@RestController
@RequestMapping("order/pmscategorybrandrelation")
public class PmsCategoryBrandRelationController {
    @Autowired
    private PmsCategoryBrandRelationService pmsCategoryBrandRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:pmscategorybrandrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsCategoryBrandRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:pmscategorybrandrelation:info")
    public R info(@PathVariable("id") Long id){
		PmsCategoryBrandRelationEntity pmsCategoryBrandRelation = pmsCategoryBrandRelationService.getById(id);

        return R.ok().put("pmsCategoryBrandRelation", pmsCategoryBrandRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:pmscategorybrandrelation:save")
    public R save(@RequestBody PmsCategoryBrandRelationEntity pmsCategoryBrandRelation){
		pmsCategoryBrandRelationService.save(pmsCategoryBrandRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:pmscategorybrandrelation:update")
    public R update(@RequestBody PmsCategoryBrandRelationEntity pmsCategoryBrandRelation){
		pmsCategoryBrandRelationService.updateById(pmsCategoryBrandRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:pmscategorybrandrelation:delete")
    public R delete(@RequestBody Long[] ids){
		pmsCategoryBrandRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
