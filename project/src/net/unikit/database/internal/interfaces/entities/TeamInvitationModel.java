package net.unikit.database.internal.interfaces.entities;

import java.util.Date;

/**
 * Created by Andreas on 19.11.2015.
 */
public interface TeamInvitationModel extends AbstractModel<Integer> {
    Integer getId();

    String getInviteeStudentNumber();
    void setInviteeStudentNumber(String inviteeStudentNumber);

    TeamModel getTeam();
    void setTeam(TeamModel team);

    String getCreatedByStudentNumber();
    void setCreatedByStudentNumber(String createdByStudentNumber);

    Date getCreatedAt();

    Date getUpdatedAt();
}
