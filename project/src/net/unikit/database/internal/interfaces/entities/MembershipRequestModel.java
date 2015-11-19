package net.unikit.database.internal.interfaces.entities;

import java.util.Date;

/**
 * Created by Andreas on 19.11.2015.
 */
public interface MembershipRequestModel extends AbstractModel {
    Integer getId();

    String getApplicantStudentNumber();
    void setApplicantStudentNumber(String applicantStudentNumber);

    TeamModel getTeam();
    void setTeam(TeamModel team);

    Date getCreatedAt();

    Date getUpdatedAt();
}
