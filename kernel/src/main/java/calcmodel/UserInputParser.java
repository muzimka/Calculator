package calcmodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputParser {
    private String input;
    private LinkedList<Double> ciphers;
    private LinkedList<Character> signs;
    private LinkedList<Integer> minusAfterParenth = new LinkedList<Integer>();



    private boolean hasFirstNegativeCipher;

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
        this.input= userInput;
        if(!isValid()){
            throw new InputMismatchException("Выражение не должно содержать символом кроме '*','/','+','-','(',')'");
        }
        parseInput();
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
        return input.matches("[0-9.*+-/() ]+");
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
        input.replaceAll("\\s+", "");
        List<String> pOpen = getTokens("\\(");
        List<String> pClose = getTokens("\\)");
        if(pClose.size()!=pOpen.size()){
            throw new InputMismatchException("Число закрывающих скобок не совпадает с количеством открывающих");
        }
        System.out.println("input = " + input);
       /*проверяет начинается ли выражение с отрицательной цифры*/
        if(input.toCharArray()[0]=='-' && new String(Character.toString(input.toCharArray()[1])).matches("\\d")){
            char[] givenArr = input.toCharArray().clone();
            char[] tempArr = new char[givenArr.length-1];
           /*удаляем отрицательный знак сначала и перевод булен в тру*/
            for (int i = 0; i < tempArr.length; i++) {
                tempArr[i]=givenArr[i+1];
            }
            input = new String(tempArr);
            setHasFirstNegativeCipher(true);
        }

        char[] chars = input.toCharArray();
        LinkedList<String>  tempCiphers= getTokens("[0-9.]+");
        LinkedList<String>  tempSigns= getTokens("[\\*\\+\\-/]+|\\(|\\)");
        convertStringsList(tempCiphers, tempSigns);
    }

    private void convertStringsList(LinkedList<String> tempCiphers, LinkedList<String> tempSigns) {

/*обрабатывает последствия нахождения в выражении цифры в скобках типа -(-3)*/
        /*проверяет ошибку ввода типа 2+*3, если 2***3 то считает как 2*3  и т.п.*/
        for (String tempSign : tempSigns) {

            char firstSign = tempSign.toCharArray()[0];
            char[] chars = tempSign.toCharArray();
            if(chars.length>1){
                for (int i = 1; i <= chars.length-1; i++) {

                    if(firstSign!=chars[i]){
                        throw new InputMismatchException("Выражение содержит нелогичные чередования операторов, например 2+-3 или 2*+3 ");
                    }
                }
            }
            signs.add(firstSign);
        }



        int signsCount =0;
        for (String tempSign : tempSigns) {
            if(tempSign.matches("[*\\-+/]+")){
                signsCount++;
            }
        }
        for (int i = 0; i < tempSigns.size() && i+1<tempSigns.size() && i+2<tempSigns.size(); i++) {
           /*решает можно ли применить последствия(если кол-во знаков(всех кроме ( и ) меньше чем кол-во цифр то цифр типа (-3) в выражении нет*/
            if(signsCount<tempCiphers.size()){
                break;
            }

            String givenString = tempSigns.get(i);
            String nextString = tempSigns.get(i+1);
            String afterNextString = tempSigns.get(i+2);


// if 2+((-35)+2) то создаем массив с индексами цифр типа -35, чтобы потом сделать ее отрицательной при расчете
            if (i + 3 < tempSigns.size()
                    && givenString.equals("(")
                    && nextString.equals("(")
                    && afterNextString.equals("-")
                    && tempSigns.get(i + 3).equals(")")) {
                int indx = countMinusAfterParenthesisOffset(i + 2, tempSigns);
                minusAfterParenth.add(indx);
                tempSigns.remove(i + 3);
                tempSigns.remove(i + 2);
                tempSigns.remove(i + 1);
                signsCount--;
            }

// if (+78)-1
            if(i-1<0 && givenString.equals("(")
                    && nextString.equals("+")
                    && afterNextString.equals(")")){
                tempSigns.remove(i+2);
                tempSigns.remove(i+1);
                tempSigns.remove(i);
                signsCount--;
            }
/*if 1-(+78)*/
            if(i-1>=0 && givenString.equals("(")
                    && nextString.equals("+")
                    && afterNextString.equals(")")){
                    tempSigns.remove(i+2);
                    tempSigns.remove(i+1);
                    tempSigns.remove(i);
                    signsCount--;
            }

// if (-78)+1
           if(i-1<0 && givenString.equals("(")
                   && nextString.equals("-")
                   && afterNextString.equals(")")){
               if(tempSigns.get(i+1).equals("-")){
                   setHasFirstNegativeCipher(true);
               }
               tempSigns.remove(i+2);
               tempSigns.remove(i+1);
               tempSigns.remove(i);
               signsCount--;
               setHasFirstNegativeCipher(true);
           }
//  если 1-(-78)
            if(i-1>=0
                    &&givenString.equals("(")
                    && nextString.equals("-")
                    && afterNextString.equals(")")
                    && tempSigns.get(i-1).equals("-")){
                tempSigns.remove(i+2);
                tempSigns.set(i+1,"+");
                tempSigns.remove(i);
                tempSigns.remove(i-1);
                signsCount--;
            }
//if 1+(-78)
            else if(i-1>=0 &&
                    givenString.equals("(")
                    &&tempSigns.get(i-1).equals("+")){
                tempSigns.remove(i+2);
                tempSigns.remove(i+1);
                tempSigns.remove(i);
                tempSigns.set(i-1,"-");
                signsCount--;
            }
        }




        for (String tempCipher : tempCiphers) {
            double temp = Double.valueOf(tempCipher);
            ciphers.add(temp);
        }
    }

    private int countMinusAfterParenthesisOffset(int signIndex, LinkedList<String> signs) {
        int count = 0;
        for (int i = 0; i <= signIndex && i < signs.size(); i++) {
            if (signs.get(i).equals("(") || signs.get(i).equals(")")) {
                count++;
            }
        }
        return signIndex - count;
    }

    public LinkedList<Double> getCiphersList() {
        return ciphers;
    }

    public LinkedList<Character> getSignsList() {
        return signs;
    }

    private void setHasFirstNegativeCipher(boolean hasFirstNegativeCipher) {
        this.hasFirstNegativeCipher = hasFirstNegativeCipher;
    }

    public boolean isHasFirstNegativeCipher() {
        return hasFirstNegativeCipher;
    }

    public LinkedList<Integer> getMinusAfterParenth() {
        return minusAfterParenth;
    }
}
