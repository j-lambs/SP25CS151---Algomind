import java.util.BitSet;

interface Schedulable {
    void setAvailability(int timeSlot, boolean isAvailable);
    void updateSchedule();
    boolean isAvailable(int startTime, int duration);
    String getAvailabilityBitString(BitSet newSchedule);
    void setAppointment(int startTime, int duration);
    void cancelAppointment(Appointment timeSlot);
}
