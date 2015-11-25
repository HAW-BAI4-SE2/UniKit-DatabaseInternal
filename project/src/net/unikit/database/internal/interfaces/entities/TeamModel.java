package net.unikit.database.internal.interfaces.entities;

import java.util.Date;
import java.util.List;

/**
 * A model for a team which is associated to a course.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface TeamModel extends AbstractModel<Integer> {
    /**
     * Getter for the internal identifier in the database.
     * @return The internal identifier in the database
     */
    Integer getId();

    /**
     * Getter for the id of the course which is associated to the team.
     * @return The id of the course which is associated to the team
     */
    int getCourseId();

    /**
     * Setter for the id of the course which is associated to the team.
     * @param courseId The id of the course which is associated to the team
     */
    void setCourseId(int courseId);

    /**
     * Getter for the student number of the student which created the team.
     * @return The student number of the student which created the team
     */
    String getCreatedByStudentNumber();

    /**
     * Setter for the student number of the student which created the team.
     * @param createdByStudentNumber The student number of the student which created the team
     */
    void setCreatedByStudentNumber(String createdByStudentNumber);

    List<MembershipRequestModel> getMembershipRequests();

    List<TeamInvitationModel> getTeamInvitations();

    List<TeamRegistrationModel> getTeamRegistrations();

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
