import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConjuntoBomRuim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int words = Integer.parseInt(br.readLine());
        List<String> listWords = new ArrayList<>();
        List<String> listGoodOrBad = new ArrayList<>();
        while (words > 0) {
            for (int i = 0; i < words; i++) {
                String word = br.readLine();
                listWords.add(word);
            }
            listGoodOrBad.add(functionGoodorBad(listWords));
            listWords.clear();
            words = Integer.parseInt(br.readLine());
        }
        for (String goodOrBad: listGoodOrBad)
        System.out.println(goodOrBad);

    }

    public static String functionGoodorBad(List<String> words) {
        List<String> copy = new ArrayList<>(List.copyOf(words));
        String isGoodOrBad = "Conjunto Bom";

        for (String word: words) {
            copy.remove(word);
            List<String> w = copy.stream().filter((findWord) -> findWord.startsWith(word)).collect(Collectors.toList());
            if (!w.isEmpty()) {
                isGoodOrBad = "Conjunto Ruim";
            }
            copy.add(word);
        }

        return isGoodOrBad;
    }
}
