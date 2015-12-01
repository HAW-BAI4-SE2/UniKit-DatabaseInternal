package net.unikit.database.internal.implementations;

import net.unikit.database.implementations.AbstractModelManagerImpl;
import net.unikit.database.internal.interfaces.entities.CourseRegistrationModel;
import net.unikit.database.internal.interfaces.managers.CourseRegistrationModelManager;
import org.hibernate.SessionFactory;

/**
 * Created by Andreas on 20.11.2015.
 */
final class CourseRegistrationModelManagerImpl
        extends AbstractModelManagerImpl<CourseRegistrationModel, Integer, CourseRegistrationModelImpl, Integer>
        implements CourseRegistrationModelManager {
    private CourseRegistrationModelManagerImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public static CourseRegistrationModelManager create(SessionFactory sessionFactory) {
        return new CourseRegistrationModelManagerImpl(sessionFactory);
    }

    @Override
    public CourseRegistrationModel createEntity() {
        return new CourseRegistrationModelImpl();
    }

    @Override
    protected Class getAnnotatedClass() {
        return CourseRegistrationModelImpl.class;
    }

    @Override
    protected void updateDatabaseFields(CourseRegistrationModelImpl entityOld, CourseRegistrationModelImpl entityNew) {
        entityOld.setIdField(entityNew.getIdField());
        entityOld.setStudentNumberField(entityNew.getStudentNumberField());
        entityOld.setCourseIdField(entityNew.getCourseId());
        entityOld.setCurrentlyAssignedToTeam(entityNew.isCurrentlyAssignedToTeamField());
    }
}
