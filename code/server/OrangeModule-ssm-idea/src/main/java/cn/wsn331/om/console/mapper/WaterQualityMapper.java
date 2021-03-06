package cn.wsn331.om.console.mapper;

import cn.wsn331.om.model.WaterQuality;
import shit.ssm1.mybatis.BaseMapper;

public interface WaterQualityMapper extends BaseMapper<WaterQuality, Integer> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_water_quality
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_water_quality
     *
     * @mbggenerated
     */
    int insert(WaterQuality record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_water_quality
     *
     * @mbggenerated
     */
    int insertSelective(WaterQuality record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_water_quality
     *
     * @mbggenerated
     */
    WaterQuality selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_water_quality
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WaterQuality record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_water_quality
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WaterQuality record);
}