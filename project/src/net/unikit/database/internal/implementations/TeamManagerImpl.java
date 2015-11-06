package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.Team;
import net.unikit.database.internal.interfaces.TeamManager;
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
final class TeamManagerImpl implements TeamManager {
    private final SessionFactory sessionFactory;

    private void validate() throws NullPointerException {
        checkNotNull(sessionFactory, "value of 'sessionFactory' is null!");
    }

    private TeamManagerImpl(SessionFactory sessionFactory) throws NullPointerException {
        this.sessionFactory = sessionFactory;
        validate();
    }

    public static TeamManager create(SessionFactory sessionFactory) throws NullPointerException {
        return new TeamManagerImpl(sessionFactory);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamManagerImpl)) return false;

        TeamManagerImpl that = (TeamManagerImpl) o;

        return getSessionFactory().equals(that.getSessionFactory());

    }

    @Override
    public int hashCode() {
        return getSessionFactory().hashCode();
    }

    @Override
    public String toString() {
        return "TeamManager{" +
                "sessionFactory=" + sessionFactory +
                '}';
    }

    public List<Team> getAllTeams() throws HibernateException {
        List<Team> result = new ArrayList<>();

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            List teams = session.createQuery("FROM TeamImpl").list();
            for (Object team : teams) {
                result.add((Team) team);
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

    public Team getTeam(Integer id) throws NullPointerException, HibernateException {
        checkNotNull(id, "value of 'id' is null!");

        Team team = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            team = (Team) session.get(TeamImpl.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw e;
        } finally {
            if (session != null)
                session.close();
        }

        return team;
    }

    public void updateTeam(Team team) throws NullPointerException, HibernateException {
        checkNotNull(team, "value of 'team' is null!");

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Team entity = (Team) session.get(TeamImpl.class, team.getId());
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

    public void deleteTeam(Team team) throws NullPointerException, HibernateException {
        checkNotNull(team, "value of 'team' is null!");

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Team entity = (Team) session.get(TeamImpl.class, team.getId());
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

    public Integer addTeam(Team team) throws NullPointerException, HibernateException {
        checkNotNull(team, "value of 'team' is null!");

        Integer id = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            id = (Integer) session.save(team);
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

    public Team createTeam() {
        return new TeamImpl();
    }
}
