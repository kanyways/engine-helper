package com.shhxzq.fin.ehelper.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.shhxzq.fin.ehelper.biz.service.BeCommandService;
import com.shhxzq.fin.ehelper.common.GsonUtil;
import com.shhxzq.fin.ehelper.model.constants.DataSource;
import com.shhxzq.fin.ehelper.model.vo.BeCommand;
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
     * @return
     */
    @RequestMapping(value = "trans", method = RequestMethod.GET)
    public String trans() {
        return getPathRoot() + "/trans";
    }

    /**
     * 交易查询
     *
     * @param serialNo
     * @param env
     * @param model
     * @return
     */
    @RequestMapping(value = "trans", method = RequestMethod.POST)
    public String trans(@RequestParam(value = "serialNo", required = false, defaultValue = "") String serialNo,
                        @RequestParam(value = "env", required = false, defaultValue = "dev") String env, Model model) {
        BeCommand beCommand = beCommandService.findBeCommandBySerialNo(DataSource.getDataSource(env), serialNo);
        model.addAttribute("result", GsonUtil.format(JSONObject.toJSONString(beCommand)));

        return getPathRoot() + "/trans";
    }

}
