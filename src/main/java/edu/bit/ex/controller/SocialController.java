package edu.bit.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.bit.ex.service.KakaoServiceImpl;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class SocialController {
    
    @Autowired
    private KakaoServiceImpl kakaoService;

    @GetMapping("/social")
    public String home(Model model) {
       log.info("social..");
       model.addAttribute("kakaoUrl", kakaoService.getAuthorizationUrl());
       
       return "social/login";
    }

    @GetMapping("/auth/kakao/callback")   
    public String kakaoCallback(String code,Model model) {
       log.info("kakaoCallback ..");
       //이제 부터 스프링 서버와  외부 카카오 서버와 POST 통신을 해야함.
       
       KakaoAuth kakaoAuth = kakaoService.getKakaoTokenInfo(code);
       KakaoProfile profile= kakaoService.getKakaoProfile(kakaoAuth.getAccess_token());
       model.addAttribute("user", profile);
       
             
       //user.kakao_account.profile.nickname
       return "social/social_home";
    }   
