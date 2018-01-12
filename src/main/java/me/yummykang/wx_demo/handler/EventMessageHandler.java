package me.yummykang.wx_demo.handler;

import org.weixin4j.WeixinException;
import org.weixin4j.message.OutputMessage;
import org.weixin4j.message.event.*;
import org.weixin4j.spi.IEventMessageHandler;

import static me.yummykang.wx_demo.WxDemoApplication.weixin;

/**
 * write something to describe this file.
 *
 * @author demon
 * @date 18-1-11 下午1:45
 */
public class EventMessageHandler implements IEventMessageHandler {

    @Override
    public OutputMessage subscribe(SubscribeEventMessage msg) {
        try {
            System.out.println(weixin.getUserInfo(msg.getFromUserName()));
        } catch (WeixinException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OutputMessage unSubscribe(UnSubscribeEventMessage msg) {
        try {
            System.out.println(weixin.getUserInfo(msg.getFromUserName()));
        } catch (WeixinException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OutputMessage qrsceneSubscribe(QrsceneSubscribeEventMessage msg) {
        return null;
    }

    @Override
    public OutputMessage qrsceneScan(QrsceneScanEventMessage msg) {
        return null;
    }

    @Override
    public OutputMessage location(LocationEventMessage msg) {
        return null;
    }

    @Override
    public OutputMessage click(ClickEventMessage msg) {
        return null;
    }

    @Override
    public OutputMessage view(ViewEventMessage msg) {
        return null;
    }

    @Override
    public OutputMessage scanCodePush(ScanCodePushEventMessage msg) {
        return null;
    }

    @Override
    public OutputMessage scanCodeWaitMsg(ScanCodeWaitMsgEventMessage msg) {
        return null;
    }

    @Override
    public OutputMessage picSysPhoto(PicSysPhotoEventMessage msg) {
        return null;
    }

    @Override
    public OutputMessage picPhotoOrAlbum(PicPhotoOrAlbumEventMessage msg) {
        return null;
    }

    @Override
    public OutputMessage picWeixin(PicWeixinEventMessage msg) {
        return null;
    }

    @Override
    public OutputMessage locationSelect(LocationSelectEventMessage msg) {
        return null;
    }
}
