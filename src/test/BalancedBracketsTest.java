package test;

import org.junit.Test;
import java.util.ArrayList;

import static main.BalancedBrackets.hasBalancedBrackets;
import static org.junit.Assert.*;

public class BalancedBracketsTest {

    //TODO: add tests here
    @Test
    public void emptyTest() {
        assertEquals(true, true);
    }

    @Test
    public void onlyBracketsReturnsTrue(){
        assertTrue(hasBalancedBrackets("[]"));
    }

    @Test
    public void blankReturnsTrue(){
        assertTrue(hasBalancedBrackets(""));
    }

    @Test
    public void nestedBracketsReturnsFalse(){
        assertFalse(hasBalancedBrackets("[[]]"));
    }

    @Test
    public void consecutiveBracketsReturnsTrue(){
        assertTrue(hasBalancedBrackets("[][]"));
    }

    @Test
    public void textWontInterfere(){
        assertTrue(hasBalancedBrackets("[]hfdjlsahfjsag[asfdsafsa]"));
    }

    @Test
    public void differentStringsMatch(){
        assertEquals(hasBalancedBrackets("[][]"), hasBalancedBrackets("[thklds][fdjsaksad][]"));
    }

    @Test
    public void normalStringReturnsTrue(){
        assertTrue(hasBalancedBrackets("This is a normal string with no brackets."));
    }

    @Test
    public void isTypeBoolean(){
        Object result = hasBalancedBrackets("");
        assertEquals("Boolean", result.getClass().getSimpleName());
    }

    @Test
    public void reversingResultsAreTheSame(){
        String str = "[jkfl;asdf[]dfas[sdfa]fdsa[fd][][]]";
        char leftBracket = '[';
        char rightBracket = ']';
        ArrayList<Integer> leftBracketIndexes = new ArrayList<>();
        ArrayList<Integer> rightBracketIndexes = new ArrayList<>();

        for(int x = 0; x < str.length(); x++){
            if(str.charAt(x) == leftBracket){
                leftBracketIndexes.add(x);
            }
            if(str.charAt(x) == rightBracket){
                rightBracketIndexes.add(x);
            }
        }

        StringBuilder input = new StringBuilder();
        input.append(str);
        input.reverse();

        for (Integer leftBracketIndex : leftBracketIndexes) {
            input.replace(leftBracketIndex, leftBracketIndex + 1, "]");
        }
        for (Integer rightBracketIndex : rightBracketIndexes) {
            input.replace(rightBracketIndex, rightBracketIndex + 1, "[");
        }

        assertEquals(hasBalancedBrackets(str), hasBalancedBrackets(input.toString()));
    }

    @Test
    public void improperFormatFails(){
        assertFalse(hasBalancedBrackets("launch]code["));
    }

    @Test
    public void concatenatedStringSucceeds(){
        assertTrue(hasBalancedBrackets("fds[][fsddgs][" + "]fdsf[][dfas]dfdas"));
    }

}