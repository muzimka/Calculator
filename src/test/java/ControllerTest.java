import com.muzima.calc.calculator.Calculating;
import com.muzima.calc.controllers.AppController;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.mockito.Mockito.*;


import org.junit.Ignore;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ModelResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

/**
 * Created by MainW8 on 12.03.2016.
 */
public class ControllerTest {
    @Test
    public void testHomeMethod() throws Exception {
        AppController controller = new AppController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("home"));
        //mockMvc.perform(MockMvcRequestBuilders.get("/home/")).andExpect(MockMvcResultMatchers.view().name("home"));
    }

    @Ignore
    @Test
    public void testAddCalculatingInterface() throws Exception {
        int x = 1;
        int y = 3;
        int res = x + y;
        Calculating interfaceCalc = mock(Calculating.class);
        when(interfaceCalc.add(x, y)).thenReturn(x + y);

        AppController controller = new AppController();

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(
                new InternalResourceView("/WEB-INF/view/home.jsp")).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.view().name("home"))
                .andExpect(model().attributeExists("result"))
                .andExpect(model().attribute("result",hasValue(res)));

    }
}
