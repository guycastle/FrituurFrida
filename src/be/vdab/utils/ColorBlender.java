package be.vdab.utils;

import be.vdab.entities.ColorPalette;

import java.awt.*;

/**
 *
 * @author guillaume.vandecasteele
 */
public class ColorBlender {
    
    public static ColorPalette blendPalette(ColorPalette male, ColorPalette female, int gender) {
        ColorPalette blendedPalette = new ColorPalette();
        float ratio = gender / 100F;
        blendedPalette.setBackground(blend(convertToColor(male.getBackground()), convertToColor(female.getBackground()), ratio));
        blendedPalette.setMenuBackground(blend(convertToColor(male.getMenuBackground()), convertToColor(female.getMenuBackground()), ratio));
        blendedPalette.setMenuBackgroundActive(blend(convertToColor(male.getMenuBackgroundActive()), convertToColor(female.getMenuBackgroundActive()), ratio));
        blendedPalette.setTextColor(blend(convertToColor(male.getTextColor()), convertToColor(female.getTextColor()), ratio));
        return blendedPalette;
    } 
    
    public static String blend (Color male, Color female, float ratio) {
        float inversedRatio = (float) 1.0 - ratio;

        float rgb1[] = new float[3];
        float rgb2[] = new float[3];    

        male.getColorComponents(rgb1);
        female.getColorComponents(rgb2);    

        Color color = new Color (rgb1[0] * inversedRatio + rgb2[0] * ratio, 
                                 rgb1[1] * inversedRatio + rgb2[1] * ratio, 
                                 rgb1[2] * inversedRatio + rgb2[2] * ratio);  
        return convertToHexString(color);
    }
    
    private static Color convertToColor(String hexString) {
        Color color = new Color(Integer.parseInt(hexString, 16));
        return color;
    }
    
    private static String convertToHexString(Color color) {
        StringBuilder returnValue = new StringBuilder();
        
        String[] rgb = new String[]{Integer.toHexString(color.getRed()), 
                Integer.toHexString(color.getGreen()), Integer.toHexString(color.getBlue())};
        
        for (String RGBSeperateValue : rgb) {
            if (RGBSeperateValue.length() < 2) RGBSeperateValue = "0" + RGBSeperateValue;
            returnValue.append(RGBSeperateValue);
        }

        return returnValue.toString();
    }

    private ColorBlender() {
    }
}