package dorm.system.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dorm.system.dao.StudentDao;
import dorm.system.entity.Student;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
@Repository
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {	

}
