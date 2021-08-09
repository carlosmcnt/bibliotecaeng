package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

import java.util.HashMap;
import java.util.Scanner;

//Faz interface com o usuário; Vai fazer a leitura dos comandos do console

public class InterfaceUsuario {
        
        Scanner teclado = new Scanner(System.in);   
        
        private HashMap<String, Command>comandos;
        
        private String texto;
        private String cod1;
        private String cod2;
       
        private String obterComandoEntrada(){ 
                System.out.println();
                System.out.println("Digite o comando: ");
                texto = teclado.nextLine();
                return texto;
        }
       
        //Nas duas funções seguintes, a String é quebrada afim de obter os dois parâmetros separadamente
        public String obterParametro1(){
                
                String cod1 = texto.substring(4,7);
                texto = texto.substring(7);
                return cod1;  
        }
        
        public String obterParametro2(){
                
                if(texto.isEmpty()){
                    cod2 = null; 
                }
                else{
                    cod2 = texto.substring(1,4);
                }
                return cod2;  
        }
   
        //Chamada do comando
        private void executarComando(String stringComando){
                
                String par1 = obterParametro1();
                String par2 = obterParametro2();
                Command comando = comandos.get(stringComando);
                comando.executar(par1, par2);
        }
        
        //Chamada do loop para entrada no programa
        public void loopEntrada(){
                
                comandos = InicializadorDeComandos.inicializarComandos();
                String texto = obterComandoEntrada();
                String stringComando = texto.substring(0, (texto + " ").indexOf(" ")); //Quebra de String para obter o comando
                
                while(!stringComando.equals("sai")){
                        executarComando(stringComando);
                        texto = obterComandoEntrada();
                        stringComando = texto.substring(0, (texto + " ").indexOf(" ")); //Quebra de String para obter o comando
                }
        }
}