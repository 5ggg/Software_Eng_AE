package model;

import java.util.ArrayList;
import java.util.Iterator;

public class ListOfClasses implements Iterable<Classes> {

    private ArrayList<Classes> listOfClasses = new ArrayList<Classes>();

//    private static ListOfClasses instance = new ListOfClasses();
//    public static ListOfClasses getInstance() {
//        return instance;
//    }

    public ArrayList<Classes> getClasses(){
        return this.listOfClasses;
    }

    public Classes findById(int id) {
        for (Classes c : listOfClasses) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void add(Classes c) {
        listOfClasses.add(c);
    }


    public Iterator<Classes> iterator() {
        return this.listOfClasses.iterator();
    }

}