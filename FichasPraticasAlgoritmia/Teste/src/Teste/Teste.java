package Teste;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // loja 1 - Produtos
        int[] codigo1 = {1, 2, 3, 4};
        String[] nome1 = {"agua", "chocolate", "pao", "sacola"};
        String[] categoria1 = {"bebida", "doce", "salgado", "utilitario"};
        double[] preco1 = {0.90, 2.80, 2.10, 1.50};
        int[] stock1 = {0, 0, 0, 0};
        double venda1Total = 0;

        // loja 2 - Produtos
        int[] codigo2 = {1, 2, 3, 4};
        String[] nome2 = {"agua", "chocolate", "pao", "sacola"};
        String[] categoria2 = {"bebida", "doce", "salgado", "utilitario"};
        double[] preco2 = {0.90, 2.80, 2.10, 1.50};
        int[] stock2 = {0, 0, 0, 0};
        double venda2Total = 0;


        // Usuário e senha de acesso Loja 1
        String usuario = "acessoLoja1";
        String senha = "1234";

        // Usuário e senha de acesso Loja 2
        String usuario2 = "acessoLoja2";
        String senha2 = "1234";

        int acessoLojas = 0;
        boolean continuar = true;
        boolean loja1 = false;

        //Acesso Login
        while (acessoLojas != 3 && continuar) {

            System.out.println("1 - Aceder a loja 1" + "\n" + "2 - Aceder a loja 2" + "\n" + "3 - Sair");
            acessoLojas = input.nextInt();

            switch (acessoLojas) {
                case 1: {
                    System.out.println("Introduza o seu usuário: ");
                    String usuarioCliente = input.next();

                    System.out.println("Introduza a senha: ");
                    String senhaCliente = input.next();

                    if (usuario.equals(usuarioCliente) && senha.equals(senhaCliente)) {
                        continuar = false;
                        loja1 = true;
                        System.out.println("Acesso à loja 1 permitido");
                    } else {
                        System.out.println("Tente novamente");
                    }
                    break;
                }

                case 2: {
                    System.out.println("Introduza o seu usuário: ");
                    String usuarioCliente2 = input.next();

                    System.out.println("Introduza a senha: ");
                    String senhaCliente2 = input.next();

                    if (usuario2.equals(usuarioCliente2) && senha2.equals(senhaCliente2)) {
                        continuar = false;
                        loja1 = false;
                        System.out.println("Acesso à loja 2 permitido");
                    } else {
                        System.out.println("Tente novamente");
                    }
                    break;
                }

                case 3:
                    return;
            }
        }

        // variaveis para menu 2
        int[] stockAtual;
        double[] precoAtual;
        String[] nomeAtual;
        String[] catAtual;

        // de acordo com sleção da loja
        if (loja1 = true) {
            stockAtual = stock1;
            precoAtual = preco1;
            nomeAtual = nome1;
            catAtual = categoria1;
        } else {
            stockAtual = stock2;
            precoAtual = preco2;
            nomeAtual = nome2;
            catAtual = categoria2;
        }

        // Menu produtos
        System.out.println("Selecione um produto: 1." + nomeAtual[0] + " 2." + nomeAtual[1] + " 3." + nomeAtual[2] + " 4." + nomeAtual[3]);
        int produto = input.nextInt();

        while (produto <= 3) {

            System.out.println("------------MENU------------");
            System.out.println("1. Consultar informações" + "\n" + "2. Adquirir" + "\n" + "3. Vender" + "\n" + "4. Transferir stock" + "\n" + "5. Simular venda total loja" + "\n" + "6. Simular venda total geral" + "\n" + "7. Loja com maior valor" + "\n" + "8. Logout");
            int num = input.nextInt();

            switch (num) {
                //descrição
                case 1:
                    System.out.println(codigo1[produto] + "\n" + nomeAtual[produto] + "\n" + precoAtual[produto] + "\n" + catAtual[produto] + "\n" + "Stock: " + stockAtual[produto]);
                    break;
                //Acrescentar stock
                case 2:
                    System.out.println("Insira quantidade para acrescentar no stock: ");
                    int add = input.nextInt();
                    stockAtual[produto] += add;
                    System.out.println("Stock atualizado: " + stockAtual[produto]);
                    break;
                //venda
                case 3:
                    System.out.println("Insira quantidade para venda: ");
                    int venda = input.nextInt();
                    if (stockAtual[produto] >= venda) {
                        stockAtual[produto] -= venda;
                        if (loja1) {
                            venda1Total += venda * precoAtual[produto];
                        } else venda2Total += venda * precoAtual[produto];
                        System.out.println("Venda realizada, seu stock restante é: " + stockAtual[produto]);
                    } else {
                        System.out.println("Stock insuficiente");
                    }
                    break;
                //tranferencia de itens de uma loja pra outra
                case 4:
                    System.out.println("Quantidade para transferir:");
                    int transferencia = input.nextInt();
                    if (loja1) {
                        if (stock1[produto] >= transferencia) {
                            stock1[produto] -= transferencia;
                            stock2[produto] += transferencia;
                            System.out.println("Transferido para loja 2");
                        } else System.out.println("Stock insuficiente");
                    } else {
                        if (stock2[produto] >= transferencia) {
                            stock2[produto] -= transferencia;
                            stock1[produto] += transferencia;
                            System.out.println("transferido para loja 1");
                        } else System.out.println("Stock insuficiente.");
                    }
                    break;
                //valor total da loja.
                case 5:
                    if (loja1 = true) {
                        System.out.println("Valor total loja: " + venda1Total);
                    } else {
                        System.out.println("Valor total loja: " + venda2Total);
                    }
                    break;

                case 6:
                    System.out.println("Venda total geral: " + (venda1Total + venda2Total));
                    break;
                //Comparação de tamanho
                case 7:
                    if (venda1Total > venda2Total) System.out.println("Loja 1 tem maior valor.");
                    else if (venda2Total > venda1Total) System.out.println("Loja 2 tem maior valor.");
                    else System.out.println("ambas tem o mesmo valor");
                    break;
                //finaliza o menu
                case 8:
                    break;
            }
        }
    }
}