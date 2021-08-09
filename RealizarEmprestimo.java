package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

public class RealizarEmprestimo implements Command {

        @Override
        public void executar(String par1, String par2) {
                String idUsuario = par1;
                String codLivro = par2;
                BibliotecaFachada.obterInstancia().realizarEmprestimo(idUsuario,codLivro);
        }
    
}
