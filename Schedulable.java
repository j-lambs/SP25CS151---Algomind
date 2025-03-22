import java.util.BitSet;

interface Schedulable {
    boolean isAvailable(int startTime, int duration, Tutors tutor, Student student);
    BitSet getAvailabilityBitSet(BitSet newSchedule);
}
