package exam.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class Task3 {
    public static void main(String[] args) throws IOException {
        String directoryName = "src/exam/task3";
        String fileName = "Password.txt";
        List<Path> walk = Files.walk(Path.of(directoryName)).toList();


        for (Path path : walk) {
            if (Files.isRegularFile(path)) {
                BufferedReader br = new BufferedReader(new FileReader(path.toString()));
                String line;
                if (Objects.equals(path.getFileName().toString(), fileName)) {
                    while ((line = br.readLine()) != null) {
                        checkStrongPassword(line);
                    }
                    br.close();
                }
            }
        }
    }

    private static void checkStrongPassword(String line) {
        String[] strings = line.split(" ");
        for (String string : strings) {
            if (isStrongPassword(string)) {
                System.out.println(string);
            }
        }
    }

    private static boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean haveDigit = false,
                haveUpperCase = false,
                haveLowerCase = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                haveUpperCase = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                haveDigit = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                haveLowerCase = true;
            }
        }

        return haveDigit && haveLowerCase && haveUpperCase;
    }
}