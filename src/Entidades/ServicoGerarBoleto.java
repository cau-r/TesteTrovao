package Programa.Entidades;
import java.time.Duration;

import Programa.Entidades.Aluguel;
import Programa.Entidades.Boleto;

public class ServicoGerarBoleto{
    private Double valorDiaria;
    private ServicoTaxa servicoTaxa;
    
    public ServicoGerarBoleto(Double valorDiaria, ServicoTaxa servicoTaxa) {
        this.valorDiaria = valorDiaria;
        this.servicoTaxa = servicoTaxa;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public ServicoTaxa getServicoTaxa() {
        return servicoTaxa;
    }

    public void setServicoTaxa(ServicoTaxa servicoTaxa) {
        this.servicoTaxa = servicoTaxa;
    }

    public void processarBoleto(Aluguel aluguel){
        Duration tempo = Duration.between(aluguel.getEntrada().atStartOfDay(),aluguel.getSaida().atStartOfDay());
        Long dias = tempo.toDays();
        Double taxaDiaria = servicoTaxa.calculaTaxa(valorDiaria);
        Double taxaTotal = taxaDiaria * dias;
        Double valorTotal = (valorDiaria * dias) + taxaTotal;
        aluguel.setBoleto(new Boleto(taxaTotal, valorTotal));
    }
}
