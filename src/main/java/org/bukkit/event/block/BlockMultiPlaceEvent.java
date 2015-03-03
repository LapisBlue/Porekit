package org.bukkit.event.block;

import com.google.common.collect.ImmutableList;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Fired when a single block placement action of a player triggers the
 * creation of multiple blocks(e.g. placing a bed block). The block returned
 * by {@link #getBlockPlaced()} and its related methods is the block where
 * the placed block would exist if the placement only affected a single
 * block.
 */
public class BlockMultiPlaceEvent extends BlockPlaceEvent {
    private final List<BlockState> states;

    public BlockMultiPlaceEvent(List<BlockState> states, Block clicked, ItemStack itemInHand, Player thePlayer, boolean canBuild) {
        super(null, null, clicked, itemInHand, thePlayer, canBuild);
        if (isPoreEvent()) {
            this.states = null;
        } else {
            this.block = states.get(0).getBlock();
            this.replacedBlockState = states.get(0);
            this.states = ImmutableList.copyOf(states);
        }
    }

    /**
     * Gets a list of blockstates for all blocks which were replaced by the
     * placement of the new blocks. Most of these blocks will just have a
     * Material type of AIR.
     *
     * @return immutable list of replaced BlockStates
     */
    public List<BlockState> getReplacedBlockStates() {
        return states;
    }
}
