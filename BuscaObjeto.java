package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

//Classe com funções que realizam busca de objetos nas listas.
public class BuscaObjeto {
        
        private static Usuario usuario;
        private static Livro livro;
        private static Exemplar exemplar;
        private static TransacaoEmprestimo transacaoEmprestimo;
        private static TransacaoReserva transacaoReserva;
        
        public static Usuario buscarUsuario(String idUsuario){ 
            
                for (int i = 0; i < DadosMemoria.getListaUsuarios().size(); i++) {
                        if(DadosMemoria.getListaUsuarios().get(i).getCodigo().equals(idUsuario)){
                                usuario = DadosMemoria.getListaUsuarios().get(i); 
                            }   
                }
                return usuario;
        }
        
        public static Livro buscarLivro(String codLivro){
            
                for (int i = 0; i < DadosMemoria.getListaLivros().size(); i++) {
                        if(DadosMemoria.getListaLivros().get(i).getCodigo().equals(codLivro)){
                                livro = DadosMemoria.getListaLivros().get(i); 
                        }   
                }
                return livro;
        }
        
        
        
        //Busca exemplar disponível para empréstimo
        public static Exemplar buscarExemplarEmprestimo(String codLivro){
            
                for (int i = 0; i < DadosMemoria.getListaExemplares().size(); i++) {
                        if(DadosMemoria.getListaExemplares().get(i).getCodLivro().equals(codLivro)){
                                if(DadosMemoria.getListaExemplares().get(i).getStatus().equals("disponível")){
                                        exemplar = DadosMemoria.getListaExemplares().get(i);
                                        return exemplar;
                                }
                                
                        }   
                }
                return null;
        }
        
        public static Exemplar buscarExemplar(String codLivro){  
            
                for (int i = 0; i < DadosMemoria.getListaExemplares().size(); i++) {
                        if(DadosMemoria.getListaExemplares().get(i).getCodLivro().equals(codLivro)){
                                 exemplar = DadosMemoria.getListaExemplares().get(i);
                                  return exemplar;
                        }   
                }
                return null;
        }
        
        public static TransacaoEmprestimo buscaTransacaoEmprestimo (Exemplar exemplar){
                for (int i = 0; i < TransacaoEmprestimo.getListaTransacaoEmprestimo().size(); i++){
                        if (TransacaoEmprestimo.getListaTransacaoEmprestimo().get(i).exemplar.getCodExemplar().equals(exemplar.getCodExemplar())){
                                transacaoEmprestimo = TransacaoEmprestimo.getListaTransacaoEmprestimo().get(i);
                                return transacaoEmprestimo;
                        }
                }
            return null;
        }
        
        public static TransacaoReserva buscaTransacaoReserva (Livro livro){
                for (int i = 0; i < TransacaoReserva.getListaTransacaoReserva().size(); i++){
                        if (TransacaoReserva.getListaTransacaoReserva().get(i).livro.getCodigo().equals(livro.getCodigo())){
                                transacaoReserva = TransacaoReserva.getListaTransacaoReserva().get(i);
                                return transacaoReserva;
                        }
                }
            return null;
        }
   
}
