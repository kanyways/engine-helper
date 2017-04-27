package com.shhxzq.fin.ehelper.biz.service.impl;

import com.shhxzq.fin.ehelper.biz.service.BeEngineService;
import com.shhxzq.fin.ehelper.model.annotation.LogTime;
import com.shhxzq.fin.ehelper.model.vo.BeEngine;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author kangyonggan
 * @since 4/27/17
 */
@Service
@Log4j2
public class BeEngineServiceImpl extends BaseService<BeEngine> implements BeEngineService {

    @Override
    @LogTime
    public List<BeEngine> findAllEngine() {
        Example example = new Example(BeEngine.class);

        example.setOrderByClause("id desc");
        return super.selectByExample(example);
    }
}
