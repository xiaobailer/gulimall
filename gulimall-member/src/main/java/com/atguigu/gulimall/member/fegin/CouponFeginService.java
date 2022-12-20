package com.atguigu.gulimall.member.fegin;


import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/*
*   这是一个声明式的远程调用
* */

@FeignClient("gulimall-coupon")
public interface CouponFeginService {

    @RequestMapping("coupon/coupon/member/coupon")
    public R Membergetcoupon();
}
