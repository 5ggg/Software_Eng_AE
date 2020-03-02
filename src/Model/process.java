package model;

import java.util.ArrayList;

/**
 * deal with the process
 */
public class Process {


    /**
     *  the class director should list the teaching requirement based on the current situation
     * @param numOfTeachers
     * @param classes
     */
    public void createRequirement(int numOfTeachers, Classes classes) {
        Requirement requirement = new Requirement(numOfTeachers, classes);
        ListOfRequirements.getInstance().add(requirement);
    }

    /**
     * Teacher create the teaching request and sent to the PTT director
     * @param id
     * @param teacher
     * @param classInfo
     * @param approval
     */
    public void createRequest(int id, Teacher teacher, Classes classInfo, int approval) {
        Request request = new Request(id, teacher, classInfo, approval);
        ListOfRequests.getInstance().add(request);
    }

    //    Call it from the Request class.
    //    /**
//     * PPT Director approve the teaching request
//     * @param request
//     */
//    public void approveRequest(Request request) {
//        ListOfRequests.getInstance().approve(request);
//    }
//
//    /**
//     * PPT Director reject the teaching request
//     * @param request
//     */
//    public void rejectRequest(Request request) {
//        ListOfRequests.getInstance().reject(request);
//    }

    /**
     * Admin match the
     * @param request  this request is the request after approved by PTT director
     */
    public void matchRequest(Request request) {
        boolean match = ListOfRequirements.getInstance().match(request);
        if (match==false){ // if not matched ,removed
            ListOfRequests.getInstance().remove(request);
        }
    }

    /**
     * get the approved list.
     * @return
     */
    public ArrayList<Request> getApprovedRequest(){
        return ListOfRequests.getInstance().getApproved();
    }


}
