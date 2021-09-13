package com.yuan.config;

import com.yuan.utils.ConfigUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Author: yuanjz
 * @Date: 2021-08-30 10:30
 * @Description:
 */
@Getter
@Setter
@Configuration
public class SpiderConfig {

    @Value("${spider.switch:true}")
    private Boolean spiderSwitch;

    @PostConstruct
    public void init() {
        ConfigUtil.setSpiderConfig(this);
    }
}
