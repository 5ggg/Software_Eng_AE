package Model;

import java.io.PrintStream;

public class PTTDirector extends Staff {
    public PTTDirector (String firstName, String lastName){
        super(firstName, lastName);
    }

    public void approve(ClassRequest request){
        request.setRequestStatus(ClassRequest.status[1]);
    }

    public void disapprove(ClassRequest request){
        request.setRequestStatus(ClassRequest.status[2]);
    }

    public void print (PrintStream ps){
        super.print(ps);
        ps.print("PTT Director");
    }
}
