import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import java.util.LinkedList;

public class MoveToFront {

    private static LinkedList<Character> getAsciiLinkedList() {
        LinkedList<Character> ll = new LinkedList<>();
        for (char c = 0; c < 256; c++) {
            ll.add(c);
        }
        return ll;
    }

    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {
        LinkedList<Character> ls = getAsciiLinkedList();
        int i;
        while (!BinaryStdIn.isEmpty()) {
            char c = BinaryStdIn.readChar();
            i = ls.indexOf(c);
            ls.remove(i);
            ls.addFirst(c);
            BinaryStdOut.write(i, 8);
        }
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        LinkedList<Character> ls = getAsciiLinkedList();
        char ch;
        while (!BinaryStdIn.isEmpty()) {
            char c = BinaryStdIn.readChar();
            ch = ls.remove((int)c);
            ls.addFirst(ch);
            BinaryStdOut.write(ch);
        }
        BinaryStdOut.close();
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if ("-".equals(args[0])) {
            MoveToFront.encode();
        } else if ("+".equals(args[0])) {
            MoveToFront.decode();
        }
    }

}