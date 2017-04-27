package com.shhxzq.fin.ehelper.remote;

import com.alibaba.fastjson.JSONObject;
import com.shhxzq.fin.bankengine.model.RedeemPrivateRequest;
import com.shhxzq.fin.bankengine.model.RedeemPrivateResponse;
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

    @Resource
    private BankEngineService bankEngineService;

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

        // 设置哪些固定的值
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
            RedeemPrivateResponse response = bankEngineService.redeemPrivate(request);
            log.info("响应信息:{}", response);

            return GsonUtil.format(JSONObject.toJSONString(response));
        } catch (Exception e) {
            log.warn("对私赎回交易调用异常", e);
            return e.getMessage();
        }
    }

}
