import java.util.Scanner;

public class ValidadorSenhas {

    public static void main(String[] args) {
        Scanner passwords = new Scanner(System.in);

        while (passwords.hasNextLine()) {
                password(passwords.nextLine());
        }

    }

    public static void password(String password) {
        if(!validPassword(password) || !(password.length() >= 6 && password.length() <=32) || password.length() == 0) {
            System.out.println("Senha invalida.");
        } else {
            System.out.println("Senha valida.");
        }
    }

    public static boolean validPassword(String password) {
        boolean v;

        v = password.matches("(.*[a-z].*)") && password.matches("(.*[A-Z].*)")
                && password.matches("(.*[0-Z].*)") && password.matches("\\S+$");

        if (password.matches("(.*[!@#$%&*()_+=|<>?{}\\[\\]~-].*)")) {
            v = false;
        }

        return v;
    }
}
