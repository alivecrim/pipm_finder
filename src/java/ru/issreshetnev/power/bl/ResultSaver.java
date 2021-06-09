package ru.issreshetnev.power.bl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultSaver {
    public static void accept(Map<Double, String> doubleStringMap) {
        if (doubleStringMap.size()>0) {
            try {
                PrintWriter printWriter = new PrintWriter("result.csv");
                printWriter.println("#COMBINATION;FREQ1;FREQ2;ORDER1;ORDER2;SIGN");
                doubleStringMap.entrySet().stream().forEach(e -> {
                    Equation ex = eqParse(e.getValue());
                    printWriter.println(e.getKey() + ";" + ex.getF1() + ";" + ex.getF2() + ";" + ex.getO1() + ";" + ex.getO2() + ";" + (ex.isSign() ? "-" : "+"));
                });
                printWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static Equation eqParse(String value) {
        Pattern pattern = Pattern.compile("([1234567890]+)\\*(\\d+\\.\\d+[E]?[\\d]?[\\d]?[\\d]?)([\\+-])([1234567890]+)\\*(\\d+\\.\\d+[E]?[\\d]?[\\d]?[\\d]?)");
        Matcher matcher = pattern.matcher(value);
        matcher.find();
        return new Equation(Integer.parseInt(matcher.group(1)),
                Double.parseDouble(matcher.group(2)),
                matcher.group(3).equals("-"),
                Integer.parseInt(matcher.group(4)),
                Double.parseDouble(matcher.group(5))
        );
    }

    public static class Equation {
        double f1;
        double f2;
        int o1;
        int o2;
        boolean sign;

        public Equation(int o1, double f1, boolean sign, int o2, double f2) {
            this.f1 = f1;
            this.f2 = f2;
            this.o1 = o1;
            this.o2 = o2;
            this.sign = sign;

        }

        public boolean isSign() {
            return sign;
        }

        public double getF1() {
            return f1;
        }

        public double getF2() {
            return f2;
        }

        public int getO1() {
            return o1;
        }

        public int getO2() {
            return o2;
        }
    }
}
