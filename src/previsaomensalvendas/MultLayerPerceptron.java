/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package previsaomensalvendas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor
 */
public class MultLayerPerceptron {

    private List<Neuronio> camadaOculta;
    private List<Neuronio> camadaSaida;

    /**
     * Construtor recebendo numero de entradas da rede, num de neuronios na
     * camada oculta e na camada de saida.
     *
     * @param numeroEntradas da rede.
     * @param numeroNeuroniosCamadaOculta
     * @param numeroNeuroniosCamadaSaida
     */
    public MultLayerPerceptron(int numeroEntradas, int numeroNeuroniosCamadaOculta, int numeroNeuroniosCamadaSaida) {
        this.camadaOculta = new ArrayList<>();
        this.camadaSaida = new ArrayList<>();
        this.inicializarCamadas(numeroEntradas, numeroNeuroniosCamadaOculta, numeroNeuroniosCamadaSaida);
    }

    /**
     * Inicializa a Camada Oculta e a Camada de Saida com o numero de neuronios passados.
     * @param numeroEntradas
     * @param numeroNeuroniosCamadaOculta
     * @param numeroNeuroniosCamadaSaida 
     */
    private void inicializarCamadas(int numeroEntradas, int numeroNeuroniosCamadaOculta, int numeroNeuroniosCamadaSaida) {
        Neuronio neuronio = null;
        for (int i = 0; i < numeroNeuroniosCamadaOculta; i++) {
            neuronio = new Neuronio(numeroEntradas);
            this.camadaOculta.add(neuronio);
        }
        numeroEntradas = this.camadaOculta.size();
        for (int i = 0; i < numeroNeuroniosCamadaSaida; i++) {
            neuronio = new Neuronio(numeroEntradas);
            this.camadaSaida.add(neuronio);
        }
    }

    /**
     * Primeiro faz o FORWARD da Camada Oculta,
     * Pegas as saidas da Camada Oculta e seta como entradas para a Camada de Saida e
     * entao faz se o FORWARD da Camada de Saida
     */
    public void forward() {
        this.forwardPorCamada(this.camadaOculta);
        List<Double> entradasCamadaSaida = this.getSaidasCamadaOculta();
        for (Neuronio neuronio : this.camadaSaida) {
            neuronio.setEntradas(entradasCamadaSaida); // setando as entradas da camada oculta com a saida da camada de saida
        }
        this.forwardPorCamada(this.camadaSaida);
    }
    
    public void treinar(Double saidaEsperada) {
        this.processaTreino(saidaEsperada);
    }
    
    /**
     * PREVISAO, NAO AJUSTA MAIS OS PESOS.
     * Primeiro faz o FORWARD da Camada Oculta,
     * Pegas as saidas da Camada Oculta e seta como entradas para a Camada de Saida e
     * entao faz se o FORWARD da Camada de Saida
     */
    public void prever() {
        this.forwardPorCamada(this.camadaOculta);
        List<Double> entradasCamadaSaida = this.getSaidasCamadaOculta();
        for (Neuronio neuronio : this.camadaSaida) {
            neuronio.setEntradas(entradasCamadaSaida); // setando as entradas da camada oculta com a saida da camada de saida
        }
        this.forwardPorCamada(this.camadaSaida);
    }

    /**
     * Faz o FORWARD de neuronio por neuronio na camada passada.
     *
     * @param camada
     */
    private void forwardPorCamada(List<Neuronio> camada) {
        for (Neuronio neuronio : camada) {
            neuronio.forward();
        }
    }

    /**
     * Pega as saidas da Camada oculta,
     * coloca em um array e retorna ele.
     * @return 
     */
    private List<Double> getSaidasCamadaOculta() {
        ArrayList<Double> saidaCamadaOculta = new ArrayList<>();
        for (Neuronio neuronio : this.camadaOculta) {
            saidaCamadaOculta.add(neuronio.getSaida()); // pegando a saida da camada oculta
        }
        return saidaCamadaOculta;
    }

    /**
     * Faz o FORWARD da camada oculta e de saida, depois faz o BACKWARD da
     * camada de saida e so depois  o BACKWARD da camada oculta. E entao
     * ajusta os pesos.
     * 
     * Função executada apenas quando está treinando
     * @param saidaEsperada
     * @see forward()
     * @see backwardPorCamada(List<Neuronio> camada, Double saidaEsperada)
     * @see backwardCamadaOculta()
     */
    public void processaTreino(Double saidaEsperada) {
        this.forward();
        this.backwardPorCamada(this.camadaSaida, saidaEsperada);
        this.backwardCamadaOculta();
        for (Neuronio neuronio : this.camadaSaida) {
            neuronio.ajustarPesos();
        }
    }

    public void backwardPorCamada(List<Neuronio> camada, Double saidaEsperada) {
        for (Neuronio neuronio : camada) {
            neuronio.backward(saidaEsperada);
        }
    }

    private void backwardCamadaOculta() {
        List<Double> erroCamadaSaida = this.calcularErroCamadaSaida();
        for (int i = 0; i < this.camadaOculta.size(); i++) {
            Neuronio neuronio = this.camadaOculta.get(i);
            Double erro = erroCamadaSaida.get(i);
            neuronio.setErro(erro);
            neuronio.ajustarPesos();
        }
    }

    /**
     * Calcula o Erro na camada de saida.
     *
     * @return
     */
    private List<Double> calcularErroCamadaSaida() {
        List<Double> erroCamadaSaida = new ArrayList<>();
        Double erroAux;
        for (int i = 0; i < this.camadaOculta.size(); i++) {
            erroCamadaSaida.add(new Double(0));
        }
        for (int i = 0; i < this.camadaSaida.size(); i++) {
            Neuronio neuronio = this.camadaSaida.get(i);
            List<Double> peso = neuronio.getPesos();
            for (int j = 1; j < peso.size(); j++) {
                erroAux = erroCamadaSaida.get(j - 1);
                erroAux += (peso.get(j) * neuronio.getErro());
                erroCamadaSaida.set(j-1, erroAux);
            }
        }
        return erroCamadaSaida;
    }

    public void definirEntradas(List<Double> entradas) {
        for (Neuronio neuronio : this.camadaOculta) {
            neuronio.setEntradas(entradas);
        }
    }
    
    /**
     * Pegar saida da rede.
     * @return 
     */
    public Double getResultado() {
        return this.camadaSaida.get(0).getSaida();
    }

    public List<Neuronio> getCamadaOculta() {
        return camadaOculta;
    }

    public void setCamadaOculta(List<Neuronio> camadaOculta) {
        this.camadaOculta = camadaOculta;
    }

    public List<Neuronio> getCamadaSaida() {
        return camadaSaida;
    }

    public void setCamadaSaida(List<Neuronio> camadaSaida) {
        this.camadaSaida = camadaSaida;
    }
}
