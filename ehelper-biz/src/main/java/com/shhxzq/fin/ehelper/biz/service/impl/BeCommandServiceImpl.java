package com.shhxzq.fin.ehelper.biz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shhxzq.fin.ehelper.biz.service.BeCommandService;
import com.shhxzq.fin.ehelper.biz.service.impl.transaction.BaseService;
import com.shhxzq.fin.ehelper.common.GsonUtil;
import com.shhxzq.fin.ehelper.mapper.BeSimulatorTransactionMapper;
import com.shhxzq.fin.ehelper.model.annotation.DataSourceSwitch;
import com.shhxzq.fin.ehelper.model.annotation.LogTime;
import com.shhxzq.fin.ehelper.model.constants.DataSource;
import com.shhxzq.fin.ehelper.model.vo.BeCommand;
import com.shhxzq.fin.ehelper.model.vo.BeSimulatorTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kangyonggan
 * @since 4/28/17
 */
@Service
public class BeCommandServiceImpl extends BaseService<BeCommand> implements BeCommandService {

    @Autowired
    private BeSimulatorTransactionMapper beSimulatorTransactionMapper;

    @Override
    @LogTime
    @DataSourceSwitch
    public String findResultBySerialNo(DataSource dataSource, String serialNo) {
        if (dataSource.equals(DataSource.SIM)) {
            BeSimulatorTransaction transaction = new BeSimulatorTransaction();
            transaction.setBeSer(serialNo);
            return GsonUtil.format(JSONObject.toJSONString(beSimulatorTransactionMapper.selectOne(transaction)));
        }

        BeCommand beCommand = new BeCommand();
        beCommand.setSerialNo(serialNo);
        return GsonUtil.format(JSONObject.toJSONString(super.selectOne(beCommand)));
    }
}
