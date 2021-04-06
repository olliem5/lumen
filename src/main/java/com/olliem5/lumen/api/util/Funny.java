package com.olliem5.lumen.api.util;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author olliem5
 * @since 1.0
 */

public final class Funny {
    public static void doFunny() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date aprilFools = simpleDateFormat.parse("2022-04-01");
            LocalDateTime now = LocalDateTime.now();
            Date today = simpleDateFormat.parse(String.valueOf(now));

            if (aprilFools == today) {
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
            }
        } catch (ParseException | URISyntaxException | IOException ignored) {}
    }
}
