package com.shhxzq.fin.ehelper.biz.service;

import com.shhxzq.fin.ehelper.model.vo.BeCommand;

/**
 * @author kangyonggan
 * @since 4/28/17
 */
public interface BeCommandService {

    /**
     * 根据流水号查询银行指令
     *
     * @param serialNo
     * @return
     */
    BeCommand findBeCommandBySerialNo(String serialNo);

}
