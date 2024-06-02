package com.thlong.event;

import com.thlong.model.Model_Receive_Message;
import com.thlong.model.Model_Send_Message;

public interface EventChat {

    public void sendMessage(Model_Send_Message data);

    public void receiveMessage(Model_Receive_Message data);
}
