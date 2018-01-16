package cn.wsn331.om.console.service;

import cn.wsn331.om.model.Config;
import shit.ssm1.mybatis.BaseService;

/**
 * @author GongTengPangYi
 */
public interface ConfigService extends BaseService<Config, Integer> {

    /**
     *
     * @param key
     * @return
     */
    Config findByKey(String key);
}
