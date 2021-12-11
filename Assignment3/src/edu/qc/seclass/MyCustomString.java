package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface{
    private String str = null;
    @Override
    public String getString() {
        return str;
//        return (str.isEmpty() || str==null) ? null : str;
    }

    @Override
    public void setString(String string) {
        this.str = string;
    }

    @Override
    public int countNumbers() {
        if(str==null) throw new NullPointerException("String is Null. Cannot get count");
        int count = 0;
        for(String s : str.split("\\D+")){
            if(s.matches("\\d+")) count++;
        }
        return count;
    }

    @Override
    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
        if(n<=0) throw new IllegalArgumentException("Input n is less or equal to 0.");
        if(str==null) throw new NullPointerException("String is null and input is greater or equals to 0. Cannot get everyNthChar");
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        if(startFromEnd){ // start from len
            for(int i = len,j=1; i>0 ;i--,j++){
                if(j%n==0){
                    sb.append(str.charAt(i-1));
                }
            }
            return sb.reverse().toString();
        }else{ // start from 0
            for(int i = 1; i<=len ;i++){
                if(i%n==0){
                    sb.append(str.charAt(i-1));
                }
            }
        }
        return sb.toString();
    }

    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
        /*
        Cases:
        end >= start
        start<0
        end>=str.length()
        input isEmpty() || ==null
         */
        if(startPosition>endPosition) throw new IllegalArgumentException("Start position is greater than end");
        if(startPosition<=0) throw new MyIndexOutOfBoundsException("Start Positioning is less than 1");
        if(endPosition>str.length()) throw new MyIndexOutOfBoundsException("End Positioning is greater than the length of the string");
        if(str==null) throw new NullPointerException("String is Null. Cannot convertDigitsToNames.");
        String[] alphaNum = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0,startPosition-1));
        for(;startPosition<=endPosition;startPosition++){
            char c = str.charAt(startPosition-1);
            if(c<=57 && c>=48) sb.append(alphaNum[c-48]);
            else sb.append(c);
        }
        sb.append(str.substring(endPosition,str.length()));
        str = sb.toString();
    }
}
