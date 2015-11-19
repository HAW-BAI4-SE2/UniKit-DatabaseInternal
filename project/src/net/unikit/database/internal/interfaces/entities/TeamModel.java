package net.unikit.database.internal.interfaces.entities;

import java.util.List;

/**
 * Created by Andreas on 19.11.2015.
 */
public interface TeamModel {
    Integer getId();
    int getCourseId();
    void setCourseId(int courseIdField);
    String getCreatedByStudentNumber();
    void setCreatedByStudentNumber(String createdByStudentNumberField);
    List<MembershipRequestModel> getMembershipRequests();
    void setMembershipRequestModels(List<MembershipRequestModel> membershipRequestModels);
    List<TeamInvitationModel> getTeamInvitations();
    void setTeamInvitationModels(List<TeamInvitationModel> teamInvitationModels);
    List<TeamRegistrationModel> getTeamRegistrations();
    void setTeamRegistrationModels(List<TeamRegistrationModel> teamRegistrationModels);
}
