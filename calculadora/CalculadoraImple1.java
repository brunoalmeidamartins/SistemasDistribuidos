/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package calculadora;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class CalculadoraImple1 extends UnicastRemoteObject implements CalculadoraInterface {
    public CalculadoraImple1() throws RemoteException{
        //super();
    }
    public int add(int a, int b) throws RemoteException{
        return a + b;
    }

    @Override
    public int sub(int a, int b) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
