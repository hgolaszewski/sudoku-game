package Game;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Clock {

    private final Timer timer;
    private final JLabel timeLabel;
    private int seconds;

    public Clock(JLabel label) {
        timeLabel = label;
        seconds = 0;
        timer = new Timer();
        timer.schedule(new UpdateUITask(), 1000, 1000);
    }

    private class UpdateUITask extends TimerTask {

        @Override
        public void run() {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    seconds += 1000;
                    SimpleDateFormat dateFormatter = new SimpleDateFormat("mm:ss", Locale.getDefault());
                    timeLabel.setText("CZAS: " + String.valueOf(dateFormatter.format(new Date(seconds))));
                }
            });
        }
    }

    public Timer getTimer() {
        return timer;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int newSeconds) {
        seconds = newSeconds;
    }
}
