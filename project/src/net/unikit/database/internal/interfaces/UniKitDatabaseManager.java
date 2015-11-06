package net.unikit.database.internal.interfaces;

import net.unikit.database.common.interfaces.DatabaseConfiguration;

/**
 * Created by Andreas on 28.10.2015.
 */
public interface UniKitDatabaseManager {
    DatabaseConfiguration getDatabaseConfiguration();
    CourseRegistrationManager getCourseRegistrationManager();
    TeamManager getTeamManager();
    TeamRegistrationManager getTeamRegistrationManager();
    TeamInvitationManager getTeamInvitationManager();
    TeamApplicationManager getTeamApplicationManager();
}
