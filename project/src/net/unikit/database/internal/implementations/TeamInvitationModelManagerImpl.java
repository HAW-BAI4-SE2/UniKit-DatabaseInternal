package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.entities.TeamInvitationModel;
import net.unikit.database.internal.interfaces.managers.TeamInvitationModelManager;
import org.hibernate.SessionFactory;

/**
 * Created by Andreas on 20.11.2015.
 */
final class TeamInvitationModelManagerImpl
        extends AbstractModelManagerImpl<TeamInvitationModel, Integer, TeamInvitationModelImpl, Integer>
        implements TeamInvitationModelManager {
    private TeamInvitationModelManagerImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public static TeamInvitationModelManager create(SessionFactory sessionFactory) {
        return new TeamInvitationModelManagerImpl(sessionFactory);
    }

    @Override
    public TeamInvitationModel createEntity() {
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
    protected void updateDatabaseFields(TeamInvitationModelImpl entityOld, TeamInvitationModelImpl entityNew) {

    }
}
