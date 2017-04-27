package com.shhxzq.fin.ehelper.web.controller;

import com.shhxzq.fin.ehelper.biz.service.BeChannelConfService;
import com.shhxzq.fin.ehelper.biz.service.BeTranService;
import com.shhxzq.fin.ehelper.common.Collections3;
import com.shhxzq.fin.ehelper.model.dto.CommonTransDto;
import com.shhxzq.fin.ehelper.model.vo.BeChannelConf;
import com.shhxzq.fin.ehelper.model.vo.BeTran;
import com.shhxzq.fin.ehelper.remote.RemoteBankEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author kangyonggan
 * @since 4/27/17
 */
@Controller
@RequestMapping("trans")
public class TransController extends BaseController {

    @Autowired
    private RemoteBankEngineService remoteBankEngineService;

    @Autowired
    private BeTranService beTranService;

    @Autowired
    private BeChannelConfService beChannelConfService;

    /**
     * 发起交易界面
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return getPathIndex();
    }

    /**
     * 对私赎回
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "redeemPrivate", method = RequestMethod.GET)
    public String redeemPrivate(Model model) {
        List<BeTran> beTrans = beTranService.findBeTransByMerTranCo("29");
        List<String> bnkNos = Collections3.extractToList(beTrans, "bnkNo");
        List<BeChannelConf> beChannelConfs = beChannelConfService.findBeChannelConfByBnkNos(bnkNos);

        model.addAttribute("beChannelConfs", beChannelConfs);
        return getPathRoot() + "/redeem-private";
    }

    /**
     * 对私赎回
     *
     * @param dto
     * @param model
     * @return
     */
    @RequestMapping(value = "redeemPrivate", method = RequestMethod.POST)
    public String redeemPrivate(@ModelAttribute("dto") CommonTransDto dto, Model model) {
        List<BeTran> beTrans = beTranService.findBeTransByMerTranCo("29");
        List<String> bnkNos = Collections3.extractToList(beTrans, "bnkNo");
        List<BeChannelConf> beChannelConfs = beChannelConfService.findBeChannelConfByBnkNos(bnkNos);
        String result = remoteBankEngineService.redeemPrivate(dto);

        model.addAttribute("beChannelConfs", beChannelConfs);
        model.addAttribute("result", result);
        return getPathRoot() + "/redeem-private";
    }

    /**
     * 申购
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "pay", method = RequestMethod.GET)
    public String pay(Model model) {
        List<BeTran> beTrans = beTranService.findBeTransByMerTranCo("01");
        List<String> bnkNos = Collections3.extractToList(beTrans, "bnkNo");
        List<BeChannelConf> beChannelConfs = beChannelConfService.findBeChannelConfByBnkNos(bnkNos);

        model.addAttribute("beChannelConfs", beChannelConfs);
        return getPathRoot() + "/pay";
    }

    /**
     * 申购
     *
     * @param dto
     * @param model
     * @return
     */
    @RequestMapping(value = "pay", method = RequestMethod.POST)
    public String pay(@ModelAttribute("dto") CommonTransDto dto, Model model) {
        List<BeTran> beTrans = beTranService.findBeTransByMerTranCo("01");
        List<String> bnkNos = Collections3.extractToList(beTrans, "bnkNo");
        List<BeChannelConf> beChannelConfs = beChannelConfService.findBeChannelConfByBnkNos(bnkNos);
        String result = remoteBankEngineService.pay(dto);

        model.addAttribute("beChannelConfs", beChannelConfs);
        model.addAttribute("result", result);
        return getPathRoot() + "/pay";
    }

    /**
     * 鉴权
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "verify", method = RequestMethod.GET)
    public String verify(Model model) {
        List<BeTran> beTrans = beTranService.findBeTransByMerTranCo("63");
        List<String> bnkNos = Collections3.extractToList(beTrans, "bnkNo");
        List<BeChannelConf> beChannelConfs = beChannelConfService.findBeChannelConfByBnkNos(bnkNos);

        model.addAttribute("beChannelConfs", beChannelConfs);
        return getPathRoot() + "/verify";
    }

    /**
     * 鉴权
     *
     * @param dto
     * @param model
     * @return
     */
    @RequestMapping(value = "verify", method = RequestMethod.POST)
    public String verify(@ModelAttribute("dto") CommonTransDto dto, Model model) {
        List<BeTran> beTrans = beTranService.findBeTransByMerTranCo("63");
        List<String> bnkNos = Collections3.extractToList(beTrans, "bnkNo");
        List<BeChannelConf> beChannelConfs = beChannelConfService.findBeChannelConfByBnkNos(bnkNos);
        String result = remoteBankEngineService.verify(dto);

        model.addAttribute("beChannelConfs", beChannelConfs);
        model.addAttribute("result", result);
        return getPathRoot() + "/verify";
    }

}
