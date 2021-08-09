package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Faz a ponte entre o padrão command e a parte de negócio
public class BibliotecaFachada implements IBibliotecaFachada {
        
        Scanner teclado = new Scanner(System.in);
                
        //Estabelece o padrão Singleton:
        private static BibliotecaFachada instancia;

        public BibliotecaFachada() {}
        
        public static BibliotecaFachada obterInstancia(){
                if(instancia == null){
                        instancia = new BibliotecaFachada();
                }
                return instancia;      
        }   
        
        //Operações do sistema:        
             
        
    @Override
        public void realizarEmprestimo(String idUsuario,String codLivro){
            
                int qtdExemplar = 0;    
                Usuario usuario = BuscaObjeto.buscarUsuario(idUsuario);                
                Livro livro = BuscaObjeto.buscarLivro(codLivro);
                Exemplar exemplar = BuscaObjeto.buscarExemplarEmprestimo(codLivro);
                TransacaoReserva transacaoReserva = BuscaObjeto.buscaTransacaoReserva(livro);
                qtdExemplar = Contador.qtdExemplar(codLivro);
                String dataHoje;
                boolean usuarioDevedor = false;
                boolean temLivroReservado = false;                
                boolean temLivroEmprestado = false;
                
                if (exemplar != null){ //Se exemplar está disponível no sistema
                        
                        System.out.println("Informe a data de hoje: ");
                        dataHoje = teclado.nextLine();
                        if (usuario.testeLimiteQtdEmprestimo() == true){ //Se o usuário não excedeu o limite de empréstimos        
                                if (livro.getQtdReservas() < qtdExemplar){ //Caso a quantidade de reservas seja menor que a quantidade de exemplares disponíveis
                                        if(!usuario.getListaLivrosReservados().isEmpty()){ //Caso o usuário possua reserva                                               
                                                        temLivroReservado = Validacao.livroReservado(usuario, livro);                                                        
                                                        if (temLivroReservado == false){ //Se não existe reserva do livro feita pelo usuário                                                              
                                                                if(!usuario.getListaLivrosEmprestadosCorrentes().isEmpty()){ //Se a lista de empréstimos do usuário não for vazia                                                                        
                                                                        usuarioDevedor = Validacao.usuarioDevedor(idUsuario, dataHoje);
                                                                        if(usuarioDevedor== false){ // Se usuário não for devedor
                                                                                temLivroEmprestado = Validacao.livroEmprestado(usuario, livro);                                                                                        
                                                                                if (temLivroEmprestado == false){ //Se usuário não possui empréstimo corrente deste livro                                                          
                                                                                        TransacaoEmprestimo.efetuarEmprestimo(dataHoje, exemplar, usuario, livro);
                                                                                        return;
                                                                                }
                                                                                else { //Se usuário já possui um exemplar do livro
                                                                                        System.out.println("Empréstimo não realizado: Usuário com empréstimo em curso de um exemplar deste livro!" + "\n");
                                                                                        return;
                                                                                }
                                                                                
                                                                        }
                                                                        else { //Se usuário estiver devendo algum livro
                                                                                System.out.println("Empréstimo não realizado: Usuário devedor!" + "\n");
                                                                                return;
                                                                        }
                                                                }
                                                                else{ //Se o usuário não possuir empréstimo
                                                                        TransacaoEmprestimo.efetuarEmprestimo(dataHoje, exemplar, usuario, livro);
                                                                        return;
                                                                }
                                                        }
                                                        else { //Se existe reserva para o livro feita pelo usuário
                                                            
                                                                usuario.listaLivrosReservados.remove(transacaoReserva); //Remove livro da lista de reservas do usuário                                                               
                                                                usuario.setQtdReservas(usuario.getQtdReservas()-1);                                                                
                                                                TransacaoReserva.retirarReserva(transacaoReserva); //Remove livro da lista de reservas do sistema
                                                                livro.setQtdReservas(livro.getQtdReservas()-1);
                                                                
                                                                if(!usuario.getListaLivrosEmprestadosCorrentes().isEmpty()){ //Se a lista de empréstimos do usuário não for vazia                                                                        
                                                                        usuarioDevedor = Validacao.usuarioDevedor(idUsuario, dataHoje);                                                                        
                                                                        if(usuarioDevedor== false){ //Se usuário não for devedor 
                                                                                temLivroEmprestado = Validacao.livroEmprestado(usuario, livro);                                                                                        
                                                                                if (temLivroEmprestado == false){ //Se o usuário não estiver com empréstimo corrente deste livro                                                                                        
                                                                                        TransacaoEmprestimo.efetuarEmprestimo(dataHoje, exemplar, usuario, livro);
                                                                                        return;
                                                                                }
                                                                                else { //Se está com empréstimo corrente deste livro                                                                                        
                                                                                        System.out.println("Empréstimo não realizado: Usuário com empréstimo em curso de um exemplar deste livro!" + "\n");
                                                                                        return;
                                                                                }
                                                                                
                                                                        }
                                                                        else { //Se usuário for devedor
                                                                                System.out.println("Empréstimo não realizado: Usuário devedor!" + "\n");
                                                                                return;
                                                                        }
                                                                }
                                                                else{ //Se o usuário não possuir empréstimo
                                                                        
                                                                        TransacaoEmprestimo.efetuarEmprestimo(dataHoje, exemplar, usuario, livro);  
                                                                        return;
                                                                } 
                                                        }
                                                
                                        }
                                        else { //Caso usuário não possua reserva
                                                if(!usuario.getListaLivrosEmprestadosCorrentes().isEmpty()){ //Se a lista de empréstimos do usuário não for vazia
                                                        usuarioDevedor = Validacao.usuarioDevedor(idUsuario, dataHoje);                                                             
                                                        if(usuarioDevedor== false){ //Se usuário não for devedor
                                                                temLivroEmprestado = Validacao.livroEmprestado(usuario, livro);                                                                                        
                                                                if (temLivroEmprestado == false){ //Se usuário não estiver com empréstimo corrente do livro                                                                         
                                                                        TransacaoEmprestimo.efetuarEmprestimo(dataHoje, exemplar, usuario, livro);
                                                                        return;
                                                                }
                                                                else { //Se está com empréstimo corrente deste livro
                                                                        System.out.println("Empréstimo não realizado: Usuário com empréstimo em curso de um exemplar deste livro!" + "\n");
                                                                        return;
                                                                }  
                                                        }
                                                        
                                                        else { //Se o usuário for devedor
                                                                System.out.println("Empréstimo não realizado: Usuário devedor!" + "\n");
                                                                return;
                                                        }
                                                }
                                                else{ //Se o usuário não possuir empréstimo
                                                        TransacaoEmprestimo.efetuarEmprestimo(dataHoje, exemplar, usuario, livro);
                                                        return;
                                                }
                                        }
                                }
                                else if (livro.getQtdReservas() >= qtdExemplar){ //
                                        if(!usuario.getListaLivrosReservados().isEmpty()){ //Caso o usuário possua reserva   
                                                temLivroReservado = Validacao.livroReservado(usuario, livro);                                                        
                                                        if (temLivroReservado == false){ //Se não existe reserva do livro feita pelo usuário 
                                                                if(!usuario.getListaLivrosEmprestadosCorrentes().isEmpty()){ //Se a lista de empréstimos do usuário não for vazia
                                                                        usuarioDevedor = Validacao.usuarioDevedor(idUsuario, dataHoje);                                                                  
                                                                        if(usuarioDevedor== false){ // Se usuário não for devedor
                                                                                temLivroEmprestado = Validacao.livroEmprestado(usuario, livro);                                                                                        
                                                                                        if (temLivroEmprestado == false){//Se o usuário não estiver com empréstimo corrente deste livro                                                                                        
                                                                                                TransacaoEmprestimo.efetuarEmprestimo(dataHoje, exemplar, usuario, livro);
                                                                                                return;
                                                                                        }
                                                                                        else { //Se está com empréstimo corrente deste livro
                                                                                                System.out.println("Empréstimo não realizado: Usuário com empréstimo em curso de um exemplar deste livro!" + "\n");
                                                                                                return;
                                                                                        }
                                                                                }
                                                                        }
                                                                        else { //Se usuário for devedor
                                                                                System.out.println("Empréstimo não realizado: Usuário devedor!" + "\n");
                                                                                return;
                                                                        }
                                                                        
                                                                }
                                                                else{ //Se o usuário não possuir empréstimo                                                                        
                                                                       TransacaoEmprestimo.efetuarEmprestimo(dataHoje, exemplar, usuario, livro);
                                                                       return;
                                                                }
                                                        }
                                                        else { //Se existe reserva para o livro 
                                                            
                                                                usuario.listaLivrosReservados.remove(transacaoReserva);                                                                
                                                                usuario.setQtdReservas(usuario.getQtdReservas()-1);                                                                
                                                                TransacaoReserva.retirarReserva(transacaoReserva);
                                                                livro.setQtdReservas(livro.getQtdReservas()-1);
                                                                
                                                                if(!usuario.getListaLivrosEmprestadosCorrentes().isEmpty()){ //Se a lista de empréstimos do usuário não for vazia
                                                                        boolean teste = Validacao.usuarioDevedor(idUsuario, dataHoje);                                                                    
                                                                        if(teste== false){ //Se usuário não for devedor 
                                                                                temLivroEmprestado = Validacao.livroEmprestado(usuario, livro);                                                                                        
                                                                                if (temLivroEmprestado == false){//Se o usuário não estiver com empréstimo corrente deste livro                                                                                        
                                                                                        TransacaoEmprestimo.efetuarEmprestimo(dataHoje, exemplar, usuario, livro);
                                                                                        return;
                                                                                }
                                                                                else{  //Se está com empréstimo corrente deste livro
                                                                                        System.out.println("Empréstimo não realizado: Usuário com empréstimo em curso de um exemplar deste livro!" + "\n");
                                                                                        return;
                                                                                }
                                                                        }
                                                                        
                                                                        else { //Se usuário for devedor
                                                                                System.out.println("Empréstimo não realizado: Usuário devedor!" + "\n");
                                                                                return;
                                                                        }
                                                                        
                                                                }
                                                                else{ //Se o usuário não possuir empréstimo                                                                        
                                                                        TransacaoEmprestimo.efetuarEmprestimo(dataHoje, exemplar, usuario, livro);
                                                                        return;
                                                                        
                                                                } 
                                                        }
                                                }
                                        }
                                        else {
                                                if(!usuario.getListaLivrosEmprestadosCorrentes().isEmpty()){ //Se a lista de empréstimos do usuário não for vazia
                                                        boolean teste = Validacao.usuarioDevedor(idUsuario, dataHoje);                                                             
                                                        if(teste== false){ //Se usuário não for devedor
                                                                temLivroEmprestado = Validacao.livroEmprestado(usuario, livro);                                                                                        
                                                                if (temLivroEmprestado == false){  //Se não existe reserva do livro feita pelo usuário                                                                       
                                                                        TransacaoEmprestimo.efetuarEmprestimo(dataHoje, exemplar, usuario, livro);
                                                                        return;
                                                                }
                                                                        
                                                                else { //Se está com empréstimo corrente deste livro                         
                                                                        System.out.println("Empréstimo não realizado: Usuário com empréstimo em curso de um exemplar deste livro!" + "\n");
                                                                        return;
                                                                  
                                                                }
                                                        }
                                                        
                                                        else { //Se usuário for devedor
                                                                System.out.println("Empréstimo não realizado: Usuário devedor!" + "\n");
                                                                return;
                                                        }
                                                        
                                                }
                                                else{ //Se o usuário não possuir empréstimo                                                     
                                                        TransacaoEmprestimo.efetuarEmprestimo(dataHoje, exemplar, usuario, livro);
                                                        return;
                                                }
                                        }
                                }
                                        
                        
                
                if (exemplar == null) { //Não existem exemplares disponíveis no momento
                        System.out.println("Empréstimo não realizado: Exemplar não disponível!");
                        return;
                }
        }
    
