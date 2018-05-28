package gui.logic;

import org.junit.Before;
import org.junit.Test;
import gui.logic.Theme;

import static org.junit.Assert.*;

public class ThemeTest {

    ThemeTest t;

    @Before
    public void setUp() {
        this.t = new ThemeTest();
    }

    @Test
    public void testSetColorID() {
        t.setColorID(0);
        int color = t.getColorID();
        assertTrue(t.getColorName() == "gray");
        t.setColorID(1);
        color = t.getColorID();
        assertTrue(t.getColorName() == "black");
        t.setColorID(2);
        color = t.getColorID();
        assertTrue(t.getColorName() == "white");
        t.setColorID(3);
        color = t.getColorID();
        assertTrue(t.getColorName() == "blue");
        t.setColorID(4);
        color = t.getColorID();
        assertTrue(t.getColorName() == "pink");
    }
}