package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

public class ConsultarUsuario implements Command {

        @Override
        public void executar(String par1, String par2) {
                String idUsuario = par1;
                BibliotecaFachada.obterInstancia().consultarUsuario(par1);
        }
    
}
