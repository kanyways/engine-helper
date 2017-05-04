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
     * 查询所有的银行通道
     *
     * @return
     */
    List<BeChannelConf> findAllBeChannelConfs();

}
