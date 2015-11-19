package net.unikit.database.internal.interfaces;

import net.unikit.database.internal.interfaces.managers.*;

/**
 * Created by Andreas on 19.11.2015.
 */
public interface InternalDatabaseManager {
    CourseRegistrationModelManager getCourseRegistrationModelManager();
    MembershipRequestModelManager getMembershipRequestModelManager();
    TeamInvitationModelManager getTeamInvitationModelManager();
    TeamModelManager getTeamModelManager();
    TeamRegistrationModelManager getTeamRegistrationModelManager();
}
