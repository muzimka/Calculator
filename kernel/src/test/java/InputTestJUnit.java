import static org.junit.Assert.*;

import calcmodel.UserInputParser;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Created by MainW8 on 14.03.2016.
 */
public class InputTestJUnit {
    UserInputParser mUserInput;
    File validString;
    File notValidString;

    @Before
    public void setUP(){
        validString = new File("G:\\Developing\\Java\\xhasang\\calculator\\kernel\\src\\main\\resources\\validExpression");
        notValidString = new File("G:\\Developing\\Java\\xhasang\\calculator\\kernel\\src\\main\\resources\\invalidExpression");
        mUserInput = new UserInputParser(validString);
    }


    @Test
    public void testCiphersAndSignsLists(){
        assertEquals((mUserInput.getCiphersList().remove(0)),5,0);
        assertEquals((mUserInput.getCiphersList().remove(0)),3.0,0);
        assertEquals(mUserInput.getSignsList().remove(0),"+");
        assertEquals(mUserInput.getSignsList().remove(0),"-");
        assertEquals(mUserInput.getSignsList().remove(0),"(");

    }


}