    @Override
        public void realizarDevolucao(String idUsuario,String codLivro){
                Usuario usuario = BuscaObjeto.buscarUsuario(idUsuario);
                boolean teste = false;
                for (int i = 0; i < usuario.getListaLivrosEmprestadosCorrentes().size(); i++){  
                        //testa se o usuário tem esse livro na lista de empréstimos
                        if (usuario.getListaLivrosEmprestadosCorrentes().get(i).exemplar.getCodLivro().equals(codLivro)){ 
                                String codExemplar = usuario.getListaLivrosEmprestadosCorrentes().get(i).exemplar.getCodExemplar();                                
                                
                                System.out.println("Informe a data de hoje: ");
                                String dataDevolucao = teclado.nextLine();
                                        
                                //Altera o status do exemplar em questão para disponível
                                for(int j=0; j < DadosMemoria.getListaExemplares().size(); j++){
                                        if(DadosMemoria.getListaExemplares().get(j).getCodExemplar().equals(codExemplar)){
                                                DadosMemoria.getListaExemplares().get(j).setStatus("disponível");
                                        }
                                } 
                                        
                                TransacaoEmprestimo.getListaTransacaoEmprestimo().get(i).setDataDevolucao(dataDevolucao); //Atualiza data de devolução
                                TransacaoEmprestimo.getListaTransacaoEmprestimo().get(i).setSituacaoEmprestimo("finalizado"); //Atualiza situação do empréstimo
                                        
                                TransacaoEmprestimo transacaoEmprestimo = TransacaoEmprestimo.getListaTransacaoEmprestimo().get(i);
                                TransacaoEmprestimo.adicionarEmprestimoFinalizado(transacaoEmprestimo); //Adciona a lista de empréstimos finalizados do sistema                                        
                                TransacaoEmprestimo.retirarEmprestimo(i); //Remove da lista de empréstimos correntes do sistema
                                
                                usuario.listaLivrosEmprestadosFinalizados.add(transacaoEmprestimo); //Adciona a lista de empréstimos finalizados do usuário
                                usuario.listaLivrosEmprestadosCorrentes.remove(i); //Remove da lista de empréstimos correntes do usuário
                                                
                                System.out.println("Devolução realizada com sucesso!");  
                                teste = true;   
                                return;
                             
                        }
                }
                
                if(teste == false) { 
                        System.out.println("Usuário não está com este livro emprestado!");
                }
                
        }
        
