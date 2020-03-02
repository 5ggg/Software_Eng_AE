package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Teacher List
 */
public class ListOfTeacher {

    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public static ListOfTeacher getInstance() {
        return instance;
    }

    public void add(Teacher teacher) {
        teachers.add(teacher);
    }

    public void remove(Teacher teacher) {
        teachers.remove(teacher);
    }

    public Teacher get(int id) {
        return teachers.get(id);
    }

    public List<Teacher> getTeacherList() {
        return teachers;
    }


}
