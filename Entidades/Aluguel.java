package Entidades;
import java.time.LocalDate;

public class Aluguel {
    private LocalDate entrada;
    private LocalDate saida;
    private Imovel imovel;
    private Boleto boleto;

    public Aluguel(LocalDate entrada, LocalDate saida, Imovel imovel, Boleto boleto) {
        this.entrada = entrada;
        this.saida = saida;
        this.imovel = imovel;
        this.boleto = boleto;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }

    public LocalDate getSaida() {
        return saida;
    }

    public void setSaida(LocalDate saida) {
        this.saida = saida;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    @Override
    public String toString() {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Aluguel [entrada = " + entrada.format(formatter) + ", saida = " + saida.format(formatter) + "]";
    }

}
