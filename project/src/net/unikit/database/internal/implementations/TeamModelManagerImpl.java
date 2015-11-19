package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.entities.TeamModel;
import net.unikit.database.internal.interfaces.managers.TeamModelManager;
import org.hibernate.SessionFactory;

/**
 * Created by Andreas on 20.11.2015.
 */
final class TeamModelManagerImpl
        extends AbstractModelManagerImpl<TeamModel, Integer, TeamModelImpl, Integer>
        implements TeamModelManager {
    private TeamModelManagerImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public static TeamModelManager create(SessionFactory sessionFactory) {
        return new TeamModelManagerImpl(sessionFactory);
    }

    @Override
    public TeamModel createEntity() {
        return null;
    }

    @Override
    protected Integer createIdFromBaseIdType(Integer id) {
        return null;
    }

    @Override
    protected Integer createBaseIdFromIdType(Integer id) {
        return null;
    }

    @Override
    protected Class getAnnotatedClass() {
        return null;
    }

    @Override
    protected void updateDatabaseFields(TeamModelImpl entityOld, TeamModelImpl entityNew) {

    }
}
