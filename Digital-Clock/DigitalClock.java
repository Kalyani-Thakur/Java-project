import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock {
    private JFrame jf;
    private JLabel jl;

    public DigitalClock() {
        // Create the JFrame and set its properties
        jf = new JFrame("DIGITAL CLOCK");
        jf.setSize(300, 150);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setBackground(Color.BLACK);

        // Create the JLabel for the time display
        jl = new JLabel();
        jl.setFont(new Font("Helvetica", Font.BOLD, 35));
        jl.setForeground(Color.CYAN);

        // CENTER the text inside the JLabel
        jl.setHorizontalAlignment(SwingConstants.CENTER);

        // Add the label to the JFrame
        jf.add(jl);

        // Use a Swing Timer to update the clock on the Event Dispatch Thread
        Timer timer = new Timer(1000, e -> {
            String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
            jl.setText(time);
        });

        // Set the initial time immediately
        timer.getActionListeners()[0].actionPerformed(null);

        timer.start();

        // Center the frame on the screen
        jf.setLocationRelativeTo(null);

        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}

