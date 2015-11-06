package net.unikit.database.internal.interfaces;

import java.util.Date;

/**
 * Created by Andreas on 28.10.2015.
 */
public interface TeamApplication {
    Integer getId();

    String getApplicantStudentNumber();

    Team getTeam();

    Date getCreatedAt();

    Date getUpdatedAt();
}
