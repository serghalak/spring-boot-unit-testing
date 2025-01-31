package com.luv2code.springmvc.servcie;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class StudentAndGradeService {

    @Autowired
    private StudentDao studentDao;

    public void createStudent(String firstName, String lastName, String emailAddress) {
        CollegeStudent student = new CollegeStudent(firstName, lastName, emailAddress);
        student.setId(0);
        studentDao.save(student);
    }

    public boolean checkIfStudentIsNull(int id) {
        final Optional<CollegeStudent> byId = studentDao.findById(id);
        if (byId.isPresent()) {
            return true;
        }
        return false;

    }

    public void deleteStudent(int id) {
        if (checkIfStudentIsNull(id))
            studentDao.deleteById(id);
    }

    public Iterable<CollegeStudent> getGradebook() {
        return studentDao.findAll();
    }
}
