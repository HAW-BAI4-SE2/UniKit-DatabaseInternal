package net.unikit.database.internal.implementations;

import net.unikit.database.implementations.AbstractModelManagerImpl;
import net.unikit.database.internal.interfaces.entities.TeamRegistrationModel;
import net.unikit.database.internal.interfaces.managers.TeamRegistrationModelManager;
import org.hibernate.SessionFactory;

/**
 * Created by Andreas on 20.11.2015.
 */
final class TeamRegistrationModelManagerImpl
        extends AbstractModelManagerImpl<TeamRegistrationModel, Integer, TeamRegistrationModelImpl, Integer>
        implements TeamRegistrationModelManager {
    private TeamRegistrationModelManagerImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public static TeamRegistrationModelManager create(SessionFactory sessionFactory) {
        return new TeamRegistrationModelManagerImpl(sessionFactory);
    }

    @Override
    public TeamRegistrationModel createEntity() {
        return new TeamRegistrationModelImpl();
    }

    @Override
    protected Integer createIdFromBaseIdType(Integer id) {
        return id;
    }

    @Override
    protected Integer createBaseIdFromIdType(Integer id) {
        return id;
    }

    @Override
    protected Class getAnnotatedClass() {
        return TeamRegistrationModelImpl.class;
    }

    @Override
    protected void updateDatabaseFields(TeamRegistrationModelImpl entityOld, TeamRegistrationModelImpl entityNew) {
        entityOld.setIdField(entityNew.getIdField());
        entityOld.setStudentNumberField(entityNew.getStudentNumberField());
        entityOld.setTeamField(entityNew.getTeamField());
    }
}
