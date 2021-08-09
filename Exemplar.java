package trabalhoengsoft;

/**
 * @authoria Vanessa Machado & Carlos Neto
 * @version NetBeans IDE 8.2
 */

public class Exemplar {
        private String codExemplar;
        private String status;
        private String codLivro;
        
        public Exemplar(String codLivro, String codExemplar, String status) {
                this.codLivro = codLivro;
                this.codExemplar = codExemplar;
                this.status = status;
        }

        public String getCodExemplar() {
                return codExemplar;
        }

        public void setCodExemplar(String codExemplar) {
                this.codExemplar = codExemplar;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public String getCodLivro() {
                return codLivro;
        }

        public void setCodLivro(String codLivro) {
                this.codLivro = codLivro;
        }
        
}
