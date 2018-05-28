package dao;

import damain.Message;

import java.util.List;

/**
 * 发送消息
 */
public interface Insert {

    /**
     *
     */
    void insert(List<Message> listMessages);
}
