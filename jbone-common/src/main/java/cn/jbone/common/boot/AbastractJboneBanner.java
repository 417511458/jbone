package cn.jbone.common.boot;

import cn.jbone.common.utils.AsciiArtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.env.Environment;

import javax.crypto.Cipher;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.*;

public class AbastractJboneBanner implements Banner {
    /**
     * Line separator length.
     */
    private static final int SEPARATOR_REPEAT_COUNT = 60;
    private static final String UPDATE_CHECK_MAVEN_URL = "https://search.maven.org/solrsearch/select?q=g:%22org.apereo.cas%22%20AND%20a:%22cas-server%22";

    /**
     * A line separator.
     */
    public static final String LINE_SEPARATOR = String.join(StringUtils.EMPTY, Collections.nCopies(SEPARATOR_REPEAT_COUNT, "-"));

    private static final ObjectMapper MAPPER = new ObjectMapper().findAndRegisterModules();

    @Override
    public void printBanner(final Environment environment, final Class<?> sourceClass, final PrintStream out) {
        AsciiArtUtils.printAsciiArt(out, getTitle(), collectEnvironmentInfo(environment, sourceClass));
    }

    protected String getTitle() {
        return "(Jbone)";
    }

    /**
     * Collect environment info with
     * details on the java and os deployment
     * versions.
     *
     * @param environment the environment
     * @param sourceClass the source class
     * @return environment info
     */
    private String collectEnvironmentInfo(final Environment environment, final Class<?> sourceClass) {
        final Properties properties = System.getProperties();

        try (Formatter formatter = new Formatter()) {
            formatter.format("Spring Boot Version: %s%n", SpringBootVersion.getVersion());
            formatter.format("%s%n", LINE_SEPARATOR);

            formatter.format("Java Home: %s%n", properties.get("java.home"));
            formatter.format("Java Vendor: %s%n", properties.get("java.vendor"));
            formatter.format("Java Version: %s%n", properties.get("java.version"));
            final Runtime runtime = Runtime.getRuntime();
            formatter.format("JVM Free Memory: %s%n", FileUtils.byteCountToDisplaySize(runtime.freeMemory()));
            formatter.format("JVM Maximum Memory: %s%n", FileUtils.byteCountToDisplaySize(runtime.maxMemory()));
            formatter.format("JVM Total Memory: %s%n", FileUtils.byteCountToDisplaySize(runtime.totalMemory()));
            formatter.format("JCE Installed: %s%n", StringUtils.capitalize(BooleanUtils.toStringYesNo(isJceInstalled())));
            formatter.format("%s%n", LINE_SEPARATOR);

            formatter.format("OS Architecture: %s%n", properties.get("os.arch"));
            formatter.format("OS Name: %s%n", properties.get("os.name"));
            formatter.format("OS Version: %s%n", properties.get("os.version"));
            formatter.format("OS Date/Time: %s%n", LocalDateTime.now());
            formatter.format("OS Temp Directory: %s%n", FileUtils.getTempDirectoryPath());

            formatter.format("%s%n", LINE_SEPARATOR);


            injectEnvironmentInfoIntoBanner(formatter, environment, sourceClass);

            return formatter.toString();
        }
    }


    /**
     * Inject environment info into banner.
     *
     * @param formatter   the formatter
     * @param environment the environment
     * @param sourceClass the source class
     */
    protected void injectEnvironmentInfoIntoBanner(final Formatter formatter,
                                                   final Environment environment,
                                                   final Class<?> sourceClass) {
    }

    private static boolean isJceInstalled() {
        try {
            final int maxKeyLen = Cipher.getMaxAllowedKeyLength("AES");
            return maxKeyLen == Integer.MAX_VALUE;
        } catch (final Exception e) {
            return false;
        }
    }
}
