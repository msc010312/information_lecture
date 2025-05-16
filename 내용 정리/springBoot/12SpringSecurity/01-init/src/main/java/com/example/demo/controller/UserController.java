package com.example.demo.controller;

import com.example.demo.domain.dto.UserDto;
import com.example.demo.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

//	@GetMapping("/user")
//	public void user(@AuthenticationPrincipal PrincipalDetails principalDetails) {
//		log.info("get /user " + principalDetails);
////		log.info("name " + authentication.getName());
////		log.info("getPrincipal " + authentication.getPrincipal());
////		log.info("Authorities " + authentication.getAuthorities());
////		log.info("Details " + authentication.getDetails());
////		log.info("Credential " + authentication.getCredentials());
//	}
	
	@GetMapping("/user")
	public void user(Model model) {
		log.info("get /user");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		log.info("authentication : " + authentication);
		model.addAttribute("auth",authentication);
	}
	
	@GetMapping("/manager")
	public void manager() {
		log.info("get /manager");
	}
	
	@GetMapping("/admin")
	public void admin() {
		log.info("get /admin");
	}

	@GetMapping("/login")
	public void login() {
		log.info("get /login");
	}
	
	@GetMapping("/join")
	public void join() {
		log.info("GET /join..");
	}
	@PostMapping("/join")
	public String join_post(UserDto dto, RedirectAttributes redirectAttributes) {
		log.info("POST /join.." + dto);
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		userRepository.save(dto.toEntity());
		boolean isJoin = true;
		if(isJoin) {
			redirectAttributes.addFlashAttribute("message","회원가입완료");
			return "redirect:/login";
		} else {
			return "join";
		}
	}
}



