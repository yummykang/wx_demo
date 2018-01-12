package me.yummykang.wx_demo.controller;

import me.yummykang.wx_demo.config.ExtraConfiguration;
import me.yummykang.wx_demo.utils.EncodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.weixin4j.WeixinException;
import org.weixin4j.pay.JsApiTicket;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static me.yummykang.wx_demo.WxDemoApplication.weixin;

/**
 * write something to describe this file.
 *
 * @author demon
 * @date 18-1-12 上午11:01
 */
@Controller
@RequestMapping("/scanCode")
public class ScanCodeController {
    @GetMapping
    public String scanCode(Model model) throws WeixinException {
        model.addAllAttributes(sign(getTicket().getTicket(), ExtraConfiguration.getScanCodeUrl()));
        model.addAttribute("appId", ExtraConfiguration.getOAuthAppId());
        return "index";
    }

    private JsApiTicket getTicket() throws WeixinException {
        return weixin.getJsApi_Ticket();
    }

    public static Map<String, String> sign(String jsapi_ticket, String url) {
        Map<String, String> ret = new HashMap<>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;
        System.out.println(string1);
        String signature = EncodeUtils.encodeSha1(string1);
        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
