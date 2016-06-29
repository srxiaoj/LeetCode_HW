public class WrapText {
    public static void main(String[] args) {
        String text;
        int maxCharsPerLine;

        maxCharsPerLine = 12;
        text = "Here is an example of text justification";
        System.out.println(wrapText(text, maxCharsPerLine));

        text = "This is an example of word wrapper";
        System.out.println(wrapText(text, maxCharsPerLine));

        text = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(wrapText(text, maxCharsPerLine));

        text = "aaaaaaaaaaa\n\naaaaaaaaaaaaaaa\naaa";
        System.out.println(wrapText(text, maxCharsPerLine));

    }
    private static final char NEW_LINE = '\n';
    private static final char WHITESPACE = ' ';
    public static String wrapText(String text, int maxCharsPerLine) {
        if (maxCharsPerLine <= 0) return "";
        int size = text.length();
        int index = 0, currentLineLength = 0;
        char lastChar;
        StringBuilder result = new StringBuilder(); // variable to store final output
        StringBuilder currentWord = new StringBuilder(); // variable to store each single parsed word

        outer:
        while (index < size || currentWord.length() > 0) {
            lastChar = WHITESPACE;
            // find a complete word until it reach a blank or new line
            if (index < size) {
                lastChar = text.charAt(index);
                if (lastChar != NEW_LINE && lastChar != WHITESPACE) {
                    currentWord.append(lastChar);
                    index++;
                    continue outer;
                }
            }

            if (currentLineLength > 0 && currentLineLength < maxCharsPerLine) {
                if (currentWord.length() > 0) {
                    result.append(lastChar);
                    currentLineLength++;
                }
            }

            // single word is too long, split it into two half
            if (currentWord.length() > maxCharsPerLine) {
                String firstHalf = currentWord.substring(0, maxCharsPerLine - currentLineLength);
                String secondHalf = currentWord.substring(maxCharsPerLine - currentLineLength);
                result.append(firstHalf).append(NEW_LINE);
                currentWord = new StringBuilder(secondHalf);
            } else {
                if (currentLineLength + currentWord.length() <= maxCharsPerLine) {
                    index++;
                    currentLineLength += currentWord.length();
                    result.append(currentWord);
                    if (lastChar == NEW_LINE) {
                        result.append(lastChar);
                    }
                    // reset currentWord if it can be append completely
                    currentWord = new StringBuilder();
                } else {
                    if (result.charAt(result.length() - 1) == WHITESPACE) {
                        result.deleteCharAt(result.length() - 1);
                    }
                    result.append('\n');
                }
            }
            // if encouter a '\n' start new line
            if (result.length() > 0 && result.charAt(result.length() - 1) == NEW_LINE) currentLineLength = 0;
        }

        // append last second half of the current word if it is longer than maxCharPerLine
        result.append(currentWord);
        return result.toString();
    }
}
