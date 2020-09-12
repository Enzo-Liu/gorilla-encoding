package cc.enzo.gorilla;

import java.nio.ByteBuffer;

public class DeltaOfDelta {
    private final int initTs;

    public DeltaOfDelta(int ts){
        this.initTs = ts;
    }

    public void addValue(int ts){
        //TODO
        // naive implementation
        /** 1. keep track of all the delta
         *  2. find the delta that makes the sample space of `delta of delta` smallest
         *     - maybe just use greedy, or just use the most used delta as base
         *  3. calculate delta of delta
         *  4. using dict to encoding this data
         **/
    }

    public ByteBuffer getBytes(){
        //TODO
        throw new UnsupportedOperationException("not implemented");
    }
}
