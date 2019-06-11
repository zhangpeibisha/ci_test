package org.nix.learn.feign.client;

import com.alibaba.fastjson.JSONObject;
import feign.Headers;
import feign.RequestLine;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhangpei
 * @date 2019/6/11 20:10
 */
@Headers("ContentType: application/json")
public interface UserInfoService {

    /**
     * 发现用户信息
     *
     * @return
     */
    @RequestLine("GET /")
    JSONObject findUserInfo();

}
