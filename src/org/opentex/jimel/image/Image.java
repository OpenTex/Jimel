package org.opentex.jimel.image;

/**
 * Created by jdborowy on 25/12/2014.
 */
public interface Image {
    public int getWidth();
    public int getHeight();
    public int getChannels();
    public int getdx();
    public int getdy();
    public int getStartIndex();
    public int[] getData();
    public String getName();

    public DataImage getCopy();

    public Image getSubImage(int x, int y, int width, int height);
    public DataImage getSubImageCopy(int x, int y, int width, int height);
    public double distance(Image image);
}


