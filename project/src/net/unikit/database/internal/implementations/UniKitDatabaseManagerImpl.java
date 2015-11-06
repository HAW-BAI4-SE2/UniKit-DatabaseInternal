package net.unikit.database.internal.implementations;

import net.unikit.database.common.interfaces.DatabaseConfiguration;
import net.unikit.database.internal.interfaces.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Andreas on 28.10.2015.
 */
final class UniKitDatabaseManagerImpl implements UniKitDatabaseManager {
    private final DatabaseConfiguration databaseConfiguration;
    private SessionFactory sessionFactory;
    private CourseRegistrationManager courseRegistrationManager; //TODO: ENTITIES
    private TeamManager teamManager;
    private TeamRegistrationManager teamRegistrationManager;
    private TeamInvitationManager teamInvitationManager;
    private TeamApplicationManager teamApplicationManager;

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

        configuration.addAnnotatedClass(CourseRegistrationImpl.class);
        configuration.addAnnotatedClass(TeamImpl.class);
        configuration.addAnnotatedClass(TeamRegistrationImpl.class);
        configuration.addAnnotatedClass(TeamInvitationImpl.class);
        configuration.addAnnotatedClass(TeamApplicationImpl.class);

        sessionFactory = configuration.buildSessionFactory();

        courseRegistrationManager = CourseRegistrationManagerImpl.create(sessionFactory); //TODO: ENTITIES
        teamManager = TeamManagerImpl.create(sessionFactory);
        teamRegistrationManager = TeamRegistrationManagerImpl.create(sessionFactory);
        teamInvitationManager = TeamInvitationManagerImpl.create(sessionFactory);
        teamApplicationManager = TeamApplicationManagerImpl.create(sessionFactory);
    }

    private UniKitDatabaseManagerImpl(DatabaseConfiguration databaseConfiguration) throws NullPointerException {
        this.databaseConfiguration = databaseConfiguration;
        this.sessionFactory = null;
        this.courseRegistrationManager = null; //TODO: ENTITIES
        this.teamManager = null;
        this.teamRegistrationManager = null;
        this.teamInvitationManager = null;
        this.teamApplicationManager = null;
        validate();
        init();
    }

    public static UniKitDatabaseManager create(DatabaseConfiguration databaseConfiguration) throws NullPointerException {
        return new UniKitDatabaseManagerImpl(databaseConfiguration);
    }

    @Override
    public DatabaseConfiguration getDatabaseConfiguration() {
        return databaseConfiguration;
    }

    @Override
    public CourseRegistrationManager getCourseRegistrationManager() {
        return courseRegistrationManager;
    }

    @Override
    public TeamManager getTeamManager() {
        return teamManager;
    }

    @Override
    public TeamRegistrationManager getTeamRegistrationManager() {
        return teamRegistrationManager;
    }

    @Override
    public TeamInvitationManager getTeamInvitationManager() {
        return teamInvitationManager;
    }

    @Override
    public TeamApplicationManager getTeamApplicationManager() {
        return teamApplicationManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UniKitDatabaseManagerImpl)) return false;

        UniKitDatabaseManagerImpl that = (UniKitDatabaseManagerImpl) o;

        if (getDatabaseConfiguration() != null ? !getDatabaseConfiguration().equals(that.getDatabaseConfiguration()) : that.getDatabaseConfiguration() != null)
            return false;
        return !(sessionFactory != null ? !sessionFactory.equals(that.sessionFactory) : that.sessionFactory != null);

    }

    @Override
    public int hashCode() {
        int result = getDatabaseConfiguration() != null ? getDatabaseConfiguration().hashCode() : 0;
        result = 31 * result + (sessionFactory != null ? sessionFactory.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UniKitDatabaseManager{" +
                "databaseConfiguration=" + databaseConfiguration +
                '}';
    }
}
