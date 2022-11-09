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

import com.atguigu.gulimall.order.entity.SmsCouponHistoryEntity;
import com.atguigu.gulimall.order.service.SmsCouponHistoryService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;



/**
 * 优惠券领取历史记录
 *
 * @author Sugar_Dvn
 * @email th15986581153@gmail.com
 * @date 2022-11-09 10:54:44
 */
@RestController
@RequestMapping("order/smscouponhistory")
public class SmsCouponHistoryController {
    @Autowired
    private SmsCouponHistoryService smsCouponHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:smscouponhistory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsCouponHistoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:smscouponhistory:info")
    public R info(@PathVariable("id") Long id){
		SmsCouponHistoryEntity smsCouponHistory = smsCouponHistoryService.getById(id);

        return R.ok().put("smsCouponHistory", smsCouponHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:smscouponhistory:save")
    public R save(@RequestBody SmsCouponHistoryEntity smsCouponHistory){
		smsCouponHistoryService.save(smsCouponHistory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:smscouponhistory:update")
    public R update(@RequestBody SmsCouponHistoryEntity smsCouponHistory){
		smsCouponHistoryService.updateById(smsCouponHistory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:smscouponhistory:delete")
    public R delete(@RequestBody Long[] ids){
		smsCouponHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
