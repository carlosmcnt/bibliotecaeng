package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

public class ConsultarLivro implements Command{

        @Override
        public void executar(String par1, String par2) {
                String codLivro = par1;
                BibliotecaFachada.obterInstancia().consultarLivro(par1);
        }
    
}
