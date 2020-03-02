package Model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *  Teaching request list
 */
public class ListOfRequest {

    private int index = 0;
    private ArrayList<Request> requestList = new ArrayList<Request>();

    private ListOfRequest() {
    }

    public void addRequestToList(Request request1) {
        requestList.add(request1);
    }

    public void removeList(Request request2) {
        requestList.remove(request2);
    }

    public void removeById(int id) {
        requestList.remove(id);
    }

    public Request getById(int id) {
        return requestList.get(id);
    }

    public Request getRequest(Request request) {
        for (Request request1 : requestList) {
            if (request.getRequestId() == request1.getRequestId()) {
                return request1;
            }
        }
        return null;
    }

    /**
     * update the request
     * @param request
     */
    public void updateRequest(Request request) {
        ArrayList<Request> requests = new ArrayList<>();
        for (Request request1 : requestList) {
            if (request1.getRequestId() == (request.getRequestId())) {
                requests.add(request);
            } else {
                requests.add(request1);
            }
        }
        this.requestList = requests; // re-cover
    }


    public ArrayList<Request> getRequests() {
        // get the accept list. (From PTT director)
        return requestList;
    }

    /**
     * get untreated list
     *
     * @return
     */
    public ArrayList<Request> getUntreatedList() {
        ArrayList<Request> list = new ArrayList<Request>();
        for (Request request : requestList) {
            if (request.getStatus() == 0) {
                list.add(request);
            }
        }
        return list;
    }

    /**
     * get accept request
     *
     * @return
     */
    public ArrayList<Request> getAcceptedList() {
        ArrayList<Request> list = new ArrayList<>();
        for (Request request : requestList) {
            if (request.getStatus() == 1) {
                list.add(request);
            }
        }
        return list;
    }

    /**
     * get reject request
     *
     * @return
     */
    public ArrayList<Request> getRejectedRequest() {
        ArrayList<Request> list = new ArrayList<>();
        for (Request request : requestList) {
            if (request.getStatus() == 2) {
                list.add(request);
            }

        }
        return list;
    }