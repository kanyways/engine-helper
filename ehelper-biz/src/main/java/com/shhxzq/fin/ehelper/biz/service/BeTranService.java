package com.shhxzq.fin.ehelper.biz.service;

import com.shhxzq.fin.ehelper.model.vo.BeTran;

import java.util.List;

/**
 * @author kangyonggan
 * @since 4/27/17
 */
public interface BeTranService {

    /**
     * 根据商户交易代码查询所有银行的交易
     *
     * @param merTranCo
     * @return
     */
    List<BeTran> findBeTransByMerTranCo(String merTranCo);

}
