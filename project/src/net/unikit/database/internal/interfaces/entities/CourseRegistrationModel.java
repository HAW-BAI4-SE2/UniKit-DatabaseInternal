package net.unikit.database.internal.interfaces.entities;

/**
 * Created by Andreas on 19.11.2015.
 */
public interface CourseRegistrationModel {
    Integer getId();
    String getStudentNumber();
    void setStudentNumber(String studentNumber);
    int getCourseId();
    void setCourseId(int courseId);
    boolean isCurrentlyAssignedToTeam();
    void setCurrentlyAssignedToTeam(boolean currentlyAssignedToTeam);
}
