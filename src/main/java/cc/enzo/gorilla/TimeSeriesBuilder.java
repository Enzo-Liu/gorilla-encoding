package cc.enzo.gorilla;

import java.util.Random;
import java.util.stream.Stream;

public class TimeSeriesBuilder {
    private int startTs;
    private int delta;
    private Random random = new Random();

    public TimeSeriesBuilder(){
    }

    public TimeSeriesBuilder withStartTs(int startTs){
        this.startTs = startTs;
        return this;
    }

    public TimeSeriesBuilder withDelta(int delta){
        this.delta = delta;
        return this;
    }

    public Stream<Integer> getTs(){
        return Stream.iterate(startTs, (ts) -> randomTs(ts + delta));
    }

    private Integer randomTs(int nextTs) {
        //hard code random behavior
        int r = random.nextInt(100);
        if (r < 80){
            return nextTs;
        }
        if (r < 88){
            return nextTs + 1;
        }
        if (r < 96){
            return nextTs - 1;
        }
        return nextTs + (r - 96);
    }
}
