import calcmodel.UserInputParser;

import java.util.List;

/*Проверка ввода с консоли*/
public class InputTest {

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 3; i++) {

            UserInputParser userInput = new UserInputParser();
            List listSigns = userInput.getSignsList();
            List listCiphers = userInput.getCiphersList();
            System.out.println("listCiphers = " + listCiphers);
            System.out.println("listSigns = " + listSigns);
        }
    }
}
