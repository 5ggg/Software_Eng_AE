package Model;

import java.util.ArrayList;

public class ListOfTeacher {
    private ArrayList<Teacher> loT = new ArrayList<Teacher>();

    public void add(Teacher teacher){
        loT.add(teacher);
    }
    public void remove(Teacher teacher){
        loT.remove(teacher);
    }
}
