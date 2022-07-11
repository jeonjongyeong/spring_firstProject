package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "종영형");
        return "greetings"; // templates/greetings.mustache 파일을 찾아서 브라우저로 전송
    }

    @GetMapping("/bye")
    public String seeYou(Model model) {
        model.addAttribute("nickname", "종영");
        return "goodbye";
    }
}
