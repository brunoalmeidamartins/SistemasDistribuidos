
//package calculadora;

import java.rmi.Naming;

public class CalculadoraCliente {
    public static void main(String[] args){
        try{
            CalculadoraInterface obj = (CalculadoraInterface) Naming.lookup("rmi://127.0.0.1/Servidor1");
            System.out.println("Adicao: "+obj.add(10,3));
            CalculadoraInterface obj1 = (CalculadoraInterface) Naming.lookup("rmi://127.0.0.1/Servidor2");
            System.out.println("Subtracao: "+obj1.sub(10,3));
            System.out.println("AdicaoMultiplicacao: "+obj1.add(10,3));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
