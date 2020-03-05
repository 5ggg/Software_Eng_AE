package model.operation;

import java.util.ArrayList;
import java.util.Iterator;

public class ListOfClasses implements Iterable<Classes> {

    private ArrayList<Classes> listOfClasses = new ArrayList<Classes>();

    // getInstance can across the stack
    private static ListOfClasses instance = new ListOfClasses();
    public static ListOfClasses getInstance() {
        return instance;
    }

    public ArrayList<Classes> getClasses(){
        return this.listOfClasses;
    }

    // using ID to find a certain class from the class list
    public Classes findById(int id) {
        for (Classes cs : listOfClasses) {
            if (cs.getId() == id) {
                return cs;
            }
        }
        return null;
    }

    public void add(Classes cs) {
        listOfClasses.add(cs);
    }


    @Override
    public Iterator<Classes> iterator() {
        return this.listOfClasses.iterator();
    }
}