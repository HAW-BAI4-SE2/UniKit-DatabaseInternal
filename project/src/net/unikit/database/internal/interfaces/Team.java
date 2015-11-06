package net.unikit.database.internal.interfaces;

import java.util.Date;
import java.util.List;

/**
 * Created by Andreas on 28.10.2015.
 */
public interface Team {
    Integer getId();

    int getCourseId();

    List<TeamRegistration> getTeamRegistrations();

    List<TeamInvitation> getTeamInvitations();

    List<TeamApplication> getTeamApplications();

    String getCreatedByStudentNumber();

    Date getCreatedAt();

    Date getUpdatedAt();
}
