package com.atguigu.gulimall.member.fegin;


import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gulimall-coupon")
public interface CouponFeginService {

    @RequestMapping("coupon/coupon/member/coupon")
    public R Membergetcoupon();
}
