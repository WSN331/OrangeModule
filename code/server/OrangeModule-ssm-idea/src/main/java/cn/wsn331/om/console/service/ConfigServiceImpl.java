package cn.wsn331.om.console.service;

import cn.wsn331.om.console.mapper.ConfigMapper;
import cn.wsn331.om.model.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shit.ssm1.mybatis.BaseMapper;
import shit.ssm1.mybatis.BaseServiceImpl;

/**
 * @author GongTengPangYi
 */
@Service("configService")
public class ConfigServiceImpl extends BaseServiceImpl<Config, Integer> implements ConfigService{

    @Autowired
    ConfigMapper configMapper;

    @Override
    public Config findByKey(String key) {
        return configMapper.selectByKey(key);
    }

    @Override
    public BaseMapper<Config, Integer> getMapper() {
        return configMapper;
    }
}
