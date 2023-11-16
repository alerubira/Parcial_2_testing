/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import paecial_2_testing_grupo_5.cuenta;


/**
 *
 * @author Gabriel
 */
public class cuentaTest {
    
    public cuentaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       // BeforeClass muestra: Fecha de transacción y la fechaLocal → 2020, Month.NOVEMBER, 13
       Date fechaActual = new Date();
 
        System.out.println("La fecha actual y de la transaccion es :"+fechaActual);        
    
    }
    
    @AfterClass
    public static void tearDownClass() {
        //AfterClass: que muestra: FIN de la transacción
        System.out.println("FIN de la transaccion");
    }
    cuenta miCuenta;
    cuenta c3;
    @Before
    public void setUp() {
       // Before: que instancia (micuenta) la cuenta origen y c3 (cuenta auxiliar).
        miCuenta=new cuenta();
        c3 = new cuenta(2,5000.0);
        //miCuenta.setSaldo(2000.0);
        
    }   

    
    
    @After
    public void tearDown() {
       // After: que muestra: el saldo con que quedo la cuenta.
        System.out.println("Su saldo actual es : "+miCuenta.getSaldo());
    }

    
    @Test (expected = Exception.class)
    public void testRetirarFallo() throws Exception{
        /*B. Crear el método testRetirarFallo, que espera @Test(expected = Exception.class), que con micuenta llama a 
         retirarDinero(monto) pero intenta retirar un monto de 9000.0$, la prueba tendrá éxito al arrojar la Exeption
       desde cuenta.*/
         miCuenta.retirarDinero(9000.0);
    }
    @Test
    public void testRetirarExito()throws Exception{
       /* C. Crear el método testRetirarExito, que llama a retirarDinero(monto) de la cuenta, la prueba tendrá éxito al 
        descontar saldo de la cuenta con normalidad.*/ 
       miCuenta.retirarDinero(1000.0);
    }
    @Test
    public void testDepositarDinero(){
       /* D. Crear el método testDepositarDinero un monto de 200.0$, utilice la aserción assertNotNull con la cuenta. 
         Luego llame a depositarDinero en cuenta, y use assertEquals donde su saldo esperado coincida con el real de 
        2200$. Use un delta de 0.2 centavos. */
       Assert.assertNotNull(miCuenta);
       miCuenta.depositarDinero(miCuenta, 200.0);
      
       Assert.assertEquals(2200.0, miCuenta.getSaldo(),0.2 );
    }
    @Test
    public void testTransferirCuentaNoNula() throws Exception{
       /* E. Crear el método testTransferirCuentaNoNula que pueda arrojar Exception, utilice la aserción assertNull. Con 
         micuenta invocara a transferirDinero(c2, monto) , siendo c2 una variable local cuenta con 5000$ de saldo.*/
       cuenta c2=new cuenta(3,5000);
       
       miCuenta.transferirDinero(c2, 10);
       Assert.assertNotNull(c2);
    }
    @Test
    public void testCuentasDiferentes(){
       /* F. Crear el método testCuentasDiferentes que con micuenta y la c3, llama a CuentasDiferentes en clase cuenta. 
     Luego usamos assertNotSame("SON la MISMA cuenta!! origen y destino",micuenta, micuenta. El mensaje se 
     muestra en caso de error, y le prueba debe FALLAR.*/
       miCuenta.cuentasDiferentes(c3);
       c3.cuentasDiferentes(miCuenta);
       Assert.assertNotSame("SON la misma cuenta!! origen y destino", miCuenta, miCuenta);
    }
    @Test
    public void testCuentasIguales (){
       /* G. Crear el método testCuentasIguales usamos assertSame("Las cuentas son diferentes---,micuenta, c3. El 
     mensaje se muestra en caso de error, y le prueba debe FALLAR.*/
       Assert.assertSame("Las cuentas son diferentes-----miCuenta,c3", miCuenta, c3);
    }
    @Test(timeout=60)
    public void testOperacionTildada1(){
      /* H. Creamos las @Test -timeout con 60 milisegundos, llamadas
    I. HtestOperacionTildada1: llama a OperacionTildada en clase cuenta, y le pasamos al Thread un 
      valor inferior a 50 milisegundos. Arroja una InterruptedException. Debe tener ÉXITO. */
      c3.operacionTildada(40);
    }
    @Test(timeout=60)
    public void testOperacionTildada2(){
      /* II. testOperacionTildada2: llama a OperacionTildada en clase cuenta, y le pasamos al Thread un 
      valor superior a 50 milisegundos. Arroja una InterruptedException. Debe tener causar ERROR 
       TEST TIMED.*/ 
      c3.operacionTildada(110);
    }
}


