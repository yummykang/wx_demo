package me.yummykang.wx_demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * write something to describe this file.
 *
 * @author demon
 * @date 18-1-11 下午2:39
 */
public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 将对象转换成json字符串
     * @param data
     * @return
     */
    public static String toJSONString(Object data) {
        try {
            String string = mapper.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T> T parseObject(String jsonData, Class<T> beanType) {
        try {
            T t = mapper.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
