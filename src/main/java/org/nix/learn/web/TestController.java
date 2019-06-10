package org.nix.learn.web;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author zhangpei
 * @date 2019/6/10 17:40
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/hello")
    public String hello() {
        return StrUtil.format("hello {} : 我查询时间", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:SS"));
    }

}
