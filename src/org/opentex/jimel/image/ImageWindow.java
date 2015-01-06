package org.opentex.jimel.image;

/**
 * Created by jdborowy on 25/12/2014.
 */
public class ImageWindow extends AbstractImage {
    private DataImage source;
    private int x;
    private int y;

    public ImageWindow(DataImage source, int x, int y, int width, int height) {
        super(width, height, source.getdy());
        this.source = source;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "<ImageWindow> x:" + this.x+ " y:" + this.y + " width:" + this.width + " height:" + this.height;
    }

    @Override
    public DataImage getCopy() {
        DataImage dataImage = new DataImage(width, height);
        dataImage.paste(this, 0, 0);
        return dataImage;
    }

    @Override
    public int getStartIndex() {
        return y*dy + x*dx;
    }

    @Override
    public int[] getData() {
        return source.getData();
    }

    @Override
    public Image getSubImage(int x, int y, int width, int height) {
        return new ImageWindow(source, this.x + x, this.y + y, width, height);
    }

    @Override
    public DataImage getSubImageCopy(int x, int y, int width, int height) {
        ImageWindow imageWindow = new ImageWindow(source, this.x + x, this.y + y, width, height);
        return imageWindow.getCopy();
    }
}
