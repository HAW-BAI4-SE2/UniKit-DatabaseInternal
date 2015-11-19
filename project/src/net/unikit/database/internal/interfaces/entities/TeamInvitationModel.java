package net.unikit.database.internal.interfaces.entities;

/**
 * Created by Andreas on 19.11.2015.
 */
public interface TeamInvitationModel {
    Integer getId();
    String getInviteeStudentNumber();
    void setInviteeStudentNumber(String inviteeStudentNumberField);
    TeamModel getTeam();
    void setTeam(TeamModel teamField);
    String getCreatedByStudentNumber();
    void setCreatedByStudentNumber(String createdByStudentNumberField);
}
