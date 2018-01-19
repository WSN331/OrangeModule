package cn.wsn331.om.console.service;

import cn.wsn331.om.model.Trade;
import shit.ssm1.mybatis.BaseService;

import java.util.List;

/**
 * @author GongTengPangYi
 */
public interface TradeService extends BaseService<Trade, Integer> {

    List<Trade> findByPage(int pageIndex);
}
