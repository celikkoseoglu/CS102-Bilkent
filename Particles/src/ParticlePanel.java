import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by celikkoseoglu on 11/04/15.
 */
public class ParticlePanel extends JPanel
{
    ArrayList<Particle> particleList;
    private Timer tick;
    public ParticlePanel()
    {
        particleList = new ArrayList<Particle>();
        this.addMouseListener(new ParticleClickListener());
        this.addMouseMotionListener(new ParticleClickListener());
        startAdding();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(Particle p : particleList)
        {
            g.setColor(p.getColor());
            g.fillOval(p.getX(), p.getY(), 20, 20);
        }
    }

    private class ParticleClickListener extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent e)
        {
            super.mousePressed(e);
            particleList.add(new Particle(e.getX(), e.getY()));
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e)
        {
            super.mouseDragged(e);
            System.out.println("qqq");
            particleList.add(new Particle(e.getX(), e.getY()));
            repaint();
        }
    }

    private void startAdding()
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                for (Particle p : particleList)
                    p.updateStatus();
                repaint();
            }
        };
        tick = new Timer(1, listener);
        tick.start();
    }
}
