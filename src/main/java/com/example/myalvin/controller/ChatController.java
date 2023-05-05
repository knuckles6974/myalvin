package com.example.myalvin.controller;


import com.example.myalvin.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat/")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/chat/{user_id}") //접속
    public String chatRoom(@PathVariable(name = "user_id") Long user_id) {

        return chatService.chatroom();

    }

    @GetMapping("/chat/onetoone/{user_id}") //일대일 채팅
    public String userChat(@PathVariable(name = "user_id") Long user_id) {

        return chatService.userchat();
    }

    @GetMapping("/chat/group/{user_id}")  //그룹채팅
    public String groupChat(@PathVariable(name = "user_id") Long user_id) {

        return chatService.groupchat();
    }

    @PostMapping()
    public String send_OneToOne_Chat() {

        return chatService.send_OneToOne_Chat();


    }










}
