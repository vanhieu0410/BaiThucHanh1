import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImage {
	
	private static void writeImage(BufferedImage bfi) {
		int w = bfi.getWidth();
		int h = bfi.getHeight();
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		
		for(int i =0 ; i  < w; i++) {
			for(int j =0; j<h;j++) {
				bi.setRGB(i, j, bfi.getRGB(i, j) );
			}
		}
	       File f = new File("C://Users/admin/Downloads/baitap1g.bmp");
	        try {

	        	javax.imageio.ImageIO.write(bi, "BMP", new File("C://Users/admin/Downloads/baitap1g.bmp"));
	        } catch (IOException ex) {
	            System.out.println(ex.getMessage());
	        } 
	}

	public static void main(String[] args) throws IOException {
		BufferedImage img = null;
		File f = null;
		
		try {
			f = new File("C://Users/admin/Downloads/baitap1.bmp");
			img = ImageIO.read(f);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		int width = img.getWidth();
		int height = img.getHeight();
		
		for(int y = 0; y < height; y++) {
			for(int x =0; x <width; x++) {
				int p = img.getRGB(x, y);
				
				int a = (p>>24)&0xff;
				int r = (p>>16)&0xff;
				int g = (p>>8)&0xff;
				int b = p&0xff;
				
				p = (a<<24) | 0 | (g<<8) | b; 
				img.setRGB(x, y, p);
			}
		}
		writeImage(img);
	}
}
