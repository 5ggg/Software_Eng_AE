package Model;

import java.util.ArrayList;

public class ListOfRequest {
    private ListOfRequest(){
        // constructor
    }

    private ArrayList<Request> loR = new ArrayList<Request>();


    public void addRequestToList(Request request1) {
        loR.add(request1);
    }
    public void removeList(Request request2){
        loR.remove(request2);
    }


    public ArrayList<Request> getAcceptedRequest(){
        // get the accept list. (From PTT director)
    }
    public ArrayList<Request> getRejectedRequest(){
        // get the rejected list. (From PTT director)
    }



}
