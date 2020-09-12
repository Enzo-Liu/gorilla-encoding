package cc.enzo.gorilla;

import com.google.common.io.ByteArrayDataOutput;

public class GorillaDeltaOfDelta extends DeltaOfDelta{
    @Override
    protected void encode(ByteArrayDataOutput output, int deltaOfDelta) {
        if (deltaOfDelta < 128){
            output.write(deltaOfDelta); //TODO: write bit instead of byte
            return;
        }

        output.write(128);
        output.write(deltaOfDelta);
    }
}
