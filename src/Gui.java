import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;//put icon for JFrame.
import javax.swing.JLabel;

public class Gui {
    Gui(){
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        label.setText("Play");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.BOTTOM);
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setTitle("Music Media");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.add(label);
    }
}
