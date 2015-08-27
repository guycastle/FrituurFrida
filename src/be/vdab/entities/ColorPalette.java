package be.vdab.entities;

import java.io.Serializable;

/**
 *
 * @author guillaume.vandecasteele
 */
public class ColorPalette implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final ColorPalette NEUTRAL = new ColorPalette("CCCCCC", "333333", "666666", "333333");
    private static final ColorPalette BOY = new ColorPalette("66CCFF", "003333", "006699", "003333");
    private static final ColorPalette GIRL = new ColorPalette("FF99CC", "850000", "FF0000", "850000");
    private String background;
    private String textColor;
    private String menuBackground;
    private String menuBackgroundActive;
    
    
    public ColorPalette() {
        this.background = null;
        this.textColor = null;
        this.menuBackground = null;
        this.menuBackgroundActive = null;
    }
    
    public ColorPalette(String background, String textcolor, String menuBackground, String menuBackgroundActive) {
        this.background = background;
        this.textColor = textcolor;
        this.menuBackground = menuBackground;
        this.menuBackgroundActive = menuBackgroundActive;
    }
    
    public ColorPalette(ColorPalette colorPalette) {
        this.background = colorPalette.getBackground();
        this.menuBackground = colorPalette.getMenuBackground();
        this.menuBackgroundActive = colorPalette.getMenuBackgroundActive();
        this.textColor = colorPalette.getTextColor();
    }

    public String getBackground() {
        return background;
    }

    public String getTextColor() {
        return textColor;
    }

    public String getMenuBackground() {
        return menuBackground;
    }

    public String getMenuBackgroundActive() {
        return menuBackgroundActive;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public void setMenuBackground(String menuBackground) {
        this.menuBackground = menuBackground;
    }

    public void setMenuBackgroundActive(String menuBackgroundActive) {
        this.menuBackgroundActive = menuBackgroundActive;
    }
    
}
