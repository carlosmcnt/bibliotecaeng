package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlunoGraduacao extends Usuario {
        
        private int qtdEmprestimos = 0;
                
        public AlunoGraduacao(String codigo, String nome) {
                super(codigo, nome);
        }
        
        //Calcula o se o usuário passou da quantidade de livros adquiridos no empréstimo.
        @Override
        public boolean testeLimiteQtdEmprestimo() {
            
                if (getQtdEmprestimos() == 3){
                            System.out.println("Empréstimo não realizado: Usuário alcançou limite de empréstimos!");
                            return false;
                    }
            return true;
        }        
    
        //Calcula a data limite da devolução do livro, com base no tempo do tipo do usuário.
        //Utiliza a biblioteca Date/Calendar para calcular a diferença mais facilmente
        @Override
        public Date dataLimiteDevolucao(String dataEmprestimo){
  
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Calendar c = Calendar.getInstance();
                
                try{
                        c.setTime(sdf.parse(dataEmprestimo));
                }catch(ParseException e){
                        e.printStackTrace();
                }

                c.add(Calendar.DAY_OF_MONTH, 3); 
                return c.getTime();
        }
        
        //Calcula se o usuário está devendo um livro atualmente, com base na data limite estabelecida no empréstimo.
       //Utiliza a biblioteca Date/Calendar para calcular a diferença mais facilmente
        @Override
        public boolean testeUsuarioDevedor(String dataDia, String dataEmprestimo) {

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Calendar c = Calendar.getInstance();
                
                try{
                        c.setTime(sdf.parse(dataDia));
                }catch(ParseException e){
                        e.printStackTrace();
                }
                
                Date dataLimiteDevolução = dataLimiteDevolucao(dataEmprestimo);

                if (dataLimiteDevolução.compareTo(c.getTime()) < 0){
                        return true;
                }
                return false;
        }
    
        public int getQtdEmprestimos() {
                return qtdEmprestimos;
        }

        public void setQtdEmprestimos(int qtdEmprestimos) {
                this.qtdEmprestimos = qtdEmprestimos;
        } 
        
}