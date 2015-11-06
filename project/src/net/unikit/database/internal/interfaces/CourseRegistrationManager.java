package net.unikit.database.internal.interfaces;

import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by Andreas on 28.10.2015.
 */
public interface CourseRegistrationManager {
    List<CourseRegistration> getAllCourseRegistrations() throws HibernateException;
    CourseRegistration getCourseRegistration(Integer id) throws NullPointerException, HibernateException;
}
