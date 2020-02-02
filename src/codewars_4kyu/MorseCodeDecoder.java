package codewars_4kyu;

import java.util.*;


/*
In this kata you have to write a Morse code decoder for wired electrical telegraph.
        Electric telegraph is operated on a 2-wire line with a key that, when pressed, connects the wires together, which can be detected on a remote station. The Morse code encodes every character being transmitted as a sequence of "dots" (short presses on the key) and "dashes" (long presses on the key).

        When transmitting the Morse code, the international standard specifies that:

        "Dot" – is 1 time unit long.
        "Dash" – is 3 time units long.
        Pause between dots and dashes in a character – is 1 time unit long.
        Pause between characters inside a word – is 3 time units long.
        Pause between words – is 7 time units long.
        However, the standard does not specify how long that "time unit" is. And in fact different operators would transmit at different speed. An amateur person may need a few seconds to transmit a single character, a skilled professional can transmit 60 words per minute, and robotic transmitters may go way faster.

        For this kata we assume the message receiving is performed automatically by the hardware that checks the line periodically, and if the line is connected (the key at the remote station is down), 1 is recorded, and if the line is not connected (remote key is up), 0 is recorded. After the message is fully received, it gets to you for decoding as a string containing only symbols 0 and 1.

        For example, the message HEY JUDE, that is ···· · −·−− ·−−− ··− −·· · may be received as follows:

        1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011

        As you may see, this transmission is perfectly accurate according to the standard, and the hardware sampled the line exactly two times per "dot".

        That said, your task is to implement two functions:

        Function decodeBits(bits), that should find out the transmission rate of the message, correctly decode the message to dots ., dashes - and spaces (one between characters, three between words) and return those as a string. Note that some extra 0's may naturally occur at the beginning and the end of a message, make sure to ignore them. Also if you have trouble discerning if the particular sequence of 1's is a dot or a dash, assume it's a dot.

        Function decodeMorse(morseCode), that would take the output of the previous function and return a human-readable string.

        NOTE: For coding purposes you have to use ASCII characters . and -, not Unicode characters.

        The Morse code table is preloaded for you as MORSE_CODE dictionary; in Java MorseCode class is provided; in Haskell the codes are in a Map String String and can be accessed like this: morseCodes ! ".--"; in Racket MORSE-CODE and can be accessed like this: (hash-ref MORSE-CODE ".--"). Feel free to use this preload.

        All the test strings would be valid to the point that they could be reliably decoded as described above, so you may skip checking for errors and exceptions, just do your best in figuring out what the message is!

*/

public class MorseCodeDecoder {

        public static String decodeBits(String bits) {

            String[] dividedString = divider(bits);
            int timeUnits = timeUnits(dividedString);
            Map <String, String> dictionary = makeDictionary(--timeUnits);
            StringBuilder resultString = new StringBuilder ();

            for(String s : dividedString)
            {
                resultString.append(getCharMorseCode(s,dictionary));
            }

            return resultString.toString().replace("|","");

        }




        public static String repeater(String str,int c)
        {
            StringBuilder stringBuilder = new StringBuilder(str);

            for(int i=0;i<c;i++)
            {
                stringBuilder.append(str);
            }

            return stringBuilder.toString();
        }



        public static int timeUnits(String[] strings) //find min length of string
        {

            int timeUnits = strings[0].length()+1; //start position

            for(int i=0;i<strings.length;i++)

            {
                if(timeUnits > strings[i].length())
                {
                    timeUnits = strings[i].length();
                }
            }

            return timeUnits;
        }


        public static String[] divider (String str )
        {
            char[] chars = str.toCharArray();
            List<String> list = new ArrayList<>();
            StringBuilder buffer = new StringBuilder();


            for(int i=0;i<str.length();i++)
            {
                if(buffer.length()==0){
                    buffer.append(chars[i]);
                    continue;
                }

                if(buffer.charAt(0) != chars[i])
                {
                    list.add(buffer.toString());
                    buffer = new StringBuilder();
                }

                buffer.append(chars[i]);
            }

            list.add(buffer.toString());

            //trim

            if(list.get(0).indexOf('0')>=0){
                list.remove(0);
            }
            if(list.get(list.size()-1).indexOf('0')>=0){
                list.remove(list.size()-1);
            }

            return list.toArray(new String[0]);

        }




        public static Map<String,String> makeDictionary (int timeUnits) { //dictionary
            Map<String, String> patternMap = new HashMap<>();

            patternMap.put(repeater("1",timeUnits),".");
            patternMap.put(repeater("111",timeUnits),"-");
            patternMap.put(repeater("0",timeUnits),"|");
            patternMap.put(repeater("000",timeUnits)," ");
            patternMap.put(repeater("0000000",timeUnits),"   ");

            return patternMap;
        }

        public static String getCharMorseCode (String data,Map <String,String> dictinary)
        {
            if(!dictinary.containsKey(data)){
                return "-";
            }

            return dictinary.get(data);

        }

        public static String decodeMorse(String morseCode) {

            String[] word = morseCode.split("\\s\\s\\s");
            StringBuffer result = new StringBuffer();

            for(int i=0;i < word.length;i++)
            {
                String[] letters = word[i].split("\\s");

                for(int y=0;y<letters.length;y++)
                {
                    //MorseCode it`s  dictionary
                    if(MorseCode.get(letters[y])!=null){
                        result.append(MorseCode.get(letters[y]));}


                }
                result.append(" ");

            }

            return result.toString().trim();
        }
    }

