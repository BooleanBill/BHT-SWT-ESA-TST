package bht.swt.esa.tst;

public class TimeProvider {

    private int hour, minute, second;

    TimeProvider() {
        java.time.LocalTime now = java.time.LocalTime.now();
        this.hour = now.getHour();
        this.minute = now.getMinute();
        this.second = now.getSecond();
    }

    /**
     * Updates the time to the current time.
     */
    private void updateTime() {
        java.time.LocalTime now = java.time.LocalTime.now();
        this.hour = now.getHour();
        this.minute = now.getMinute();
        this.second = now.getSecond();
    }

    public String getCurrentTime() {
        this.updateTime();
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }

    /**
     * Returns the current approx time of day as a string, e.g "Morning",
     * "Afternoon", "Evening", "Night".
     * Morning is from 6:00 to 12:00, Afternoon from 12:00 to 18:00, Evening from
     * 18:00 to 22:00, Night from 22:00 to 6:00.
     * 
     * @return the current approx time of day as a string
     */
    public String getTimeOfDay() {
        int hour = java.time.LocalTime.now().getHour();
        if (hour >= 6 && hour < 12) {
            return "Morning";
        } else if (hour >= 12 && hour < 18) {
            return "Afternoon";
        } else if (hour >= 18 && hour < 22) {
            return "Evening";
        } else {
            return "Night";
        }
    }

}
