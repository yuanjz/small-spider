package com.yuan.web.controller;

import com.yuan.domain.Graph;
import com.yuan.utils.PersistenceUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: yuanjz
 * @Date: 2021-08-31 17:41
 * @Description:
 */
@RestController
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/allController")
    public Map<String, List<Graph>> allController() {
        return PersistenceUtil.getInstance().allController();
    }
}
