package com.atguigu.gulimall.product.feign;

import com.atguigu.common.to.SkuReductionTo;
import com.atguigu.common.to.SpuBoundTo;
import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    /**
    *@Description:1.CouponFeignService.saveSpuBounds(spuBoundTo)
     *              1.）回将这个对象转换成json对象
     *              2.) 找到gulimall-coupon服务，给/coupon/spubounds/save发送请求。将上一步转的json放在请求体的位置，发送请求
     *              3.）对方服务收到请求，收到的是请求体中的json
     *                  (@RequestBody SpuBoundsEntity spuBounds)；将请求体的json转换为SpuBoundsEntity
    *@Parameter:[spuBoundTo]
    *@Return:com.atguigu.common.utils.R
    *@Author:Sugar
    *@Date:2022/12/20
    **/
    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("/coupon/skufullreduction/saveInfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
