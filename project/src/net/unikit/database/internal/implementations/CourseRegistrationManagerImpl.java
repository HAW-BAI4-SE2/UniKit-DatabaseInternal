package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.CourseRegistration;
import net.unikit.database.internal.interfaces.CourseRegistrationManager;
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
final class CourseRegistrationManagerImpl implements CourseRegistrationManager {
    private final SessionFactory sessionFactory;

    private void validate() throws NullPointerException {
        checkNotNull(sessionFactory, "value of 'sessionFactory' is null!");
    }

    private CourseRegistrationManagerImpl(SessionFactory sessionFactory) throws NullPointerException {
        this.sessionFactory = sessionFactory;
        validate();
    }

    public static CourseRegistrationManager create(SessionFactory sessionFactory) throws NullPointerException {
        return new CourseRegistrationManagerImpl(sessionFactory);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseRegistrationManagerImpl)) return false;

        CourseRegistrationManagerImpl that = (CourseRegistrationManagerImpl) o;

        return getSessionFactory().equals(that.getSessionFactory());

    }

    @Override
    public int hashCode() {
        return getSessionFactory().hashCode();
    }

    @Override
    public String toString() {
        return "CourseRegistrationManager{" +
                "sessionFactory=" + sessionFactory +
                '}';
    }

    public List<CourseRegistration> getAllCourseRegistrations() throws HibernateException {
        List<CourseRegistration> result = new ArrayList<>();

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            List courseRegistrations = session.createQuery("FROM CourseRegistrationImpl").list();
            for (Object courseRegistration : courseRegistrations) {
                result.add((CourseRegistration) courseRegistration);
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

    public CourseRegistration getCourseRegistration(Integer id) throws NullPointerException, HibernateException {
        checkNotNull(id, "value of 'id' is null!");

        CourseRegistration courseRegistration = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            courseRegistration = (CourseRegistration) session.get(CourseRegistrationImpl.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw e;
        } finally {
            if (session != null)
                session.close();
        }

        return courseRegistration;
    }

    public void updateCourseRegistration(CourseRegistration courseRegistration) throws NullPointerException, HibernateException {
        checkNotNull(courseRegistration, "value of 'courseRegistration' is null!");

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            CourseRegistration entity = (CourseRegistration) session.get(CourseRegistrationImpl.class, courseRegistration.getId());
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

    public void deleteCourseRegistration(CourseRegistration courseRegistration) throws NullPointerException, HibernateException {
        checkNotNull(courseRegistration, "value of 'courseRegistration' is null!");

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            CourseRegistration entity = (CourseRegistration) session.get(CourseRegistrationImpl.class, courseRegistration.getId());
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

    public Integer addCourseRegistration(CourseRegistration courseRegistration) throws NullPointerException, HibernateException {
        checkNotNull(courseRegistration, "value of 'courseRegistration' is null!");

        Integer id = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            id = (Integer) session.save(courseRegistration);
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

    public CourseRegistration createCourseRegistration() {
        return new CourseRegistrationImpl();
    }
}
