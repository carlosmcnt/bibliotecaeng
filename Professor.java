package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Professor extends Usuario {

        public Professor(String codigo, String nome) {
                super(codigo, nome);
        }
        
        @Override
        public boolean testeLimiteQtdEmprestimo() { //Professor não tem limite de empréstimos
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

            c.add(Calendar.DAY_OF_MONTH, 7); 
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

}
