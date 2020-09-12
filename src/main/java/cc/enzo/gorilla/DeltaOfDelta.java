package cc.enzo.gorilla;

import com.google.common.collect.Lists;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class DeltaOfDelta {
    private int initTs;
    private int lastTs;
    private int lastDelta;
    private boolean inited;
    ByteArrayDataOutput output = ByteStreams.newDataOutput();
    private List<Integer> deltaOfDeltaList = Lists.newArrayList();

    public DeltaOfDelta() {
    }

    public void addValue(int ts) {
        if (!inited) {
            this.initTs = ts;
            this.inited = true;
            this.lastTs = ts;
            output.writeInt(this.initTs);
        }

        int delta = ts - this.lastTs;
        int deltaOfDelta = delta - this.lastDelta;
        this.lastTs = ts;
        this.lastDelta = delta;
        encode(output, deltaOfDelta);
    }

    // raw encoding
    protected void encode(ByteArrayDataOutput output, int deltaOfDelta) {
        output.writeInt(deltaOfDelta);
    }

    public int getSize() {
        return output.toByteArray().length;
    }

    public byte[] getBytes() {
        return output.toByteArray();
    }
}
