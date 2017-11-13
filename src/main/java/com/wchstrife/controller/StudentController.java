package com.wchstrife.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wchstrife.entity.Student;
import com.wchstrife.service.StudentService;
import com.wchstrife.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ASUS on 2017/11/9.
 */
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/get/jpaPage")
	public JSONObject getAllByPage(HttpServletRequest request, HttpServletResponse response, @RequestParam("page") int page, @RequestParam("size") int size){

		Page<Student> studentPage =  studentService.findAllStudentByPage(page, size);

		JSONObject jsonObject = (JSONObject) JSON.toJSON(studentPage);

		return jsonObject;
	}


	@GetMapping("/get/myPage")
	public JSONObject getAllByMyPage(HttpServletRequest request, HttpServletResponse response, @RequestParam("page") int page, @RequestParam("size") int size){
		PageUtil pageUtil = studentService.findAllStudentByMypage(page, size);

		JSONObject jsonObject = (JSONObject) JSON.toJSON(pageUtil);

		return jsonObject;
	}

}
