package net.unikit.database.internal.interfaces.entities;

import java.util.Date;

/**
 * A model for a membership request which is associated to a team.
 * Membership requests will be done by students without team.
 * If a student creates a membership request for a team he is called applicant.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface MembershipRequestModel extends AbstractModel<Integer> {
    /**
     * Getter for the internal identifier in the database.
     * @return The internal identifier in the database
     */
    Integer getId();

    /**
     * Getter for the student number of applicant.
     * @return The student number of applicant
     */
    String getApplicantStudentNumber();

    /**
     * Setter for the student number of applicant.
     * @param applicantStudentNumber The student number of applicant
     */
    void setApplicantStudentNumber(String applicantStudentNumber);

    /**
     * Getter for the team which is associated with the membership request.
     * @return The team which is associated with the membership request
     */
    TeamModel getTeam();

    /**
     * Setter for the team which is associated with the membership request.
     * @param team The team which is associated with the membership request
     */
    void setTeam(TeamModel team);

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
