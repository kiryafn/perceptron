package nai.perceptron;

import java.util.ArrayList;
import java.util.List;

public class Perceptron {

    private List<Double> weights;
    private double bias;
    private double learningRate;
    private int epochs;

    public Perceptron(int numFeatures, double learningRate, int epochs, List<Vector> trainingSet) {
        this.learningRate = learningRate;

        this.weights = new ArrayList<>();
        for (int i = 0; i < numFeatures; i++) {
            this.weights.add(0.0);
        }

        train(trainingSet, epochs);
    }

    public Perceptron() {}

    public void train(List<Vector> trainingSet, int epochs) {
        for (int i = 0; i < epochs; i++) {
            for (Vector v : trainingSet) {
                updateWeightsAndBias(v, v.getLabel());
            }
        }
    }

    public int predict(Vector input) {
        double sum = 0;
        for (int i = 0; i < weights.size(); i++) {
            sum += weights.get(i) * input.getValues().get(i);
        }
        sum += bias;
        return activationFunction(sum);
    }

    public void updateWeightsAndBias(Vector input, int label) {
        List<Double> newWeights = new ArrayList<>();
        int output = predict(input);

        for (int i = 0; i < weights.size(); i++) {
            newWeights.add(weights.get(i) + learningRate * (label - output) * input.getValues().get(i));
        }

        bias += learningRate * (label - output);

        weights = newWeights;
    }

    private int activationFunction(double value) {
        return value >= 0 ? 1 : 0;
    }

    public List<Double> getWeights() {
        return weights;
    }
    public void setWeights(List<Double> weights) {
        this.weights = weights;
    }
    public double getBias() {
        return bias;
    }
    public void setBias(double bias) {
        this.bias = bias;
    }
    public double getLearningRate() {
        return learningRate;
    }
    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }
}