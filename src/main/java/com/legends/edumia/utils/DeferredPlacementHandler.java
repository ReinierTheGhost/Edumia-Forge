package com.legends.edumia.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public class DeferredPlacementHandler {

    private final List<DeferredPlacement> placements = new ArrayList<>();

    // Class to hold deferred placement data
    public static class DeferredPlacement {
        public final WorldGenLevel level;
        public final BlockPos pos;
        public final BlockState state;
        public final int flags;

        public DeferredPlacement(WorldGenLevel level, BlockPos pos, BlockState state, int flags) {
            this.level = level;
            this.pos = pos;
            this.state = state;
            this.flags = flags;
        }
    }

    // Queue a placement
    public void queuePlacement(WorldGenLevel level, BlockPos pos, BlockState state, int flags) {
        placements.add(new DeferredPlacement(level, pos, state, flags));
    }

    // Execute all queued placements
    public void executePendingPlacements() {
        for (DeferredPlacement placement : placements) {
            placement.level.setBlock(placement.pos, placement.state, placement.flags);
        }
        placements.clear();  // Clear the queue after execution
    }
//    // List to store blocks that need to be placed later
//    private final List<BlockPlacement> deferredPlacements = new ArrayList<>();
//
//    // Represents a block placement
//    private static class BlockPlacement {
//        private final BlockPos pos;
//        private final BlockState state;
//
//        public BlockPlacement(BlockPos pos, BlockState state) {
//            this.pos = pos.immutable();
//            this.state = state;
//        }
//
//        public BlockPos getPos() {
//            return pos;
//        }
//
//        public BlockState getState() {
//            return state;
//        }
//    }
//
//    // Safely place a block, deferring if the chunk isn't loaded
//    public void safeSetBlock(Level level, BlockPos pos, BlockState state) {
//        ChunkPos chunkPos = new ChunkPos(pos);
//        if (!level.getChunkSource().hasChunk(chunkPos.x, chunkPos.z)) {
//            // Add block to the deferred list if the chunk isn't loaded
//            deferredPlacements.add(new BlockPlacement(pos, state));
//        } else {
//            // Place the block immediately if the chunk is loaded
//            level.setBlock(pos, state, 2);
//        }
//    }
//
//    // Process deferred blocks once the chunks are loaded
//    public void processDeferredBlocks(Level level) {
//        List<BlockPlacement> toRemove = new ArrayList<>();
//
//        for (BlockPlacement placement : deferredPlacements) {
//            BlockPos pos = placement.getPos();
//            ChunkPos chunkPos = new ChunkPos(pos);
//            if (level.getChunkSource().hasChunk(chunkPos.x, chunkPos.z)) {
//                // Place the block if the chunk is now loaded
//                level.setBlock(pos, placement.getState(), 2);
//                toRemove.add(placement); // Mark for removal after placement
//            }
//        }
//
//        // Remove processed blocks from the deferred list
//        deferredPlacements.removeAll(toRemove);
//    }
//
//    // Helper method to clear the deferred list (optional, for cleanup)
//    public void clearDeferredPlacements() {
//        deferredPlacements.clear();
//    }
}

