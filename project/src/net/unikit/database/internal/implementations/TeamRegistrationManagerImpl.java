package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.TeamRegistration;
import net.unikit.database.internal.interfaces.TeamRegistrationManager;
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
final class TeamRegistrationManagerImpl implements TeamRegistrationManager {
    private final SessionFactory sessionFactory;

    private void validate() throws NullPointerException {
        checkNotNull(sessionFactory, "value of 'sessionFactory' is null!");
    }

    private TeamRegistrationManagerImpl(SessionFactory sessionFactory) throws NullPointerException {
        this.sessionFactory = sessionFactory;
        validate();
    }

    public static TeamRegistrationManager create(SessionFactory sessionFactory) throws NullPointerException {
        return new TeamRegistrationManagerImpl(sessionFactory);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamRegistrationManagerImpl)) return false;

        TeamRegistrationManagerImpl that = (TeamRegistrationManagerImpl) o;

        return getSessionFactory().equals(that.getSessionFactory());

    }

    @Override
    public int hashCode() {
        return getSessionFactory().hashCode();
    }

    @Override
    public String toString() {
        return "TeamRegistrationManager{" +
                "sessionFactory=" + sessionFactory +
                '}';
    }

    public List<TeamRegistration> getAllTeamRegistrations() throws HibernateException {
        List<TeamRegistration> result = new ArrayList<>();

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            List teamRegistrations = session.createQuery("FROM TeamRegistrationImpl").list();
            for (Object teamRegistration : teamRegistrations) {
                result.add((TeamRegistration) teamRegistration);
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

    public TeamRegistration getTeamRegistration(Integer id) throws NullPointerException, HibernateException {
        checkNotNull(id, "value of 'id' is null!");

        TeamRegistration teamRegistration = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            teamRegistration = (TeamRegistration) session.get(TeamRegistrationImpl.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw e;
        } finally {
            if (session != null)
                session.close();
        }

        return teamRegistration;
    }

    public void updateTeamRegistration(TeamRegistration teamRegistration) throws NullPointerException, HibernateException {
        checkNotNull(teamRegistration, "value of 'teamRegistration' is null!");

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            TeamRegistration entity = (TeamRegistration) session.get(TeamRegistrationImpl.class, teamRegistration.getId());
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

    public void deleteTeamRegistration(TeamRegistration teamRegistration) throws NullPointerException, HibernateException {
        checkNotNull(teamRegistration, "value of 'teamRegistration' is null!");

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            TeamRegistration entity = (TeamRegistration) session.get(TeamRegistrationImpl.class, teamRegistration.getId());
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

    public Integer addTeamRegistration(TeamRegistration teamRegistration) throws NullPointerException, HibernateException {
        checkNotNull(teamRegistration, "value of 'teamRegistration' is null!");

        Integer id = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            id = (Integer) session.save(teamRegistration);
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

    public TeamRegistration createTeamRegistration() {
        return new TeamRegistrationImpl();
    }
}
