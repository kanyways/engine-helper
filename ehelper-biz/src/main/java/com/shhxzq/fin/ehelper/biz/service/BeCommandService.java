package com.shhxzq.fin.ehelper.biz.service;

import com.shhxzq.fin.ehelper.model.constants.DataSource;

/**
 * @author kangyonggan
 * @since 4/28/17
 */
public interface BeCommandService {

    /**
     * 根据流水号查询银行指令
     *
     * @param dataSource
     * @param serialNo
     * @return
     */
    String findResultBySerialNo(DataSource dataSource, String serialNo);

}
