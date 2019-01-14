package cn.jbone.common.utils;

import com.github.lalyos.jfiglet.FigletFont;
import org.apache.commons.lang3.StringUtils;

import java.io.PrintStream;

public class AsciiArtUtils {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";

    private AsciiArtUtils() {
    }

    /**
     * Print ascii art.
     *
     * @param out        the out
     * @param asciiArt   the ascii art
     * @param additional the additional
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
