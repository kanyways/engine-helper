package com.shhxzq.fin.ehelper.biz.service.impl.transaction;

import com.shhxzq.fin.ehelper.biz.service.BeChannelConfService;
import com.shhxzq.fin.ehelper.model.annotation.CacheGetOrSave;
import com.shhxzq.fin.ehelper.model.annotation.LogTime;
import com.shhxzq.fin.ehelper.model.vo.BeChannelConf;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author kangyonggan
 * @since 4/27/17
 */
@Service
public class BeChannelConfServiceImpl extends BaseService<BeChannelConf> implements BeChannelConfService {

    @Override
    @LogTime
    public List<BeChannelConf> findBeChannelConfByBnkNos(List<String> bnkNos) {
        Example example = new Example(BeChannelConf.class);
        example.createCriteria().andIn("bankNo", bnkNos);

        example.setOrderByClause("id desc");
        return super.selectByExample(example);
    }

    @Override
    @LogTime
    @CacheGetOrSave("channelConf:redeem")
    public List<BeChannelConf> findRedeemBeChannelConfs() {
        Example example = new Example(BeChannelConf.class);
        example.createCriteria().andEqualTo("fastCash", "01");

        example.setOrderByClause("id desc");
        return super.selectByExample(example);
    }

    @Override
    @LogTime
    @CacheGetOrSave("channelConf:pay")
    public List<BeChannelConf> findPayBeChannelConfs() {
        Example example = new Example(BeChannelConf.class);
        example.createCriteria().andEqualTo("appRecharge", "01");

        example.setOrderByClause("id desc");
        return super.selectByExample(example);
    }

    @Override
    @LogTime
    @CacheGetOrSave("channelConf:verify")
    public List<BeChannelConf> findVerifyBeChannelConfs() {
        Example example = new Example(BeChannelConf.class);
        example.createCriteria().andEqualTo("mAddCard", "01");

        example.setOrderByClause("id desc");
        return super.selectByExample(example);
    }

}
