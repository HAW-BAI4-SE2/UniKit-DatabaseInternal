package net.unikit.database.internal.interfaces.entities;

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
    void setMembershipRequests(List<MembershipRequestModel> membershipRequests);
    List<TeamInvitationModel> getTeamInvitations();
    void setTeamInvitations(List<TeamInvitationModel> teamInvitations);
    List<TeamRegistrationModel> getTeamRegistrations();
    void setTeamRegistrations(List<TeamRegistrationModel> teamRegistrations);
}
