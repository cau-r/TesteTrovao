package Entidades;
public class ServicoTaxaParaiso implements ServicoTaxa{
    
    public Double calculaTaxa(Double valorDiaria){

        Double taxa;
        Double porcentagem = 0.05 * valorDiaria;
        Double encargos = 10.00;

        taxa = porcentagem + encargos;

        return taxa;     
    }
}