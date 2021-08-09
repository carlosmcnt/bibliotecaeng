package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

import java.util.ArrayList;

//Classe para guardar informações sobre dados e listas existentes no sistema.
public class DadosMemoria {
    
        private static  ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        private static  ArrayList<Livro> listaLivros = new ArrayList<Livro>();
        private static  ArrayList<Exemplar> listaExemplares = new ArrayList<Exemplar>();
        
        public void addUsuarios(Usuario usuario){
                listaUsuarios.add(usuario);
        }
        
        public void addLivros(Livro livro){
                listaLivros.add(livro);
        }
        
        public void addExemplar(Exemplar exemplar){
                listaExemplares.add(exemplar); 
        }

        public static ArrayList<Usuario> getListaUsuarios() {
                return listaUsuarios;
        }

        public static void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
                DadosMemoria.listaUsuarios = listaUsuarios;
        }

        public static ArrayList<Livro> getListaLivros() {
                return listaLivros;
        }

        public static void setListaLivros(ArrayList<Livro> listaLivros) {
                DadosMemoria.listaLivros = listaLivros;
        }

        public static ArrayList<Exemplar> getListaExemplares() {
                return listaExemplares;
        }

        public static void setListaExemplares(ArrayList<Exemplar> listaExemplares) {
                DadosMemoria.listaExemplares = listaExemplares;
        }
        
        //Carrega os dados de usuários, exemplares e livros
        public static void carregarDados(){
                Usuario usuario1 = new AlunoGraduacao("123", "João da Silva");
                Usuario usuario2 = new AlunoPosGraduacao("456", "Luiz Fernando Rodrigues");
                Usuario usuario3 = new AlunoGraduacao("789", "Pedro Paulo");
                Usuario usuario4 = new Professor ("100","Carlos Lucena");

                DadosMemoria dadosMemoria = new DadosMemoria();
                dadosMemoria.addUsuarios(usuario1);
                dadosMemoria.addUsuarios(usuario2);
                dadosMemoria.addUsuarios(usuario3);
                dadosMemoria.addUsuarios(usuario4);

                Livro livro1 = new Livro("100", "Engenharia de Software", "AddisonWesley", "Ian Sommervile", "6ª", 2000);
                Livro livro2 = new Livro("101", "UML – Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", "7ª", 2000);
                Livro livro3 = new Livro("200", "Code Complete", "Microsoft Press", "Steve McConnell", "2ª", 2014);
                Livro livro4 = new Livro("201", "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", "Robert Martin", "1ª", 2002);
                Livro livro5 = new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", "Martin Fowler", "1ª", 1999);
                Livro livro6 = new Livro("301", "Software Metrics: A Rigorous and Practical Approach", "CRC Press", "Norman Fenton, James Bieman", "3ª", 2014);
                Livro livro7 = new Livro("400", "Design Patterns:  Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional", "Norman Fenton, Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1ª", 1994);
                Livro livro8 = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professiona", "Martin Fowler", "3ª", 2003);

                Exemplar exemplar1 = new Exemplar ("100", "01", "disponível");
                Exemplar exemplar2 = new Exemplar ("100", "02", "disponível");
                Exemplar exemplar3 = new Exemplar ("101", "03", "disponível");
                Exemplar exemplar4 = new Exemplar ("200", "04", "disponível");
                Exemplar exemplar5 = new Exemplar ("201", "05", "disponível");
                Exemplar exemplar6 = new Exemplar ("300", "06", "disponível");
                Exemplar exemplar7 = new Exemplar ("300", "07", "disponível");
                Exemplar exemplar8 = new Exemplar ("400", "08", "disponível");
                Exemplar exemplar9 = new Exemplar ("400", "09", "disponível");

                dadosMemoria.addLivros(livro1);
                dadosMemoria.addLivros(livro2);
                dadosMemoria.addLivros(livro3);
                dadosMemoria.addLivros(livro4);
                dadosMemoria.addLivros(livro5);
                dadosMemoria.addLivros(livro6);
                dadosMemoria.addLivros(livro7);
                dadosMemoria.addLivros(livro8);

                dadosMemoria.addExemplar(exemplar1);
                dadosMemoria.addExemplar(exemplar2);
                dadosMemoria.addExemplar(exemplar3);
                dadosMemoria.addExemplar(exemplar4);
                dadosMemoria.addExemplar(exemplar5);
                dadosMemoria.addExemplar(exemplar6);
                dadosMemoria.addExemplar(exemplar7);
                dadosMemoria.addExemplar(exemplar8);
                dadosMemoria.addExemplar(exemplar9);
        }
        
        
}
