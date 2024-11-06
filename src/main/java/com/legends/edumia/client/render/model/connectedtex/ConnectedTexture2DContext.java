package com.legends.edumia.client.render.model.connectedtex;

import java.util.Collection;
import java.util.EnumSet;

public class ConnectedTexture2DContext {

    private final EnumSet<RelativePosition> relativePositions;

    public ConnectedTexture2DContext(Collection<RelativePosition> positions){
        this.relativePositions = EnumSet.copyOf(positions);
    }



    public static enum RelativePosition {
        TOP_LEFT,
        TOP,
        TOP_RIGHT,
        LEFT,
        CENTRE,
        RIGHT,
        BOTTOM_LEFT,
        BOTTOM,
        BOTTOM_RIGHT;

        private RelativePosition(){

        }
    }
}
