package com.example.demo.controller;

import com.example.demo.domain.DTO.PersonDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/param")
public class ParameterTestController {
	// @RequestParam = 	HTTP 요청의 파라미터를 메소드의 파라미터와 바인딩 URL 쿼리 문자열이나 POST 요청의 form 데이터와 매핑
	// @RequestBody = HTTP 요청의 본문(body)을 메소드의 파라미터에 바인딩 주로 JSON 또는 XML 형식의 데이터를 객체로 변환할 때 사용
	@RequestMapping(value="/p01", method=RequestMethod.GET)
	public void p01(@RequestParam(value="name",required=true)String name) {
		log.info("GET /param/p01 " + name);
	
	}
	@GetMapping("/p02")
	public void p02(@RequestParam(value="name",required=true)String name) {
		log.info("GET /param/p02 " + name);
	
	}
	@PostMapping(value="/p03")
	public void p03(@RequestParam(value="name",required=true)String name) {
		log.info("GET /param/p03 " + name);
	
	}
	@PostMapping(value="/p04")
	public void p04(@RequestBody String name) {
		log.info("/param/p04" + name);
	}
	@RequestMapping(value="/p05", method=RequestMethod.GET)
	public void p05(@RequestParam(value="name",defaultValue="홍길동")String name) {
		log.info("GET /param/p05 " + name);
	
	}
	@RequestMapping(value="/p06", method=RequestMethod.GET)
	public void p06(@RequestParam(value="name")String name,
					@RequestParam(value="age")int age,
					@RequestParam(value="addr")String addr
			) {
		log.info("GET /param/p06 " + name + age + addr);
	
	}
	@RequestMapping(value="/p07",method=RequestMethod.GET)
	public void p07(@ModelAttribute PersonDTO dto) {
		log.info("GET /param/p07 " + dto);
	}
	@RequestMapping(value="/p08/{name}/{age}/{addr}",method=RequestMethod.GET)
	public void p08(@PathVariable(value="name")String name,
					@PathVariable(value="age")int age,
					@PathVariable(value="addr")String addr) {
		log.info("GET /param/p08 " + name + age + addr);
	}
	@RequestMapping(value="/p09/{name}/{age}/{addr}",method=RequestMethod.GET)
	public void p09(PersonDTO dto) {
		log.info("GET /param/p09 " + dto);
	}
	@GetMapping("/page01")
	public void page01(PersonDTO pd, Model model){
		log.info("GET /param/page01 " + pd);
		// 반환자료형이 void일때 /WEB-INF/views/param/page01.jsp와 매핑
		// 뷰 이동 + 데이터전달(Model객체 - DispatherServlet)
		model.addAttribute("pd", pd);
		model.addAttribute("test","testValue1");
	}
	@GetMapping("/page02")
	public String page02(PersonDTO pd, Model model){
		log.info("GET /param/page02 " + pd);
		// 반환자료형이 void일때 /WEB-INF/views/param/page01.jsp와 매핑
		// 위치변경시 자료형을 String으로 하여 매핑값을 리턴
		model.addAttribute("pd", pd);
		model.addAttribute("test","testValue2");
		return "param/page01";
	}
	@GetMapping("/page03/{name}/{age}/{addr}")
	public String page03(PersonDTO pd, Model model) {
		log.info("GET /param/page03" + pd);
		model.addAttribute("pd", pd);
		model.addAttribute("test","testValue3");
		return "param/page01";
	}
	@GetMapping("/page04/{name}/{age}/{addr}")
	public ModelAndView page04(PersonDTO pd) {
		log.info("GET /param/page03" + pd);
		ModelAndView mav = new ModelAndView();
		mav.addObject(pd);
		mav.addObject("test4");
		mav.setViewName("param/page01"); // 이동할페이지경로
		return mav;
	}
	
	// Servlet 방식
	@GetMapping("/page05")
	public String page05(HttpServletRequest req, HttpServletResponse resp) {
		log.info("GET /param/page05");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String addr = req.getParameter("addr");
		log.info(name+ " " + age);
		PersonDTO pd = new PersonDTO(name,age,addr);
		req.setAttribute("pd", pd);
		HttpSession session = req.getSession();
		log.info("session : " + session);
		return "param/page01";
	}
	
	// Forward
	@GetMapping("/forward1")
	public String f1(Model model) {
		log.info("param/forward1");
		model.addAttribute("f1","f1Val");
		return "forward:/param/forward2";
	}
	@GetMapping("/forward2")
	public String f2(Model model) {
		log.info("param/forward2");
		model.addAttribute("f2","f2Val");
		return "forward:/param/forward3";
	}
	@GetMapping("/forward3")
	public String f3(Model model) {
		log.info("param/forward3");
		model.addAttribute("f3","f3Val");
		return "param/forwardResult";
	}
	
	//Redirect
	@GetMapping("/redirect1")
	public String r1(Model model, RedirectAttributes ra) {
		log.info("param/redirect1");
//		model.addAttribute("r1","r1Val");
		ra.addAttribute("r1","r1Val"); // 쿼리 스트링으로 전달
		return "redirect:/param/redirect2";
	}
	@GetMapping("/redirect2")
	public String r2(Model model,
					@RequestParam("r1") String r1
	) {
		log.info("param/redirect2 r1 : " + r1);
//		model.addAttribute("r2","r2Val");
		model.addAttribute("r1",r1);
		model.addAttribute("r2","r2Val");
		return "redirect:/param/redirectResult";
	}
	@GetMapping("/redirectResult")
	public void rr(Model model,
				@RequestParam("r1") String r1,
				@RequestParam("r2") String r2,
				RedirectAttributes ra
	) {
//		model.addAttribute("r3","r3Val");
		model.addAttribute("r1",r1);
		model.addAttribute("r2",r2);
		model.addAttribute("r3","r3Val");
		log.info("param/redirectResult");
	}
}
