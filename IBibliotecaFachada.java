package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

//Interface implementada pela BibliotecaFachada com todas as funções do sistema 
public interface IBibliotecaFachada {

        void consultarLivro(String codLivro);

        void consultarNotificacaoProfessor(String idUsuario);

        void consultarUsuario(String idUsuario);

        void realizarDevolucao(String idUsuario, String codLivro);

        void realizarEmprestimo(String idUsuario, String codLivro);

        void realizarReserva(String idUsuario, String codLivro);

        void registrarObservador(String idUsuario, String codLivro);

}
