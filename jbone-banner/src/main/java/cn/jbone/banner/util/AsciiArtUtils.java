package cn.jbone.banner.util;

import com.github.lalyos.jfiglet.FigletFont;
import org.apache.commons.lang3.StringUtils;

import java.io.PrintStream;

public class AsciiArtUtils {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";

    private AsciiArtUtils() {
    }

    /**
     * 输出艺术字
     *
     * @param out        输出流
     * @param asciiArt   艺术字
     * @param additional 普通附加字
     */
    public static void printAsciiArt(final PrintStream out, final String asciiArt, final String additional) {
        try {
            out.println(ANSI_CYAN);
            if (StringUtils.isNotBlank(additional)) {
                out.println(FigletFont.convertOneLine(asciiArt));
                out.println(additional);
            } else {
                out.print(FigletFont.convertOneLine(asciiArt));
            }
            out.println(ANSI_RESET);
        } catch (final Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
