package test;

import model.operation.Process;
import model.operation.Classes;
import model.operation.ListOfRequirements;
import model.operation.Requirement;
import model.operation.Semester;

import java.util.ArrayList;

/**
 * temporary single method test for Model.
 */
public class test {

    public static void main(String[] args) {
        Process process = new Process();
        Semester semester = new Semester(1,2020);
        Classes classes = new Classes("001","English","9:00",semester);
        process.createRequirement(2,classes); // create teaching request
        ArrayList<Requirement> requirements = ListOfRequirements.getInstance().getRequirements();
        for (Requirement requirement : requirements) {
            System.err.println(requirement.write());
        }
    }

}
