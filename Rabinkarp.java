public class Rabinkarp {
    public static void rabinKarp(String text, String pattern) {
        int d = 256;       // Number of characters in alphabet
        int q = 101;       // A prime number
        int m = pattern.length();
        int n = text.length();
        int p_hash = 0;    // Hash value for pattern
        int t_hash = 0;    // Hash value for text
        int h = 1;

        // The value of h would be "pow(d, m-1) % q"
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate hash value for pattern and first window
        for (int i = 0; i < m; i++) {
            p_hash = (d * p_hash + pattern.charAt(i)) % q;
            t_hash = (d * t_hash + text.charAt(i)) % q;
        }

        // Slide the pattern over the text
        for (int i = 0; i <= n - m; i++) {
            // If the hash values match, then only check for characters one by one
            if (p_hash == t_hash) {
                if (text.substring(i, i + m).equals(pattern)) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Calculate hash value for next window
            if (i < n - m) {
                t_hash = (d * (t_hash - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t_hash < 0) {
                    t_hash = t_hash + q;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "abedabc";
        String pattern = "abc";
        rabinKarp(text, pattern);
    }
}

    

