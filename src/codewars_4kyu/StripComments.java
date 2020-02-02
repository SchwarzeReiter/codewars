package codewars_4kyu;

/*
Complete the solution so that it strips all text that follows any of a set of comment markers passed in. Any whitespace at the end of the line should also be stripped out.

Example:

Given an input string of:

apples, pears # and bananas
grapes
bananas !apples
The output expected would be:

apples, pears
grapes
bananas
The code would be called like so:

var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
// result should == "apples, pears\ngrapes\nbananas"
 */

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {

        if(commentSymbols.length <1){return "";}

        for(String s: commentSymbols){

            if(s.equals("")){return "\n";}

            text = text.replaceAll(
                    "( +" + s + ")[^\\n]+|" +
                            "(" + s + ")[^\\n]+|" +
                            "(" + s + ". )[^\\n]+|" +
                            "(" + s + ")|" +
                            "( +\\" + s + ")[^\\n]+|" +
                            "(\\" + s + ")[^\\n]+|" +
                            "(\\" + s + ". )[^\\n]+|" +
                            "(\\" + s + ")",
                    "");



        }


        text = text.replaceAll(" +$","");
        text = text.replaceAll("( +\\n)","\n");

        return text;
    }

}


