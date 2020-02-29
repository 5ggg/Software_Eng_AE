package Model;

import java.util.ArrayList;

public class Administrator extends Staff {
    public Administrator (int staffID, String firstName, String lastName){
        super(staffID, firstName, lastName);
    }

//    public void addTraining(Teacher teacher, String training) {
//        teacher.addTraining(training);
//    }

    public ArrayList<Request> checkRequestList(ListOfRequest listOfRequest){
        return listOfRequest.getAcceptedRequest();
    }

    public ArrayList<Teacher> checkTeacherList(ListOfTeacher listOfTeacher){
        return listOfTeacher.getTeacherList();
    }
}
