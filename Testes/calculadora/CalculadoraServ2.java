/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package calculadora;
import java.rmi.Naming;
public class CalculadoraServ2 {
    public static void main(String[] args){
        try{
            CalculadoraInterface servidor2 = new CalculadoraImple2();
            Naming.rebind("Servidor2", servidor2);
            System.out.println("Servidor 2 no ar!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
