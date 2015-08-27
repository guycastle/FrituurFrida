package be.vdab.dao;

import be.vdab.entities.ColorPalette;
import be.vdab.utils.ColorBlender;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 *
 * @author guillaume.vandecasteele
 */
public class CookieDAO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static final ColorPalette NEUTRAL = new ColorPalette("CCCCCC", "333333", "666666", "333333");
    private static final ColorPalette BOY = new ColorPalette("66CCFF", "003333", "006699", "003333");
    private static final ColorPalette GIRL = new ColorPalette("FF99CC", "850000", "FF0000", "850000");

    public static HttpServletRequest processCookieRequest(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                switch (cookie.getName()) {
                    case "gender":
                        request = processGenderCookie(request, cookie);
                }
            }
        }
        return request;
        
    }
    
    private static HttpServletRequest processGenderCookie(HttpServletRequest request, Cookie cookie) {
        try {                        
            if (URLDecoder.decode(cookie.getValue(), "UTF-8").equalsIgnoreCase("agender"))
            {
                request.setAttribute("colors", NEUTRAL);
            }
            else {
                int gender = Integer.parseInt(URLDecoder.decode(cookie.getValue(), "UTF-8"));
                request.setAttribute("colors", new ColorPalette(ColorBlender.blendPalette(BOY, GIRL, gender)));
            }

        }
        catch (NumberFormatException | UnsupportedEncodingException ex) {
        }
        return request;
    }

    public CookieDAO() {
    }
}