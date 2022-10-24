import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Main {
    public static String GetJavaFileWithoutComments(String fileName) throws FileNotFoundException {
        enum StringCondition {
            Start,
            StringBody,
            StringEnd,
            SpecSymbol,
            CommentBegin,
            CommentToEnd,
            CommentLines,
            CommentEnd,
            CharBody,
            CharSpecSymbol,
            CommentEndMaybe,
            Symbol,
            EscapeSymbol,
            SymbolEnd,
            StringConst,
            StringConst2
        }

        Scanner sc = new Scanner(new File(fileName));
        StringBuilder fileString = new StringBuilder();
        while (sc.hasNext()) {
            fileString.append(sc.nextLine() + '\n');
        }
        StringBuilder resultFile = new StringBuilder();
        var charArray = fileString.toString().toCharArray();

        StringCondition condition = StringCondition.Start;
        for (char c : charArray) {
            switch (condition) {
                case Start:
                    if (c == '"') {
                        resultFile.append(c);
                        condition = StringCondition.StringBody;
                    } else if (c == '\'') {
                        resultFile.append(c);
                        condition = StringCondition.CharBody;
                    } else if (c == '/') {
                        condition = StringCondition.CommentBegin;
                    } else {
                        resultFile.append(c);
                        condition = StringCondition.Start;
                    }
                    break;
                case StringBody:
                    if (c == '"') {
                        resultFile.append(c);
                        condition = StringCondition.StringEnd;
                    } else if (c == '\\') {
                        resultFile.append(c);
                        condition = StringCondition.SpecSymbol;
                    } else {
                        resultFile.append(c);
                        condition = StringCondition.StringBody;
                    }
                    break;
                case SpecSymbol:
                    resultFile.append(c);
                    condition = StringCondition.StringBody;
                    break;
                case StringEnd:
                    if (c == '"') {
                        resultFile.append(c);
                        condition = StringCondition.StringBody;
                    } if(c == '/'){
                    condition = StringCondition.CommentBegin;
                } else {
                    resultFile.append(c);
                    condition = StringCondition.Start;
                }
                    break;
                case CommentBegin:
                    if (c == '/') {
                        condition = StringCondition.CommentEnd;
                    } else if (c == '*') {
                        condition = StringCondition.CommentLines;
                    }
                    break;
                case CommentLines:
                    if (c == '*') {
                        condition = StringCondition.CommentEndMaybe;
                    } else {
                        condition = StringCondition.CommentLines;
                    }
                    break;
                case CommentEndMaybe:
                    if (c == '/') {
                        condition = StringCondition.Start;
                    } else {
                        condition = StringCondition.CommentEndMaybe;
                    }
                    break;
                case CommentEnd:
                    if (c == '\n') {
                        resultFile.append('\n');
                        condition = StringCondition.Start;
                    } else {
                        condition = StringCondition.CommentEnd;
                    }
                    break;
                case CharBody:
                    if (c == '\\') {
                        resultFile.append(c);
                        condition = StringCondition.CharSpecSymbol;
                    } else if (c == '\'') {
                        resultFile.append(c);
                        condition = StringCondition.Start;
                    } else {
                        resultFile.append(c);
                        condition = StringCondition.CharBody;
                    }
                    break;
                case CharSpecSymbol:
                    if (c == '\'') {
                        resultFile.append(c);
                        condition = StringCondition.Start;
                    } else {
                        resultFile.append(c);
                        condition = StringCondition.CharSpecSymbol;
                    }
                    break;
            }
        }
        return resultFile.toString();
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(GetJavaFileWithoutComments("input.txt"));
    }
}
