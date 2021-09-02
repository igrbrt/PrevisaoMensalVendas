/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package previsaomensalvendas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author
 */
public class Neuronio {

    private static double TAXA_APRENDIZADO = 0.01;
    private static Random aRandom = new Random(System.currentTimeMillis());
    private List<Double> entradas;
    private List<Double> pesos;
    private Double saida;
    private Double erro;

    public Neuronio(int numeroEntradas) {
        this.pesos = new ArrayList<>();
        
        gerarPesosAleatorios(numeroEntradas);
        this.entradas = new ArrayList<>();
        for (int i = 0; i <= numeroEntradas; i++) {
            this.entradas.add(new Double(0));
        }
        this.entradas.set(0, new Double(0.0));
    }

    /**
     * FORWARD Multiplica as entradas pelos pesos e faz a funcao de ativacao com
     * a tangente hiperbolica.
     *
     * @return Double com valor da Tangente hiperbólica do somatorio.
     */
    public Double forward() {
        Double saidaAuxiliar = new Double(0.0);
        for (int i = 0; i < entradas.size(); i++) {
            saidaAuxiliar += (entradas.get(i) * pesos.get(i));
        }
        this.setSaida(Math.tanh(saidaAuxiliar));
        return this.getSaida();
    }

    /**
     * BACKWARD
     *
     * @param anExpectedOutput
     */
    public void backward(Double saidaEsperada) {
        Double saidaAux = this.forward();
        this.calcularErro(saidaEsperada, saidaAux);
    }

    /**
     * Calcula o erro.
     *
     * @param saidaEsperada
     * @param saida
     */
    private void calcularErro(Double saidaEsperada, Double saida) {
        Double erroAux = saidaEsperada - saida;
        erroAux = ((1 - Math.pow(saida, 2)) * erroAux);
        this.setErro(erroAux);
    }

    /**
     * Ajuste de pesos.
     */
    public void ajustarPesos() {
        for(int i = 0; i < pesos.size(); i++){
            Double pesoAux = pesos.get(i);
            pesoAux += (TAXA_APRENDIZADO * entradas.get(i) * this.getErro());
            pesos.set(i, pesoAux);
        }
    }

    /**
     * Gera pesos aleaatorio e atribui para o vetor pesos. Pesos entre -0.2 e
     * 0.2 sao descartados.
     */
    public final void gerarPesosAleatorios(int numeroEntradas) {
        double n;
        double X = -1;
        double Y = 1;

        for (int i = 0; i <= numeroEntradas; i++) {
            n = X + (double) (Math.random() * (Y + 1));
            while ((n < 0.2999999999) && (n > -0.2999999999)) {
                n = X + (double) (Math.random() * (Y + 1));
            }
            this.pesos.add(n);
        }
    }

    public static double getTAXA_APRENDIZADO() {
        return TAXA_APRENDIZADO;
    }

    public static void setTAXA_APRENDIZADO(double TAXA_APRENDIZADO) {
        Neuronio.TAXA_APRENDIZADO = TAXA_APRENDIZADO;
    }

    public static Random getaRandom() {
        return aRandom;
    }

    public static void setaRandom(Random aRandom) {
        Neuronio.aRandom = aRandom;
    }

    public List<Double> getEntradas() {
        return entradas;
    }

    /**
     * Seta lista de entradas passadas colocando o BIAS na posicao 0.
     *
     * @param entradas
     */
    public void setEntradas(List<Double> entradas) {
        this.entradas = new ArrayList<>();
        this.entradas.add(new Double(1.0)); // BIAS
        this.entradas.addAll(entradas);
    }

    public Double getErro() {
        return erro;
    }

    public void setErro(Double erro) {
        this.erro = erro;
    }

    public List<Double> getPesos() {
        return pesos;
    }

    public void setPesos(List<Double> pesos) {
        this.pesos = pesos;
    }

    public Double getSaida() {
        return saida;
    }

    public void setSaida(Double saida) {
        this.saida = saida;
    }
}
