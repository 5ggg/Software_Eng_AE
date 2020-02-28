package Model;

// the class director to add the teaching request (the subject need to be trained).

public class ClassDirector extends Staff {
    public ClassDirector (String firstName, String lastName){
        super(firstName, lastName);
    }

    public void addRequest(Request request, ListOfRequest listOfRequest){
        listOfRequest.addRequestToList();
    }
}