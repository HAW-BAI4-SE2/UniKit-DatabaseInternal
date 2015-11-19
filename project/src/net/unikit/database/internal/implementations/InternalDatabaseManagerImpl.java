package net.unikit.database.internal.implementations;

import net.unikit.database.interfaces.DatabaseConfiguration;
import net.unikit.database.internal.interfaces.InternalDatabaseManager;
import net.unikit.database.internal.interfaces.managers.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

final class InternalDatabaseManagerImpl implements InternalDatabaseManager {
    private final DatabaseConfiguration databaseConfiguration;
    private SessionFactory sessionFactory;
    private CourseRegistrationModelManager courseRegistrationManager;
    private TeamModelManager teamManager;
    private TeamRegistrationModelManager teamRegistrationManager;
    private TeamInvitationModelManager teamInvitationManager;
    private MembershipRequestModelManager membershipRequestManager;

    private void validate() throws NullPointerException {
        checkNotNull(databaseConfiguration, "value of 'databaseConfiguration' is null!");
        checkArgument(databaseConfiguration.getDialect().equals("org.hibernate.dialect.MySQLDialect"),
                "no support for dialect '" + databaseConfiguration.getDialect() + "'!");
        checkArgument(databaseConfiguration.getDriverClass().equals("com.mysql.jdbc.Driver"),
                "no support for driver class '" + databaseConfiguration.getDriverClass() + "'!");
    }

    private void init() {
        String connectionUrl = "jdbc:mysql://" + databaseConfiguration.getHostname() + ":" +
                databaseConfiguration.getPort() + "/" + databaseConfiguration.getSchema();

        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.dialect", databaseConfiguration.getDialect());
        configuration.setProperty("hibernate.connection.driver_class", databaseConfiguration.getDriverClass());
        configuration.setProperty("hibernate.connection.url", connectionUrl);
        configuration.setProperty("hibernate.connection.username", databaseConfiguration.getUsername());
        configuration.setProperty("hibernate.connection.password", databaseConfiguration.getPassword());
        configuration.setProperty("hibernate.enable_lazy_load_no_trans", "true");

        configuration.addAnnotatedClass(CourseRegistrationModelImpl.class);
        configuration.addAnnotatedClass(TeamModelImpl.class);
        configuration.addAnnotatedClass(TeamRegistrationModelImpl.class);
        configuration.addAnnotatedClass(TeamInvitationModelImpl.class);
        configuration.addAnnotatedClass(MembershipRequestModelImpl.class);

        sessionFactory = configuration.buildSessionFactory();

        courseRegistrationManager = CourseRegistrationModelManagerImpl.create(sessionFactory);
        teamManager = TeamModelManagerImpl.create(sessionFactory);
        teamRegistrationManager = TeamRegistrationModelManagerImpl.create(sessionFactory);
        teamInvitationManager = TeamInvitationModelManagerImpl.create(sessionFactory);
        membershipRequestManager = MembershipRequestModelManagerImpl.create(sessionFactory);
    }

    private InternalDatabaseManagerImpl(DatabaseConfiguration databaseConfiguration) throws NullPointerException {
        this.databaseConfiguration = databaseConfiguration;
        this.sessionFactory = null;
        this.courseRegistrationManager = null;
        this.teamManager = null;
        this.teamRegistrationManager = null;
        this.teamInvitationManager = null;
        this.membershipRequestManager = null;
        validate();
        init();
    }

    public static InternalDatabaseManager create(DatabaseConfiguration databaseConfiguration) throws NullPointerException {
        return new InternalDatabaseManagerImpl(databaseConfiguration);
    }

    @Override
    public CourseRegistrationModelManager getCourseRegistrationModelManager() {
        return courseRegistrationManager;
    }

    @Override
    public MembershipRequestModelManager getMembershipRequestModelManager() {
        return membershipRequestManager;
    }

    @Override
    public TeamInvitationModelManager getTeamInvitationModelManager() {
        return teamInvitationManager;
    }

    @Override
    public TeamModelManager getTeamModelManager() {
        return teamManager;
    }

    @Override
    public TeamRegistrationModelManager getTeamRegistrationModelManager() {
        return teamRegistrationManager;
    }
}
