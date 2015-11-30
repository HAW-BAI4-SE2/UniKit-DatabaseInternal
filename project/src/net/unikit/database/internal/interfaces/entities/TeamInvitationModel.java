package net.unikit.database.internal.interfaces.entities;

import net.unikit.database.interfaces.entities.AbstractModel;

import java.util.Date;

/**
 * A model for a invitation which is associated to a team.
 * Membership requests will be done by students which are in the team.
 * If a student gets invited to a team he is called invitee.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface TeamInvitationModel extends AbstractModel<Integer> {
    /**
     * Getter for the internal identifier in the database.
     * @return The internal identifier in the database
     */
    Integer getId();

    /**
     * Getter for the student number of invitee.
     * @return The student number of invitee
     */
    String getInviteeStudentNumber();

    /**
     * Setter for the student number of invitee.
     * @param inviteeStudentNumber The student number of invitee
     */
    void setInviteeStudentNumber(String inviteeStudentNumber);

    /**
     * Getter for the team which is associated with the invitation.
     * @return The team which is associated with the invitation
     */
    TeamModel getTeam();

    /**
     * Setter for the team which is associated with the invitation.
     * @param team The team which is associated with the invitation
     */
    void setTeam(TeamModel team);

    /**
     * Getter for the student number of the student which created the invitation.
     * @return The student number of the student which created the invitation
     */
    String getCreatedByStudentNumber();

    /**
     * Setter for the student number of the student which created the invitation.
     * @param createdByStudentNumber The student number of the student which created the invitation
     */
    void setCreatedByStudentNumber(String createdByStudentNumber);

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
