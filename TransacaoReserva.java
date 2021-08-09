package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

import java.util.ArrayList;

//Trabalha com os dados referentes as reservas

public class TransacaoReserva {
        
        Usuario usuario;    
        Livro livro;
        private String dataReserva;
        
        private static  ArrayList<TransacaoReserva> listaTransacaoReserva = new ArrayList<TransacaoReserva>();
        
        public  TransacaoReserva(Usuario usuario, Livro livro, String dataReserva) {
                this.usuario = usuario;
                this.livro = livro;
                this.dataReserva = dataReserva;
        }
        
        public static void adicionarReserva(Usuario usuario, Livro livro, String dataReserva){
                TransacaoReserva.listaTransacaoReserva.add(new TransacaoReserva(usuario, livro, dataReserva));
        }
        
        public static void retirarReserva(TransacaoReserva transacaoReserva){
                TransacaoReserva.listaTransacaoReserva.remove(transacaoReserva);
        }

        public Usuario getUsuario() {
                return usuario;
        }

        public void setUsuario(Usuario usuario) {
                this.usuario = usuario;
        }
        
        public Livro getLivro() {
                return livro;
        }

        public void setLivro(Livro livro) {
                this.livro = livro;
        }

        public String getDataReserva() {
                return dataReserva;
        }

        public void setDataReserva(String dataReserva) {
                this.dataReserva = dataReserva;
        }
        
        public static ArrayList<TransacaoReserva> getListaTransacaoReserva() {
                return listaTransacaoReserva;
        }

        public static void setListaTransacaoReserva(ArrayList<TransacaoReserva> listaTransacaoReserva) {
                TransacaoReserva.listaTransacaoReserva = listaTransacaoReserva;
        }
}
