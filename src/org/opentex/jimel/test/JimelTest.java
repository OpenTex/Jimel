package org.opentex.jimel.test;

import org.opentex.jimel.image.DataImage;
import org.opentex.jimel.image.filter.Haar;



import java.io.IOException;

/**
 * Created by jdborowy on 25/12/2014.
 */
public class JimelTest {
    public static void main(String[] args) {
        try {
            DataImage image = ImageIOHelper.open("test.jpg");
            System.out.println(image);
            DataImage subImage = Haar.getPowerOfTwoSizedDataImage(image);//(DataImage) image.getSubImageCopy(100, 0, 600, 600);
            System.out.println(subImage);
            ImageIOHelper.write(subImage, "test2.png");


        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
