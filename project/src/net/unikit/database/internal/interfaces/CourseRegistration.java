package net.unikit.database.internal.interfaces;

import java.util.Date;

/**
 * Created by Andreas on 28.10.2015.
 */
public interface CourseRegistration {
    Integer getId();

    String getStudentNumber();

    int getCourseId();

    boolean isCurrentlyAssignedToTeam();

    Date getCreatedAt();

    Date getUpdatedAt();
}
