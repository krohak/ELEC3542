public class MeasureMemory {

    public static long memoryUsed() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        return memory;
    }

}
