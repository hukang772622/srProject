package send.service.serviceImpl;

import damain.Message;
import dao.Insert;
import dao.daoImpl.InsertImpl;
import org.apache.commons.io.IOUtils;
import send.service.SendMessage;
import utils.InsertUtil;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.List;

/**
 * 发送信息
 */
public class SendMessageImpl implements SendMessage {
    private Insert insert = new InsertImpl();
    @Override
    public void sendMessage(List<Message> messageList) {
       insert.insert(messageList);
    }
}
