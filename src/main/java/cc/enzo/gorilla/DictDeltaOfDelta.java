package cc.enzo.gorilla;

import com.google.common.io.ByteArrayDataOutput;

public class DictDeltaOfDelta extends DeltaOfDelta {
    @Override
    protected void encode(ByteArrayDataOutput output, int deltaOfDelta) {
        //TODO: using dict to encode
        super.encode(output, deltaOfDelta);
    }

    @Override
    public byte[] getBytes() {
        //TODO: add dick encoding
        return super.getBytes();
    }
}
