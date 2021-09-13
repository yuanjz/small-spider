package com.yuan.utils;

import com.yuan.config.SpiderConfig;

/**
 * @Author: yuanjz
 * @Date: 2021-08-30 10:40
 * @Description:
 */
public class ConfigUtil {

    private static SpiderConfig spiderConfig;

    static {
        spiderConfig = new SpiderConfig();
        spiderConfig.setSpiderSwitch(false);
    }

    public static void setSpiderConfig(SpiderConfig config) {
        spiderConfig = config;
    }

    public static SpiderConfig getSpiderConfig() {
        return spiderConfig;
    }

}
