package Model;

import java.util.ArrayList;

/**
 * teaching requirement list
 */
public class ListOfClass {

    private ArrayList<Class> classes = new ArrayList<>();

    private ListOfClass() {
    }


    public Class getRequest(int classID) {
        return classes.get(classID);
    }
    public ArrayList<Class> getClassList() {
        return classes;
    }

    public void add(Class c) {
        for (Class c1 : classes) {
            if (c1.getClassID() == c.getClassID()) {
                return;
            }
        }
        classes.add(c);
    }


    public void remove(Class c) {
        for (Class c1 : classes) {
            if (c1.getClassID() == c.getClassID()) {
                classes.remove(c);
            }
        }
    }

}
