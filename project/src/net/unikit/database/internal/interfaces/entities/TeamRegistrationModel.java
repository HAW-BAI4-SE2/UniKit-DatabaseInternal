package net.unikit.database.internal.interfaces.entities;

/**
 * Created by Andreas on 19.11.2015.
 */
public interface TeamRegistrationModel {
    Integer getId();
    String getStudentNumber();
    void setStudentNumber(String studentNumber);
    TeamModel getTeam();
    void setTeam(TeamModel team);
}
