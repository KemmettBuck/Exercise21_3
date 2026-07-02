
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
    }
    
}