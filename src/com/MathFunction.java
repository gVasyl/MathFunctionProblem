package com;

import java.util.HashMap;

public class MathFunction {

    /**
     * Current value of x
     */
    private Long x;

    /**
     * Used for growing x, in case odd and x%3 != 0.
     */
    private int caseOdd;

    /**
     * Contains all numbers for the last 500 iterations.
     */
    private HashMap<Long, Long> cycle = new HashMap<>();

    /**
     * Set begin "x" for function.
     * @param x begin "x".
     * @param caseOdd variable to using in definition for odd case.
     */
    public MathFunction(Long x, int caseOdd) {
        this.x = x;
        this.caseOdd = caseOdd;
    }

    /**
     * Set default: x = 3  and caseodd = 3.
     */
    @SuppressWarnings("unused")
    public MathFunction() {
        this.x = 3L;
        this.caseOdd = 3;
    }

    /**
     * Counting return next "x". Falling down by 2 and 3.
     */
    private void getNextX() {
       this.x = this.x % 2 == 0 ?
               this.x / 2
               : this.x % 3 == 0 ?
                    this.x / 3
                    :this.x % 5 == 0 ?
                        this.x / 5
                        :(caseOdd * this.x + 1) / 2;
    }

    /**
     * Check "x" for condition to finish function. If x equal 1 then true else false.
     * @param x variable for checking.
     * @return True if "x" equal 1 else false.
     */
    private boolean checkCondition(Long x) {
        return x == 1;
    }

    /**
     * Start counting function for set "x" and "caseOdd". Return true if function hasn't cycle, else false.
     * @return true if function hasn't cycle, else false.
     */
    private boolean startFunction(Long x){
        boolean bool = true;
        this.x = x;
        while (!this.checkCondition(this.x)){
            this.getNextX();
            if (this.checkCycle()) {
                bool = false;
                break;
            }
            if (x < (long)0){
                System.out.println("x<0");
                bool = false;
                break;
            }
        }
        return bool;
    }

    /**
     * Checking function for cycle. Return true if has cycle else false.
     * @return true if has cycle or x's less then 0 else false.
     */
    private boolean checkCycle() {
        boolean bool = false;
        if (this.cycle.containsKey(x) || x < 0) {
            bool = true;
            if(x < 0){
                System.out.println("x < 0");
            }
        } else this.cycle.put(x, x);
        if (this.cycle.size() > 500)
            this.cycle.clear();
        return bool;
    }

    /**
     * Iterating method.
     * Checking first 100 numbers from 3 to 99 step 2 (this numbers used in case odd and  x%3 != 0) and x from 3 to 1_000_000 step 1.
     */
    public void iterating() {
        for (; this.caseOdd < 10; this.caseOdd += 2) {
            for (Long x = 1L; x < 1_000_000; x++) {
                boolean bool = this.startFunction(x);
                System.out.println(this.caseOdd + "\t" + bool + " " + x);
                this.cycle.clear();
                if (!bool)
                    break;
            }
        }
    }
}


