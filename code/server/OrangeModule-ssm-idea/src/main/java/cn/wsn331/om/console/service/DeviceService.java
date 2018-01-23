package cn.wsn331.om.console.service;

import cn.wsn331.om.model.Device;
import cn.wsn331.om.model.Entity;
import shit.ssm1.mybatis.BaseService;

/**
 * @author GongTengPangYi
 */

public interface DeviceService extends BaseService<Device, Integer> {

    Device findByCode(String code);

    void insertDeviceData(String code, Entity entity);
}