    @Override
        public void realizarReserva(String idUsuario, String codLivro){
                    
                    Livro livro = BuscaObjeto.buscarLivro(codLivro); //busca o livro desejado, através do seu código  
                    Usuario usuario = BuscaObjeto.buscarUsuario(idUsuario);  
                    
                                     
                    if (usuario.getQtdReservas()<3){ //Caso usuário possua menos de 3 reservas. estabelece a reserva                            
                            System.out.println("Digite a data de hoje: ");
                            String dataReserva = teclado.nextLine();                                            
                            System.out.println("Reserva Realizada!" + "\n");
                                            
                            livro.setQtdReservas(livro.getQtdReservas()+1);
                                            
                            TransacaoReserva.adicionarReserva(usuario, livro, dataReserva); //Guarda nome do usuário que reservou e o livro reservado por ele
                            TransacaoReserva transacaoReserva = BuscaObjeto.buscaTransacaoReserva(livro);
                            usuario.listaLivrosReservados.add(transacaoReserva);
                            usuario.setQtdReservas(usuario.getQtdReservas()+1);
                    }
                    else { //Usuário alcançou o limite máximo de reservas : 3
                            System.out.println("Reserva não pode ser realizada! Usuário excedeu número máximo permitido" + "\n");
                    }                         
            }
        
