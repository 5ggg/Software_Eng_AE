package Model;

import java.util.ArrayList;
import java.util.Iterator;

// available maybe
public class ListOfStaff {
    private final ArrayList<Staff> loS = new ArrayList<Staff>();


    public void add(Staff staff){
        loS.add(staff);
    }
//  public class ListOfStaff implements Iterable<Staff>
//
//  @Override
//  public Iterator<Staff> iterator()

}
