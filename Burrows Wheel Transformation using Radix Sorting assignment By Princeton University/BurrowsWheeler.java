import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {

    private final static int R = 256;

    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output 
    public static void transform() {
		String str = BinaryStdIn.readString();
		CircularSuffixArray csa = new CircularSuffixArray(str);
		int fst,idx;
		fst = -1;
		StringBuilder res =  new StringBuilder();
		
		for (int i = 0; i < str.length(); i++) {
			idx = csa.index(i);
			if (idx == 0) fst = i;
			idx = idx - 1;
			if (idx < 0) idx += str.length();
			
			res.append(str.charAt(idx));
		}
		BinaryStdOut.write(fst, 32);
		BinaryStdOut.write(res.toString());
		BinaryStdOut.close();
	}

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
		int fst = BinaryStdIn.readInt(32);
		String str = BinaryStdIn.readString();
		int []count = new int[R+1];
		
		// count chars
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i) + 1]++;
		}
		
		// do comulative count
		for (int i = 0; i < R; i++) {
			count[i + 1] += count[i];
		}

		// auxilary array final step
		char[] aux = new char[str.length()];
		int[] nxt = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			aux[count[c]] = c;
			nxt[count[c]] = i;
			count[c]++;
		}
   
        int ln = str.length();
		int ptr = fst;
		while(ln >= 0) {
			BinaryStdOut.write(aux[ptr]);
			ptr = nxt[ptr];
			ln--;
		}
		BinaryStdOut.close();
	}

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
		if ("-".equals(args[0])) {
            BurrowsWheeler.transform();
        } else if ("+".equals(args[0])) {
            BurrowsWheeler.inverseTransform();
        }
	}

}
