package net.unikit.database.internal.interfaces;

import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by Andreas on 28.10.2015.
 */
public interface TeamRegistrationManager {
    List<TeamRegistration> getAllTeamRegistrations() throws HibernateException;
    TeamRegistration getTeamRegistration(Integer id) throws NullPointerException, HibernateException;
}
