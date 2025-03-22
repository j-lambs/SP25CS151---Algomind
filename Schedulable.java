import java.util.BitSet;

interface Schedulable {
    void setAvailability(int timeStart, int duration, boolean isAvailable);
    boolean isAvailable(int startTime, int duration);
    BitSet getAvailabilityBitSet(BitSet newSchedule);
}
