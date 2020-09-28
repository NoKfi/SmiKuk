import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        System.out.println("Input address files:\n");

        BufferedReader bufferedReader1 = null;
        BufferedReader bufferedReader2 = null;

        try {
            if (args.length > 0) {
                bufferedReader1 = new BufferedReader(new FileReader(args[0]));
            } else {
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader consoleReaderr = new BufferedReader(new InputStreamReader(System.in));
                String fileName1 = consoleReader.readLine();
                String fileName2 = consoleReaderr.readLine();
                bufferedReader1 = new BufferedReader(new FileReader(fileName1));
                bufferedReader2 = new BufferedReader(new FileReader(fileName2));
                consoleReader.close();
            }

            while (true) {
                String line = bufferedReader1.readLine();
                assert bufferedReader2 != null;
                String line2 = bufferedReader2.readLine();
                if (line2 == null) {
                    break;
                }
                if (line == null) {
                    break;
                }

                try {
                    if (line2.equals(line)) {
                        System.out.println("\nFiles match. \n"
                                + "\nText output from files:\n" + (line));
                    } else {
                        System.out.println("Files do not match.");
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }

            }

        } catch (IOException a) {
            System.out.println("!FILE NOT FOUND! " + a);
        } finally {
            try {
                assert bufferedReader1 != null;
                bufferedReader1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert bufferedReader2 != null;
                bufferedReader2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}