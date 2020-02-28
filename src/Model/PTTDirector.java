package Model;

import java.io.PrintStream;

public class PTTDirector extends Staff {
    public PTTDirector (String firstName, String lastName){
        super(firstName, lastName);
    }

    public void approve(Request request){
        request.requestAccept();
    }
    public void disapprove(Request request){
        request.requestReject();
    }
}
