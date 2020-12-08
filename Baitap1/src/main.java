import java.awt.image.BufferedImage;

public class main {
	
	static BufferedImage bfi;

	public static void main(String[] args) {
		BmpFile bmpFile = new BmpFile();
		bfi = bmpFile.readImage();
		bmpFile.saveBitmap("C://Users/admin/Downloads/baitap1e.bmp", bfi, bfi.getWidth(),bfi.getHeight());
		

	}

}
