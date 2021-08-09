package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

import java.util.ArrayList;

public class Livro  {
    
        private String codigo;
        private String titulo;
        private String editora;
        private String autoria;
        private String edicao;
        private int anoPublicacao;
        
        private int qtdReservas = 0;
        
        ArrayList<Usuario> listaObservadores = new ArrayList<Usuario>(); //Lista para guardar observadores 

        public Livro(String codigo, String titulo, String editora, String autoria, String edicao, int anoPublicacao) {
                this.codigo = codigo;
                this.titulo = titulo;
                this.editora = editora;
                this.autoria = autoria;
                this.edicao = edicao;
                this.anoPublicacao = anoPublicacao;
            }

        public String getCodigo() {
                return codigo;
        }

        public int getQtdReservas() {
                return qtdReservas;
        }

        public void setQtdReservas(int qtdReservas) {
                this.qtdReservas = qtdReservas;
        }

        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }
        
        public ArrayList<Usuario> getObservador() {
                return listaObservadores;
        }

        public void setObservador(ArrayList<Usuario> observador) {
                this.listaObservadores = observador;
        }

}

