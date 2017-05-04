package com.shhxzq.fin.ehelper.biz.service;

import com.shhxzq.fin.ehelper.model.vo.BeChannelConf;

import java.util.List;

/**
 * @author kangyonggan
 * @since 4/27/17
 */
public interface BeChannelConfService {

    /**
     * 根据bnkNos查找银行通道
     *
     * @param bnkNos
     * @return
     */
    List<BeChannelConf> findBeChannelConfByBnkNos(List<String> bnkNos);

    /**
     * 查找支持对私赎回的通道
     *
     * @return
     */
    List<BeChannelConf> findRedeemBeChannelConfs();

    /**
     * 查找支持支付的通道
     *
     * @return
     */
    List<BeChannelConf> findPayBeChannelConfs();

    /**
     * 查找支持鉴权的通道
     *
     * @return
     */
    List<BeChannelConf> findVerifyBeChannelConfs();

}
