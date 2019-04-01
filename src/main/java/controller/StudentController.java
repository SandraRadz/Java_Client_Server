package controller;

import service.impl.StudentInfoServiceImpl;

import java.util.Arrays;
import java.util.List;

public class StudentController {

    public String parse(String line){
        StudentInfoServiceImpl service = new StudentInfoServiceImpl();
        String result="it seems there is no command with this name";
        List<String> st = Arrays.asList(line.split(" "));
        System.out.print("size = " + st.size());
        String method = st.get(0);
        if (method.equals("allStudent")){
            service.getAllStudents();
            result="get all students ";
        }
        else if (method.equals("details")){
            try {
                int d = Integer.parseInt(st.get(1));
                service.getInfoAboutStudentbyId(d);
                result="get info about "+ d;
            }
            catch (Exception e){
                result = "some trouble with id";
            }
        }
        return result;
    }
}
