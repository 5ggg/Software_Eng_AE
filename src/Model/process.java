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
     * @param teacher
     * @param classes
     * @param requirement
     */
    public void createRequest(Teacher teacher, Classes classes, Requirement requirement) {
        Request request = new Request(teacher, classes, requirement);
        ListOfRequests.getInstance().add(request);
    }

    /**
     * PPT Director approve the teaching request
     * @param request
     */
    public void approveRequest(Request request) {
        ListOfRequests.getInstance().approve(request);
    }

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
