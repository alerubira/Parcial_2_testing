/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import paecial_2_testing_grupo_5.cuenta;


/**
 *
 * @author Gabriel
 */
@RunWith(value=Parameterized.class)
public class parameterCuentaTesat {
      static double esperado;
      static double monto;
      static cuenta miCuenta;
   
     public parameterCuentaTesat(cuenta miCuenta,double monto,double esperado) {
         this.miCuenta=miCuenta;
         this.esperado=esperado;
         this.monto=monto;
    }
      

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testeando varios retiros");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin de la transaccion");
    }
    
    @Before
    public void setUp() {
        System.out.println("Intentamos");
         miCuenta=new cuenta();
    }
    
    @After
    public void tearDown() {
        System.out.println("Saldo final : "+miCuenta.getSaldo());
    }
    @Parameters
    public static Iterable<Object[]> datos() {
        return Arrays.asList(new Object[][] {
                
                 { miCuenta, 1500.0,500.0 }, { miCuenta, 300.5,333333 } , { miCuenta, 9999,2000.0 }   
           }); 
    
    }
    @Test
    public void testRetirarDinero() throws Exception {
        assertEquals(esperado, miCuenta.retirarDinero(monto),0.2);
    }

 
   
 
    
}
