package ex09;

public class Funcionario {
    private String nome;
    private String email;
    private String departamento;
    private double salario;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Funcionario(String nome, String email, String departamento, double salario) {
        this.nome = nome;
        this.email = email;
        this.departamento = departamento;
        this.salario = salario;
    }
    public double aumentarSalario(double porcentagem){
        this.salario = (this.salario * (porcentagem /100)) + this.salario;
        return this.salario;
    }
}
