//package com.example.myalvin.controller.chat;
//
//
//import com.example.myalvin.config.message.ChatResponse;
//import com.example.myalvin.domain.entity.Chat;
//import com.example.myalvin.service.ChatService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/chat/") //일대일 채팅
//public class OnetoOneChatController {
//
//    @Autowired
//    private ChatService chatService;
//
//    @GetMapping("/chat/{user_id}") //접속
//    public String chatRooms(@PathVariable(name = "user_id") Long user_id) {
//
//        return chatService.chatrooms();
//
//    }
//
//    @GetMapping("/chat/room_id") //채팅입장
//    public String userChat() {
//
//        return chatService.userchat();
//    }
//
//    @PostMapping("/chat/send/room_id")  //메세지전송
//    public Chat send_Chat(@RequestBody sendchat request, ChatResult chatResult) {
//
//        //validator 처리
//
//        return chatService.send_Chat(request, chatResult);
//
//    }
//
//    @DeleteMapping("/chat/delete/room_id/{chat_id}") // 메세지 하나를 삭제
//    public ChatResponse delete_Chat(@PathVariable(name = "user_id") Long user_id) {
//
//        chatService.delete_Chat();
//        return ChatResponse.delSuccess();
//
//    }
//
//    @GetMapping("/chat/receive/all") //자신이 받은 메세지 목록
//    public PageResponse<Chat> receivedoChat(@ModelAttribute  PageResponse request) {
//
//        List<Chat> result = chatService.receivedoChat(request);
//        return PageResponse.onetoonereceivelist(result);
//    }
//
//    @GetMapping("/chat/sent/all")//자신이 보낸 메세지목록
//    public PageSent<Chat> sentoChat(@ModelAttribute PageSent sent) {
//
//        List<Chat> result = chatService.sentoChat(sent);
//        return PageSent.onetoonesentlist(result);
//
//    }
//
//    @GetMapping("/chat/room")
//    public List<PersonalChatRoom> mychatroomlist() {
//
//        return chatService.mychatroomlist();
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
