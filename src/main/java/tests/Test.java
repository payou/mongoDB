package tests;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {

    @org.junit.Test
    public void testImageIo() {

        //read image
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (true){
                        System.out.println("Read !");
                        File f =  new File("C:\\Users\\bubulle\\Desktop\\out.jpg");
                        if (f.exists())
                        ImageIO.read(new File("C:\\Users\\bubulle\\Desktop\\out.jpg"));
                        File f2 =  new File("C:\\Users\\bubulle\\Desktop\\out.jpg");
                        if (f2.exists())
                        ImageIO.read(new File("C:\\Users\\bubulle\\Desktop\\out.jpeg"));
                        File f3 =  new File("C:\\Users\\bubulle\\Desktop\\out.jpg");
                        if (f3.exists())
                        ImageIO.read(new File("C:\\Users\\bubulle\\Desktop\\out.png"));
                        Thread.sleep(500);
                    }
                } catch(MalformedURLException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.setDaemon(true);

        Thread t2 = new Thread() {
            @Override
            public void run() {

                while (true){
                    BufferedImage image = null;
                    // retrieve image
                    try {
                        URL url = new URL("http://www.mkyong.com/image/mypic.jpg");
                        //URL url = new URL("http://www.bennieandthejets.com/redsamhd.jpg");
                        //URL url = new URL("http://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png");
                        image = ImageIO.read(url);
                        ImageIO.write(image, "jpg", new File("C:\\Users\\bubulle\\Desktop\\out.jpg"));
                        ImageIO.write(image, "jpeg", new File("C:\\Users\\bubulle\\Desktop\\out.jpeg"));
                        ImageIO.write(image, "png", new File("C:\\Users\\bubulle\\Desktop\\out.png"));
                        Thread.sleep(500);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        t2.setDaemon(true);

        //t.start();
        t2.start();


//        BufferedImage image = null;
//        // retrieve image
//        try {
//            //URL url = new URL("http://www.mkyong.com/image/mypic.jpg");
//            URL url = new URL("http://www.bennieandthejets.com/redsamhd.jpg");
//            //URL url = new URL("http://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png");
//            image = ImageIO.read(url);
//            ImageIO.write(image, "jpg", new File("C:\\Users\\bubulle\\Desktop\\out.jpg"));
//            ImageIO.write(image, "jpeg", new File("C:\\Users\\bubulle\\Desktop\\out.jpeg"));
//            ImageIO.write(image, "png", new File("C:\\Users\\bubulle\\Desktop\\out.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

}