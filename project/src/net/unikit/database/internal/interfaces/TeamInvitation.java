package net.unikit.database.internal.interfaces;

import java.util.Date;

/**
 * Created by Andreas on 28.10.2015.
 */
public interface TeamInvitation {
    Integer getId();

    String getInviteeStudentNumber();

    Team getTeam();

    String getCreatedByStudentNumber();

    Date getCreatedAt();

    Date getUpdatedAt();
}
