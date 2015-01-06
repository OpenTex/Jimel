package org.opentex.jimel.image;

/**
 * Created by jdborowy on 25/12/2014.
 */
public class DataImage extends AbstractImage {
    private int[] data;

    public DataImage(int width, int height, int[] data) {
        super(width, height, width);
        this.data = data;
    }

    public DataImage(int width, int height) {
        this(width, height, new int[width * height]);
    }

    @Override
    public DataImage getCopy() {
        return new DataImage(width, height, data.clone());
    }

    @Override
    public String toString() {
        return "<DataImage> width:" + this.width + " height:" + this.height;
    }

    @Override
    public int getStartIndex() {
        return 0;
    }

    @Override
    public int[] getData() {
        return data;
    }

    @Override
    public Image getSubImage(int x, int y, int width, int height) {
        return new ImageWindow(this, x, y, width, height);
    }

    @Override
    public DataImage getSubImageCopy(int x, int y, int width, int height) {
        ImageWindow subImage = new ImageWindow(this, x, y, width, height);
        return subImage.getCopy();
    }
}
