package  edu.qc.seclass;

public class BuggyClass {
    // buggyMethod1 division by zero error
    double buggyMethod1(int a, int b, int c) {
        // 100% statement coverage and does not reveal the fault
        // less than 50% statement coverage and reveals the fault
        // quadratic formula: finds the greater of the two
        double divisor = (2 * a);
        if(divisor == 0.0) throw new ArithmeticException("Divisor is 0");
        double first_part = (-1.0*b)/divisor; // error when a = 0
        double second_part =  (Math.pow(b, 2) - (4.0* a * c));
        if(second_part<0.0) throw new ArithmeticException("Error result will contain i"); // b^2 - 4ac = negative
        else second_part = Math.sqrt(second_part)/divisor;
        if(second_part>0) first_part += second_part;
        else first_part -= second_part;
        return first_part;
    }
    double buggyMethod2(int a, int b, int c) {
        // 100% statement coverage and does not reveal the fault
        // more than 50% branch coverage reveals the fault
        double first_part = (-1.0*b);
        double second_part =  (Math.pow(b, 2) - (4.0* a * c));
        if(second_part<0.0 || a==0) throw new ArithmeticException("Error result will contain i or a is 0"); // b^2 - 4ac = negative or a == 0
        else{
            second_part = Math.sqrt(second_part);
        }

        double divisor = 2*a;
        if((second_part>=0 && divisor>0) || (second_part<=0 && divisor<0)){ // top is +, bottom is + || top is - bottom is -
            first_part += second_part;
        }else if((second_part<0 && divisor>0) || (second_part>0 && divisor<0)) { // top is -, bottom is +
            first_part -= second_part;
        }
        first_part /= divisor;

        return first_part;
    }
    int buggyMethod3(int a, int b) {
        // achieves 100% branch coverage and does not reveal the fault
        // 100% statement coverage, does not achieve 100% branch coverage, and reveals the fault
        if(a%2==1){
            a--;
        }else{
            a*=2;
        }
        return a/b;
    }
    double buggyMethod4(int a, int b, int c) {
        // achieves 100% statement coverage reveals the fault
        // achieves 100% branch coverage and does not reveal the fault

        // This is not possible because if a branch coverage were to reach 100% the statement coverage also must reach 100%
        // However is a statement coverage meets 100%, the branch coverage would not necessary meet 100%
        // Therefore for a statement coverage to reach 100% and reveal a fault the branch coverage
        // also must show the fault

        return 0.0;
    }
    public void buggyMethod5 (int i) {
        // achieves 100% statement coverage and not reveal the fault

        // No it is not possible to reach a 100% statement coverage without a division by 0 fault
        // unless their is another fault that occurs before the program
        // The program can return before the division by 0 fault, however it would not reach 100% statement coverage
        // Therefore this program cannot reach 100% statement coverage
//
//        int x;
//        // add code
//        x = i/0;
//        // add code
    }

}