package cc.enzo;

import cc.enzo.gorilla.DeltaOfDelta;
import cc.enzo.gorilla.GorillaDeltaOfDelta;
import cc.enzo.gorilla.TimeSeriesBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        withCost(()->{
            TimeSeriesBuilder tsBuilder = new TimeSeriesBuilder().withStartTs(1596240000).withDelta(5);
            DeltaOfDelta deltaOfDelta = new DeltaOfDelta();
            tsBuilder.getTs().limit(10000000).forEach(deltaOfDelta::addValue);
            System.out.println("total size is " + deltaOfDelta.getSize());
            deltaOfDelta.getBytes();
        });

        withCost(()->{
            TimeSeriesBuilder tsBuilder = new TimeSeriesBuilder().withStartTs(1596240000).withDelta(5);
            DeltaOfDelta deltaOfDelta = new GorillaDeltaOfDelta();
            tsBuilder.getTs().limit(10000000).forEach(deltaOfDelta::addValue);
            System.out.println("gorilla total size is " + deltaOfDelta.getSize());
            deltaOfDelta.getBytes();
        });
    }

    public static void withCost(Runnable runnable){
        long start = System.currentTimeMillis();
        runnable.run();
        long end = System.currentTimeMillis();
        System.out.println( "run time is " + (end - start));
    }
}
