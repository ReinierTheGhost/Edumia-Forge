package com.legends.edumia.dynamictrees.cellkits;

import com.ferreusveritas.dynamictrees.api.cell.Cell;
import com.ferreusveritas.dynamictrees.api.cell.CellKit;
import com.ferreusveritas.dynamictrees.api.cell.CellNull;
import com.ferreusveritas.dynamictrees.api.cell.CellSolver;
import com.ferreusveritas.dynamictrees.api.registry.Registry;
import com.ferreusveritas.dynamictrees.cell.CellKits;
import com.ferreusveritas.dynamictrees.cell.MetadataCell;
import com.ferreusveritas.dynamictrees.cell.NormalCell;
import com.ferreusveritas.dynamictrees.util.SimpleVoxmap;
import com.legends.edumia.Edumia;
import com.legends.edumia.dynamictrees.cellkits.cell.PoplarBranchCell;
import com.legends.edumia.dynamictrees.cellkits.cell.PoplarLeafCell;
import com.legends.edumia.dynamictrees.cellkits.cell.PoplarTopBranchCell;
import net.minecraft.resources.ResourceLocation;

public class DTEdumiaCellKits {
    public static void register(final Registry<CellKit> registry) {
        registry.registerAll(POPLAR);
    }

    public static final CellKit POPLAR = new CellKit(new ResourceLocation(Edumia.MOD_ID, "poplar")) {

        private final Cell poplarBranch = new PoplarBranchCell();
        private final Cell poplarTopBranch = new PoplarTopBranchCell();
        private final Cell poplarUpperTrunk = new NormalCell(4);

        private final Cell[] poplarLeaves = new Cell[] { CellNull.NULL_CELL, new PoplarLeafCell(1),
                new PoplarLeafCell(2), new PoplarLeafCell(3), new PoplarLeafCell(4), };

        private final CellSolver solver = new CellKits.BasicSolver(new short[] { 0x0412, 0x0311, 0x0211 });

        @Override
        public Cell getCellForLeaves(int hydro) {
            return poplarLeaves[hydro];
        }

        @Override
        public Cell getCellForBranch(int radius, int meta) {
            if (meta == MetadataCell.TOP_BRANCH)
                return poplarTopBranch;
            if (radius == 1)
                return poplarBranch;
            if (radius < 4)
                return poplarUpperTrunk;
            return CellNull.NULL_CELL;
        }

        @Override
        public SimpleVoxmap getLeafCluster() {
            return DTEdumiaLeafClusters.POPLAR;
        }

        @Override
        public CellSolver getCellSolver() {
            return solver;
        }

        @Override
        public int getDefaultHydration() {
            return 4;
        }

    };
}
