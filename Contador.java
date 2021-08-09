package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

//Classe para guardar os contadores de exemplar de cada livro e a quantidade de notificações do professor observador.
public class Contador {
    
        private static Usuario usuario;

        public static int qtdExemplar(String codLivro){
                
                int qtdExemplar = 0;
                for (int i = 0; i < DadosMemoria.getListaExemplares().size(); i++) {
                            if(DadosMemoria.getListaExemplares().get(i).getCodLivro().equals(codLivro)){
                                    if(DadosMemoria.getListaExemplares().get(i).getStatus().equals("disponível")){
                                            qtdExemplar ++;
                                    }
                            }
                }
                return qtdExemplar;
        }

        public static int qtdNotificacaoProfessor(String idUsuario, String codLivro){
            
                Livro livro = BuscaObjeto.buscarLivro(codLivro); 
                usuario = BuscaObjeto.buscarUsuario(idUsuario);
                int qtdReservaLivro = livro.getQtdReservas();                
                int qtdNotificacoesProfessor =0;
                if (qtdReservaLivro >= 2){
                        usuario.setQtdNotificacao(usuario.getQtdNotificacao()+1);
                        qtdNotificacoesProfessor = usuario.getQtdNotificacao();
                }
                return qtdNotificacoesProfessor;
        }
}
