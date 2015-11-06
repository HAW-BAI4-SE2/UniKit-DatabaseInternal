package net.unikit.database.internal.implementations;

import net.unikit.database.common.interfaces.DatabaseConfiguration;
import net.unikit.database.internal.interfaces.UniKitDatabaseManager;

/**
 * Created by Andreas on 28.10.2015.
 */
public final class UniKitDatabaseManagerFactory {
    private UniKitDatabaseManagerFactory() {
    }

    public static UniKitDatabaseManager createDatabaseManager(DatabaseConfiguration databaseConfiguration) throws NullPointerException {
        return UniKitDatabaseManagerImpl.create(databaseConfiguration);
    }
}
