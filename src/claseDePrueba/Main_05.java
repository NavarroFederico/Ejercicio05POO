/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseDePrueba;
import ClasesDeServicios.ServicioCuenta;
import Entidades.Cuenta;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Main_05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner leer = new Scanner(System.in);
        
        ServicioCuenta servicioCuenta = new ServicioCuenta();
        
        Cuenta c1= servicioCuenta.crearUnaCuenta();
        
        System.out.println("Ingrese el dinero a ingresar");
        double monto= leer.nextDouble();
        servicioCuenta.ingresarDinero(c1, monto);
        System.out.println("Ingrese dinero a retirar: ");
        monto=leer.nextDouble();
        servicioCuenta.retirarDinero(c1, monto);
        servicioCuenta.consultarSaldo(c1);
        servicioCuenta.extraccionRapida(c1);
        servicioCuenta.consultarSaldo(c1);
        servicioCuenta.mostrarDatos(c1);
        
    }

}
