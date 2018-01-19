package cn.wsn331.om.client.controller;

import cn.wsn331.om.console.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import shit.helper.ShitJSONHelper;
import shit.helper.json.ShitJSONObject;
import shit.helper.json.netsf.ShitJSONObjectByNetSf;

/**
 * @author GongTengPangYi
 */
@RequestMapping("/trade")
@Controller
public class TradeController extends CommonController {

    @Autowired
    TradeService tradeService;

    @RequestMapping("/getTradeList")
    @ResponseBody
    public String getTradeList(@RequestParam("pageIndex")Integer pageIndex) {
        ShitJSONObject<?> jobj = new ShitJSONObjectByNetSf();
        int tradeListResult = -1; // 0为成功，1为失败
        jobj.put("tradeList", ShitJSONHelper.fromList(tradeService.findByPage(pageIndex), "* !state"));
        jobj.put("tradeListResult", tradeListResult);
        return jobj.toString();
    }

}
