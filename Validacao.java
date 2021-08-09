package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

//Testa se dado usuário é devedor em uma dada data

public class Validacao {
    
        private static Usuario usuario;
        
        public static boolean usuarioDevedor(String idUsuario, String dataDia){
                usuario = BuscaObjeto.buscarUsuario(idUsuario);
                boolean teste = false;
                for (int i = 0; i<usuario.getListaLivrosEmprestadosCorrentes().size(); i++){
                        
                        String dataEmprestimo = usuario.getListaLivrosEmprestadosCorrentes().get(i).getDataEmprestimo();
                        teste = usuario.testeUsuarioDevedor(dataDia, dataEmprestimo);
                        if (teste){
                                return true;
                        }
                        
                }    
                return false;
        }
        
        public static boolean livroReservado(Usuario usuario, Livro livro){
                
                boolean teste = false;
                for (int i = 0; i<usuario.getListaLivrosReservados().size(); i++){
                        if(usuario.getListaLivrosReservados().get(i).livro.getCodigo().equals(livro.getCodigo())){
                                teste = true;                              
                        }                     
                } 
                if(teste){
                        return true;
                }
                return false;
        }
        
        public static boolean livroEmprestado(Usuario usuario, Livro livro){
                
                boolean teste = false;
                for (int i = 0; i<usuario.getListaLivrosEmprestadosCorrentes().size(); i++){
                        if(usuario.getListaLivrosEmprestadosCorrentes().get(i).exemplar.getCodLivro().equals(livro.getCodigo())){
                                teste = true;                              
                        }                     
                } 
                if(teste){
                        return true;
                }
                return false;
        }
   
}
