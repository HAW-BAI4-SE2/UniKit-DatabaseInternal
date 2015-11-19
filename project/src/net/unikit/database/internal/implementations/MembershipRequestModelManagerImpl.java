package net.unikit.database.internal.implementations;

import net.unikit.database.internal.interfaces.entities.MembershipRequestModel;
import net.unikit.database.internal.interfaces.managers.MembershipRequestModelManager;
import org.hibernate.SessionFactory;

/**
 * Created by Andreas on 20.11.2015.
 */
final class MembershipRequestModelManagerImpl
        extends AbstractModelManagerImpl<MembershipRequestModel, Integer, MembershipRequestModelImpl, Integer>
        implements MembershipRequestModelManager {
    private MembershipRequestModelManagerImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public static MembershipRequestModelManager create(SessionFactory sessionFactory) {
        return new MembershipRequestModelManagerImpl(sessionFactory);
    }

    @Override
    public MembershipRequestModel createEntity() {
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
    protected void updateDatabaseFields(MembershipRequestModelImpl entityOld, MembershipRequestModelImpl entityNew) {

    }
}
