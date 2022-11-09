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

import com.atguigu.gulimall.order.entity.UmsMemberCollectSubjectEntity;
import com.atguigu.gulimall.order.service.UmsMemberCollectSubjectService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;



/**
 * 会员收藏的专题活动
 *
 * @author Sugar_Dvn
 * @email th15986581153@gmail.com
 * @date 2022-11-09 10:54:44
 */
@RestController
@RequestMapping("order/umsmembercollectsubject")
public class UmsMemberCollectSubjectController {
    @Autowired
    private UmsMemberCollectSubjectService umsMemberCollectSubjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:umsmembercollectsubject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsMemberCollectSubjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:umsmembercollectsubject:info")
    public R info(@PathVariable("id") Long id){
		UmsMemberCollectSubjectEntity umsMemberCollectSubject = umsMemberCollectSubjectService.getById(id);

        return R.ok().put("umsMemberCollectSubject", umsMemberCollectSubject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:umsmembercollectsubject:save")
    public R save(@RequestBody UmsMemberCollectSubjectEntity umsMemberCollectSubject){
		umsMemberCollectSubjectService.save(umsMemberCollectSubject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:umsmembercollectsubject:update")
    public R update(@RequestBody UmsMemberCollectSubjectEntity umsMemberCollectSubject){
		umsMemberCollectSubjectService.updateById(umsMemberCollectSubject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:umsmembercollectsubject:delete")
    public R delete(@RequestBody Long[] ids){
		umsMemberCollectSubjectService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