    @Override
        public void registrarObservador(String idUsuario, String codLivro){
            
                Livro livro = BuscaObjeto.buscarLivro(codLivro); //busca o livro desejado, através do seu código     
                int qtdReservaLivro = livro.getQtdReservas();
                if (qtdReservaLivro > 2){ //Caso o livro tenha mais de duas reservas simultâneas
                        for (int i = 0; i < DadosMemoria.getListaUsuarios().size(); i++) {
                                if(DadosMemoria.getListaUsuarios().get(i).getCodigo().equals(idUsuario)){ //Caso o usuário exista na lista
                                        Usuario usuario = DadosMemoria.getListaUsuarios().get(i);
                                        livro.listaObservadores.add(usuario);
                                        usuario.listaLivrosObservados.add(livro);
                                        System.out.println("Observador Registrado!" + "\n");
                                }
                        }
                }
                else { //Caso o livro tenha duas ou menos de duas reservas simultâneas
                        System.out.println("Observador não pode ser registrado! Livro tem: " +  qtdReservaLivro + " reservas. Só pode se registrar caso livro tenha mais de 2 reservas." + "\n");
                }
        }
        
        
    @Override
        public void consultarLivro(String codLivro){        
            
                Livro livro = BuscaObjeto.buscarLivro(codLivro); 
                int qtdReservaLivro = livro.getQtdReservas();
                
                System.out.println("\nTítulo do livro: " + livro.getTitulo() + "\nQuantidade de reservas: " + livro.getQtdReservas());
         
                if(qtdReservaLivro != 0){ //Caso possuam reservas do determinado livro                    
                        for (int i=0; i<TransacaoReserva.getListaTransacaoReserva().size();i++){                                      
                                if(TransacaoReserva.getListaTransacaoReserva().get(i).getLivro().getCodigo().equals(codLivro)){ //Procura pelo livro reservado                                    
                                        System.out.println("Reservado por: " + TransacaoReserva.getListaTransacaoReserva().get(i).usuario.getNome());
                                } 
                        }     
                }
                
                System.out.println("\nExemplares:");
                boolean teste = false;
                for(int i=0; i<DadosMemoria.getListaExemplares().size();i++){
                        if(DadosMemoria.getListaExemplares().get(i).getCodLivro().equals(codLivro)){ //Procura os exemplares de cada livro
                                System.out.println("Código Exemplar: " + DadosMemoria.getListaExemplares().get(i).getCodExemplar() + "\nStatus: " + DadosMemoria.getListaExemplares().get(i).getStatus());                                
                                for (int j=0; j<TransacaoEmprestimo.getListaTransacaoEmprestimo().size();j++){
                                        if(TransacaoEmprestimo.getListaTransacaoEmprestimo().get(j).exemplar.getCodExemplar().equals(DadosMemoria.getListaExemplares().get(i).getCodExemplar())){ 
                                                System.out.println("Emprestado para: " + TransacaoEmprestimo.getListaTransacaoEmprestimo().get(j).usuario.getNome()
                                                + "\nData de Empréstimo: " + TransacaoEmprestimo.getListaTransacaoEmprestimo().get(j).getDataEmprestimo() +
                                                "\nData de Devolução: " + TransacaoEmprestimo.getListaTransacaoEmprestimo().get(j).getDataDevolucao() + "\n");
                                        }
                                }                                
                        }
                }   
        }
       
