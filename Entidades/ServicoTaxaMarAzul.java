package Entidades;
public class ServicoTaxaMarAzul implements ServicoTaxa{

    public Double calculaTaxa(Double valorDiaria){
        Double taxa;
        Double porcentagem = 0.02 * valorDiaria;
        Double encargos = 15.00;

        taxa = porcentagem + encargos;

        return taxa;
    }
}
