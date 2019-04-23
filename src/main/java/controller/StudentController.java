package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import service.impl.StudentInfoServiceImpl;
import vo.Enrollment;
import vo.Student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StudentController {
    List<String> st = new ArrayList<String>();
    StudentInfoServiceImpl service = new StudentInfoServiceImpl();

    public String parse(String line){
        String result="it seems there is no command with this name";
        st = Arrays.asList(line.split(" "));
        System.out.print("size = " + st.size());
        String method = st.get(0);
        if (method.equals("allStudents")){
            service.getAllStudents();
            List<Student> res = service.getAllStudents();
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(new File("target/detail_list.json"), res);
                result = objectMapper.writeValueAsString(res);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method.equals("details")){
            try {
                int d = Integer.parseInt(st.get(1));
                System.out.println("id = "+ d);
                List<Enrollment> res = service.getInfoAboutStudentbyId(d);
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(new File("target/detail_list.json"), res);
                result = objectMapper.writeValueAsString(res);
            }
            catch (Exception e){
                result = "some trouble with id";
            }
        }
        return result;
    }
}
