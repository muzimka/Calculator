package calcmodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputParser {
    private String input;
    private List<Double> ciphers;
    private List<Character> signs;

    public UserInputParser() {
        ciphers = new LinkedList<Double>();
        signs = new LinkedList<Character>();

        readInput();
    }

    public UserInputParser(File file) {
        ciphers = new LinkedList<Double>();
        signs = new LinkedList<Character>();
        readInput(file);
    }

    public UserInputParser(String userInput) {
        ciphers = new LinkedList<Double>();
        signs = new LinkedList<Character>();
        this.input = userInput;
    }

    /*читает ввод из файла для тестирования*/
    private void readInput(File file) {
        Scanner sc = null;
        try {
            sc = new Scanner(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        input = sc.nextLine();
        parseInput();
    }

    /*читает ввод из потока ввода*/
    private void readInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение:");
        input = sc.nextLine();
        boolean valid = isValid();
        while (!valid) {
            System.out.println("Ошибка ввода! Введите еще раз");
            input = sc.nextLine();
            valid = isValid();
        }
        parseInput();
    }

    /*`первичная проверка на отсутствие символов никогда не принимающих участие в выражении*/
    private boolean isValid() {
        return input.matches("[0-9.*+-/()]+");
    }

    private LinkedList<String> getTokens(String pattern) {
        LinkedList<String> tokens = new LinkedList<String>();
        Pattern tokSplitter = Pattern.compile(pattern);
        Matcher m = tokSplitter.matcher(input);

        while (m.find()) {
            tokens.add(m.group());
        }
        return tokens;
    }

    /*создает два листа 1. с цифрами 2. с операторами*/
    private void parseInput() {
        LinkedList<String>  tempCiphers= getTokens("[0-9.]+");
        LinkedList<String>  tempSigns= getTokens("[\\*\\+\\-/]+|\\(|\\)");
        convertStringsList(tempCiphers, tempSigns);
    }

    private void convertStringsList(LinkedList<String> tempCiphers, LinkedList<String> tempSigns) {
        for (String tempSign : tempSigns) {
            char temp = tempSign.toCharArray()[0];
            signs.add(temp);
        }
        for (String tempCipher : tempCiphers) {
            double temp = Double.valueOf(tempCipher);
            ciphers.add(temp);
        }
    }

    public List<Double> getCiphersList() {
        return ciphers;
    }

    public List<Character> getSignsList() {
        return signs;
    }
}
