import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntrevistaEmbaracosa {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word;

        while ((word = br.readLine()) != null) {
            int size = word.length();
            boolean hasSuffix = false;

            for (int i = 1; i < size; i++) {
                String firstPart = word.substring(0, i);
                String secondPart = word.substring(i);

                if (firstPart.endsWith(secondPart)) {
                    System.out.println(firstPart);
                    hasSuffix = true;
                }
            }

            if (!hasSuffix) {
                System.out.println(word);
            }
        }
    }
}
