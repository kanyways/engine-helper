package com.shhxzq.fin.ehelper.web.controller;

import com.shhxzq.fin.ehelper.biz.service.BeEngineService;
import com.shhxzq.fin.ehelper.model.vo.BeEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author kangyonggan
 * @since 4/27/17
 */
@Controller
@RequestMapping("engine")
public class EngineController extends BaseController {

    @Autowired
    private BeEngineService beEngineService;

    /**
     * 引擎列表
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<BeEngine> engines = beEngineService.findAllEngine();

        model.addAttribute("engines", engines);
        return getPathIndex();
    }

}
