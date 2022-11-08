package com.aspose.html.android;

import com.aspose.html.android.model.InputFormats;
import com.aspose.html.android.model.OutputFormats;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class Utils {

    private static final List<String> protocols = Arrays.asList("http", "https");

    public static InputFormats getInputFormat(String filePath){
        int lastIndexOf = filePath.lastIndexOf(".");
        if(lastIndexOf == -1) return null;
        String ext = filePath.substring(lastIndexOf + 1).toUpperCase();
        switch (ext){
            case "HTML":
            case "HTM": return InputFormats.HTML;
            case "MHT":
            case "MHTML": return InputFormats.MHTML;
            case "XML":
            case "XHTML": return InputFormats.XHTML;
            case "EPUB": return InputFormats.EPUB;
            case "SVG": return InputFormats.SVG;
            case "MD": return InputFormats.MD;
            case "JPEG":
            case "JPG": return InputFormats.JPEG;
            case "TIF":
            case "TIFF": return InputFormats.TIFF;
            case "PNG": return InputFormats.PNG;
            case "GIF": return InputFormats.GIF;
            case "BMP": return InputFormats.BMP;
            default: return null;
        }
    }

    public static OutputFormats getOutputFormat(String filePath){
        int lastIndexOf = filePath.lastIndexOf(".");
        if(lastIndexOf == -1) return null;
        String ext = filePath.substring(lastIndexOf + 1).toUpperCase();
        return OutputFormats.fromValue(ext);
    }

    public static boolean isURI(String str) {
        int colon = str.indexOf(':');
        if (colon < 3) return false;

        String proto = str.substring(0, colon).toLowerCase();
        if (!protocols.contains(proto)) return false;

        try {
            URI uri = new URI(str);
            if (uri.getHost() == null) return false;

            String path = uri.getPath();
            if (path != null) {
                for (int i=path.length()-1; i >= 0; i--) {
                    if ("?<>:*|\"".indexOf( path.charAt(i) ) > -1)
                        return false;
                }
            }
            return true;
        } catch ( Exception ex ) {}

        return false;
    }

}
