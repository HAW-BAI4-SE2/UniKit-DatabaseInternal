package net.unikit.database.internal.interfaces.entities;

/**
 * Created by Andreas on 19.11.2015.
 */
public interface TeamInvitationModel {
    Integer getId();
    String getInviteeStudentNumber();
    void setInviteeStudentNumber(String inviteeStudentNumber);
    TeamModel getTeam();
    void setTeam(TeamModel team);
    String getCreatedByStudentNumber();
    void setCreatedByStudentNumber(String createdByStudentNumber);
}
