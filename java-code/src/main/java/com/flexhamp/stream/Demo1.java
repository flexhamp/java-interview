package com.flexhamp.stream;

import com.flexhamp.paths.DemoPath;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

import static com.flexhamp.util.Constants.DEMO_TXT_FILE_NAME;

public class Demo1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        final URI uri = ClassLoader.getSystemResource(DEMO_TXT_FILE_NAME).toURI();
        final URI uri2 = Objects.requireNonNull(DemoPath.class.getResource("/data.txt")).toURI();

        final byte[] bytes = Files.readAllBytes(Paths.get(uri));
        final String contents = new String(bytes, StandardCharsets.UTF_8);

        final String[] words = contents.split("\\PL+");
        System.out.println(Arrays.toString(words));


        final long count = Arrays.stream(contents.split("\\PL+"))
                .filter(w -> w.length() > 12)
                .count();

        System.out.println(count);
    }
}
