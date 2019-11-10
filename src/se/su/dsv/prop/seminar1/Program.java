package se.su.dsv.prop.seminar1;

public class Program {
    public static void main(String[] args) {
        String inputFileName = "/home/isak/Desktop/test_program.txt";
        Tokenizer t = new Tokenizer();

        try {
            t.open(inputFileName);
            t.moveNext();

            while (t.current().token() != Token.EOF) {
                System.out.println(t.current());
                t.moveNext();
            }
            t.close();
        } catch (Exception exception) {
            System.out.println("EXCEPTION: " + exception);
        }
    }
}

