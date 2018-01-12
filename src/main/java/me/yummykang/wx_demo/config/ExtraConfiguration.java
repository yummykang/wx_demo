package me.yummykang.wx_demo.config;

import org.weixin4j.Configuration;

/**
 * write something to describe this file.
 *
 * @author demon
 * @date 18-1-11 下午3:07
 */
public class ExtraConfiguration extends Configuration {
    private static String ROBOT_API_URL = "robot.api.url";

    private static String JS_TICKET_URL = "js_ticket.url";

    private static String SCAN_CODE_URL = "scan_code.url";

    public static String getRobotApiUrl() {
        return getProperty(ROBOT_API_URL);
    }

    public static String getJsTicketUrl() {
        return getProperty(JS_TICKET_URL);
    }

    public static String getScanCodeUrl() {
        return getProperty(SCAN_CODE_URL);
    }

}
