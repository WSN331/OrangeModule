package cn.wsn331.om.console.service;

import cn.wsn331.om.console.mapper.*;
import cn.wsn331.om.model.Device;
import cn.wsn331.om.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shit.helper.ShitReflectException;
import shit.helper.ShitReflectHelper;
import shit.ssm1.mybatis.BaseMapper;
import shit.ssm1.mybatis.BaseServiceImpl;
import shit.ssm1.spring.ToolSpring;


/**
 * @author GongTengPangYi
 */
@Service("deviceService")
public class DeviceServiceImpl extends BaseServiceImpl<Device, Integer> implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public Device findByCode(String code) {
        return deviceMapper.selectByCode(code);
    }

    @Override
    public BaseMapper<Device, Integer> getMapper() {
        return deviceMapper;
    }

    private BaseMapper getDeviceEntityMapper(String code) {
        String mapperName = code + "Mapper";
        return (BaseMapper) ToolSpring.getBean(mapperName);
    }

    @Override
    public void insertDeviceData(String code, Entity entity) {
        Device device = findByCode(code);
        try {
            ShitReflectHelper.setValue(entity, "deviceId", String.valueOf(device.getId()), true);
        } catch (ShitReflectException e) {
            e.printStackTrace();
        }
        getDeviceEntityMapper(code).insert(entity);
    }
}
