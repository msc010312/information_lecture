package com.example.app.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.domain.dto.MemoDto;
import com.example.app.domain.service.MemoServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/rest/memo")
public class MemoRestController {

	@Autowired
	private MemoServiceImpl memoService;
	
	//메모확인전체
		@GetMapping(value="/getAll",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<MemoDto> getAll() {
			log.info("GET /memo/getAll");
			return memoService.getAllMemo();
		}
		
		//메모확인(단건)
		@GetMapping(value="/get/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ResponseEntity get(@PathVariable int id) {
			log.info("GET /memo/get... "+id);
			MemoDto dto = memoService.getMemo(id);
			return new ResponseEntity(null, HttpStatus.OK);
		}
		

		//메모쓰기
		@GetMapping("/add")	//http://localhost:8080/app/rest/memo/post
		public void add_get(MemoDto dto) {
			log.info("GET /memo/add_rest_get.."+dto);
			memoService.registrationMemo(dto);
		}
		//메모쓰기
		@PostMapping("/post")	//http://localhost:8080/app/memo/add
		public void add(@RequestBody MemoDto dto) {
			log.info("POST /memo/add_rest_post.."+dto);
			memoService.registrationMemo(dto);
		}
		
		//메모수정
		@PutMapping("/put/{id}/{text}")
		public void put(MemoDto dto) {
			log.info("PUT /memo/put.."+dto);
			memoService.modifyMemo(dto);
		}
		
		@PutMapping("/put2")	//http://localhost:8080/app/memo/put2
		public void put2(@RequestBody MemoDto dto) {
			log.info("PUT /memo/put2.."+dto);
			memoService.modifyMemo(dto);
		}
		
		@PatchMapping("/patch/{id}/{text}")
		public void patch(MemoDto dto) {
			log.info("PATCH /memo/patch.."+dto);
		}
		//메모삭제
		@DeleteMapping("/remove/{id}")	//http://localhost:8080/app/memo/remove/{id}
		public void remove(@PathVariable int id) {
			log.info("DELETE /memo/remove.."+id);
			memoService.removeMemo(id);
		}
}
