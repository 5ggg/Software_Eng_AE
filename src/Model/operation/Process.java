package model.operation;

import model.Staff.Teacher;

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
        Request request = new Request(id, teacher, approval);
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
     * Admin match the request and requirement.
     * and if matchable = false, (means that there is no available requirement for the request)
     * so the request will be removed automatically.
     * @param request
     */
    public void initMatchRequest(Request request) {
        boolean matchable = ListOfRequirements.getInstance().matchable(request);
        if (matchable==false){ // if not matched ,removed
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
