package net.unikit.database.internal.implementations;

import net.unikit.database.interfaces.DatabaseConfiguration;
import net.unikit.database.internal.interfaces.InternalDatabaseManager;

/**
 * Created by Andreas on 19.11.2015.
 */
public final class InternalDatabaseManagerFactory {
    public static InternalDatabaseManager createInternalDatabaseManager(DatabaseConfiguration databaseConfiguration) {
        return InternalDatabaseManagerImpl.create(databaseConfiguration);
    }
}
