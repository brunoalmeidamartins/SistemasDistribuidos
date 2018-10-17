/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package calculadora;
import java.rmi.Naming;
public class CalculadoraServ1 {
    public static void main(String[] args){
        try{
            CalculadoraInterface servidor1 = new CalculadoraImple1();
            Naming.rebind("Servidor1", servidor1);
            System.out.println("Servidor 1 no ar!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
