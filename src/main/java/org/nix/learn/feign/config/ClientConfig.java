package org.nix.learn.feign.config;


import feign.Feign;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.nix.learn.feign.client.UserInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangpei
 * @date 2019/6/11 20:18
 */
@Configuration
public class ClientConfig {

    @Bean
    public UserInfoService userInfoService(){
        return Feign.builder()
                .client(new OkHttpClient())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(UserInfoService.class))
                .options(new Request.Options(1000, 10 * 1000))
                .target(UserInfoService.class,"http://es4course.inner.youdao.com:80");
    }


}
