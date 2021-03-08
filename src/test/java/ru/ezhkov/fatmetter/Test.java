package ru.ezhkov.fatmetter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test {

    public static void main(String[] args) throws Exception {
        NewRiskLevel newRiskLevel = null;
        NewRiskLevel currentRiskLevel = new NewRiskLevel();

        boolean b = (newRiskLevel == null && currentRiskLevel == null) || (newRiskLevel != null && newRiskLevel.equals(currentRiskLevel));
        System.out.println(b);
    }


    private static class NewRiskLevel {
        public NewRiskLevel( ) {
        }
    }
}
