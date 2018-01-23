package cn.wsn331.om.client.controller;

import cn.wsn331.om.console.common.Constants;
import cn.wsn331.om.console.service.DeviceService;
import cn.wsn331.om.console.service.UserService;
import cn.wsn331.om.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import shit.helper.ShitJSONHelper;
import shit.helper.ShitReflectException;
import shit.helper.ShitReflectHelper;
import shit.helper.json.ShitJSONObject;
import shit.helper.json.netsf.ShitJSONObjectByNetSf;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GongTengPangYi
 */
@RequestMapping("/device")
@Controller
public class DeviceController extends CommonController {

    static Map<String, Class<? extends Entity>> entityMap = new HashMap<>();

    static {
        entityMap.put("airQuality", AirQuality.class);
        entityMap.put("uDisk", UDisk.class);
        entityMap.put("waterQuality", WaterQuality.class);
        entityMap.put("formaldehyde", Formaldehyde.class);
        entityMap.put("frame", Frame.class);
    }

    @Autowired
    UserService userService;

    @Autowired
    DeviceService deviceService;

    /**
     * 接收模块的数据
     * @param token
     * @param userId
     * @param data
     * @return
     */
    @RequestMapping("/sendData")
    @ResponseBody
    public String sendData(@RequestParam("accessToken") String token, @RequestParam("userId") Integer userId,
                                @RequestParam("data") String data) {
        ShitJSONObject<?> jobj = new ShitJSONObjectByNetSf();
        int sendDataResult = 1; // 0为成功，1为失败
        if (isTokenTrue(userId, token)) {
            /**
             * 判断token正确性，如果正确就把data变为json
             */
            ShitJSONObject<?> jsonData = ShitJSONHelper.fromObject(data, "*");
            SimpleDateFormat format = new SimpleDateFormat(Constants.DATETIME_FORMAT_NOSPACE);
            for (String key : jsonData.keySet()) {
                /**
                 * 遍历所有类型的模块
                 */
                ShitJSONObject<?> jsonEntity = jsonData.getJSONObject(key);
                try {
                    /**
                     * 先把createTime的格式转变过来
                     */
                    jsonEntity.put("createTime", format.parse((String) jsonEntity.get("createTime")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(jsonEntity);
                /**
                 * 做出统一的转变成为java类
                 */
                Entity entity = (Entity) jsonEntity.toBean(entityMap.get(key));
                try {
                    ShitReflectHelper.setValue(entity, "userId", String.valueOf(userId), false);
                } catch (ShitReflectException e) {
                    e.printStackTrace();
                }
                System.out.println(entity);
                deviceService.insertDeviceData(key, entity);
            }
            sendDataResult = 0;
        }
        jobj.put("sendDataResult", sendDataResult);
        return jobj.toString();
    }

}
