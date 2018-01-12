package me.yummykang.wx_demo.handler;

import me.yummykang.wx_demo.config.ExtraConfiguration;
import me.yummykang.wx_demo.model.robot.Message2Bot;
import me.yummykang.wx_demo.model.robot.MessageFromBot;
import me.yummykang.wx_demo.utils.HttpUtils;
import me.yummykang.wx_demo.utils.JsonUtils;
import org.weixin4j.message.OutputMessage;
import org.weixin4j.message.normal.*;
import org.weixin4j.message.output.TextOutputMessage;
import org.weixin4j.spi.INormalMessageHandler;

import java.io.IOException;
import java.util.Date;

/**
 * write something to describe this file.
 *
 * @author demon
 * @date 18-1-11 下午1:12
 */
public class RobotMessageHandler implements INormalMessageHandler {

    @Override
    public OutputMessage textTypeMsg(TextInputMessage msg) {
        TextOutputMessage outputMessage = new TextOutputMessage();
        outputMessage.setCreateTime(new Date().getTime());
        outputMessage.setFromUserName(msg.getToUserName());
        outputMessage.setToUserName(msg.getFromUserName());
        outputMessage.setContent(msg.getContent());
        // 组装信息发到机器人
        Message2Bot message2Bot = new Message2Bot();
        message2Bot.setInfo(msg.getContent());
        message2Bot.setUserid(msg.getFromUserName());
        try {
            String result = HttpUtils.doPost(ExtraConfiguration.getRobotApiUrl(), JsonUtils.toJSONString(message2Bot));
            MessageFromBot messageFromBot = JsonUtils.parseObject(result, MessageFromBot.class);
            outputMessage.setContent(messageFromBot.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputMessage;
    }

    @Override
    public OutputMessage imageTypeMsg(ImageInputMessage msg) {
        return null;
    }

    @Override
    public OutputMessage voiceTypeMsg(VoiceInputMessage msg) {
        return null;
    }

    @Override
    public OutputMessage videoTypeMsg(VideoInputMessage msg) {
        return null;
    }

    @Override
    public OutputMessage shortvideoTypeMsg(ShortVideoInputMessage msg) {
        return null;
    }

    @Override
    public OutputMessage locationTypeMsg(LocationInputMessage msg) {
        return null;
    }

    @Override
    public OutputMessage linkTypeMsg(LinkInputMessage msg) {
        return null;
    }
}
