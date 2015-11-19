package net.unikit.database.internal.interfaces.entities;

import java.util.Date;

/**
 * Created by Andreas on 19.11.2015.
 */
public interface TeamRegistrationModel {
    Integer getId();

    String getStudentNumber();
    void setStudentNumber(String studentNumber);

    TeamModel getTeam();
    void setTeam(TeamModel team);

    Date getCreatedAt();

    Date getUpdatedAt();
}
