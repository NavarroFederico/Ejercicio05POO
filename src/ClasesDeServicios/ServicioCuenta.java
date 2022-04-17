/*
Realizar una clase llamada Cuenta (bancaria) que debe tener como mínimo los
atributos: numeroCuenta (entero), el DNI del cliente (entero largo), el saldo actual. Las
operaciones asociadas a dicha clase son:
• Constructor por defecto y constructor con DNI, saldo, número de cuenta e interés.
• Agregar los métodos getters y setters correspondientes
• Ok-Metodo para crear un objeto Cuenta, pidiéndole los datos al usuario.
• Método ingresar(double ingreso): el método recibe una cantidad de dinero a
ingresar y se la sumara a saldo actual.
• Método retirar(double retiro): el método recibe una cantidad de dinero a retirar y
se la restará al saldo actual. Si la cuenta no tiene la cantidad de dinero a retirar, se
pondrá el saldo actual en 0.
• Método extraccionRapida(): le permitirá sacar solo un 20% de su saldo. Validar
que el usuario no saque más del 20%.
• Método consultarSaldo(): permitirá consultar el saldo disponible en la cuenta.
• Método consultarDatos(): permitirá mostrar todos los datos de la cuent
 */
package ClasesDeServicios;

import Entidades.Cuenta;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class ServicioCuenta {

    public Cuenta crearUnaCuenta() {
        Scanner leer = new Scanner(System.in);
        int nroDeCuentaActual = 0;
        double saldoActual = 0;
        long dniActual = 0;

        System.out.println("Ingrese el numero de cuenta");
        nroDeCuentaActual = leer.nextInt();
        System.out.println("Ingrese el DNI ");
        dniActual = leer.nextLong();
        System.out.println("Ingrese el Saldo de la Cuenta");
        saldoActual = leer.nextDouble();

        Cuenta nuevaCuenta = new Cuenta(nroDeCuentaActual, dniActual, saldoActual);
        return nuevaCuenta;
    }

    public void ingresarDinero(Cuenta usuarioActual, double dineroIngresado) {
        double saldoTotal;
        saldoTotal = usuarioActual.getSaldoActual() + dineroIngresado;
        usuarioActual.setSaldoActual(saldoTotal);
    }

    public void retirarDinero(Cuenta usuarioActual, double dineroARetirar) {
        double saldoTotal;
        if (usuarioActual.getSaldoActual() > dineroARetirar) {
            saldoTotal = usuarioActual.getSaldoActual() - dineroARetirar;
            usuarioActual.setSaldoActual(saldoTotal);
            System.out.println("Extracción Exitosa");
        } else {
            saldoTotal = usuarioActual.getSaldoActual();
            usuarioActual.setSaldoActual(0);
            System.out.println("No se ha podido retirar el total de su saldo. Se retiro solo " + saldoTotal);
        }
    }

    public void extraccionRapida(Cuenta usuarioActual) {
        double porcentaje = usuarioActual.getSaldoActual() * 0.2;
        if(usuarioActual.getSaldoActual()>0){
        double saldoTotal = usuarioActual.getSaldoActual() - porcentaje;

        usuarioActual.setSaldoActual(saldoTotal);
            System.out.println("Extraccion rápida Exitosa");
        }else
        {
            System.out.println("No Posee saldo para hacer esta operación ");
        }
    }

    public void consultarSaldo(Cuenta usuarioActual) {
        double saldoActual = usuarioActual.getSaldoActual();
        System.out.println("El saldo actual de la cuenta es: " + saldoActual);
    }

    public String mostrarDatos(Cuenta usuarioActual) {
        String resultado = "";
        int nroDeCuentaActual = usuarioActual.getNumeroCuenta();
        double saldoActual = usuarioActual.getSaldoActual();
        long dniActual = usuarioActual.getDni();

        resultado = "Datos de la Cuenta :\nNúmero de Cuenta" + nroDeCuentaActual + "\nDNI : " + dniActual + "\nSaldo : " + saldoActual + " pesos.";
        return resultado;
    }
}
