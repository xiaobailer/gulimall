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

import com.atguigu.gulimall.order.entity.UmsMemberCollectSpuEntity;
import com.atguigu.gulimall.order.service.UmsMemberCollectSpuService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;



/**
 * 会员收藏的商品
 *
 * @author Sugar_Dvn
 * @email th15986581153@gmail.com
 * @date 2022-11-09 10:54:44
 */
@RestController
@RequestMapping("order/umsmembercollectspu")
public class UmsMemberCollectSpuController {
    @Autowired
    private UmsMemberCollectSpuService umsMemberCollectSpuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:umsmembercollectspu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsMemberCollectSpuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:umsmembercollectspu:info")
    public R info(@PathVariable("id") Long id){
		UmsMemberCollectSpuEntity umsMemberCollectSpu = umsMemberCollectSpuService.getById(id);

        return R.ok().put("umsMemberCollectSpu", umsMemberCollectSpu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:umsmembercollectspu:save")
    public R save(@RequestBody UmsMemberCollectSpuEntity umsMemberCollectSpu){
		umsMemberCollectSpuService.save(umsMemberCollectSpu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:umsmembercollectspu:update")
    public R update(@RequestBody UmsMemberCollectSpuEntity umsMemberCollectSpu){
		umsMemberCollectSpuService.updateById(umsMemberCollectSpu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:umsmembercollectspu:delete")
    public R delete(@RequestBody Long[] ids){
		umsMemberCollectSpuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
