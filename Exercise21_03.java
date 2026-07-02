import java.io.File;
import java.util.Scanner;
import java.util.Set;

public class Exercise21_03 {
    public static void main(String[] args) throws Exception {
        
        // check if filename provided
        if (args.length != 1) {
            System.out.println("Error: Provide a source file.");
            System.exit(1);
        }

        //check file status
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File " + args[0] + " does not exist");
            System.exit(2);
        }

        // display
        System.out.println("The program is");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            System.out.println(input.nextLine());
        }
        input.close();

        // count and display keywords 
        System.out.println("The number of keywords in the program is " 
        + countKeywords(file));
    }
    public static int countKeywords(File file) throws Exception {

        // keywords
        String[] keywordString = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"};

        Set<String> keywordSet =
            new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        // read file into string
        Scanner input = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (input.hasNextLine()) {
            sb.append(input.nextLine()).append("\n");
        }
        input.close();

        String code = sb.toString();

        // remove string literals to avoid counting keywords
        code = code.replaceAll("\"[^\"]*\"", "\"\"");

        // remove character literals
        code = code.replaceAll("'[^']*'", "''");

        // remove line comments
        code = code.replaceAll("//[^\n]*", "");

        // remove line block comments
        code = code.replaceAll("/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/", "");

        
    }
    
}