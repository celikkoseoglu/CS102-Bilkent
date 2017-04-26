import javax.swing.*;

/**
 * Created by celikkoseoglu on 11/04/15.
 */
public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Particles");
        frame.getContentPane().add(new ParticlePanel());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
