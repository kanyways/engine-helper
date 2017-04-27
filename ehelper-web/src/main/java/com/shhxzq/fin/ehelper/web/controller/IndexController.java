package com.shhxzq.fin.ehelper.web.controller;

import com.shhxzq.fin.ehelper.biz.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kangyonggan
 * @since 2017/3/27
 */
@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String layout() {
        return "layout";
    }

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return getPathIndex();
    }

    /**
     * 清除缓存
     *
     * @return
     */
    @RequestMapping(value = "clear", method = RequestMethod.GET)
    public String clear() {
        return getPathRoot() + "/clear";
    }

    /**
     * 清除缓存
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "clear/all", method = RequestMethod.GET)
    public String clearAll(Model model) {
        redisService.deleteAll("*");

        model.addAttribute("result", "清除缓存成功");
        return getPathRoot() + "/clear";
    }

}
