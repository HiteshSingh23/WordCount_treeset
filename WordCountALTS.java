import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class WordCountALTS {

    public static void main(String[] args) {
        String linesRead = " ";
        ArrayList<String> aldata = new ArrayList<String>();
        TreeSet<String> tsdata = new TreeSet<>();
        String tokens[];
        ArrayList<Integer> wordcounts = new ArrayList<>();

        try {
            FileReader fr = new FileReader("C:\\Users\\hitesh\\Ideaprojects\\DataSets\\wcfile.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((linesRead = br.readLine()) != null) {
                tokens = linesRead.split(" ");
                aldata.addAll(Arrays.asList(tokens)); // all words captured in arraylist
                tsdata.addAll(Arrays.asList(tokens)); // set of unique words in treeset

                //aldata.addAll(Arrays.asList(linesRead.split(";"))); // can be simplified like this also.
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // search for frequency of unique words in the list
        for (String s : tsdata) {
            int num = Collections.frequency(aldata, s);
            wordcounts.add(num);
            //System.out.println(val1 + " " + num);
        }

        int count = 0;

        for (String s : tsdata) {
            System.out.println(s + " : " + wordcounts.get(count));

            count++;
        }

    }
}