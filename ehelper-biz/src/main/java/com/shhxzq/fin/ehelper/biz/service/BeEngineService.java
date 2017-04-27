package com.shhxzq.fin.ehelper.biz.service;

import com.shhxzq.fin.ehelper.model.vo.BeEngine;

import java.util.List;

/**
 * @author kangyonggan
 * @since 4/27/17
 */
public interface BeEngineService {

    /**
     * 查找所有引擎
     *
     * @return
     */
    List<BeEngine> findAllEngine();

}
