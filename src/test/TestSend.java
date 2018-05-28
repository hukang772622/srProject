package test;

import damain.Message;
import send.service.SendMessage;
import send.service.serviceImpl.SendMessageImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */
public class TestSend {
    private static SendMessage sendMessage = new SendMessageImpl();

    public static void main(String[] args) {
        List<Message> messageList = new ArrayList<>();
        Message message1 = new Message();
        message1.setMessage("再来试一次");
        message1.setMobile("13913167747");
        message1.setPort(18);
        message1.setTime(30000);
        messageList.add(message1);
        Message message2 = new Message();
        message2.setMessage("再来试一次");
        message2.setMobile("18012623998");
        message2.setPort(18);
        message2.setTime(30000);
        messageList.add(message2);
        sendMessage.sendMessage(messageList);
    }
}
