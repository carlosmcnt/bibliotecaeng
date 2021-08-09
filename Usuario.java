package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

import java.util.ArrayList;
import java.util.Date;

public  abstract class Usuario {
    
        private String idUsuario;
        private String nome;
        
        private int qtdReservas;
        private int qtdEmprestimos;
        private int qtdNotificacao = 0;
        
        
        ArrayList<TransacaoReserva> listaLivrosReservados = new ArrayList<TransacaoReserva>(); //Cada usuário tem uma lista de livros reservados
        ArrayList<Livro> listaLivrosObservados = new ArrayList<Livro>(); //Cada observador tem uma lista com os livros que observa
        ArrayList<TransacaoEmprestimo> listaLivrosEmprestadosCorrentes = new ArrayList<TransacaoEmprestimo>(); //Cada usuário tem uma lista de livros emprestados correntes
        ArrayList<TransacaoEmprestimo> listaLivrosEmprestadosFinalizados = new ArrayList<TransacaoEmprestimo>(); //Cada usuário tem uma lista de livros emprestados finalizados
        
        public abstract boolean testeUsuarioDevedor(String dataDia, String dataEmprestimo); 
        public abstract Date dataLimiteDevolucao(String dataEmprestimo);
        public abstract boolean testeLimiteQtdEmprestimo(); 
 
        public Usuario(String codigo, String nome) {
                this.idUsuario = codigo;
                this.nome = nome;
        }
       
        public String getCodigo() {
                return idUsuario;
        }

        public void setCodigo(String codigo) {
                this.idUsuario = codigo;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        } 
        
        public int getQtdReservas() {
                return qtdReservas;
        }

        public void setQtdReservas(int qtdReservas) {
                this.qtdReservas = qtdReservas;
        }

        public String getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(String idUsuario) {
            this.idUsuario = idUsuario;
        }

        public int getQtdEmprestimos() {
            return qtdEmprestimos;
        }

        public void setQtdEmprestimos(int qtdEmprestimos) {
            this.qtdEmprestimos = qtdEmprestimos;
        }
        
        public int getQtdNotificacao() {
                return qtdNotificacao;
        }

        public void setQtdNotificacao(int qtdNotificacao) {
                this.qtdNotificacao = qtdNotificacao;
        }

        public ArrayList<Livro> getListaLivrosObservados() {
                return listaLivrosObservados;
        }

        public void setListaLivrosObservados(ArrayList<Livro> listaLivrosObservados) {
                this.listaLivrosObservados = listaLivrosObservados;
        }

        public ArrayList<TransacaoReserva> getListaLivrosReservados() {
                return listaLivrosReservados;
        }

        public void setListaLivrosReservados(ArrayList<TransacaoReserva> listaLivrosReservados) {
                this.listaLivrosReservados = listaLivrosReservados;
        }

        public ArrayList<TransacaoEmprestimo> getListaLivrosEmprestadosCorrentes() {
                return listaLivrosEmprestadosCorrentes;
        }

        public void setListaLivrosEmprestadosCorrentes(ArrayList<TransacaoEmprestimo> listaLivrosEmprestadosCorrentes) {
               this.listaLivrosEmprestadosCorrentes = listaLivrosEmprestadosCorrentes;
        }

        public ArrayList<TransacaoEmprestimo> getListaLivrosEmprestadosFinalizados() {
               return listaLivrosEmprestadosFinalizados;
        }

        public void setListaLivrosEmprestadosFinalizados(ArrayList<TransacaoEmprestimo> listaLivrosEmprestadosFinalizados) {
               this.listaLivrosEmprestadosFinalizados = listaLivrosEmprestadosFinalizados;
        }
        
        

        
        
        
        
        
        

}