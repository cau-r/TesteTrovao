package Programa;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Entidades.Aluguel;
import Entidades.Imovel;
import Entidades.ServicoGerarBoleto;
import Entidades.ServicoTaxaMarAzul;
import Entidades.ServicoTaxaParaiso;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Integer codigo;
        String descricao;
        Double valorDiaria;
        LocalDate entrada = LocalDate.now();
        LocalDate saida = LocalDate.now();
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Integer tipoCondominio;

        ServicoGerarBoleto gerarBoleto = null;

        System.out.println(" *** Informe os dados da locação: *** ");

        System.out.println("Informe o codigo ");
        codigo = input.nextInt();
        input.nextLine();

        System.out.println("Informe a descricao ");
        descricao = input.nextLine();

        System.out.println("Informe o valor da diaria");
        valorDiaria = input.nextDouble();
        input.nextLine();

        System.out.println("Digite a data de entrada (formato: DD-MM-YYYY):");
        entrada = LocalDate.parse(input.nextLine(), dataFormatada);

        System.out.println("Digite a data de saída (formato: DD-MM-YYYY):");
        saida = LocalDate.parse(input.nextLine(), dataFormatada);

        Imovel imovel = new Imovel(codigo, descricao);
        Aluguel aluguel = new Aluguel(entrada, saida, imovel, null);

        System.out.println("Selecione as opções abaixo");
        System.out.println("""
                1) Condominio Mar Azul
                2) Condominio Paraiso
                """);

        tipoCondominio = input.nextInt();

        if (tipoCondominio == 1) {
            gerarBoleto = new ServicoGerarBoleto(valorDiaria, new ServicoTaxaMarAzul());
        } else {
            gerarBoleto = new ServicoGerarBoleto(valorDiaria, new ServicoTaxaParaiso());
        }

        gerarBoleto.processarBoleto(aluguel);

        if (tipoCondominio == 1) {
            System.out.println("\n***Boleto Condomínio Mar Azul***");
        } else {
            System.out.println("\n***Boleto Condomínio Paraiso***");
        }

        System.out.println(imovel.toString());
        System.out.println(aluguel.toString());
        System.out.println(aluguel.getBoleto());

    }
}