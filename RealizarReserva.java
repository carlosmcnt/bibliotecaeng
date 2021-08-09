package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

public class RealizarReserva implements Command {
        
        private String dataReserva;

        public String getDataReserva() {
            return dataReserva;
        }

        public void setDataReserva(String dataReserva) {
            this.dataReserva = dataReserva;
        }
        
        @Override
        public void executar(String par1, String par2) {
                String idUsuario = par1;
                String codLivro = par2;
                BibliotecaFachada.obterInstancia().realizarReserva(idUsuario, codLivro);
        }
    
}
