package com.yuan.utils;

import com.yuan.persistence.Persistence;
import com.yuan.persistence.impl.Memory;

/**
 * @Author: yuanjz
 * @Date: 2021-08-31 16:44
 * @Description:
 */
public class PersistenceUtil {

    private static Persistence instance = null;

    public static Persistence getInstance() {
        if (instance == null) {
            instance = new Memory();
        }
        return instance;
    }
}
