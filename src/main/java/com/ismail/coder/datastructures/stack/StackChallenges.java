package com.ismail.coder.datastructures.stack;

import java.util.function.Function;

public class StackChallenges {
    public static void main(String[] args) {
        String term_1 = "[]";
        String term_2 = "([])";
        String term_3 = "(([])";
        System.out.println(parenthesisMatching(term_1.toCharArray()));
        System.out.println(parenthesisMatching(term_2.toCharArray()));
        System.out.println(parenthesisMatching(term_3.toCharArray()));
    }

    public static boolean parenthesisMatching(char[] text) {
        // start from here -> ([])
        String openingBrackets = "[{(\\<";
        String closingBrackets = "]})\\<";
        Function<Character,Character> getReverseBracket = (letter) -> {
            var index = closingBrackets.indexOf(letter);
            return index == -1 ? null : openingBrackets.charAt(index);
        };
        var arrayStack = new ArrayStack<Character>();
        for (var letter : text) {
            if (openingBrackets.indexOf(letter) != -1) {
                arrayStack.push(letter);
                continue;
            }
            // letter is a closing bracket
            var reverseBracket = getReverseBracket.apply(letter) ;
            if (arrayStack.isEmpty() && reverseBracket != arrayStack.pop()) return  false ;
        }
        return arrayStack.isEmpty();
    }
}
