package cn.wsn331.om.console.mapper;

import cn.wsn331.om.model.UserDevice;
import shit.ssm1.mybatis.BaseMapper;

public interface UserDeviceMapper extends BaseMapper<UserDevice, Integer> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_device
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_device
     *
     * @mbggenerated
     */
    int insert(UserDevice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_device
     *
     * @mbggenerated
     */
    int insertSelective(UserDevice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_device
     *
     * @mbggenerated
     */
    UserDevice selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_device
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserDevice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_device
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserDevice record);
}