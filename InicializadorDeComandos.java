package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

import java.util.HashMap;

//Inicializa os comandos do sistema da biblioteca
public class InicializadorDeComandos {

        public  static HashMap<String, Command> inicializarComandos(){
                
                HashMap<String, Command>comandos = new HashMap<String, Command>();
                
                comandos.put("emp", new RealizarEmprestimo());
                comandos.put("dev", new RealizarDevolucao());
                comandos.put("res", new RealizarReserva());
                comandos.put("obs", new RegistrarObservador());
                comandos.put("liv", new ConsultarLivro());
                comandos.put("usu", new ConsultarUsuario());
                comandos.put("ntf", new ConsultarNotificacaoProfessor());
                
                return comandos;
        }
}
