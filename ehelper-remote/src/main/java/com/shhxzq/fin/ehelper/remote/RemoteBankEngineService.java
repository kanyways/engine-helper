package com.shhxzq.fin.ehelper.remote;

import com.alibaba.fastjson.JSONObject;
import com.shhxzq.fin.bankengine.model.*;
import com.shhxzq.fin.bankengine.service.BankEngineService;
import com.shhxzq.fin.ehelper.common.DateUtil;
import com.shhxzq.fin.ehelper.common.GsonUtil;
import com.shhxzq.fin.ehelper.model.annotation.LogTime;
import com.shhxzq.fin.ehelper.model.dto.CommonTransDto;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author kangyonggan
 * @since 4/27/17
 */
@Service
@Log4j2
public class RemoteBankEngineService {

    @Resource(name = "bankEngineServiceDev")
    private BankEngineService bankEngineServiceDev;

    @Resource(name = "bankEngineServiceUat")
    private BankEngineService bankEngineServiceUat;

    /**
     * 对私赎回
     *
     * @param commonTransDto
     * @return
     */
    @LogTime
    public String redeemPrivate(CommonTransDto commonTransDto) {
        RedeemPrivateRequest request = new RedeemPrivateRequest();
        try {
            PropertyUtils.copyProperties(request, commonTransDto);
        } catch (Exception e) {
            log.warn("对私赎回交易异常", e);
            return e.getMessage();
        }

        // 设置那些固定的值
        request.setMerTranCode("29");
        request.setProductId("000330");
        request.setProductName("引擎助手");
        request.setProductType(null);
        request.setCurrency("156");
        request.setAppKind("952");
        request.setReceiverIdType("0");
        request.setReceiverCity("");
        request.setHuiLu("");
        request.setRefAppNo(DateUtil.getCurrentFullDateTime());
        request.setCurrWorkingDate(DateUtil.now());
        request.setAccountId(request.getRouteCode());
        request.setCapitalMode("H");

        try {
            RedeemPrivateResponse response;
            if ("uat".equals(commonTransDto.getEnv())) {
                response = bankEngineServiceUat.redeemPrivate(request);
            } else {
                response = bankEngineServiceDev.redeemPrivate(request);
            }
            log.info("响应信息:{}", response);

            return GsonUtil.format(JSONObject.toJSONString(response));
        } catch (Exception e) {
            log.warn("对私赎回交易调用异常", e);
            return e.getMessage();
        }
    }

    /**
     * 申购
     *
     * @param commonTransDto
     * @return
     */
    public String pay(CommonTransDto commonTransDto) {
        PayRequest request = new PayRequest();
        try {
            PropertyUtils.copyProperties(request, commonTransDto);
        } catch (Exception e) {
            log.warn("申购交易异常", e);
            return e.getMessage();
        }

        // 设置那些固定的值
//        request.setSenderIdType("0");//身份证
//        request.setSenderProtocolNo("20161111100004229413");
        request.setAccpTmd(Accptmd.Mobile.getValue());
        request.setRefAppNo(DateUtil.getCurrentFullDateTime());
        request.setMerTranCode("01");
        request.setCurrWorkingDate(DateUtil.now());
        request.setAppKind("022");

        try {
            PayResponse response;
            if ("uat".equals(commonTransDto.getEnv())) {
                response = bankEngineServiceUat.pay(request);
            } else {
                response = bankEngineServiceDev.pay(request);
            }
            log.info("响应信息:{}", response);

            return GsonUtil.format(JSONObject.toJSONString(response));
        } catch (Exception e) {
            log.warn("申购交易调用异常", e);
            return e.getMessage();
        }
    }

    /**
     * 鉴权
     *
     * @param commonTransDto
     * @return
     */
    public String verify(CommonTransDto commonTransDto) {
        VerifyRequest request = new VerifyRequest();
        try {
            PropertyUtils.copyProperties(request, commonTransDto);
        } catch (Exception e) {
            log.warn("鉴权交易异常", e);
            return e.getMessage();
        }

        // 设置那些固定的值
        request.setIdType("0");//身份证（内部0, 会被翻译为1）
        request.setAppKind("918");
        request.setAccptmd(Accptmd.Mobile);

        try {
            VerifyResponse response;
            if ("uat".equals(commonTransDto.getEnv())) {
                response = bankEngineServiceUat.verify(request);
            } else {
                response = bankEngineServiceDev.verify(request);
            }
            log.info("响应信息:{}", response);

            return GsonUtil.format(JSONObject.toJSONString(response));
        } catch (Exception e) {
            log.warn("鉴权交易调用异常", e);
            return e.getMessage();
        }
    }
}
