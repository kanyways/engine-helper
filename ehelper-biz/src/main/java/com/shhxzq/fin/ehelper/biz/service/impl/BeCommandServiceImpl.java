package com.shhxzq.fin.ehelper.biz.service.impl;

import com.shhxzq.fin.ehelper.biz.service.BeCommandService;
import com.shhxzq.fin.ehelper.model.annotation.LogTime;
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
    public BeCommand findBeCommandBySerialNo(String serialNo) {
        BeCommand beCommand = new BeCommand();
        beCommand.setSerialNo(serialNo);

        return super.selectOne(beCommand);
    }
}
