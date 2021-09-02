package previsaomensalvendas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Marcelo Claudio Sousa Araújo
 */

public class Neuron {
    //primeira posição é o bais.
    private static double LEARNING_RATE = 0.01;
    private static Random aRandom = new Random(System.currentTimeMillis());
    private List<Double> inputs;
    private List<Double> weights;
    private Double output;
    private Double error;

    public Neuron(int anInputSize) {
        this.weights = new ArrayList<>();
        for(int i = 0; i <= anInputSize ; i++){
            this.weights.add(aRandom.nextDouble());
        }
        this.inputs = new ArrayList<>();
        for (int i = 0; i <= anInputSize; i++) {
            this.inputs.add(new Double(0));
        }
        this.inputs.set(0,new Double(0.0));
    }
    
    
    public List<Double> getInputs() {
        return inputs;
    }
    
    public void setInputs(List<Double> inputs) {
        this.inputs = new ArrayList<>();
        this.inputs.add(new Double(1.0));
        this.inputs.addAll(inputs);
    }
    
    public List<Double> getWeights() {
        return weights;
    }
    
    public void setWeights(List<Double> weights) {
        this.weights = weights;
    }
    
    public Double getOutput() {
        return output;
    }
    
    public void setOutput(Double output) {
        this.output = output;
    }
    
    public Double foward() {
        Double aParcialOutput = new Double(0.0);
        for (int i = 0; i < inputs.size(); i++) {
            aParcialOutput += (inputs.get(i) * weights.get(i));
        }
        this.setOutput(Math.tanh(aParcialOutput));
        return this.getOutput();
    }
    
    public void backward(Double anExpectedOutput) {
        //this.setInputs(theInputs);
        Double anOutput = this.foward();
        this.calculateError(anExpectedOutput, anOutput);
        //this.adjustWeights(aParcialError);
    }
    
    private void calculateError(Double anExpectedOutput, Double anOutput) {
        Double aParcialError = anExpectedOutput - anOutput;
        aParcialError = ((1 - Math.pow(anOutput, 2)) * aParcialError);
        this.setError(aParcialError);
    }
    
    public void adjustWeights() {
        for (int i = 0; i < weights.size(); i++) {
            Double anWeight = weights.get(i);
            anWeight += (LEARNING_RATE * inputs.get(i) * this.getError());
            weights.set(i, anWeight);
        }
    }

    public Double getError() {
        return this.error;
    }

    public void setError(Double anError) {
        this.error = anError;
    }
}