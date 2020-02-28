package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class ListOfStaff implements Iterable<Staff> {
    private final ArrayList<Staff> listOfStaff = new ArrayList<Staff>();


    public void add(Staff staff){
        listOfStaff.add(staff);
    }

    public Iterator<Staff> iterator(){
        return this.listOfStaff.iterator();
    }


}
