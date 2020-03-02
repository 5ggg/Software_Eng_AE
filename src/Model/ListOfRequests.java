package model;

import java.util.ArrayList;
import java.util.Iterator;

public class ListOfRequests implements Iterable<Request> {

	ArrayList<Request> listOfRequest = new ArrayList<Request>();

	private static ListOfRequests instance = new ListOfRequests();
	public static ListOfRequests getInstance() {
		return instance;
	}

	public ArrayList<Request> getRequests(){
		return listOfRequest;
	}

	public int getID() {
		return listOfRequest.get(listOfRequest.size()-1).getId();
	}

	public Iterator<Request> iterator() {
		return this.listOfRequest.iterator();
	}

	public void add(Request request) {
		this.listOfRequest.add(request);
	}

	// approve the request
	public void approve(Request request){
		ArrayList<Request> requests = new ArrayList<>();
		for(Request r:this.listOfRequest){

			if (r.getId()==request.getId()){
				r.setApproval(1);
				requests.add(r);
			}

			else{
				requests.add(r);
			}
		}
		this.listOfRequest = requests;
	}

	/**
	 * get the list approved
	 */
	public ArrayList<Request> getApproved(){
		ArrayList<Request> requests = new ArrayList<>();
		for (Request r:this.listOfRequest){
			if (r.getApproval()==1){
				requests.add(r);
			}
		}
		return requests;
	}

	/**
	 * remove the request from the list
	 */
	public void remove(Request request){
		for (int i = 0; i < this.listOfRequest.size(); i++) {
			Request current = this.listOfRequest.get(i);
			if (current.getId()==request.getId()){
				this.listOfRequest.remove(i);
				return;
			}
		}
	}

}