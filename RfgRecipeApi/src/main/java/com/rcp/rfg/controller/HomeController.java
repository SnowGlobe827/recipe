package com.rcp.rfg.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rcp.rfg.jpa.entity.UserEntity;
import com.rcp.rfg.jpa.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

	private final UserService service;
	
	@GetMapping("/")
	public String home() {
		return "hello";
	}
	
	@GetMapping("/move")
	public String move() {
		return "NewFile";
	}
	
	@GetMapping("/login")
	public String showLoginPage(@RequestParam(value = "error", required = false) String error, Model model) {
	    if (error != null) {
	        model.addAttribute("errorMessage", "아이디 또는 비밀번호가 잘못되었습니다.");
	    }
	    return "hello";
	}
	
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password, RedirectAttributes redirectAttributes) {
		log.info("접속 시도 아이디 : {}", username);
		log.info("접속 시도 비밀번호 : {}", password);
		Optional<UserEntity> userOpt = service.findByUsername(username);
		
		if(userOpt.isPresent()) {
			UserEntity user = userOpt.get();
			
			if(user.getPassword().equals(password)) {
				redirectAttributes.addFlashAttribute("username", user.getUsername());
				redirectAttributes.addFlashAttribute("nickname", user.getNickname());
				return "redirect:/mainpage";
			}else {
				return "redirect:/login?error=true";
			}
		}else {			
			return "redirect:/login?error=true";
		}
	}
	
	@GetMapping("/mainpage")
	public String mainpage(Model model) {
		return "mainpage";
	}
	
}
