import com.MathFunction;

public class Main {
    public static void main(String[] args) {
        /*MathFunction mathFunction = new MathFunction();
        mathFunction.iterating();*/
        int caseOdd = 3;
        Long x = 1L;
        MathFunction mathFunction = new MathFunction(x, caseOdd);
        mathFunction.iterating();
    }
}
