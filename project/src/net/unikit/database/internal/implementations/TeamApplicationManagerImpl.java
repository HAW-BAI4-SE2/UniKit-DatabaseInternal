package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.TeamApplication;
import net.unikit.database.internal.interfaces.TeamApplicationManager;
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
final class TeamApplicationManagerImpl implements TeamApplicationManager {
    private final SessionFactory sessionFactory;

    private void validate() throws NullPointerException {
        checkNotNull(sessionFactory, "value of 'sessionFactory' is null!");
    }

    private TeamApplicationManagerImpl(SessionFactory sessionFactory) throws NullPointerException {
        this.sessionFactory = sessionFactory;
        validate();
    }

    public static TeamApplicationManager create(SessionFactory sessionFactory) throws NullPointerException {
        return new TeamApplicationManagerImpl(sessionFactory);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamApplicationManagerImpl)) return false;

        TeamApplicationManagerImpl that = (TeamApplicationManagerImpl) o;

        return getSessionFactory().equals(that.getSessionFactory());

    }

    @Override
    public int hashCode() {
        return getSessionFactory().hashCode();
    }

    @Override
    public String toString() {
        return "TeamApplicationManager{" +
                "sessionFactory=" + sessionFactory +
                '}';
    }

    public List<TeamApplication> getAllTeamApplications() throws HibernateException {
        List<TeamApplication> result = new ArrayList<>();

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            List teamApplications = session.createQuery("FROM TeamApplicationImpl").list();
            for (Object teamApplication : teamApplications) {
                result.add((TeamApplication) teamApplication);
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

    public TeamApplication getTeamApplication(Integer id) throws NullPointerException, HibernateException {
        checkNotNull(id, "value of 'id' is null!");

        TeamApplication teamApplication = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            teamApplication = (TeamApplication) session.get(TeamApplicationImpl.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw e;
        } finally {
            if (session != null)
                session.close();
        }

        return teamApplication;
    }

    public void updateTeamApplication(TeamApplication teamApplication) throws NullPointerException, HibernateException {
        checkNotNull(teamApplication, "value of 'teamApplication' is null!");

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            TeamApplication entity = (TeamApplication) session.get(TeamApplicationImpl.class, teamApplication.getId());
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

    public void deleteTeamApplication(TeamApplication teamApplication) throws NullPointerException, HibernateException {
        checkNotNull(teamApplication, "value of 'teamApplication' is null!");

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            TeamApplication entity = (TeamApplication) session.get(TeamApplicationImpl.class, teamApplication.getId());
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

    public Integer addTeamApplication(TeamApplication teamApplication) throws NullPointerException, HibernateException {
        checkNotNull(teamApplication, "value of 'teamApplication' is null!");

        Integer id = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            id = (Integer) session.save(teamApplication);
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

    public TeamApplication createTeamApplication() {
        return new TeamApplicationImpl();
    }
}
