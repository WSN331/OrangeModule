package cn.wsn331.om.console.mapper;

import cn.wsn331.om.model.TradeOrderSingle;
import shit.ssm1.mybatis.BaseMapper;

public interface TradeOrderSingleMapper extends BaseMapper<TradeOrderSingle, Integer> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_trade_order_single
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_trade_order_single
     *
     * @mbggenerated
     */
    int insert(TradeOrderSingle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_trade_order_single
     *
     * @mbggenerated
     */
    int insertSelective(TradeOrderSingle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_trade_order_single
     *
     * @mbggenerated
     */
    TradeOrderSingle selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_trade_order_single
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TradeOrderSingle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_trade_order_single
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TradeOrderSingle record);
}