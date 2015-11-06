package net.unikit.database.internal.interfaces;

import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by Andreas on 28.10.2015.
 */
public interface TeamManager {
    List<Team> getAllTeams() throws HibernateException;
    Team getTeam(Integer id) throws NullPointerException, HibernateException;
}
