package net.unikit.database.internal.interfaces.entities;

import java.util.Date;

/**
 * A model for a registration which is associated to a team.
 * Team registrations will be done by students and means that the student is member of the team.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface TeamRegistrationModel extends AbstractModel<Integer> {
    /**
     * Getter for the internal identifier in the database.
     * @return The internal identifier in the database
     */
    Integer getId();

    /**
     * Getter for the student number of the student which is member of the team.
     * @return The student number of the student which is member of the team
     */
    String getStudentNumber();

    /**
     * Setter for the student number of the student which is member of the team.
     * @param studentNumber The student number of the student which is member of the team
     */
    void setStudentNumber(String studentNumber);

    /**
     * Getter for the team which is associated with the registration.
     * @return The team which is associated with the registration
     */
    TeamModel getTeam();

    /**
     * Setter for the team which is associated with the registration.
     * @param team The team which is associated with the registration
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
