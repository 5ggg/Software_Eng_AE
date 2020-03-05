package com.em.controller;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.em.util.CommonVal;
import com.em.util.ImgRandomCodeUtils;


/**
 * The class give the image verification code generation interface, 
 * which is used to generate a picture with a 4-digit random code
 * @author 5ggg
 *
 */
@Controller
public class CodeController {
	@RequestMapping("/commonapi/code") 
    public void getCode(HttpServletRequest req, HttpServletResponse resp) throws IOException { 
		ImgRandomCodeUtils rdnu = ImgRandomCodeUtils.Instance();//Picture verification code generator
		HttpSession session = req.getSession(); 
		// Get random string into Session
		session.setAttribute(CommonVal.code, rdnu.getString());//Store the verification code in the session
		// Disable image caching.
        resp.setHeader("Pragma", "no-cache"); 
        resp.setHeader("Cache-Control", "no-cache"); 
        resp.setDateHeader("Expires", 0); 
        resp.setContentType("image/jpeg"); 
        // Output the image to a servlet output stream.
        ServletOutputStream sos = resp.getOutputStream(); 
        ImageIO.write(rdnu.getBuffImg(), "jpeg", sos);//Return to the front side.
        sos.close(); 
    }
}
