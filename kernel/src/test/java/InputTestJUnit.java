import static org.junit.Assert.*;

import calcmodel.UserInput;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

/**
 * Created by MainW8 on 14.03.2016.
 */
public class InputTestJUnit {
    UserInput mUserInput;
    File validString;
    File notValidString;

    @Before
    public void setUP(){
        mUserInput = new UserInput();
        validString = new File("G:\\Developing\\Java\\xhasang\\calculator\\kernel\\src\\main\\resources\\validExpression");
        notValidString = new File("G:\\Developing\\Java\\xhasang\\calculator\\kernel\\src\\main\\resources\\invalidExpression");
    }
    @Ignore
    @Test
    public void testReadInput(){
      mUserInput.readInput(validString);
        System.out.println(mUserInput.getInput());
    }

    @Ignore
    @Test
    public void testIsValid(){
       assertTrue(mUserInput.isValid(validString));
        assertFalse(mUserInput.isValid(notValidString));
    }

    @Test
    public void testParseInput(){
        mUserInput.parseInput(validString);
        assertEquals(Integer.parseInt(mUserInput.getCiphers().remove()),5);
        assertEquals(Double.parseDouble(mUserInput.getCiphers().remove()),3.0,0);
        assertEquals(mUserInput.getSigns().remove(),"+");
        assertEquals(mUserInput.getSigns().remove().charAt(0),'-');
    }


}
