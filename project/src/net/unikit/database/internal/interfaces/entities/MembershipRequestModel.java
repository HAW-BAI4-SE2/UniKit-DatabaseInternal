package net.unikit.database.internal.interfaces.entities;

/**
 * Created by Andreas on 19.11.2015.
 */
public interface MembershipRequestModel {
    Integer getId();
    String getApplicantStudentNumber();
    void setApplicantStudentNumber(String applicantStudentNumberField);
    TeamModel getTeam();
    void setTeam(TeamModel teamField);
}