    @Override
        public void consultarUsuario(String idUsuario){
                boolean teste1 = false;
                boolean teste2 = false;
                boolean teste3 = false;
                Usuario usuario = BuscaObjeto.buscarUsuario(idUsuario);                 
                System.out.println("\n#Lista de Empréstimos Correntes#");
                for(int i=0; i < usuario.getListaLivrosEmprestadosCorrentes().size(); i++){
                        
                                String codLivro = usuario.getListaLivrosEmprestadosCorrentes().get(i).exemplar.getCodLivro();
                                Livro livro = BuscaObjeto.buscarLivro(codLivro);
                                System.out.println("Título do livro: " + livro.getTitulo() + "\nData de Empréstimo: " + usuario.getListaLivrosEmprestadosCorrentes().get(i).getDataEmprestimo() 
                                + "\nSituação atual: " + usuario.getListaLivrosEmprestadosCorrentes().get(i).getSituacaoEmprestimo() + "\nData de Devolução: " 
                                + usuario.getListaLivrosEmprestadosCorrentes().get(i).getDataDevolucao() + "\n");
                                teste1 = true;
                        
                }
                if(teste1 == false ){ //Caso o usuário não tenha nenhum empréstimo corrente
                        System.out.println("Usuário não possui empréstimos correntes" + "\n");
                }
                System.out.println("\n#Lista de Empréstimos Finalizados#");
                for(int i=0; i < usuario.getListaLivrosEmprestadosFinalizados().size(); i++){
                        
                                String codLivro = usuario.getListaLivrosEmprestadosFinalizados().get(i).exemplar.getCodLivro();
                                Livro livro = BuscaObjeto.buscarLivro(codLivro);
                                System.out.println("Título do livro: " + livro.getTitulo() + "\nData de Empréstimo: " + usuario.getListaLivrosEmprestadosFinalizados().get(i).getDataEmprestimo() 
                                + "\nSituação atual: " + usuario.getListaLivrosEmprestadosFinalizados().get(i).getSituacaoEmprestimo() + "\nData de Devolução: " 
                                + usuario.getListaLivrosEmprestadosFinalizados().get(i).getDataDevolucao() + "\n");
                                teste2 = true;
                        
                }
                
                if(teste2 == false ){ //Caso o usuário não tenha nenhum empréstimo finalizado
                        System.out.println("Usuário não possui empréstimos finalizados" + "\n");
                }
                
                System.out.println("#Lista de reservas#");
                for (int i=0; i < usuario.getListaLivrosReservados().size();i++){
                        if(usuario.getListaLivrosReservados().get(i).usuario.getCodigo().equals(idUsuario)){
                                System.out.println("Título do livro: " + usuario.getListaLivrosReservados().get(i).livro.getTitulo()
                                + "\nData de solicitação da reserva: " + usuario.getListaLivrosReservados().get(i).getDataReserva() + "\n");
                                teste3 = true;
                        }                    
                }
                if(teste3 == false ){ //Caso o usuário não possua reservas 
                        System.out.println("Usuário não possui reservas" + "\n");
                }                     
                
        }
        
    @Override
        public void consultarNotificacaoProfessor(String idUsuario){
                Usuario usuario = BuscaObjeto.buscarUsuario(idUsuario);
                String codLivro = null;
                if(usuario.listaLivrosObservados.isEmpty()){
                        System.out.println("Usuário não é um observador"+ "\n");
                        return;
                }
                for (int i = 0; i < usuario.getListaLivrosObservados().size(); i++) { 
                        codLivro = usuario.getListaLivrosObservados().get(i).getCodigo() ;
                        System.out.println("Código do livro observado: " + codLivro);
                        usuario.setQtdNotificacao(Contador.qtdNotificacaoProfessor(idUsuario,codLivro));
                        
                }
                System.out.println("O professor foi notificado: " + usuario.getQtdNotificacao() + " vez(es);" + "\n");
        }

}