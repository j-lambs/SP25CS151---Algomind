import java.util.BitSet;

interface Schedulable {
    void setAvailability(int timeSlot, boolean isAvailable);
    void updateAvailibility();
    boolean isAvailable(int startTime, int duration);
    String getAvailabilityBitString(BitSet newSchedule);
}
