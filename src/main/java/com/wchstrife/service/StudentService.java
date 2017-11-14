package com.wchstrife.service;

import com.wchstrife.dao.StudentRepository;
import com.wchstrife.entity.Student;
import com.wchstrife.util.PageUtil;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ASUS on 2017/11/9.
 */
@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	@PersistenceContext
	EntityManager em;

	/**
	 * 查询所有的学生
	 * @return
	 */
	public List<Student> findAllStudent(){

		return studentRepository.findAll();
	}


	/**
	 * 分页获取所有的学生
	 * @param size
	 * @param page
	 * @return
	 */
	public Page<Student> findAllStudentByPage(int page, int size){

		PageRequest pageRequest = new PageRequest(page, size);

		return studentRepository.findAll(pageRequest);
	}

	/**
	 * 自定义分页获取所有学生
	 * @param page
	 * @param size
	 */
	public PageUtil findAllStudentByMypage(int page, int size){

		/*分页查询数据*/
		Query query = em.createNativeQuery("SELECT * FROM student s LIMIT " + page*size + "," + size);
		List<Student> studentList = query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();

		/*查询总共的数据条目*/
		query = em.createNativeQuery("SELECT COUNT(*) FROM student");
		Object object = query.getResultList().get(0);
		int totalElements = Integer.parseInt(object.toString());

		/*构建自定义Page对象*/
		PageUtil pageUtil = new PageUtil(size, page, totalElements);
		pageUtil.setNumberOfElements(studentList.size());
		pageUtil.setContent(studentList);

		return pageUtil;
	}

}
