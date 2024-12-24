package name.ncg777.computing.structures;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import name.ncg777.maths.MatrixOfIntegers;

public class Image24Bits extends MatrixOfIntegers {
  public Image24Bits(int width, int height) {
    this(width, height, new Pixel24Bits(0));
  }
  
  public Image24Bits(int width, int height, Pixel24Bits fill) {
    super(height, width, fill.toInteger());
  }
  public BufferedImage toBufferedImage() {
    BufferedImage image = new BufferedImage(n, m, BufferedImage.TYPE_INT_RGB);

    for (int y = 0; y < m; y++) {
        for (int x = 0; x < n; x++) {
            image.setRGB(x, y,this.get(y,x));
        }
    }

    return image;
  }
  
  public Pixel24Bits getPixel(int i, int j) {
    return new Pixel24Bits(this.get(j, i));
  }
  
  public void writeToPNG(String path) throws IOException {
      File output = new File(path);
      ImageIO.write(this.toBufferedImage(), "png", output);
  }
}
