package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.TeamInvitation;
import net.unikit.database.internal.interfaces.TeamInvitationManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Andreas on 28.10.2015.
 */
final class TeamInvitationManagerImpl implements TeamInvitationManager {
    private final SessionFactory sessionFactory;

    private void validate() throws NullPointerException {
        checkNotNull(sessionFactory, "value of 'sessionFactory' is null!");
    }

    private TeamInvitationManagerImpl(SessionFactory sessionFactory) throws NullPointerException {
        this.sessionFactory = sessionFactory;
        validate();
    }

    public static TeamInvitationManager create(SessionFactory sessionFactory) throws NullPointerException {
        return new TeamInvitationManagerImpl(sessionFactory);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamInvitationManagerImpl)) return false;

        TeamInvitationManagerImpl that = (TeamInvitationManagerImpl) o;

        return getSessionFactory().equals(that.getSessionFactory());

    }

    @Override
    public int hashCode() {
        return getSessionFactory().hashCode();
    }

    @Override
    public String toString() {
        return "TeamInvitationManager{" +
                "sessionFactory=" + sessionFactory +
                '}';
    }

    public List<TeamInvitation> getAllTeamInvitations() throws HibernateException {
        List<TeamInvitation> result = new ArrayList<>();

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            List teamInvitations = session.createQuery("FROM TeamInvitationImpl").list();
            for (Object teamInvitation : teamInvitations) {
                result.add((TeamInvitation) teamInvitation);
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw e;
        } finally {
            if (session != null)
                session.close();
        }

        return result;
    }

    public TeamInvitation getTeamInvitation(Integer id) throws NullPointerException, HibernateException {
        checkNotNull(id, "value of 'id' is null!");

        TeamInvitation teamInvitation = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            teamInvitation = (TeamInvitation) session.get(TeamInvitationImpl.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw e;
        } finally {
            if (session != null)
                session.close();
        }

        return teamInvitation;
    }

    public void updateTeamInvitation(TeamInvitation teamInvitation) throws NullPointerException, HibernateException {
        checkNotNull(teamInvitation, "value of 'teamInvitation' is null!");

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            TeamInvitation entity = (TeamInvitation) session.get(TeamInvitationImpl.class, teamInvitation.getId());
            session.update(entity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw e;
        } finally {
            if (session != null)
                session.close();
        }
    }

    public void deleteTeamInvitation(TeamInvitation teamInvitation) throws NullPointerException, HibernateException {
        checkNotNull(teamInvitation, "value of 'teamInvitation' is null!");

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            TeamInvitation entity = (TeamInvitation) session.get(TeamInvitationImpl.class, teamInvitation.getId());
            session.delete(entity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw e;
        } finally {
            if (session != null)
                session.close();
        }
    }

    public Integer addTeamInvitation(TeamInvitation teamInvitation) throws NullPointerException, HibernateException {
        checkNotNull(teamInvitation, "value of 'teamInvitation' is null!");

        Integer id = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            id = (Integer) session.save(teamInvitation);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw e;
        } finally {
            if (session != null)
                session.close();
        }

        return id;
    }

    public TeamInvitation createTeamInvitation() {
        return new TeamInvitationImpl();
    }
}
