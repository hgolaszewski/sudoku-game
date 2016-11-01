package Game;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Clock {

    public Timer timer;
    private JLabel label;
    public int nSeconds;

    public Clock(JLabel label) {
        timer = new Timer();
        nSeconds = 0;
        this.label = label;
        timer.schedule(new UpdateUITask(), 0, 1000);
    }

    private class UpdateUITask extends TimerTask {
        @Override
        public void run() {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    nSeconds += 1000;
                    SimpleDateFormat formatter = new SimpleDateFormat("mm:ss", Locale.getDefault());
                    label.setText("CZAS: " + String.valueOf(formatter.format(new Date(nSeconds))));
                }
            });
        }
    }

}
