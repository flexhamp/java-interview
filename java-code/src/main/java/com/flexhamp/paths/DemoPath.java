package com.flexhamp.paths;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class DemoPath {
    public static void main(String[] args) {
        final URL resource = DemoPath.class.getResource("/data.txt");
    }

    public void pathUsage () {
        Path currentDir = Paths.get("."); // currentDir = "."
        Path fullPath = currentDir.toAbsolutePath(); // fullPath = "/Users/guest/workspace"
        Path one = currentDir.resolve("file.txt"); // one = "./file.txt"
        Path fileName = one.getFileName(); // fileName = "file.txt"
    }
}
