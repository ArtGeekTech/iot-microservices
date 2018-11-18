package com.artgeektech.iotmicroservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by guang on 1:30 PM 8/26/18.
 */
@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Scheduled(fixedRate = 1000)
    public void callback() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));
        messagingTemplate.convertAndSend("/topic/mural", df.format(new Date()));
    }

    @GetMapping("/get/{msg}")
    @ResponseBody
    public String get(@PathVariable String msg) {
        return msg;
    }

    @GetMapping("/get2/{msg}")
    @ResponseBody
    public String get2(@PathVariable String msg) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("get2 " + msg + df.format(new Date()));
        messagingTemplate.convertAndSend("/topic/mural", "get2 " + msg + df.format(new Date()));
        return msg + "get2";
    }

    @MessageMapping("/message")
    @SendTo("/topic/mural")
    public String send1(String msg) throws Exception {
        return msg + "zzzzz";
    }

}
