package Model;

import java.util.ArrayList;

public class Administrator extends Staff {
    public Administrator (String firstName, String lastName){
        super(firstName, lastName);
    }

    public ArrayList<Request> checkRequestList(ListOfRequest requestList){
        return requestList.getAcceptedList();
    }

    public ArrayList<Teacher> checkTeacherList(List_Of_Teacher teacherList){
        return teacherList.getTeacherList();
    }
}
