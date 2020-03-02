package Model;

// the class director to add the teaching request (the subject need to be trained).

import java.util.List;

/**
 * ClassDirector
 * ClassDirector add teaching request // some issues here
 */
public class ClassDirector extends Staff {

    public ClassDirector(int staffID, String firstName, String lastName) {
        super(staffID, firstName, lastName);
    }

    /**
     * create teaching request
     * @param classId
     * @param numOfTeacher
     * @param subject
     */
    public void createRequest(int classId, int numOfTeacher, String subject,String time){
        Request request = new Request(classId,numOfTeacher,0,subject,time);
        ListOfRequest.getInstance().addRequestToList(request);
    }

    /**
     * add teaching requirement
     * @param request
     * @param listOfRequest
     */
    public void addRequest(Request request, ListOfRequest listOfRequest) {
        listOfRequest.addRequestToList(request);
    }

    /**
     * Get Untreated list
     * checkRequestList
     * @param listOfRequest
     * @return
     */
    public List<Request> getUntreatedd(ListOfRequest listOfRequest){
        return listOfRequest.getUntreatedList();
    }
}