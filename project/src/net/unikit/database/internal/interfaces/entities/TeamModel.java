package net.unikit.database.internal.interfaces.entities;

import java.util.Date;
import java.util.List;

/**
 * Created by Andreas on 19.11.2015.
 */
public interface TeamModel {
    Integer getId();

    int getCourseId();
    void setCourseId(int courseId);

    String getCreatedByStudentNumber();
    void setCreatedByStudentNumber(String createdByStudentNumber);

    List<MembershipRequestModel> getMembershipRequests();

    List<TeamInvitationModel> getTeamInvitations();

    List<TeamRegistrationModel> getTeamRegistrations();

    Date getCreatedAt();

    Date getUpdatedAt();
}
