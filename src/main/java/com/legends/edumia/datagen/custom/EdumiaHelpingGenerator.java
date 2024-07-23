package com.legends.edumia.datagen.custom;


import com.legends.edumia.blocks.blocksets.BuildingSets;
import com.legends.edumia.datagen.custom.loot_tables.BlockDrops;
import com.legends.edumia.datagen.custom.models.*;
import com.legends.edumia.datagen.custom.tags.MineablePickaxe;
import com.legends.edumia.datagen.custom.tags.Pillar;
import com.legends.edumia.datagen.custom.tags.RequiresStoneTool;
import com.legends.edumia.datagen.custom.tags.Walls;

public class EdumiaHelpingGenerator {
    public static void generateFiles() {

//        for (WoodBlockSets.SimpleVanillaBlocks beam : WoodBlockSets.beams){
//            SimplePillarModel.blocks.add(new SimplePillarModel.Pillar(beam.beam()));
//        }
//
//        for (ClayTilingSets.ClayTilingSet set : ClayTilingSets.sets){
//            SimpleBlockModel.blocks.add(set.block());
//            SimpleAxisSlabModel.blocks.add(new SimpleAxisSlabModel.Slab(set.block(), set.slab()));
//            SimpleStairModel.blocks.add(new SimpleStairModel.Stair(set.block(), set.stairs()));
//            SimpleCornerBlockModel.blocks.add(new SimpleCornerBlockModel.Corner(set.block(), set.corner()));
//
//            BlockDrops.blocks.add(set.block());
//            BlockDrops.blocks.add(set.slab());
//            BlockDrops.blocks.add(set.stairs());
//            BlockDrops.blocks.add(set.corner());
//
//            MineablePickaxe.blocks.add(set.block());
//            MineablePickaxe.blocks.add(set.slab());
//            MineablePickaxe.blocks.add(set.stairs());
//            MineablePickaxe.blocks.add(set.corner());
//
//            RequiresIronTool.blocks.add(set.block());
//            RequiresIronTool.blocks.add(set.slab());
//            RequiresIronTool.blocks.add(set.stairs());
//            RequiresIronTool.blocks.add(set.corner());
//
//        }
//
//        for (WoodBlockSets.SimpleBlockSet set : WoodBlockSets.sets){
//            if(set.leaves() != null) {
//                SimpleLeavesModel.blocks.add(set.leaves());
//                LeavesDrops.blocks.add(set.leaves());
//                Leaves.leaves.add(set.leaves());
//            }
//
//
//            SimplePillarModel.blocks.add(new SimplePillarModel.Pillar(set.log()));
//            SimpleWoodBlockModel.blocks.add(new SimpleWoodBlockModel.WoodBlocks(set.log(), set.wood()));
//            SimpleStairModel.blocks.add(new SimpleStairModel.Stair(set.log(), set.woodStairs()));
//            SimpleAxisSlabModel.blocks.add(new SimpleAxisSlabModel.Slab(set.log(), set.woodSlab()));
//            SimpleWallModel.blocks.add(new SimpleWallModel.Wall(set.log(), set.woodWall()));
//            SimpleFenceModel.blocks.add(new SimpleFenceModel.Fence(set.log(), set.woodFence()));
//            SimplePillarModel.blocks.add(new SimplePillarModel.Pillar(set.strippedLog()));
//            SimpleWoodBlockModel.blocks.add(new SimpleWoodBlockModel.WoodBlocks(set.strippedLog(), set.strippedWood()));
//            SimpleStairModel.blocks.add(new SimpleStairModel.Stair(set.strippedLog(), set.strippedWoodStairs()));
//            SimpleAxisSlabModel.blocks.add(new SimpleAxisSlabModel.Slab(set.strippedLog(), set.strippedWoodSlab()));
//            SimpleWallModel.blocks.add(new SimpleWallModel.Wall(set.strippedLog(), set.strippedWoodWall()));
//            SimpleFenceModel.blocks.add(new SimpleFenceModel.Fence(set.strippedLog(), set.strippedWoodFence()));
//
//            SimpleBlockModel.blocks.add(set.planks());
//            SimpleAxisSlabModel.blocks.add(new SimpleAxisSlabModel.Slab(set.planks(), set.planksSlab()));
//            SimpleStairModel.blocks.add(new SimpleStairModel.Stair(set.planks(), set.planksStairs()));
//            SimpleFenceModel.blocks.add(new SimpleFenceModel.Fence(set.planks(), set.planksFence()));
//            SimpleFenceGateModel.blocks.add(new SimpleFenceGateModel.FenceGate(set.planks(), set.planksGate()));
//            SimpleButtonModel.blocks.add(new SimpleButtonModel.Button(set.planks(), set.button()));
//            SimplePressurePlateModel.blocks.add(new SimplePressurePlateModel.PressurePlate(set.planks(), set.pressurePlate()));
//            SimplePillarModel.blocks.add(new SimplePillarModel.Pillar(set.beam()));
//            SimpleDoorModel.blocks.add(set.door());
//            SimpleTrapDoorModel.blocks.add(set.trapdoor());
//
//
//            BlockDrops.blocks.add(set.log());
//            BlockDrops.blocks.add(set.wood());
//            BlockDrops.blocks.add(set.strippedLog());
//            BlockDrops.blocks.add(set.strippedWood());
//            BlockDrops.blocks.add(set.woodWall());
//            BlockDrops.blocks.add(set.woodFence());
//            BlockDrops.blocks.add(set.planks());
//            BlockDrops.blocks.add(set.planksSlab());
//            BlockDrops.blocks.add(set.planksStairs());
//            BlockDrops.blocks.add(set.planksFence());
//            BlockDrops.blocks.add(set.planksGate());
//            BlockDrops.blocks.add(set.button());
//            BlockDrops.blocks.add(set.pressurePlate());
//            DoorDrops.blocks.add(set.door());
//            BlockDrops.blocks.add(set.trapdoor());
//
//            MineableAxe.blocks.add(set.log());
//            MineableAxe.blocks.add(set.wood());
//            MineableAxe.blocks.add(set.strippedLog());
//            MineableAxe.blocks.add(set.strippedWood());
//            MineableAxe.blocks.add(set.woodWall());
//            MineableAxe.blocks.add(set.woodFence());
//            MineableAxe.blocks.add(set.planks());
//            MineableAxe.blocks.add(set.planksSlab());
//            MineableAxe.blocks.add(set.planksStairs());
//            MineableAxe.blocks.add(set.planksFence());
//            MineableAxe.blocks.add(set.planksGate());
//            MineableAxe.blocks.add(set.button());
//            MineableAxe.blocks.add(set.pressurePlate());
//
//            Buttons.buttons.add(set.button());
//            Fences.fences.add(set.woodFence());
//            Fences.fences.add(set.planksFence());
//            FenceGates.fenceGates.add(set.planksGate());
//            Logs.logs.add(set.log());
//            Logs.logs.add(set.wood());
//            Logs.logs.add(set.woodWall());
//            Logs.logs.add(set.woodFence());
//            Logs.logs.add(set.woodSlab());
//            Logs.logs.add(set.woodStairs());
//            PressurePlates.pressurePlates.add(set.pressurePlate());
//            Walls.walls.add(set.woodWall());
//            Planks.planks.add(set.planks());
//
//        }
//
//        for (PaperwallSets.PaperwallSet set : PaperwallSets.paperwallSets){
//            SimplePaperWallModel.blocks.add(set.pane());
//        }
//
//        for (GlassSets.GlassSet set : GlassSets.glassSets){
//            SimpleGlassModel.blocks.add(new SimpleGlassModel.Glass(set.block(), set.pane()));
//        }

        for (BuildingSets.BuildSet set : BuildingSets.buildSets){
            SimpleBlockModel.blocks.add(set.block().get());
            SimpleAxisSlabModel.blocks.add(new SimpleAxisSlabModel.Slab(set.block().get(), set.slab().get()));
            SimpleStairModel.blocks.add(new SimpleStairModel.Stair(set.block().get(), set.stair().get()));
            SimpleWallModel.blocks.add(new SimpleWallModel.Wall(set.block().get(), set.wall().get()));

            BlockDrops.blocks.add(set.block().get());
            BlockDrops.blocks.add(set.slab().get());
            BlockDrops.blocks.add(set.stair().get());
            BlockDrops.blocks.add(set.wall().get());

            MineablePickaxe.blocks.add(set.block().get());
            MineablePickaxe.blocks.add(set.slab().get());
            MineablePickaxe.blocks.add(set.stair().get());
            MineablePickaxe.blocks.add(set.wall().get());

            RequiresStoneTool.blocks.add(set.block().get());
            RequiresStoneTool.blocks.add(set.slab().get());
            RequiresStoneTool.blocks.add(set.stair().get());
            RequiresStoneTool.blocks.add(set.wall().get());

            Walls.walls.add(set.wall().get());

            if (set.pillar() != null){
                SimplePillarModels.blocks.add(new SimplePillarModels.Pillar(set.pillar().get()));
                BlockDrops.blocks.add(set.pillar().get());
                Pillar.pillars.add(set.pillar().get());
                MineablePickaxe.blocks.add(set.pillar().get());
                RequiresStoneTool.blocks.add(set.pillar().get());

                SimpleAxisPillarSlabModel.blocks.add(new SimpleAxisPillarSlabModel.Slab(set.pillar().get(), set.pillarSlab().get()));
                BlockDrops.blocks.add(set.pillarSlab().get());
                MineablePickaxe.blocks.add(set.pillarSlab().get());
                RequiresStoneTool.blocks.add(set.pillarSlab().get());
            }


            SimpleSmallArchModel.blocks.add(new SimpleSmallArchModel.Arch(set.block().get(), set.smallArch().get()));
            BlockDrops.blocks.add(set.smallArch().get());
            MineablePickaxe.blocks.add(set.smallArch().get());
            RequiresStoneTool.blocks.add(set.smallArch().get());

            SimpleTwoMeterArchModel.blocks.add(new SimpleTwoMeterArchModel.Arch(set.block().get(), set.twoMeterArch().get()));
            BlockDrops.blocks.add(set.twoMeterArch().get());
            MineablePickaxe.blocks.add(set.twoMeterArch().get());
            RequiresStoneTool.blocks.add(set.twoMeterArch().get());

            SimpleRoundArchModel.blocks.add(new SimpleRoundArchModel.Arch(set.block().get(), set.roundArch().get()));
            BlockDrops.blocks.add(set.roundArch().get());
            MineablePickaxe.blocks.add(set.roundArch().get());
            RequiresStoneTool.blocks.add(set.roundArch().get());

            SimpleSegmentalArchModel.blocks.add(new SimpleSegmentalArchModel.Arch(set.block().get(), set.segmentalArch().get()));
            BlockDrops.blocks.add(set.segmentalArch().get());
            MineablePickaxe.blocks.add(set.segmentalArch().get());
            RequiresStoneTool.blocks.add(set.segmentalArch().get());

            SimpleGothicArchModel.blocks.add(new SimpleGothicArchModel.Arch(set.block().get(), set.gothicArch().get()));
            BlockDrops.blocks.add(set.gothicArch().get());
            MineablePickaxe.blocks.add(set.gothicArch().get());
            RequiresStoneTool.blocks.add(set.gothicArch().get());

            SimpleBalustradeModels.blocks.add(new SimpleBalustradeModels.Balustrade(set.block().get(), set.balustrade().get()));
            BlockDrops.blocks.add(set.balustrade().get());
            MineablePickaxe.blocks.add(set.balustrade().get());
            RequiresStoneTool.blocks.add(set.balustrade().get());

            SimpleArrowSlitModel.blocks.add(new SimpleArrowSlitModel.ArrowSlit(set.block().get(), set.arrowSlit().get()));
            BlockDrops.blocks.add(set.arrowSlit().get());
            MineablePickaxe.blocks.add(set.arrowSlit().get());
            RequiresStoneTool.blocks.add(set.arrowSlit().get());
        }

//        for (NotBrickBuildingSets.BuildSet set : NotBrickBuildingSets.buildSets){
//            SimpleBlockModel.blocks.add(set.block());
//            SimpleAxisSlabModel.blocks.add(new SimpleAxisSlabModel.Slab(set.block(), set.slab()));
//            SimpleStairModel.blocks.add(new SimpleStairModel.Stair(set.block(), set.stair()));
//
//            BlockDrops.blocks.add(set.block());
//            BlockDrops.blocks.add(set.slab());
//            BlockDrops.blocks.add(set.stair());
//
//            MineablePickaxe.blocks.add(set.block());
//            MineablePickaxe.blocks.add(set.slab());
//            MineablePickaxe.blocks.add(set.stair());
//
//            if (set.wall() != null){
//                SimpleWallModel.blocks.add(new SimpleWallModel.Wall(set.block(), set.wall()));
//                BlockDrops.blocks.add(set.wall());
//                MineablePickaxe.blocks.add(set.wall());
//                RequiresIronTool.blocks.add(set.wall());
//                Walls.walls.add(set.wall());
//            }
//
//        }
//
//        for (OreRockSets.OreRockSet set : OreRockSets.sets) {
//            if(set.coal_ore() != null){
//                SimpleBlockModel.blocks.add(set.coal_ore());
//                MineablePickaxe.blocks.add(set.coal_ore());
//            }
//            if(set.copper_ore() != null){
//                SimpleBlockModel.blocks.add(set.copper_ore());
//                MineablePickaxe.blocks.add(set.copper_ore());
//            }
//            if(set.tin_ore() != null){
//                SimpleBlockModel.blocks.add(set.tin_ore());
//                MineablePickaxe.blocks.add(set.tin_ore());
//            }
//            if(set.lead_ore() != null){
//                SimpleBlockModel.blocks.add(set.lead_ore());
//                MineablePickaxe.blocks.add(set.lead_ore());
//            }
//            if(set.silver_ore() != null){
//                SimpleBlockModel.blocks.add(set.silver_ore());
//                MineablePickaxe.blocks.add(set.silver_ore());
//            }
//            if(set.gold_ore() != null){
//                SimpleBlockModel.blocks.add(set.gold_ore());
//                MineablePickaxe.blocks.add(set.gold_ore());
//            }
//            if(set.iron_ore() != null){
//                SimpleBlockModel.blocks.add(set.iron_ore());
//                MineablePickaxe.blocks.add(set.iron_ore());
//            }
//            if(set.mithril_ore() != null){
//                SimpleBlockModel.blocks.add(set.mithril_ore());
//                MineablePickaxe.blocks.add(set.mithril_ore());
//            }
//
//        }
//
//        for (StoneSets.StoneSet set : StoneSets.naturalSets){
//            SimpleBlockModel.blocks.add(set.block());
//            SimpleAxisSlabModel.blocks.add(new SimpleAxisSlabModel.Slab(set.block(), set.slab()));
//            SimpleStairModel.blocks.add(new SimpleStairModel.Stair(set.block(), set.stair()));
//            SimpleWallModel.blocks.add(new SimpleWallModel.Wall(set.block(), set.wall()));
//
//            BlockDrops.blocks.add(set.block());
//            BlockDrops.blocks.add(set.slab());
//            BlockDrops.blocks.add(set.stair());
//            BlockDrops.blocks.add(set.wall());
//
//            MineablePickaxe.blocks.add(set.block());
//            MineablePickaxe.blocks.add(set.slab());
//            MineablePickaxe.blocks.add(set.stair());
//            MineablePickaxe.blocks.add(set.wall());
//
//            RequiresIronTool.blocks.add(set.block());
//            RequiresIronTool.blocks.add(set.slab());
//            RequiresIronTool.blocks.add(set.stair());
//            RequiresIronTool.blocks.add(set.wall());
//
//
//            Walls.walls.add(set.wall());
//        }
    }
}
