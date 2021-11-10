import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PhanTu<T extends Comparable<T>> {
    public T value;

    public boolean isGreaterThan(T a) {
        if (value.compareTo(a) > 0) {
            return true;
        }
        return false;
    }

    public static void readAndWriteToFile(String fileInput, String fileOutput) {
        try {
            File f1 = new File(fileInput);
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);

            String s = br.readLine();

            File f2 = new File(fileOutput);
            FileWriter fw = new FileWriter(f2);
            BufferedWriter bw = new BufferedWriter(fw);

            List<String> sortArr = new ArrayList<String>();

            while (s != null) {
                sortArr.add(s);
                s = br.readLine();
            }

            Collections.sort(sortArr);
            for (String cur : sortArr) {
                bw.write(cur);
                bw.newLine();
            }

            br.close();
            bw.flush();
            bw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.print("Input: ");

        String name = input.nextLine();

        System.out.print("Output: ");

        String name1 = input.nextLine();

        input.close();
        PhanTu<String> test = new PhanTu<>();
        test.value = "aba";
        System.out.println(test.isGreaterThan("a"));
        readAndWriteToFile(name, name1);

    }
}
