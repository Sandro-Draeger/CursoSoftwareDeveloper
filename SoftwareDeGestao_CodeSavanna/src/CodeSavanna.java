import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class CodeSavanna {

    //********** MENUS ***********

    public static void login(String[][] matrizAnimais, String[][] matrizClientes, String[][] matrizInteracoes) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n🐒🦒🐧 Login SavannaCode 🐒🦒🐧");
            System.out.println("\n1. Admin");
            System.out.println("2. Cliente");
            System.out.println("3. Sair");
            System.out.print("\nOpção: ");


            opcao = input.nextInt();


            //Definição de login e senha:
            String userNameDefinido = "ADMIN";
            String senhaDefinida = "!password?456";

            switch (opcao) {
                case 1:
                    System.out.println("Username: ");
                    String userName = input.next();

                    System.out.println("Senha: ");
                    String senha = input.next();

                    if (userName.equals(userNameDefinido) && senha.equals(senhaDefinida)) {
                        menuAdministrador(matrizAnimais, matrizClientes, matrizInteracoes);
                    } else {
                        System.out.println("❌ Usuário ou senha inválidos!");
                    }
                    break;

                case 2:
                    menuCliente(matrizAnimais, matrizClientes, matrizInteracoes);
                    break;

                case 3:
                    System.out.println("👋 Até a próxima!");
                    break;

                default:
                    System.out.println("❌ Opção inválida!");
                    break;
            }

        } while (opcao != 3);

    }

    public static void menuAdministrador(String[][] matrizAnimais, String[][] matrizClientes, String[][] matrizInteracoes) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n🐒🦒🐧 MENU ADMIN CODE SAVANNA 🐒🦒🐧\n");
            System.out.println("1 - Listar conteúdo dos ficheiros");
            System.out.println("2 - Estatísticas gerais de interações");
            System.out.println("3 - Receita total por tipo de interação");
            System.out.println("4 - Animal mais popular");
            System.out.println("5 - Top 3 espécies com mais apadrinhamentos");
            System.out.println("6 - Listar padrinhos de um animal");
            System.out.println("7 - Espetáculo mais rentável");
            System.out.println("8 - Ranking de animais em perigo de extinção");
            System.out.println("9 - Estatísticas por habitat");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    menuFicheiros(matrizAnimais, matrizClientes, matrizInteracoes);
                    break;
                case 2:
                    impressaoInteracoes(matrizInteracoes);
                    break;
                case 3:
                    impressaoReceitaInteracoes(matrizInteracoes);
                    break;
                case 4:
                    animalMaiorInteracao(matrizInteracoes, matrizAnimais);
                    break;
                case 5:
                    animalTop3Interacao(matrizInteracoes, matrizAnimais);
                    break;
                case 6:
                    listarApadrinhamentosAnimal(matrizAnimais, matrizClientes, matrizInteracoes);
                    break;
                case 7:
                    espetaculoMaisRentavel(matrizInteracoes, matrizAnimais);
                    break;
                case 8:
                    animaisPerigoExtincao(matrizInteracoes, matrizAnimais);
                    break;
                case 9:
                    estatisticasPorHabitat(matrizAnimais, matrizInteracoes);
                    break;
                case 0:
                    System.out.println("👋 Até a próxima!");
                    break;
                default:
                    System.out.println("❌ Opção inválida!");
            }

        } while (opcao != 0);
    }

    public static void menuCliente(String[][] matrizAnimais, String[][] matrizClientes, String[][] matrizInteracoes) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n🐒🦒🐧 MENU CLIENTE CODE SAVANNA 🐒🦒🐧");
            System.out.println("\n1 - Ver catálogo de animais por habitat");
            System.out.println("2 - Ver atividades de um animal (espetáculos e alimentações)");
            System.out.println("3 - Simular apadrinhamento de um animal");
            System.out.println("4 - Jogo: adivinha a espécie");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    verCatalogoPorHabitat(matrizAnimais);
                    break;
                case 2:
                    atividadesAnimal(matrizAnimais, matrizInteracoes);
                    break;
                case 3:
                    simuladorApadrinhamento(matrizAnimais);
                    break;
                case 4:
                    jogoAdvinha(matrizAnimais);
                    break;
                case 0:
                    System.out.println("👋 Até a próxima!");
                    break;
                default:
                    System.out.println("❌ Opção inválida!");
            }

        } while (opcao != 0);

    }

    public static void menuFicheiros(String[][] matrizAnimais, String[][] matrizClientes, String[][] matrizInteracoes) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nEscolha sua opção: \n");
            System.out.println("1. Animais 🐒");
            System.out.println("2. Clientes \uD83E\uDDD1");
            System.out.println("3. Interações \u200D\uD83D\uDCBB");
            System.out.println("4. Sair");


            opcao = input.nextInt();


            switch (opcao) {
                case 1:
                    System.out.println("\n🐒 Animais 🐒\n");
                    lerFicheiro("ficheiros/animais.csv");
                    break;
                case 2:
                    System.out.println("\n\uD83E\uDDD1 clientes \uD83E\uDDD1\n");
                    lerFicheiro("ficheiros/clientes.csv");
                    break;

                case 3:
                    System.out.println("\n\u200D\uD83D\uDCBB Interações \u200D\uD83D\uDCBB\n");
                    lerFicheiro("ficheiros/interacoes.csv");
                    break;

                case 4: //SAIR
                    break;

                default:
                    System.out.println("❌ Opção inválida!");
                    break;
            }

        } while (opcao != 4);
    }


    //************* FICHEIROS ***********

    public static void lerFicheiro(String caminho) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
        }
        sc.close();
    }

    public static String[][] ficheiroParaMatriz(String caminho) throws FileNotFoundException {

        int linhas = contarLinhasFicheiro(caminho);
        int colunas = contarColunasFicheiro(caminho);

        String[][] matriz = new String[linhas][colunas];

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int linhaAtual = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] valores = linha.split(";");

            for (int col = 0; col < valores.length; col++) {
                matriz[linhaAtual][col] = valores[col];
            }
            linhaAtual++;
        }
        return matriz;
    }

    public static int contarLinhasFicheiro(String caminho) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int contadorLinhas = 0;

        while (sc.hasNextLine()) {
            contadorLinhas++;
            sc.nextLine();
        }

        sc.close();
        return contadorLinhas;
    }

    public static int contarColunasFicheiro(String caminho) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int contadorColunas = 0;

        if (sc.hasNextLine()) {
            String linha = sc.nextLine();
            contadorColunas = linha.split(";").length;
        }

        sc.close();
        return contadorColunas;
    }


    //*********** ITENS ADMIN ************

    //ITEM 1
    public static int contagemInteracoes(String[][] matrizInteracoes, String interacaoesElemento) {

        int contagem = 0;

        for (int linha = 0; linha < matrizInteracoes.length; linha++) {

            if (matrizInteracoes[linha][2].equals(interacaoesElemento)) {
                contagem++;
            }
        }
        return contagem;
    }

    public static int contagemInteracoesAnimal(String[][] matrizInteracoes, String idAnimal) {
        int contagem = 0;

        for (int linha = 0; linha < matrizInteracoes.length; linha++) {

            if (matrizInteracoes[linha][3].equals(idAnimal)) {
                contagem++;
            }
        }
        return contagem;
    }

    //ITEM 2
    public static void impressaoInteracoes(String[][] matrizInteracoes) {
        int contagemVisitas = contagemInteracoes(matrizInteracoes, "VISITA");
        int contagemEspetaculo = contagemInteracoes(matrizInteracoes, "ESPETACULO");
        int contagemAlimentacao = contagemInteracoes(matrizInteracoes, "ALIMENTACAO");
        int contagemApadrinhamento = contagemInteracoes(matrizInteracoes, "APADRINHAMENTO");

        int contagemTotal = contagemVisitas + contagemEspetaculo + contagemAlimentacao + contagemApadrinhamento;

        System.out.println("\n\uD83E\uDD92\uD83E\uDD92\uD83E\uDD92\uD83E\uDD92\uD83E\uDD92\uD83E\uDD92\uD83E\uDD92\uD83E\uDD92\n");
        System.out.println("Total de Interações: " + contagemTotal);
        System.out.println("VISITA: " + contagemVisitas);
        System.out.println("ESPETACULO: " + contagemEspetaculo);
        System.out.println("ALIMENTAÇÃO: " + contagemAlimentacao);
        System.out.println("APADRINHAMENTO: " + contagemApadrinhamento);
        System.out.println("\n\uD83E\uDD92\uD83E\uDD92\uD83E\uDD92\uD83E\uDD92\uD83E\uDD92\uD83E\uDD92\uD83E\uDD92\uD83E\uDD92");
    }

    //ITEM 3
    public static double receitaInteracoes(String[][] matrizInteracoes, String interacaoesElemento) {
        int contagem = 0;
        double coluna = 0.0;
        double valorTotal = 0.0;

        for (int linha = 0; linha < matrizInteracoes.length; linha++)
            if (matrizInteracoes[linha][2].equals(interacaoesElemento)) {
                contagem++;

                coluna = Double.parseDouble(matrizInteracoes[linha][5]);


                valorTotal = valorTotal + coluna;
            }


        return valorTotal;
    }

    public static double receitaInteracoesAnimalApadrinhamento(String[][] matrizInteracoes, String idAnimal) {

        int contagem = 0;
        double coluna = 0.0;
        double valorTotal = 0.0;

        for (int linha = 0; linha < matrizInteracoes.length; linha++)
            if (matrizInteracoes[linha][2].equals("APADRINHAMENTO") && matrizInteracoes[linha][3].equals(idAnimal)) {
                contagem++;

                coluna = Double.parseDouble(matrizInteracoes[linha][5]);


                valorTotal = valorTotal + coluna;
            }


        return valorTotal;
    }

    public static double receitaTotalAnimal(String[][] matrizInteracoes, String idAnimal) {

        double valor = 0.0;
        double valorTotal = 0.0;

        for (int linha = 0; linha < matrizInteracoes.length; linha++)
            if (matrizInteracoes[linha][3].equals(idAnimal)) {


                valor = Double.parseDouble(matrizInteracoes[linha][5]);


                valorTotal = valorTotal + valor;
            }


        return valorTotal;
    }

    public static void impressaoReceitaInteracoes(String[][] matrizInteracoes) {
        double receitaVisitas = receitaInteracoes(matrizInteracoes, "VISITA");
        double receitaEspetaculo = receitaInteracoes(matrizInteracoes, "ESPETACULO");
        double receitaAlimentacao = receitaInteracoes(matrizInteracoes, "ALIMENTACAO");
        double receitaApadrinhamento = receitaInteracoes(matrizInteracoes, "APADRINHAMENTO");

        double contagemTotal = receitaVisitas + receitaEspetaculo + receitaAlimentacao + receitaApadrinhamento;

        System.out.println("\n\uD83D\uDCB8\uD83D\uDCB8\uD83D\uDCB8\uD83D\uDCB8\uD83D\uDCB8\uD83D\uDCB8\uD83D\uDCB8\uD83D\uDCB8\n");
        System.out.println("Receita total: " + contagemTotal);
        System.out.println("VISITA: " + receitaVisitas);
        System.out.println("ESPETACULO: " + receitaEspetaculo);
        System.out.println("ALIMENTAÇÃO: " + receitaAlimentacao);
        System.out.println("APADRINHAMENTO: " + receitaApadrinhamento);
        System.out.println("\n\uD83D\uDCB8\uD83D\uDCB8\uD83D\uDCB8\uD83D\uDCB8\uD83D\uDCB8\uD83D\uDCB8\uD83D\uDCB8\uD83D\uDCB8\n");


    }

    //ITEM 4
    public static void animalMaiorInteracao(String[][] matrizInteracoes, String[][] matrizAnimais) {

        int maiorInteracao = 0;
        String animalMaiorInteracao = "";

        for (int i = 0; i < matrizInteracoes.length; i++) {
            String idAtual = matrizInteracoes[i][3];
            int numInteracao = 0;
            for (int j = 0; j < matrizInteracoes.length; j++) {
                if (matrizInteracoes[j][3].equals(idAtual)) {
                    numInteracao++;
                }
            }
            //achar o maior
            if (numInteracao > maiorInteracao) {
                maiorInteracao = numInteracao;
                animalMaiorInteracao = idAtual;
            }
        }
        //usando minha função para receber as infos dos animais e atribuir cada valor a uma variavel
        String[] animalInfo = animalInfo(matrizAnimais, animalMaiorInteracao);
        String nomeAnimal = animalInfo[1];
        String especieAnimal = animalInfo[2];
        String habitatAnimal = animalInfo[3];

        System.out.println("\n***** Animal com maior número de interações! *****\n");
        System.out.println("Nome: " + nomeAnimal);
        System.out.println("Espécie: " + especieAnimal);
        System.out.println("Habitat: " + habitatAnimal);
        System.out.println("Total interações: " + maiorInteracao);

    }

    //ITEM 5
    public static void animalTop3Interacao(String[][] matrizInteracoes, String[][] matrizAnimais) {

        int top1Interacao = 0;
        int top2Interacao = 0;
        int top3Interacao = 0;
        String animalTop1 = "";
        String animalTop2 = "";
        String animalTop3 = "";

        for (int i = 0; i < matrizInteracoes.length; i++) {
            String idAtual = matrizInteracoes[i][3];
            int numInteracao = 0;
            for (int j = 0; j < matrizInteracoes.length; j++) {
                if (matrizInteracoes[j][3].equals(idAtual) && matrizInteracoes[j][2].equals("APADRINHAMENTO")) {
                    numInteracao++;
                }
            }
            //verificação para encontrar o top3
            // se o numero for maior que o 3, menor que o 2 e menor que o 1
            if ((numInteracao > top3Interacao) && (numInteracao < top2Interacao) && (numInteracao < top1Interacao)) {
                top3Interacao = numInteracao;
                animalTop3 = idAtual;
                // se o numero for maior que o 3, maior que o 2 e menor que o 1
            } else if ((numInteracao > top3Interacao) && (numInteracao > top2Interacao) && (numInteracao < top1Interacao)) {
                top2Interacao = numInteracao;
                animalTop2 = idAtual;
                // se o numero for maior o 1
            } else if (numInteracao > top1Interacao) {
                top1Interacao = numInteracao;
                animalTop1 = idAtual;
            }
        }

        //receitas totais usando minha função de calcular receita por ID
        double receitaTop1 = receitaInteracoesAnimalApadrinhamento(matrizInteracoes, animalTop1);
        double receitaTop2 = receitaInteracoesAnimalApadrinhamento(matrizInteracoes, animalTop2);
        double receitaTop3 = receitaInteracoesAnimalApadrinhamento(matrizInteracoes, animalTop3);


        //usando minha função para receber as infos dos animais e atribuir cada valor a uma variavel
        String[] animalInfo1 = animalInfo(matrizAnimais, animalTop1);
        String[] animalInfo2 = animalInfo(matrizAnimais, animalTop2);
        String[] animalInfo3 = animalInfo(matrizAnimais, animalTop3);
        String especieAnimal1 = animalInfo1[2];
        String especieAnimal2 = animalInfo2[2];
        String especieAnimal3 = animalInfo3[2];

        System.out.println("\n***** Top 3 espécies mais apadrinhadas: *****\n");
        System.out.println("1)" + especieAnimal1);
        System.out.println("Numero Apadrinhamento: " + top1Interacao);
        System.out.println("Valor mensal total: " + receitaTop1 + "€");
        System.out.println("\n2)" + especieAnimal2);
        System.out.println("Numero Apadrinhamento: " + top2Interacao);
        System.out.println("Valor mensal total: " + receitaTop2 + "€");
        System.out.println("\n3)" + especieAnimal3);
        System.out.println("Numero Apadrinhamento: " + top3Interacao);
        System.out.println("Valor mensal total: " + receitaTop3 + "€");

    }

    public static String[] encontrarAnimalID(String[][] matrizAnimais) {
        Scanner input = new Scanner(System.in);
        String[] animal = new String[6];
        boolean animalEncontrado = false;
        String opcaoDigitada = "";

        System.out.println("\nIntroduza o ID do animal (ex: A03): ");
        System.out.println("0 - Para voltar ao menu.\n");
        opcaoDigitada = input.next();

        while (!opcaoDigitada.equals("0") || animalEncontrado) {

            for (int linha = 0; linha < matrizAnimais.length; linha++) {
                if (matrizAnimais[linha][0].equals(opcaoDigitada)) {
                    animalEncontrado = true;

                    animal[0] = matrizAnimais[linha][0];
                    animal[1] = matrizAnimais[linha][1];
                    animal[2] = matrizAnimais[linha][2];
                    animal[3] = matrizAnimais[linha][3];
                    animal[4] = matrizAnimais[linha][4];
                    animal[5] = matrizAnimais[linha][5];

                    break; // encontro o valor e posso sair do looping
                }
            }

            if (animalEncontrado) {
                break;
            } else {
                System.out.println("Animal nao encontrado!");
                System.out.println("\nIntroduza o ID do animal (ex: A03): ");
                System.out.println("0 - Para voltar ao menu.\n");
                opcaoDigitada = input.next();
            }
        }

        return animal;
    }

    public static String[] animalInfo(String[][] matrizAnimais, String animalID) {
        String[] animal = new String[6];

        for (int linha = 0; linha < matrizAnimais.length; linha++) {
            if (matrizAnimais[linha][0].equals(animalID)) {

                animal[0] = matrizAnimais[linha][0];
                animal[1] = matrizAnimais[linha][1];
                animal[2] = matrizAnimais[linha][2];
                animal[3] = matrizAnimais[linha][3];
                animal[4] = matrizAnimais[linha][4];
                animal[5] = matrizAnimais[linha][5];

                break;
            }
        }

        return animal;
    }

    //ITEM 6
    public static void listarApadrinhamentosAnimal(String[][] matrizAnimais, String[][] matrizClientes, String[][] matrizInteracoes) {
        String[] animal = encontrarAnimalID(matrizAnimais);

        // percorrer minha lista usando a função anterior para achar todos que são APADRINHAMENTO
        for (int i = 0; i < matrizInteracoes.length; i++) {
            if (matrizInteracoes[i][2].equals("APADRINHAMENTO") && matrizInteracoes[i][3].equals(animal[0])) {
                //adicionar as variaveis que serão impressao e atribuir o valor correposndente da Matriz
                String idCliente = matrizInteracoes[i][1];
                String valorPago = matrizInteracoes[i][5];
                String nomeEvento = matrizInteracoes[i][4];

                //segundo for para buscar os dados correspondentes da matriz clientes
                for (int j = 0; j < matrizClientes.length; j++) {
                    if (matrizClientes[j][0].equals(idCliente)) {
                        String nomeCliente = matrizClientes[j][1];
                        String emailCliente = matrizClientes[j][3];

                        System.out.println("\nNome: " + nomeCliente);
                        System.out.println("Email: " + emailCliente);
                        System.out.println("Valor mensal: " + valorPago);
                        System.out.println("Plano: " + nomeEvento);
                    }
                }
            }
        }
    }

    //ITEM 7
    public static void espetaculoMaisRentavel(String[][] matrizInteracoes, String[][] matrizAnimais) {
        double espetaculoMaisRentavel = 0;
        String[] animal = new String[6];
        String nomeEvento = "";

        for (int i = 0; i < matrizInteracoes.length; i++) {
            String nomeEventoAtual = matrizInteracoes[i][4];
            double valorTotal = 0;
            String idAnimal = matrizInteracoes[i][3];


            for (int j = 0; j < matrizInteracoes.length; j++) {
                if (matrizInteracoes[j][4].equals(nomeEventoAtual) && matrizInteracoes[j][2].equals("ESPETACULO")) {

                    double valorEspetaculo = Double.parseDouble(matrizInteracoes[j][5]);

                    valorTotal = valorTotal + valorEspetaculo;
                }
            }
            //achar o espetaculo mais rentavel
            if (valorTotal > espetaculoMaisRentavel) {
                espetaculoMaisRentavel = valorTotal;
                animal = animalInfo(matrizAnimais, idAnimal);
                nomeEvento = nomeEventoAtual;
            }
        }

        String animalNome = animal[1];
        String animalEspecie = animal[2];

        System.out.println("\n***** Espetáculo mais rentável: *****\n");
        System.out.println("Espetáculo: " + nomeEvento);
        System.out.println("Receita total: " + espetaculoMaisRentavel + "€");
        System.out.println("Animal principal: " + animalNome + " " + animalEspecie);
    }

    //ITEM 8
    public static void animaisPerigoExtincao(String[][] matrizInteracoes, String[][] matrizAnimais) {
        String idAnimal;
        double valorTotal = 0.0;
        int interacoesAssociadas = 0;
        String nomeAnimal = "";
        String especieAnimal = "";

        System.out.println("\n****** Animais em perigo de Extinção: ******");

        for (int i = 0; i < matrizAnimais.length; i++) {
            if (matrizAnimais[i][5].equals("SIM")) {
                idAnimal = matrizAnimais[i][0];
                nomeAnimal = matrizAnimais[i][1];
                especieAnimal = matrizAnimais[i][2];

                valorTotal = receitaTotalAnimal(matrizInteracoes, idAnimal);
                interacoesAssociadas = contagemInteracoesAnimal(matrizInteracoes, idAnimal);

                System.out.println("\nAnimal: " + nomeAnimal + " " + especieAnimal);
                System.out.println("Total de interações: " + interacoesAssociadas);
                System.out.println("Total de dinheiro associado: " + valorTotal);

                //Não consegui fazer a parte de ordenação por animal com maior valor associado.
            }
        }
    }

    //ITEM 9
    public static String[] habitatsUnicos(String[][] matrizAnimais) {

        String[] arrayHabitatsTotal = new String[matrizAnimais.length];
        int indexDisponivel = 0;

        // Este ciclo itera para cada animal da matriz
        for (int linhaAnimais = 0; linhaAnimais < matrizAnimais.length; linhaAnimais++) {

            boolean encontrei = false;

            // matrizAnimais[linhaAnimais][3] é o habitat do animal atual

            // Este ciclo itera para cada habitat do meu array sem duplicados
            for (int habitatAtual = 0; habitatAtual < arrayHabitatsTotal.length; habitatAtual++) {
                if (matrizAnimais[linhaAnimais][3].equals(arrayHabitatsTotal[habitatAtual])) {
                    encontrei = true;
                }
            }

            if (!encontrei) { // encontrei == false
                arrayHabitatsTotal[indexDisponivel] = matrizAnimais[linhaAnimais][3];
                indexDisponivel++;
            }

        }

        int quantidadeDeHabitats = indexDisponivel;

        // Limpeza - colocar o array à medida
        String[] arrayHabitatsMedida = new String[quantidadeDeHabitats];

        for (int i = 0; i < arrayHabitatsMedida.length; i++) {
            arrayHabitatsMedida[i] = arrayHabitatsTotal[i];
        }

        return arrayHabitatsMedida;

    }

    public static int numeroAnimaisHabitat(String[][] matrizAnimais, String habitat) {

        int contagemAnimais = 0;

        for (int linha = 0; linha < matrizAnimais.length; linha++) {
            if (matrizAnimais[linha][3].equals(habitat)) {
                contagemAnimais++;
            }
        }
        return contagemAnimais;
    }

    public static String[] animaisDeUmHabitat(String[][] matrizAnimais, String habitat) {
        String[] animaisDoHabitat = new String[matrizAnimais.length];
        int indexDisponivel = 0;

        for (int linhaAnimal = 0; linhaAnimal < matrizAnimais.length; linhaAnimal++) {
            if (matrizAnimais[linhaAnimal][3].equals(habitat)) {
                // Encontramos um animal deste Habitat
                animaisDoHabitat[indexDisponivel] = matrizAnimais[linhaAnimal][0];
                indexDisponivel++;
            }
        }

        int quantidadeAnimais = indexDisponivel;

        String[] animaisDoHabitatMedida = new String[quantidadeAnimais];

        for (int i = 0; i < animaisDoHabitatMedida.length; i++) {
            animaisDoHabitatMedida[i] = animaisDoHabitat[i];
        }

        return animaisDoHabitatMedida;
    }

    public static int interacoesAnimal(String[][] matrizInteracoes, String idAnimal) {
        int contagemInteracoes = 0;

        for (int linhaInteracao = 0; linhaInteracao < matrizInteracoes.length; linhaInteracao++) {

            if (matrizInteracoes[linhaInteracao][3].equals(idAnimal)) {
                // Contar a interação
                contagemInteracoes++;
            }
        }
        return contagemInteracoes;
    }

    public static double rendimentosAnimal(String[][] matrizInteracoes, String idAnimal) {
        double rendimentoTotal = 0;

        for (int linhaInteracao = 1; linhaInteracao < matrizInteracoes.length; linhaInteracao++) {

            if (matrizInteracoes[linhaInteracao][3].equals(idAnimal)) {
                // Incrementar ao rendimento
                rendimentoTotal += Double.parseDouble(matrizInteracoes[linhaInteracao][5]);
            }
        }
        return rendimentoTotal;
    }

    public static void estatisticasPorHabitat(String[][] matrizAnimais, String[][] matrizInteracoes) {

        String[] habitatsSemDuplicados = habitatsUnicos(matrizAnimais);

        for (int i = 1; i < habitatsSemDuplicados.length; i++) {
            System.out.println("\nHabitat: " + habitatsSemDuplicados[i]);
            System.out.println("  Nº de Animais: " + numeroAnimaisHabitat(matrizAnimais, habitatsSemDuplicados[i]));

            int numInteracoesTotal = 0;
            double receitaTotal = 0;

            String[] idsAnimaisHabitatAtual = animaisDeUmHabitat(matrizAnimais, habitatsSemDuplicados[i]);

            for (int indexAnimal = 0; indexAnimal < idsAnimaisHabitatAtual.length; indexAnimal++) {
                numInteracoesTotal += interacoesAnimal(matrizInteracoes, idsAnimaisHabitatAtual[indexAnimal]);
                receitaTotal += rendimentosAnimal(matrizInteracoes, idsAnimaisHabitatAtual[indexAnimal]);

            }

            System.out.println("  Nº de Interações: " + numInteracoesTotal);
            System.out.println("  Receita Associada: " + receitaTotal + " €");


        }
    }


    //************* ITENS CLIENTE ****************

    //ITEM 1 CLIENTE
    public static void verCatalogoPorHabitat(String[][] matrizAnimais) {
        // Arrays para armazenar uma array de habitats únicos e o contador
        String[] habitats = new String[matrizAnimais.length];

        for (int animalAtual = 0; animalAtual < matrizAnimais.length; animalAtual++) {
            String habitatAtual = matrizAnimais[animalAtual][3];

            //validação pra nao adicionar repetidos
            boolean encontrado = false;

            for (int i = 0; i < habitats.length; i++) {
                //verificar pois array habitats tem varios nulos
                if (habitats[i] != null) {
                    if (habitats[i].equals(habitatAtual)) {
                        encontrado = true;
                    }
                }
            }
            //adiciona se nao foi encontrado
            if (!encontrado) {
                habitats[animalAtual] = habitatAtual;
            }
        }
        //Imprimir todos os habitats e os animais correspondentes
        for (int i = 1; i < habitats.length; i++) {
            //nao printar os nulos
            if (habitats[i] != null) {
                System.out.println("\n\uD83E\uDD92" + habitats[i] + "\uD83D\uDC12");
                for (int j = 1; j < matrizAnimais.length; j++) {
                    if (matrizAnimais[j][3].equals(habitats[i])) {
                        String nomeAnimal = matrizAnimais[j][1];
                        String especieAnimal = matrizAnimais[j][2];
                        System.out.println("• " + nomeAnimal + " (" + especieAnimal + ")");
                    }
                }
            }
        }
    }

    //ITEM 2 CLIENTE
    public static void atividadesAnimal(String[][] matrizAnimais, String[][] matrizInteracoes) {
        //chamar função para encotnrar o ID do animal
        String[] animal = encontrarAnimalID(matrizAnimais);
        String idAnimal = animal[0];
        int numEspetaculo = 0;
        int numAlimentacao = 0;
        String nomeEspetaculo = "";
        String nomeAlimentacao = "";

        //comparar o ID localizado com a matriz de interações
        for (int i = 0; i < matrizInteracoes.length; i++) {
            if (idAnimal.equals(matrizInteracoes[i][3])) {
                if (matrizInteracoes[i][2].equals("ESPETACULO")) {
                    numEspetaculo++;
                    nomeEspetaculo = matrizInteracoes[i][4];
                } else if (matrizInteracoes[i][2].equals("ALIMENTACAO")) {
                    numAlimentacao++;
                    nomeAlimentacao = matrizInteracoes[i][4];
                }
            }
        }
        // impressão
        System.out.println("Atividades do animal " + animal[1] + " (" + animal[2] + "): \n");
        System.out.println("ESPETÁCULOS:");
        System.out.println("• " + nomeEspetaculo + " " + " (" + numEspetaculo + " vezes" + "): \n");
        System.out.println("ALIMENTAÇÃO:");
        System.out.println("• " + nomeAlimentacao + " " + " (" + numAlimentacao + " vezes" + "): ");
    }

    //ITEM 3 CLIENTE
    public static void simuladorApadrinhamento(String[][] matrizAnimal) {
        Scanner input = new Scanner(System.in);

        System.out.println("Bem-Vindo ao Apadrinhamento SAVANACODE");
        System.out.print("Nome: ");
        String nome = input.next();
        System.out.print("E-mail: ");
        String email = input.next();
        System.out.print("ID animal: ");
        String idAnimal = input.next();
        System.out.print("Valor mensal do apadrinhamento: ");
        double valorApadrinhamento = input.nextDouble();

        String nomeAnimal = "";
        String especieAnimal = "";
        String habitatAnimal = "";

        //para buscar o nome e especie do animal por ID
        for (int i = 0; i < matrizAnimal.length; i++) {
            if (matrizAnimal[i][0].equals(idAnimal)) {
                nomeAnimal = matrizAnimal[i][1];
                especieAnimal = matrizAnimal[i][2];
                habitatAnimal = matrizAnimal[i][3];
            }
        }

        //plano de Apadrinhamento
        String planoApadrinhamento = "";
        if (valorApadrinhamento <= 25) {
            planoApadrinhamento = "Apadrinhamento SIMPLES";
        } else if (valorApadrinhamento >= 25 && valorApadrinhamento <= 50) {
            planoApadrinhamento = "Apadrinhamento GOLD";
        } else if (valorApadrinhamento > 50) {
            planoApadrinhamento = "Apadrinhamento DIAMOND";
        }

        System.out.println("\nResumo do Apadrinhamento: \n");
        System.out.println("Padrinho: " + nome + " (" + email + ")");
        System.out.println("Animal: " + nomeAnimal + " " + especieAnimal + " (" + habitatAnimal + ")");
        System.out.println("Plano: " + planoApadrinhamento);
        System.out.println("Valor: " + valorApadrinhamento + "€");
        System.out.println("\nA SAVANACODE e seus animais agradecem!");

    }

    //ITEM 4 CLIENTE
    public static void jogoAdvinha(String[][] matrizAnimal) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        String animalInput = "";

        int numAleatorio = rnd.nextInt(matrizAnimal.length);

        //dicas
        System.out.println("***** Dicas *****");

        String dicaHabitat = matrizAnimal[numAleatorio][3];
        System.out.println("Habitat: " + dicaHabitat);
        String dicaAlimentacao = matrizAnimal[numAleatorio][4];
        System.out.println("Alimentação: " + dicaAlimentacao);
        String dicaExtincao = matrizAnimal[numAleatorio][5];
        System.out.println("Perigo de Extinção: " + dicaExtincao);

        boolean usuarioAcertou = false;


        while (!animalInput.equals("0") && !usuarioAcertou) {
            System.out.println("\nAdivinhe o animal(0 - Para desistir): ");
            animalInput = input.next();

            if (matrizAnimal[numAleatorio][2].equals(animalInput)) {
                System.out.println("Parabéns, você acertou!");
                usuarioAcertou = true;
            } else {
                if (!animalInput.equals("0")) {
                    System.out.println("Palpite incorreto, tente denovo.");
                }
            }
        }
    }

    //********** MAIN **********

    public static void main(String[] args) throws FileNotFoundException {

        String[][] matrizAnimais = ficheiroParaMatriz("ficheiros/animais.csv");
        String[][] matrizClientes = ficheiroParaMatriz("ficheiros/clientes.csv");
        String[][] matrizInteracoes = ficheiroParaMatriz("ficheiros/interacoes.csv");

        login(matrizAnimais, matrizClientes, matrizInteracoes);

        System.out.println(
                " XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" +
                        " X                                                    X\n" +
                        " X    (0>                                             X\n" +
                        " X    //|      Feito por: Sandro Draeger :)           X\n" +
                        " X    V_/_                                            X\n" +
                        " X                                                    X\n" +
                        " XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

    }
}


