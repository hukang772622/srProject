package send.service;

import damain.Message;

import java.util.List;

/**
 * 发送信息
 */
public interface SendMessage {

    /**
     * 发送短信
     * @param messageList
     */
    void sendMessage (List<Message> messageList);
}
