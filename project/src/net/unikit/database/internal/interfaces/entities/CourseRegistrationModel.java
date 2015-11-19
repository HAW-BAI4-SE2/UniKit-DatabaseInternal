package net.unikit.database.internal.interfaces.entities;

/**
 * Created by Andreas on 19.11.2015.
 */
public interface CourseRegistrationModel {
    Integer getId();
    String getStudentNumber();
    void setStudentNumber(String studentNumberField);
    int getCourseId();
    void setCourseId(int courseIdField);
    boolean isCurrentlyAssignedToTeam();
    void setCurrentlyAssignedToTeam(boolean currentlyAssignedToTeamField);
}
