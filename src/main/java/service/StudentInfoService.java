package service;

import vo.Enrollment;
import vo.Student;

import java.util.List;

public interface StudentInfoService {
    public List<Student>  getAllStudents();
    public List<Enrollment> getInfoAboutStudent(Student student);
    public List<Enrollment> getInfoAboutStudentbyId(int id);
}
