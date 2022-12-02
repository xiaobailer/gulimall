package com.atguigu.gulimall.product.vo;

import lombok.Data;

@Data
public class AttrRespVo extends AttrVo{

    /*
     * @Author 42092
     * @Date 2022/12/2 9:38
      * @param
      "catelogName": "手机/数码/手机", //所属分类名字
      "groupName": "主体", //所属分组名字
     */
    private String catelogName;
    private String groupName;
}
