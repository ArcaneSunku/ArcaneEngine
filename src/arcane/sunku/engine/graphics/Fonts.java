package arcane.sunku.engine.graphics;

import java.awt.Font;
import java.io.IOException;
import java.awt.FontFormatException;

public class Fonts {

    public static Font loadTTF(String fontName) {
        return loadFont(fontName, true);
    }

    public static Font loadFont(String fontName, boolean ttf) {
        Font temp;

        try {
            if(ttf)
                temp = Font.createFont(Font.TRUETYPE_FONT, Fonts.class.getResourceAsStream("/assets/fonts/" +fontName));
            else
                temp = Font.createFont(Font.TYPE1_FONT, Fonts.class.getResourceAsStream("/assets/fonts/" +fontName));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.err.printf("Graphics::ERR Couldn't load file \"%s\"\n", fontName);
            temp = null;
        }

        return temp;
    }

}