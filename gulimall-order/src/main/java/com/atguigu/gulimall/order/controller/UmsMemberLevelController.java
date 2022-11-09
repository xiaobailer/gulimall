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

import com.atguigu.gulimall.order.entity.UmsMemberLevelEntity;
import com.atguigu.gulimall.order.service.UmsMemberLevelService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;



/**
 * 会员等级
 *
 * @author Sugar_Dvn
 * @email th15986581153@gmail.com
 * @date 2022-11-09 10:54:44
 */
@RestController
@RequestMapping("order/umsmemberlevel")
public class UmsMemberLevelController {
    @Autowired
    private UmsMemberLevelService umsMemberLevelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:umsmemberlevel:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsMemberLevelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:umsmemberlevel:info")
    public R info(@PathVariable("id") Long id){
		UmsMemberLevelEntity umsMemberLevel = umsMemberLevelService.getById(id);

        return R.ok().put("umsMemberLevel", umsMemberLevel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:umsmemberlevel:save")
    public R save(@RequestBody UmsMemberLevelEntity umsMemberLevel){
		umsMemberLevelService.save(umsMemberLevel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:umsmemberlevel:update")
    public R update(@RequestBody UmsMemberLevelEntity umsMemberLevel){
		umsMemberLevelService.updateById(umsMemberLevel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:umsmemberlevel:delete")
    public R delete(@RequestBody Long[] ids){
		umsMemberLevelService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
