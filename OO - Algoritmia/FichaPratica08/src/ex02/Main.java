package ex02;

public class Main {
    //instanciar
    public static void main(String[] args){
        Edificio edificio1 = new Edificio("CESAE", "rualTal", "Porto", "Vermelho", 5, true);
        System.out.println("Nome: " + edificio1.getNome() + "\nRua: " + edificio1.getRua() + "\nCidade: " + edificio1.getCidade() + "\nCor da Fachada: " + edificio1.getCorFachada() + "\nNumero de andares: " + edificio1.getNumAndares() + "\nGaragem: " + edificio1.isGaragem());

        edificio1.setCorFachada("Azul");

        System.out.println("Nome: " + edificio1.getNome() + "\nRua: " + edificio1.getRua() + "\nCidade: " + edificio1.getCidade() + "\nCor da Fachada: " + edificio1.getCorFachada() + "\nNumero de andares: " + edificio1.getNumAndares() + "\nGaragem: " + edificio1.isGaragem());
    }
}
