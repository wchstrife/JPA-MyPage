package com.wchstrife.service;

import com.wchstrife.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ASUS on 2017/11/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

	@Autowired
	StudentService studentService;

	@Test
	public void testFindAllStudent() throws Exception {
		List<Student> studentList = studentService.findAllStudent();
		System.out.println(studentList);
	}

	@Test
	public void testFindAllStudentByPage() throws Exception {
		Page<Student> studentPage = studentService.findAllStudentByPage(0, 2);
		System.out.println(studentPage.getSize());
	}
}