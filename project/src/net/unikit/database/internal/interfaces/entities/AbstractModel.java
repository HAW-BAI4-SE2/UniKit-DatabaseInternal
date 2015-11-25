package net.unikit.database.internal.interfaces.entities;

/**
 * An abstract model for a database entry.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface AbstractModel<IdType> {
    /**
     * Getter for the internal identifier in the database.
     * @return The internal identifier in the database
     */
    IdType getId();
}
