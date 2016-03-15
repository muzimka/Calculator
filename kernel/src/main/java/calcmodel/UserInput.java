package calcmodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MainW8 on 14.03.2016.
 */
public class UserInput {
    String input;
    Queue<String> ciphers;
    Queue<String> signs;


    public UserInput() {
        ciphers = new LinkedList<String>();
        signs = new LinkedList<String>();
    }

    public Queue<String> getCiphers() {
        return ciphers;
    }

    public Queue<String> getSigns() {
        return signs;
    }

    public void readInput(File file) {
        Scanner sc = null;
        try {
            sc = new Scanner(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        input = sc.nextLine();
    }

    public void readInput() {
       Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение:");
        input = sc.nextLine();
        boolean valid = isValid();
        while (!valid){
            System.out.println("Ошибка ввода! Введите еще раз");
            input = sc.nextLine();
            valid = isValid();
        }


    }

    public String getInput() {
        return input;
    }

    private boolean isValid() {
        return input.matches("[0-9.*+-/()]+");
    }

    public boolean isValid(File file) {
        readInput(file);
       return input.matches("[0-9.*+-/()]+");
    }

    private Queue<String> getTokens(String pattern) {
        Queue<String> tokens = new LinkedList<String>();
        Pattern tokSplitter = Pattern.compile(pattern);
        Matcher m = tokSplitter.matcher(input);

        while (m.find()) {
            tokens.add(m.group());
        }
        return tokens;
    }

    public void parseInput(File file){
        readInput(file);
    ciphers = getTokens("[0-9.]+");
        System.out.println(ciphers);
    signs = getTokens("[\\*\\+\\-/()]+");
        System.out.println(signs);
    }

}
