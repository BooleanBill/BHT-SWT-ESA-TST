package bht.swt.esa.tst;

public class TimeBasedAction {
    
        private TimeProvider timeProvider;
    
        public TimeBasedAction(TimeProvider timeProvider) {
            this.timeProvider = timeProvider;
        }
    
        /**
        * Returns a string that depends on the current time of day.
        * 
        * @return a string that depends on the current time of day
        */
        public String greeting() {
            String timeOfDay = this.timeProvider.getTimeOfDay();
            if (timeOfDay.equals("Morning")) {
                return "Good morning!";
            } else if (timeOfDay.equals("Afternoon")) {
                return "Good afternoon!";
            } else if (timeOfDay.equals("Evening")) {
                return "Good evening!";
            } else {
                return "Good night!";
            }
        }
}
