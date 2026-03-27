// A non-parameter file variable is set as world-writable and later read from should be flagged as a security vulnerability.
package scensct.var.pos;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class PosCase1_Var1 {
    public static void main(String[] args) throws IOException {
        // Variant 1: Use Files.setPosixFilePermissions for world-writable
        Path path = Paths.get("world_writable.txt");
        File fileVar = path.toFile();
        Set<PosixFilePermission> perms = new HashSet<>();
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.GROUP_WRITE);
        perms.add(PosixFilePermission.OTHERS_READ);
        perms.add(PosixFilePermission.OTHERS_WRITE);
        Files.setPosixFilePermissions(path, perms);
        
        try (FileInputStream fis = new FileInputStream(fileVar)) {
            fis.read();
        }
    }
}