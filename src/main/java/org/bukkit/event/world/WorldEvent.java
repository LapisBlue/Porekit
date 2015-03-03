package org.bukkit.event.world;

import org.bukkit.World;
import org.bukkit.event.Event;

/**
 * Represents events within a world
 */
public abstract class WorldEvent extends Event {
    private final World world;

    public WorldEvent(final World world) {
        this.world = world;
    }

    protected WorldEvent(final org.bukkit.Chunk chunk) {
        this.world = isPoreEvent() ? null : chunk.getWorld();
    }

    protected WorldEvent(final org.bukkit.Location location) {
        this.world = isPoreEvent() ? null : location.getWorld();
    }

    /**
     * Gets the world primarily involved with this event
     *
     * @return World which caused this event
     */
    public World getWorld() {
        return world;
    }
}
