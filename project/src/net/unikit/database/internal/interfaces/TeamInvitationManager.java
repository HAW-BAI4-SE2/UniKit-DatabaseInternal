package net.unikit.database.internal.interfaces;

import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by Andreas on 28.10.2015.
 */
public interface TeamInvitationManager {
    List<TeamInvitation> getAllTeamInvitations() throws HibernateException;
    TeamInvitation getTeamInvitation(Integer id) throws NullPointerException, HibernateException;
}
