package Model;

import java.util.ArrayList;

public class ListOfClass {
    private ListOfClass(){
        // constructor
    }


    private ArrayList<Class> loC = new ArrayList<Class>();


    public Class getClassRequest(int classID) {
        return loC.get(classID);
    }
    public ArrayList<Class> getCListOfClass() {
        return loC;
    }

    public void add(int classID){
    }
    public void add(Class c) {
    }

    public void remove(int classID){

    }
    public void remove(Class c) {

    }


}
