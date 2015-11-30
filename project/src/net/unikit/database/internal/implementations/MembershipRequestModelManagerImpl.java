package net.unikit.database.internal.implementations;

import net.unikit.database.implementations.AbstractModelManagerImpl;
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
        return new MembershipRequestModelImpl();
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
        return MembershipRequestModelImpl.class;
    }

    @Override
    protected void updateDatabaseFields(MembershipRequestModelImpl entityOld, MembershipRequestModelImpl entityNew) {
        entityOld.setIdField(entityNew.getIdField());
        entityOld.setApplicantStudentNumberField(entityNew.getApplicantStudentNumberField());
        entityOld.setTeamField(entityNew.getTeamField());
    }
}
