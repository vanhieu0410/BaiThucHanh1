import java.awt.Image;
import java.awt.image.ImageFilter;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class readFile {
	

	public static void main(String[] args)throws IOException {
		
		Image image;
		File file = null;
		FileInputStream fs = new FileInputStream(file = new File("C://Users/admin/Downloads/baitap1.bmp"));
		
		int bflen = 14;
		byte bf[] = new byte[bflen];
		fs.read(bf,0,bflen);
		int bilen = 40;ds
		byte bi[]=new byte[bilen];
	    fs.read(bi,0,bilen);
	    
	    // Interperet data.
	    int nsize = (((int)bf[5]&0xff)<<24) 
	    		| (((int)bf[4]&0xff)<<16)
	    		| (((int)bf[3]&0xff)<<8)
	    		| (int)bf[2]&0xff;
	    System.out.println("File type is :"+(char)bf[0]+(char)bf[1]);
	    System.out.println("Size of file is :"+nsize);
	    int nbisize = (((int)bi[3]&0xff)<<24)
	            | (((int)bi[2]&0xff)<<16)
	            | (((int)bi[1]&0xff)<<8)
	            | (int)bi[0]&0xff;
	    System.out.println("Size of bitmapinfoheader is :"+nbisize);
	    int nwidth = (((int)bi[7]&0xff)<<24)
	            | (((int)bi[6]&0xff)<<16)
	            | (((int)bi[5]&0xff)<<8)
	            | (int)bi[4]&0xff;
	    System.out.println("Width is :"+nwidth);
	    int nheight = (((int)bi[11]&0xff)<<24)
	            | (((int)bi[10]&0xff)<<16)
	            | (((int)bi[9]&0xff)<<8)
	            | (int)bi[8]&0xff;
	    System.out.println("Height is :"+nheight);
	            int nplanes = (((int)bi[13]&0xff)<<8) | (int)bi[12]&0xff;
	    System.out.println("Planes is :"+nplanes);
	            int nbitcount = (((int)bi[15]&0xff)<<8) | (int)bi[14]&0xff;
	    System.out.println("BitCount is :"+nbitcount);
	    int ncompression = (((int)bi[19])<<24)
	            | (((int)bi[18])<<16)
	            | (((int)bi[17])<<8)
	            | (int)bi[16];
	    System.out.println("Compression is :"+ncompression);
	    int nsizeimage = (((int)bi[23]&0xff)<<24)
	            | (((int)bi[22]&0xff)<<16)
	            | (((int)bi[21]&0xff)<<8)
	            | (int)bi[20]&0xff;
	    System.out.println("SizeImage is :"+nsizeimage);
	    int nxpm = (((int)bi[27]&0xff)<<24)
	            | (((int)bi[26]&0xff)<<16)
	            | (((int)bi[25]&0xff)<<8)
	            | (int)bi[24]&0xff;
	    System.out.println("X-Pixels per meter is :"+nxpm);
	    int nypm = (((int)bi[31]&0xff)<<24)
	            | (((int)bi[30]&0xff)<<16)
	            | (((int)bi[29]&0xff)<<8)
	            | (int)bi[28]&0xff;
	    System.out.println("Y-Pixels per meter is :"+nypm);
	    int nclrused = (((int)bi[35]&0xff)<<24)
	            | (((int)bi[34]&0xff)<<16)
	            | (((int)bi[33]&0xff)<<8)
	            | (int)bi[32]&0xff;
	    System.out.println("Colors used are :"+nclrused);
	    int nclrimp = (((int)bi[39]&0xff)<<24)
	            | (((int)bi[38]&0xff)<<16)
	            | (((int)bi[37]&0xff)<<8)
	            | (int)bi[36]&0xff;
	    
	    System.out.println("Colors important are :"+nclrimp);
	    int nNumColors = 0;
        if (nclrused > 0)
            {
            nNumColors = nclrused;
            }
        else
            {
            nNumColors = (1&0xff)<<nbitcount;
            }
        System.out.println("The number of Colors is"+nNumColors);
	    
	    int  npalette[] = new int [nNumColors];
        byte bpalette[] = new byte [nNumColors*4];
        fs.read (bpalette, 0, nNumColors*4);
        int nindex8 = 0;
        for (int n = 0; n < nNumColors; n++)
            {
            npalette[n] = (255&0xff)<<24
            | (((int)bpalette[nindex8+2]&0xff)<<16)
            | (((int)bpalette[nindex8+1]&0xff)<<8)
            | (int)bpalette[nindex8]&0xff;
       System.out.println ("Palette Color "+n
            +" is:"+npalette[n]+" (res,R,G,B)= ("
            +((int)(bpalette[nindex8+3]) & 0xff)+","
            +((int)(bpalette[nindex8+2]) & 0xff)+","
            +((int)bpalette[nindex8+1]&0xff)+","
            +((int)bpalette[nindex8]&0xff)+")");
            nindex8 += 4;
            }
	    
	    int npad8 =(nsizeimage / nheight) - nwidth;
	    System.out.println("nPad is: " + npad8);
	    int ndata8[] = new int [nwidth*nheight];
	    byte bdata[] = new byte [(nwidth + npad8)*nheight];
	    fs.read(bdata, 0, (nwidth+ npad8)*nheight);
	    nindex8 = 0;
	    for (int j8 = 0; j8< nheight; j8++) {
	    	for (int i8 = 0; i8< nwidth; i8++) {
	    		ndata8 [nwidth*(nheight-j8-1)+i8] =
	                    npalette [((int)bdata[nindex8]&0xff)];
	                nindex8++;
	    	}
	    	nindex8 += npad8;
	    }
	    
	    
	    
	}
}

