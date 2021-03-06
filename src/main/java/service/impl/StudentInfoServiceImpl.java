package service.impl;

import dao.impl.StudentDaoImpl;
import service.StudentInfoService;
import vo.Enrollment;
import vo.Student;

import java.util.List;

public class StudentInfoServiceImpl implements StudentInfoService {
    public List<Student> getAllStudents() {
        System.out.println("service");
        StudentDaoImpl sdi = new StudentDaoImpl();
        List<Student> res = sdi.getAll();
        sdi.close();
        return res;
    }

    public List<Enrollment> getInfoAboutStudent(Student student) {
        StudentDaoImpl sdi = new StudentDaoImpl();
        List<Enrollment> res = sdi.getDiscByStudent(student);
        sdi.close();
        return res;
    }

    public List<Enrollment> getInfoAboutStudentbyId(int id) {
        StudentDaoImpl sdi = new StudentDaoImpl();
        List<Enrollment> res = sdi.getDiscByStudentId(id);
        sdi.close();
        return res;
    }
}
