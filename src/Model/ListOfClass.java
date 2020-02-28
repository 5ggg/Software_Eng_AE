package Model;

import java.util.ArrayList;

public class ListOfClass {


    private ArrayList<Class> classList = new ArrayList<Class>();

    private ListOfClass(){};


// ---------------------------

    public Class getRequest(int classID) {

        return classList.get(classID);
    }

    public ArrayList<Class> getClassList() {
        return classList;
    }

    public void add(Class c) {
        for (Class c1 : classList) {
            if (c1.getClassID() == c.getClassID()) {
                return;
            }
        }
        classList.add(c);
        System.out.println("New Class added to list!");
    }

    public void remove(int classID){
        for(Class c : classList){
            if (c.getClassID() == classID){
                classList.remove(c);
                return;
            }
        }
    }

    public void remove(Class c) {
        for (Class c1 : classList) {
            if (c1.getClassID() == c.getClassID()) {
                classList.remove(c);
            }
        }
    }

}
