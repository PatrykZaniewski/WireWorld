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
        Theme.setColorID(0);
        int color = Theme.getColorID();
        assertTrue(Theme.getColorName() == "gray");
        Theme.setColorID(1);
        color = Theme.getColorID();
        assertTrue(Theme.getColorName() == "black");
        Theme.setColorID(2);
        color = Theme.getColorID();
        assertTrue(Theme.getColorName() == "white");
        Theme.setColorID(3);
        color = Theme.getColorID();
        assertTrue(Theme.getColorName() == "blue");
        Theme.setColorID(4);
        color = Theme.getColorID();
        assertTrue(Theme.getColorName() == "pink");
    }
}