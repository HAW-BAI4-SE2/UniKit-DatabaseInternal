package net.unikit.database.internal.interfaces;

import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by Andreas on 28.10.2015.
 */
public interface TeamApplicationManager {
    List<TeamApplication> getAllTeamApplications() throws HibernateException;
    TeamApplication getTeamApplication(Integer id) throws NullPointerException, HibernateException;
}
