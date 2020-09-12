package cc.enzo.gorilla;

import com.google.common.io.ByteArrayDataOutput;

public class DictDeltaOfDelta extends DeltaOfDelta {
    @Override
    protected void encode(ByteArrayDataOutput output, int deltaOfDelta) {
        //TODO: using dict to encode
        //TODO: dict, freq, huffman encoding ??
        super.encode(output, deltaOfDelta);
    }

    @Override
    public byte[] getBytes() {
        //TODO: add dict encoding
        return super.getBytes();
    }
}
