package net.unikit.database.internal.interfaces;

import net.unikit.database.internal.interfaces.managers.*;

/**
 * A manager which grants access to all database managers of the internal database.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface InternalDatabaseManager {
    /**
     * Getter for the manager for the course registrations.
     * @return The manager for the course registrations
     */
    CourseRegistrationModelManager getCourseRegistrationModelManager();

    /**
     * Getter for the manager for the membership requests.
     * @return The manager for the membership requests
     */
    MembershipRequestModelManager getMembershipRequestModelManager();

    /**
     * Getter for the manager for the team invitations.
     * @return The manager for the course team invitations
     */
    TeamInvitationModelManager getTeamInvitationModelManager();

    /**
     * Getter for the manager for the teams.
     * @return The manager for the teams
     */
    TeamModelManager getTeamModelManager();

    /**
     * Getter for the manager for the team registrations.
     * @return The manager for the team registrations
     */
    TeamRegistrationModelManager getTeamRegistrationModelManager();
}
