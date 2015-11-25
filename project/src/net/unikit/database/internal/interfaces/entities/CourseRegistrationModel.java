package net.unikit.database.internal.interfaces.entities;

import java.util.Date;

/**
 * A model for a course registration which is associated to a course.
 * Course registrations will be done by students and means that the student is enrolled in the course.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface CourseRegistrationModel extends AbstractModel<Integer> {
    /**
     * Getter for the internal identifier in the database.
     * @return The internal identifier in the database
     */
    Integer getId();

    /**
     * Getter for the student number of the student which has done the registration.
     * @return The student number of the student which has done the registration
     */
    String getStudentNumber();

    /**
     * Setter for the student number of the student which has done the registration.
     * @param studentNumber The student number of the student which has done the registration
     */
    void setStudentNumber(String studentNumber);

    /**
     * Getter for the id of the course for which the student has done the registration.
     * @return The id of the course for which the student has done the registration
     */
    int getCourseId();

    /**
     * Setter for the id of the course for which the student has done the registration.
     * @param courseId The id of the course for which the student has done the registration
     */
    void setCourseId(int courseId);

    /**
     * Getter for the flag which states if the registration is already assigned to a team.
     * @return The flag which states if the registration is already assigned to a team
     */
    boolean isCurrentlyAssignedToTeam();

    /**
     * Setter for the flag which states if the registration is already assigned to a team.
     * @param currentlyAssignedToTeam The flag which states if the registration is already assigned to a team
     */
    void setCurrentlyAssignedToTeam(boolean currentlyAssignedToTeam);

    /**
     * Getter for the date in which the entry was written to the database.
     * @return The date in which the entry was written to the database
     */
    Date getCreatedAt();

    /**
     * Getter for the date in which the entry was updated in the database the last time.
     * @return The date in which the entry was updated in the database the last time
     */
    Date getUpdatedAt();
}
