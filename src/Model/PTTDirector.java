package Model;

import java.util.ArrayList;

/**
 * Part-Time Teacher
 */
public class PTTDirector extends Staff {

    public PTTDirector (int staffID, String firstName, String lastName){
        super(staffID, firstName, lastName);
    }

    /**
     * get untreated list
     * @param requestList
     * @return
     */
    public ArrayList<Request> checkRequirement(ListOfRequest requestList) {
        return requestList.getUntreatedList();
    }

    /**
     * get treated list
     * @param requestList
     * @return
     */
    public ArrayList<Request> checkApproved(ListOfRequest requestList){
        return requestList.getAcceptedList();
    }

    /**
     * accept/approve the teaching request
     * @param acceptedRequest
     */
    public void acceptRequest(Request acceptedRequest) {
        acceptedRequest.requestAccepted();
    }

    /**
     * reject the teaching request
     * @param rejectedRequest
     */
    public void rejectRequest(Request rejectedRequest) {
        rejectedRequest.requestReject();
    }

}
