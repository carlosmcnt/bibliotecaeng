package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

public class SistemaBiblioteca {

    public static void main(String[] args) {
                        
            DadosMemoria.carregarDados();
            
            InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
            interfaceUsuario.loopEntrada(); 
            
    }
    
}
