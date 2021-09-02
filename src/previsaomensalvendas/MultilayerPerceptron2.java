package previsaomensalvendas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcelo Claudio Sousa Araújo
 */
public class MultilayerPerceptron2 {

    private List<Neuron> hiddenLayer;
    private List<Neuron> outputLayer;

    public MultilayerPerceptron2(int anInputSize, int anHiddenLayerSize, int anOutputLayerSize) { //OK
        this.hiddenLayer = new ArrayList<>();
        this.outputLayer = new ArrayList<>();
        this.randomFill(anInputSize, anHiddenLayerSize, anOutputLayerSize);
    }

    private void randomFill(int anInputSize, int anHiddenLayerSize, int anOutputLayerSize) { //OK
        Neuron aNeuron = null;
        for (int i = 0; i < anHiddenLayerSize; i++) {
            aNeuron = new Neuron(anInputSize);
            this.hiddenLayer.add(aNeuron);
        }
        anInputSize = this.hiddenLayer.size();
        for (int i = 0; i < anOutputLayerSize; i++) {
            aNeuron = new Neuron(anInputSize);
            this.outputLayer.add(aNeuron);
        }
    }

    public void foward() {
        this.fowardLayer(this.hiddenLayer);
        List<Double> hiddenInputs = this.getHiddenInputs();
        for (Neuron aNeuron : this.outputLayer) {
            aNeuron.setInputs(hiddenInputs);
        }
        this.fowardLayer(this.outputLayer);
    }

    private List<Double> getHiddenInputs() {
        ArrayList<Double> hiddenInputs = new ArrayList<>();
        for (Neuron aNeuron : this.hiddenLayer) {
            hiddenInputs.add(aNeuron.getOutput());
        }
        return hiddenInputs;
    }

    private void fowardLayer(List<Neuron> aLayer) {
        for (Neuron aNeuron : aLayer) {
            aNeuron.foward();
        }
    }

    public void backward(Double anExpectedOutput) {
        this.foward();
        this.backwardLayer(this.outputLayer, anExpectedOutput);
        this.backwardHiddenLayer();
        for (Neuron aNeuron : this.outputLayer) {
            aNeuron.adjustWeights();
        }
    }

    public void defineInputs(List<Double> theInputs) { //OK
        for (Neuron aNeuron : this.hiddenLayer) {
            aNeuron.setInputs(theInputs);
        }
    }

    public void defineTraining(List<Double> theInputs, Double anExpectedOutput) {
        this.defineInputs(theInputs);
        this.backward(anExpectedOutput);
    }

    private void backwardLayer(List<Neuron> aLayer, Double anExpectedOutput) {
        for (Neuron aNeuron : aLayer) {
            aNeuron.backward(anExpectedOutput);
        }
    }

    private void backwardHiddenLayer() {
        List<Double> theGamaValues = this.calculateGama();
        for (int anIndex = 0; anIndex < this.hiddenLayer.size(); anIndex++) {
            Neuron aNeuron = this.hiddenLayer.get(anIndex);
            Double aGamaValue = theGamaValues.get(anIndex);
            aNeuron.setError(aGamaValue);
            aNeuron.adjustWeights();
        }
    }

    private List<Double> calculateGama() {
        List<Double> theGamaValues = new ArrayList<>();
        Double aParcialGama;
        for (int i = 0; i < this.hiddenLayer.size(); i++) {
            theGamaValues.add(new Double(0));
        }
        for (int anIndex = 0; anIndex < this.outputLayer.size(); anIndex++) {
            Neuron aNeuron = this.outputLayer.get(anIndex);
            List<Double> theSinaptcs = aNeuron.getWeights();
            for (int anSecondIndex = 1; anSecondIndex < theSinaptcs.size(); anSecondIndex++) {
                aParcialGama = theGamaValues.get(anSecondIndex - 1);
                aParcialGama += (theSinaptcs.get(anSecondIndex) * aNeuron.getError());
                theGamaValues.set(anSecondIndex-1, aParcialGama);
            }
        }
        return theGamaValues;
    }

    public Double getResult() {
        return this.outputLayer.get(0).getOutput();
    }
}