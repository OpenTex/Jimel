package org.opentex.jimel.image.filter;

import org.opentex.jimel.image.DataImage;
import org.opentex.jimel.image.Image;
import org.opentex.jimel.image.AbstractImage;

/**
 * Created by jdborowy on 29/12/2014.
 */
public class Haar {
    private static int upperPowerOfTwo(int value) {
        int result;
        for (result = 0; value != 0; ++result) {
            value >>= 1;
        }

        return 1 << (result + 1);
    }

    public static DataImage getPowerOfTwoSizedDataImage(Image source) {
        int width = Haar.upperPowerOfTwo(source.getWidth());
        int height = Haar.upperPowerOfTwo(source.getHeight());
        DataImage image = new DataImage(width, height);
        image.paste(source, (width - source.getWidth())/2, (height - source.getHeight())/2);
        return image;
    }

    public static DataImage getHaarWaveletTransformation(Image source) {
        Image result = Haar.getPowerOfTwoSizedDataImage(source);

        for (int width = source.getWidth(); width > 1; width /= 2) {
            AbstractImage
        }

    }

    private static void calculateH1Image(Image source, Image dest) {
        int[] data0 = source.getData();
        int[] data1 = dest.getData();
        int dy0 = source.getdy();
        int dy1 = dest.getdy();
        int startIndex0 = source.getStartIndex();
        int startIndex1 = dest.getStartIndex();

        for (int y = 0, yy = source.getHeight(), xx = source.getWidth(); y < yy; y += 2) {
            int tmp0 = startIndex0 + y*dy0;
            int tmp1 = startIndex1 + (y/2)*dy1;
            for (int x = 0; x < xx; x += 2) {
                data1[tmp1 + x/2] = Haar.calculateH1(data0, tmp0 + x, dy0);
            }
        }
    }

    private static void calculateH2Image(Image source, Image dest) {
        int[] data0 = source.getData();
        int[] data1 = dest.getData();
        int dy0 = source.getdy();
        int dy1 = dest.getdy();
        int startIndex0 = source.getStartIndex();
        int startIndex1 = dest.getStartIndex();

        for (int y = 0, yy = source.getHeight(), xx = source.getWidth(); y < yy; y += 2) {
            int tmp0 = startIndex0 + y*dy0;
            int tmp1 = startIndex1 + (y/2)*dy1;
            for (int x = 0; x < xx; x += 2) {
                data1[tmp1 + x/2] = Haar.calculateH2(data0, tmp0 + x, dy0);
            }
        }
    }

    private static void calculateH3Image(Image source, Image dest) {
        int[] data0 = source.getData();
        int[] data1 = dest.getData();
        int dy0 = source.getdy();
        int dy1 = dest.getdy();
        int startIndex0 = source.getStartIndex();
        int startIndex1 = dest.getStartIndex();

        for (int y = 0, yy = source.getHeight(), xx = source.getWidth(); y < yy; y += 2) {
            int tmp0 = startIndex0 + y*dy0;
            int tmp1 = startIndex1 + (y/2)*dy1;
            for (int x = 0; x < xx; x += 2) {
                data1[tmp1 + x/2] = Haar.calculateH3(data0, tmp0 + x, dy0);
            }
        }
    }

    private static void calculateH4Image(Image source, Image dest) {
        int[] data0 = source.getData();
        int[] data1 = dest.getData();
        int dy0 = source.getdy();
        int dy1 = dest.getdy();
        int startIndex0 = source.getStartIndex();
        int startIndex1 = dest.getStartIndex();

        for (int y = 0, yy = source.getHeight(), xx = source.getWidth(); y < yy; y += 2) {
            int tmp0 = startIndex0 + y*dy0;
            int tmp1 = startIndex1 + (y/2)*dy1;
            for (int x = 0; x < xx; x += 2) {
                data1[tmp1 + x/2] = Haar.calculateH4(data0, tmp0 + x, dy0);
            }
        }
    }

    private static int calculateH1(int[] data, int index, int dy) {
         int c1 = data[index];
         int c2 = data[index + 1];
         int c3 = data[index + dy];
         int c4 = data[index + dy + 1];

         int red = AbstractImage.getRedValue(c1)
                 + AbstractImage.getRedValue(c2)
                 + AbstractImage.getRedValue(c3)
                 + AbstractImage.getRedValue(c4);

         int green = AbstractImage.getGreenValue(c1)
                   + AbstractImage.getGreenValue(c2)
                   + AbstractImage.getGreenValue(c3)
                   + AbstractImage.getGreenValue(c4);

         int blue = AbstractImage.getBlueValue(c1)
                  + AbstractImage.getBlueValue(c2)
                  + AbstractImage.getBlueValue(c3)
                  + AbstractImage.getBlueValue(c4);

         return AbstractImage.getColor(red/4, green/4, blue/4);
     }

    private static int calculateH2(int[] data, int index, int dy) {
        int c1 = data[index];
        int c2 = data[index + 1];
        int c3 = data[index + dy];
        int c4 = data[index + dy + 1];

        int red = 512 + AbstractImage.getRedValue(c1)
                + AbstractImage.getRedValue(c2)
                - AbstractImage.getRedValue(c3)
                - AbstractImage.getRedValue(c4);

        int green = 512 + AbstractImage.getGreenValue(c1)
                + AbstractImage.getGreenValue(c2)
                - AbstractImage.getGreenValue(c3)
                - AbstractImage.getGreenValue(c4);

        int blue = 512 + AbstractImage.getBlueValue(c1)
                + AbstractImage.getBlueValue(c2)
                - AbstractImage.getBlueValue(c3)
                - AbstractImage.getBlueValue(c4);

        return AbstractImage.getColor(red/4, green/4, blue/4);
    }

    private static int calculateH3(int[] data, int index, int dy) {
        int c1 = data[index];
        int c2 = data[index + 1];
        int c3 = data[index + dy];
        int c4 = data[index + dy + 1];

        int red = 512 + AbstractImage.getRedValue(c1)
                - AbstractImage.getRedValue(c2)
                + AbstractImage.getRedValue(c3)
                - AbstractImage.getRedValue(c4);

        int green = 512 + AbstractImage.getGreenValue(c1)
                - AbstractImage.getGreenValue(c2)
                + AbstractImage.getGreenValue(c3)
                - AbstractImage.getGreenValue(c4);

        int blue = 512 + AbstractImage.getBlueValue(c1)
                - AbstractImage.getBlueValue(c2)
                + AbstractImage.getBlueValue(c3)
                - AbstractImage.getBlueValue(c4);

        return AbstractImage.getColor(red/4, green/4, blue/4);
    }

    private static int calculateH4(int[] data, int index, int dy) {
        int c1 = data[index];
        int c2 = data[index + 1];
        int c3 = data[index + dy];
        int c4 = data[index + dy + 1];

        int red = 512 + AbstractImage.getRedValue(c1)
                - AbstractImage.getRedValue(c2)
                - AbstractImage.getRedValue(c3)
                + AbstractImage.getRedValue(c4);

        int green = 512 + AbstractImage.getGreenValue(c1)
                - AbstractImage.getGreenValue(c2)
                - AbstractImage.getGreenValue(c3)
                + AbstractImage.getGreenValue(c4);

        int blue = 512 + AbstractImage.getBlueValue(c1)
                - AbstractImage.getBlueValue(c2)
                - AbstractImage.getBlueValue(c3)
                + AbstractImage.getBlueValue(c4);

        return AbstractImage.getColor(red/4, green/4, blue/4);
    }
}