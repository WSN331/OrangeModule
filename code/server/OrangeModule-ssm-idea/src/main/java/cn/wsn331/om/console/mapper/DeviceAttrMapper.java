package cn.wsn331.om.console.mapper;

import cn.wsn331.om.model.DeviceAttr;
import shit.ssm1.mybatis.BaseMapper;

public interface DeviceAttrMapper extends BaseMapper<DeviceAttr, Integer> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_device_attr
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_device_attr
     *
     * @mbggenerated
     */
    int insert(DeviceAttr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_device_attr
     *
     * @mbggenerated
     */
    int insertSelective(DeviceAttr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_device_attr
     *
     * @mbggenerated
     */
    DeviceAttr selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_device_attr
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DeviceAttr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_device_attr
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DeviceAttr record);
}