package zadanie1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Skynet {

    private String login = "Reese";
    private String password = "#Terminate";
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        Skynet skynet = new Skynet();
        skynet.run();
    }

    public void run() {
        readCredentials();
        printSkyNetLogo();
        runLoginPanel();
    }

    private void runLoginPanel() {
        String readLogin;
        String readPassword;
        boolean credentialsOK;
        do {
            readLogin = getTextFromInput("Login");
            readPassword = getTextFromInput("Password");
            credentialsOK = verifyCredentials(readLogin, readPassword);
            if (!credentialsOK) {
                System.out.println("Wrong login or password. Try again.");
            }
        } while (!credentialsOK);
        System.out.println();
        System.out.println("Welcome to SKYNET...");
    }

    private String getTextFromInput(String label) {
        System.out.println(label);
        String input = scanner.nextLine();
        return input;
    }

    private boolean verifyCredentials(String login, String password) {
        return this.login.equals(login) && this.password.equals(password);
    }

    private void readCredentials() {
        String path = "res/zadanie1/skynet.conf";
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            this.login = scanner.nextLine();
            this.password = scanner.nextLine();
            scanner.close();
            System.out.println("INFO System reconfigured...");
        } catch (IOException x) {
            System.out.println("INFO No valid conf data");
        }
    }

    private void printSkyNetLogo() {
        try {
            String path = "res/zadanie1/logo.txt";
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException x) {
            System.out.println("Logo file not found!");
        }
    }
}
