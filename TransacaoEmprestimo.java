package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//Trabalha com os dados referentes aos empréstimos 

public class TransacaoEmprestimo {
        
          
        private String dataEmprestimo;
        private String dataDevolucao; 
        private String situacaoEmprestimo;
        
        Usuario usuario;
        Exemplar exemplar;
        
        private static  ArrayList<TransacaoEmprestimo> listaTransacaoEmprestimo = new ArrayList<TransacaoEmprestimo>(); //Todos os empréstimos realizados
        private static  ArrayList<TransacaoEmprestimo> listaTransacaoEmprestimoFinalizado = new ArrayList<TransacaoEmprestimo>(); //Empréstimos finalizados

        public TransacaoEmprestimo(String dataEmprestimo, String dataDevolucao, String situacaoEmprestimo, Exemplar exemplar, Usuario usuario) {
                this.dataEmprestimo = dataEmprestimo;
                this.dataDevolucao = dataDevolucao;
                this.situacaoEmprestimo = situacaoEmprestimo;
                this.usuario = usuario;
                this.exemplar = exemplar;
        }
        
        
        
        
        public static void adicionarEmprestimo(String dataEmprestimo, String dataDevolucao, String situacaoEmprestimo, Exemplar exemplar, Usuario usuario){
                TransacaoEmprestimo.listaTransacaoEmprestimo.add(new TransacaoEmprestimo(dataEmprestimo,dataDevolucao, situacaoEmprestimo, exemplar, usuario ));
        }
        
        public static void adicionarEmprestimoFinalizado(TransacaoEmprestimo transacaoEmprestimo){
                TransacaoEmprestimo.listaTransacaoEmprestimoFinalizado.add(transacaoEmprestimo);
        }
        
        public static void retirarEmprestimo(int i){
                TransacaoEmprestimo.listaTransacaoEmprestimo.remove(i);
        }
        
        //Função auxiliar para a realização do empréstimo
        public static void efetuarEmprestimo(String dataHoje, Exemplar exemplar, Usuario usuario, Livro livro){            
                                                                     
                Date dataLimiteDevolucaoD = usuario.dataLimiteDevolucao(dataHoje);                                                        
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");                                                        
                String dataLimiteDevolucaoS = dateFormat.format(dataLimiteDevolucaoD);                                                                                                            
                
                exemplar.setStatus("emprestado"); 
                
                System.out.println("\nEmpréstimo realizado com sucesso!" + "\nEmprestado para: " + usuario.getNome() 
                + "\nTítulo do livro: " + livro.getTitulo() + "\n");                                                                                     
                
                String situacaoEmprestimo = "Em curso";
                
                TransacaoEmprestimo.adicionarEmprestimo(dataHoje,dataLimiteDevolucaoS,situacaoEmprestimo,exemplar, usuario); //adiciona empréstimo a lista de empréstimos correntes do sistema
                
                TransacaoEmprestimo transacaoEmprestimo = BuscaObjeto.buscaTransacaoEmprestimo(exemplar);
                usuario.listaLivrosEmprestadosCorrentes.add(transacaoEmprestimo); //adiciona empréstimo a lista de empréstimos correntes do usuário
                usuario.setQtdEmprestimos(usuario.getQtdEmprestimos()+1);
                                          
        }
        
                
        public String getDataEmprestimo() {
                return dataEmprestimo;
        }

        public void setDataEmprestimo(String dataEmprestimo) {
                this.dataEmprestimo = dataEmprestimo;
        }

        public String getDataDevolucao() {
                return dataDevolucao;
        }

        public void setDataDevolucao(String dataDevolucao) {
            this.dataDevolucao = dataDevolucao;
        }

        public String getSituacaoEmprestimo() {
            return situacaoEmprestimo;
        }

        public void setSituacaoEmprestimo(String situacaoEmprestimo) {
            this.situacaoEmprestimo = situacaoEmprestimo;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public Exemplar getExemplar() {
            return exemplar;
        }

        public void setExemplar(Exemplar exemplar) {
            this.exemplar = exemplar;
        }
        
        public static ArrayList<TransacaoEmprestimo> getListaTransacaoEmprestimo() {
            return listaTransacaoEmprestimo;
        }

        public void setListaTransacaoEmprestimo(ArrayList<TransacaoEmprestimo> listaTransacaoEmprestimo) {
                listaTransacaoEmprestimo = listaTransacaoEmprestimo;
        }

        public static ArrayList<TransacaoEmprestimo> getListaTransacaoEmprestimoFinalizado() {
            return listaTransacaoEmprestimoFinalizado;
        }

        public static void setListaTransacaoEmprestimoFinalizado(ArrayList<TransacaoEmprestimo> listaTransacaoEmprestimoFinalizado) {
            TransacaoEmprestimo.listaTransacaoEmprestimoFinalizado = listaTransacaoEmprestimoFinalizado;
        }   
}
