//package com.example.myalvin.controller;
//
//import com.example.myalvin.service.AlarmService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("alarm")
//public class AlarmController {
//
//
//    @Autowired
//    private AlarmService alarmService;
//
//    @GetMapping("/alarm/getalarm/{user_id}")
//    public String update_alarm(@PathVariable(name = "user_id") Long user_id) {
//
//        return alarmService.update_alarm();
//    }
//
//    @PostMapping("/alarm/create_alarm")
//    public String create_alarm() {
//
//        return alarmService.create_alarm();
//    }
//
//    @GetMapping("/alarm/alarms/{user_id}")
//    public String allalarms() {
//
//        return alarmService.allalarms();
//    }
//
//    @DeleteMapping("/alarm/delete/{user_id}")
//    public void delete_alarm(@PathVariable(name = "user_id") Long user_id) {
//
//        alarmService.delete_alarm();
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
//}
