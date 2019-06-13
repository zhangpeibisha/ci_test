package org.nix.learn.web;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.nix.learn.huffman.HuffmanImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    @GetMapping(value = "/huffman")
    public Object printHuffman(){
        HuffmanImpl huffman = new HuffmanImpl();
        huffman.printCodingTest();
        return huffman.getCompression();
    }


}
