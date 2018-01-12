package me.yummykang.wx_demo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.yummykang.wx_demo.model.robot.Message2Bot;
import me.yummykang.wx_demo.model.robot.MessageFromBot;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * write something to describe this file.
 *
 * @author demon
 * @date 18-1-11 下午2:07
 */
public class HttpUtils {
    public static ContentType DEFAULT_TYPE = ContentType.APPLICATION_JSON;

    public static void doPost(String url, String body, ContentType contentType) throws IOException {
        Content content = Request.Post(url).bodyString(body, contentType).execute().returnContent();
        System.out.println(content.asString(Charset.forName("UTF-8")));
    }

    public static String doPost(String url, String body) throws IOException {
        Content content = Request.Post(url).bodyString(body, DEFAULT_TYPE).execute().returnContent();
        return content.asString(Charset.forName("UTF-8"));
    }

    public static String doGet(String url, Map<String ,String> params) throws IOException {
        StringBuilder urlBuilder = new StringBuilder(url + "?");
        for (Map.Entry entry : params.entrySet()) {
            urlBuilder.append("&" + entry.getKey() + "=" + entry.getValue());
        }
        Content content = Request.Get(urlBuilder.toString()).execute().returnContent();
        return content.asString(Charset.forName("UTF-8"));
    }

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Message2Bot msg = new Message2Bot();
        msg.setInfo("你叫什么名字");
        msg.setKey("747e7b028c534f7795902c841c7be48d");
        try {
            String result = doPost("http://www.tuling123.com/openapi/api", mapper.writeValueAsString(msg));
            MessageFromBot messageFromBot = mapper.readValue(result, MessageFromBot.class);
            System.out.println(messageFromBot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
