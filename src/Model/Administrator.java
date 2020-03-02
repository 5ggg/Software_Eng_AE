package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * The admin find the suitable staff
 */
public class Administrator extends Staff {

    public Administrator(int staffID, String firstName, String lastName) {
        super(staffID, firstName, lastName);
    }

    /**
     * match
     * @return
     */
    public List<Teacher> getTeachersByRequest(String subject, String availableDate) {
        return ListOfTeacher.getInstance().getTeachersByRequest(subject,availableDate);
    }

    /**
     * get teaching request
     * @param listOfRequest
     * @return
     */
    public ArrayList<Request> checkRequestList(ListOfRequest listOfRequest) {
        return listOfRequest.getRequests();
    }

    /**
     * get teaching requirement
     * @param listOfClass
     * @return
     */
    public ArrayList<Class> checkClassList(ListOfClass listOfClass){
        return listOfClass.getClassList();
    }

    /**
     * get teacher list
     * @param listOfTeacher
     * @return
     */
    public List<Teacher> checkTeacherList(ListOfTeacher listOfTeacher) {
        return listOfTeacher.getTeacherList();
    }
}