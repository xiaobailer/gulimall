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

import com.atguigu.gulimall.order.entity.SmsCouponSpuRelationEntity;
import com.atguigu.gulimall.order.service.SmsCouponSpuRelationService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;



/**
 * 优惠券与产品关联
 *
 * @author Sugar_Dvn
 * @email th15986581153@gmail.com
 * @date 2022-11-09 10:54:44
 */
@RestController
@RequestMapping("order/smscouponspurelation")
public class SmsCouponSpuRelationController {
    @Autowired
    private SmsCouponSpuRelationService smsCouponSpuRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:smscouponspurelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsCouponSpuRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:smscouponspurelation:info")
    public R info(@PathVariable("id") Long id){
		SmsCouponSpuRelationEntity smsCouponSpuRelation = smsCouponSpuRelationService.getById(id);

        return R.ok().put("smsCouponSpuRelation", smsCouponSpuRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:smscouponspurelation:save")
    public R save(@RequestBody SmsCouponSpuRelationEntity smsCouponSpuRelation){
		smsCouponSpuRelationService.save(smsCouponSpuRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:smscouponspurelation:update")
    public R update(@RequestBody SmsCouponSpuRelationEntity smsCouponSpuRelation){
		smsCouponSpuRelationService.updateById(smsCouponSpuRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:smscouponspurelation:delete")
    public R delete(@RequestBody Long[] ids){
		smsCouponSpuRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
