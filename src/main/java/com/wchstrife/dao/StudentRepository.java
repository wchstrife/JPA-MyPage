package com.wchstrife.dao;

import com.wchstrife.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ASUS on 2017/11/9.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, String>{

}
