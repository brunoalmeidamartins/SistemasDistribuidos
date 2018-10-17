#!/bin/bash


javac *.java

rmic BancoPrincipalImple

rmic BancoFilial1Imple

rmic BancoFilial2Imple

rmic BancoFilial3Imple

rmiregistry 
