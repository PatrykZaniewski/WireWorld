package gui.logic;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SimulationTest {

    Simulation s;


    @Before
    public void setUp() {
        ArrayList<int [][]> lista = new ArrayList<>();
        int [][] l1 = new int [2][2];
        int [][] l2 = new int [2][2];
        int amount = 50;
        l1[0][0] = 1;
        l1[0][1] = 2;
        l1[1][0] = 3;
        l1[1][1] = 4;
        l2[0][0] = 0;
        l2[0][1] = 1;
        l2[1][0] = 0;
        l2[1][1] = 1;
        lista.add(l1);
        lista.add(l2);
        s = new Simulation(l1,amount, true);

    }

    @Test
    public void getAmount() {
        int i;
        i = s.getAmount();
        assertTrue((i > 0 ) && (i <= 100 ) );
        assertNotNull(i);
    }

    @Test

    public void startSim(){
        ArrayList<int [][]> lista2 = new ArrayList<>();
        lista2 = s.getLista();
        int n1 = lista2.size();
        int [][] l3 = new int [2][2];
        l3[0][0] = 3;
        l3[0][1] = 3;
        l3[1][0] = 3;
        l3[1][1] = 3;
        lista2.add(l3);
        int n2 = lista2.size();
        assertTrue(n2>n1 );
        assertNotNull(lista2);
    }

}