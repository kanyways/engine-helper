package com.shhxzq.fin.ehelper.biz.service.impl;

import com.shhxzq.fin.ehelper.biz.service.BeTranService;
import com.shhxzq.fin.ehelper.model.annotation.CacheGetOrSave;
import com.shhxzq.fin.ehelper.model.annotation.LogTime;
import com.shhxzq.fin.ehelper.model.vo.BeTran;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kangyonggan
 * @since 4/27/17
 */
@Service
public class BeTranServiceImpl extends BaseService<BeTran> implements BeTranService {

    @Override
    @LogTime
    @CacheGetOrSave("tran:code:{0}")
    public List<BeTran> findBeTransByMerTranCo(String merTranCo) {
        BeTran beTran = new BeTran();
        beTran.setMerTranCo(merTranCo);
        return super.select(beTran);
    }
}
