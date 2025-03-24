package nai.perceptron;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vector> trainingSet = Parser.parseVectorsFromFile("src/main/resources/perceptron.txt");
        int numFeatures = trainingSet.getFirst().getValues().size();

        Perceptron perceptron = new Perceptron(numFeatures, 0.01, 1000, trainingSet);


        List<Vector> testVectors = Parser.parseVectorsFromFile("src/main/resources/perceptron.test.txt");
        int tests = testVectors.size();
        int passes = 0;

        for (Vector testVector : testVectors) {
            if (testVector.getLabel() == perceptron.predict(testVector)) {
                passes++;
            }
        }

        System.out.println("Number of tests: " + tests);
        System.out.println("Number of passes: " + passes);
        System.out.println("Ratio: " + 100.0 * passes / tests);
    }
}