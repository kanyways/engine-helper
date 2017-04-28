package com.shhxzq.fin.ehelper.biz.service.impl;

import com.shhxzq.fin.ehelper.biz.service.BeCommandService;
import com.shhxzq.fin.ehelper.biz.util.MultiDataSource;
import com.shhxzq.fin.ehelper.model.annotation.DataSourceSwitch;
import com.shhxzq.fin.ehelper.model.annotation.LogTime;
import com.shhxzq.fin.ehelper.model.constants.DataSource;
import com.shhxzq.fin.ehelper.model.vo.BeCommand;
import org.springframework.stereotype.Service;

/**
 * @author kangyonggan
 * @since 4/28/17
 */
@Service
public class BeCommandServiceImpl extends BaseService<BeCommand> implements BeCommandService {

    @Override
    @LogTime
    @DataSourceSwitch
    public BeCommand findBeCommandBySerialNo(DataSource dataSource, String serialNo) {
        MultiDataSource.setDataSource(dataSource);
        BeCommand beCommand = new BeCommand();
        beCommand.setSerialNo(serialNo);

        return super.selectOne(beCommand);
    }
}
