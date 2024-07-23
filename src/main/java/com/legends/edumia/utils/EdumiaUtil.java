package com.legends.edumia.utils;

import com.legends.edumia.EdumiaLog;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.swing.text.html.BlockView;
import java.lang.reflect.Field;

public class EdumiaUtil {

    public static void unlockFinalField(Field f){
        try {
            f.setAccessible(true);
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(f, (f.getModifiers() & -3 & -5 | 1) & -17);
        } catch (SecurityException | IllegalAccessException | NoSuchFieldException var2){
            EdumiaLog.error("Error unlocking final field " + f.toString());
            var2.printStackTrace();
        }

    }

    public static boolean hasSolidSide(BlockGetter world, BlockPos pos, Direction side) {
        BlockState state = world.getBlockState(pos);
        return Block.isFaceFull(state.getBlockSupportShape(world, pos), side);
    }
}
