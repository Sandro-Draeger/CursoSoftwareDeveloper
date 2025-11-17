package ex02;


    public class Edificio {
        private String nome;
        private String rua;
        private String cidade;
        private String corFachada;
        private int numAndares;
        private boolean garagem;


        public Edificio(String nome, String rua, String cidade, String corFachada, int numAndares, boolean garagem) {
            this.nome = nome;
            this.rua = rua;
            this.cidade = cidade;
            this.corFachada = corFachada;
            this.numAndares = numAndares;
            this.garagem = garagem;

        }


        public void setCorFachada(){
            this.corFachada = corFachada;
        }
        public String getCorFachada(){
            return this.corFachada;
        }

        public String getNome(){
            return this.nome;
        }

        public String getRua(){
            return this.rua;
        }

        public String getCidade(){
            return this.cidade;
        }

        public int getNumAndares(){
            return this.numAndares;
        }

        public boolean getGaragem(){

            return this.garagem;
        }
    }

