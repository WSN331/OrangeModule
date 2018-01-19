package cn.wsn331.om.console.service;

import cn.wsn331.om.console.mapper.TradeMapper;
import cn.wsn331.om.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shit.ssm1.mybatis.BaseMapper;
import shit.ssm1.mybatis.BaseServiceImpl;

import java.util.List;

/**
 * @author GongTengPangYi
 */
@Service("tradeService")
public class TradeServiceImpl extends BaseServiceImpl<Trade,Integer> implements TradeService {

    @Autowired
    TradeMapper tradeMapper;

    @Override
    public List<Trade> findByPage(int pageIndex) {
        int limit = 10;
        return tradeMapper.selectByPage((pageIndex - 1) * limit, limit);
    }

    @Override
    public BaseMapper<Trade, Integer> getMapper() {
        return tradeMapper;
    }
}
