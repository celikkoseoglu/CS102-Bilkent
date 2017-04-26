import java.awt.*;

/**
 * Created by celikkoseoglu on 11/04/15.
 */
public class Particle
{
    private int locationX, locationY;
    private Color color;
    public Particle(int locationX, int locationY)
    {
        this.locationX = locationX;
        this.locationY = locationY;
        color = new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255));
    }

    public Color getColor()
    {
        return color;
    }

    public int getX()
    {
        return locationX;
    }

    public int getY()
    {
        return locationY;
    }

    public void updateStatus()
    {
        locationY += Math.random() * 2 - 1;
        locationX += Math.random() * 2 - 1;
    }
}
