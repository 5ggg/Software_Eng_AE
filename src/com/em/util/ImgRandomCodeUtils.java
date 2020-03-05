package com.em.util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
/**
* Generate random number verification code
*
* @author zh
*
*/
public class ImgRandomCodeUtils {
    private ByteArrayInputStream byteImg;	// byte image 1
    private BufferedImage buffImg;			// buff image 2
    private String str;						// Verification code
    private int codeCount = 4;				// Define the number of verification codes displayed on the picture
    private int xx = 28; 					// Verification code horizontal position offset
    private int codeY = 30; 				// Verification code vertical position offset
    private int fontHeight = 30; 			// font size
    private int runLin = 60;				// Number of interference lines
    private int red = 255, green = 100, blue = 50; // Random colors in the font value range
    private int bgfc = 150, bgbc = 200;		// background color
    private int linfc = 200, linbc = 250;	// Interference line color
    private int width = 158, height =40;	// Image width and height
    //Does not contain the letter i l o I, the number 0 1, it will make people feel confused some time.
    char[] codeSequence = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '2', '3', '4', '5', '6', '7', '8', '9',
    };
    private int ruNumber = codeSequence.length-1; //Get the verification code with the natural number between 0 ~ ruNumber
    private ImgRandomCodeUtils() {
        init();// Initialize attributes
    }
    /**
    * Get RandomNumUtil instance
    */
    public static ImgRandomCodeUtils Instance() {
        return new ImgRandomCodeUtils();
    }
    /**
    * Get verification code picture byteImg
    */
    public ByteArrayInputStream GetByteImg() {
        return this.byteImg;
    }
    /**
    * Get captcha picture buffImg
    */
    public BufferedImage getBuffImg() {
        return this.buffImg;
    }
    /**
    * Get image verification code string
    */
    public String getString() {
        return this.str;
    }
    /**
    * Initialize attributes
    */
    private void init() {
        // Create image in memory
        BufferedImage buffImg = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        // Get graphics context
        Graphics g = buffImg.getGraphics();
        // Generate Random Class
        Random random = new Random();
        // Set background color
        g.setColor(getRandColor(bgfc, bgbc));
        g.fillRect(0, 0, width, height);
        // Set font
        g.setFont(new Font("Times New Roman", Font.BOLD, fontHeight));
        // RunLin interference lines are generated randomly, 
        // making the authentication code in the image 
        // difficult to be detected by other programs
        g.setColor(getRandColor(linfc, linbc));
        for (int i = 0; i < runLin ; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        // randomCode is used to save a randomly generated verification code 
        // for users to verify after login.
        StringBuffer randomCode = new StringBuffer();
        //Randomly generated codeCount number verification code
        for (int i = 0; i < codeCount; i++) {
            // Get a randomly generated verification code number.
            String code = String.valueOf(codeSequence[random.nextInt(ruNumber)]); //With natural number between 0 ~ ruNumber
            // Generate random color components to construct color values, 
            // so that the color value of each digit of the output will be different.
            // The verification code is drawn into the image with randomly generated colors.
            g.setColor(new Color(random.nextInt(red), random.nextInt(green), random.nextInt(blue)));
            // Called functions have the same color, 
            // probably because the seeds are too close, 
            // so they can only be generated directly
            g.drawString(code, (i + 1) * xx, codeY);
            // Combine the four random numbers generated.
            randomCode.append(code);
        }
        // Assignment verification code
        this.str = randomCode.toString();
        // Image effect
        g.dispose();
        
        
        /************Assign byte image 1     output image stream**************/
        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            ImageOutputStream imageOut = ImageIO
            .createImageOutputStream(output);
            ImageIO.write(buffImg, "JPEG", imageOut);
            imageOut.close();
            input = new ByteArrayInputStream(output.toByteArray());
            } catch (Exception e) {
                System.out.println("Captcha image produced an error：" + e.toString());
            }
            this.byteImg = input;	// Assignment byte image 1
            
            
            /************Assignment buff image 2    output image**************/
            this.buffImg = buffImg; // Assignment buff image 2
        }
        /**
        * Get random colors for a given range
        */
        private Color getRandColor(int fc, int bc) {
            Random random = new Random();
            if (fc > 255)
            fc = 255;
            if (bc > 255)
            bc = 255;
            int r = fc + random.nextInt(bc - fc);
            int g = fc + random.nextInt(bc - fc);
            int b = fc + random.nextInt(bc - fc);
            return new Color(r, g, b);
        }
    }
