package com.my.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.service.QNAService;
import com.my.vo.PageGroupBean;
import com.my.vo.QNA;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class QNAController {
	
	@Autowired
	private QNAService service;
	
	@GetMapping(value= {"/qna/list",
						"/qna/list/{currentPage}"})
	public Map<String, Object> list(@PathVariable("currentPage")Optional<Integer> optCurrentPage) throws Exception{
		
		int currentPage = 1;
		int cnt_per_page = 10;
		int totalCnt = service.findCnt();
		
		List<QNA> list = null;
		Map<String, Object> map = new HashMap<>();
		PageGroupBean<QNA> pgb = null;
		
		if(optCurrentPage.isPresent()) {
			currentPage = optCurrentPage.get();
		}
		list = service.findPerPage(currentPage, cnt_per_page);
		pgb = new PageGroupBean<>(totalCnt, currentPage, list);
		
		log.debug(pgb);
		map.put("pgb", pgb);
		map.put("status", 1);
		
		return map;
	}
	
	@GetMapping(value={"/qna/myList",
					   "/qna/myList/{currentPage}"})
	public Map<String, Object> myList(HttpSession session, 
									  @PathVariable("currentPage")Optional<Integer> optCurrentPage)throws Exception{
		
		int student_id = 0;
		int currentPage = 1;
		int cnt_per_page = 10;
		int totalCnt = service.findCnt();
		
		List<QNA> list = null;		
		Map<String, Object>map = new HashMap<>();
		PageGroupBean<QNA> pgb = null;
		
		if(optCurrentPage.isPresent()) {
			currentPage = optCurrentPage.get();
		}
		Integer wrapperStudent_id = (Integer)session.getAttribute("loginInfo");
		if(wrapperStudent_id != null) {
			student_id = wrapperStudent_id;
			
			list = service.findByStudentIdPerPage(student_id, currentPage, cnt_per_page);
			pgb = new PageGroupBean<>(totalCnt, currentPage, list);
			log.debug(pgb);
			map.put("pgb", pgb);
			map.put("status", 1);
		}else {
			log.debug("로그인 안 함");
			map.put("status", 0);
		}
		return map;
	}
	
	@GetMapping(value= {"/admin/qna/list",
						"/admin/qna/list/{currentPage}", 
						"/admin/qna/list/{currentPage}/{word}"})
	public Map<String, Object> adminList(@PathVariable ("currentPage")Optional<Integer> optCurrentPage,
										@PathVariable("word")Optional<String> optWord)throws Exception{
		int currentPage = 1;
		int cnt_per_page = 10;
		int totalCnt = service.findCnt();
		String word = null;
		
		List<QNA> list = null;
		Map<String, Object> map = new HashMap<>();
		PageGroupBean<QNA> pgb = null;
		
		if(optCurrentPage.isPresent()) {
			currentPage = optCurrentPage.get();
		}
		
		if(optWord.isPresent()) {
			word = optWord.get();
			list = service.findByNameOrTitleOrContentPerPage(word, currentPage, cnt_per_page);
		}else {
			list = service.findPerPage(currentPage, cnt_per_page);
		}
		pgb = new PageGroupBean<>(totalCnt, currentPage, list);
		log.debug(pgb);
		map.put("pgb", pgb);
		map.put("status", 1);
		
		return map;
	}

	@GetMapping("/qna/{qna_id}")
	public Map<String, Object> detail (HttpSession session,
									   @PathVariable int qna_id) throws Exception{
		Map<String, Object> map = new HashMap<>();
		int student_id = 0;
		
		Integer wrapperStudentId = (Integer)session.getAttribute("loginInfo");
		if(wrapperStudentId != null) {
			student_id = wrapperStudentId;
			
			//service.findById(qna_id, student);
			QNA qna = service.findById(qna_id);
			log.debug(qna);
			map.put("qna", qna);
			map.put("status", 1);
		}else {
			log.debug("로그인안함");
			map.put("status", 0);
		}
		return map;
	}
	
	@GetMapping("/admin/qna/{qna_id}")
	public Map<String, Object> adminDetail(@PathVariable int qna_id) throws Exception{
		Map<String, Object> map = new HashMap<>();
		QNA qna = service.findById(qna_id);
		log.debug(qna);
		map.put("qna", qna);
		map.put("status", 1);
		return map;
	}
	
	@PostMapping("/qna/write")
	public Map<String, Object> write(@RequestBody QNA qna) throws Exception{
		Map<String, Object> map = new HashMap<>();
		service.add(qna);
		log.debug(qna);
		map.put("status", 1);
		return map;
	}
	
}