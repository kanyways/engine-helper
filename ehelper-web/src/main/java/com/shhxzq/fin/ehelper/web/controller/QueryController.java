package com.shhxzq.fin.ehelper.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.shhxzq.fin.ehelper.biz.service.BeCommandService;
import com.shhxzq.fin.ehelper.common.GsonUtil;
import com.shhxzq.fin.ehelper.model.vo.BeCommand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kangyonggan
 * @since 4/28/17
 */
@Controller
@RequestMapping("query")
public class QueryController extends BaseController {

    @Autowired
    private BeCommandService beCommandService;

    /**
     * 交易查询
     *
     * @param serialNo
     * @param model
     * @return
     */
    @RequestMapping(value = "trans", method = RequestMethod.GET)
    public String trans(@RequestParam(value = "serialNo", required = false, defaultValue = "") String serialNo, Model model) {
        if (StringUtils.isNotEmpty(serialNo)) {
            BeCommand beCommand = beCommandService.findBeCommandBySerialNo(serialNo);
            model.addAttribute("result", GsonUtil.format(JSONObject.toJSONString(beCommand)));
        }

        return getPathRoot() + "/trans";
    }

}
