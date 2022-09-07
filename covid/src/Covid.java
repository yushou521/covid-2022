import java.io.*;
import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.*;
import java.util.function.Consumer;

public class Covid {
    public static void main(String[] args) throws IOException {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("C:\\Users\\rongmeng\\Desktop\\code\\covid2022\\README.md");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));


        Set<String> set = new HashSet<>();
        String str = null;
        System.out.println("=========重复内容=========");
        while ((str = bufferedReader.readLine()) != null) {
            if (set.contains(str)) {
                System.out.println(str);
            } else {
                if (str.length() > 0) {
                    set.add(str);
                }
            }
        }
        System.out.println("=========重复内容=========");

        //close
        inputStream.close();
        bufferedReader.close();

        List<String> list = Arrays.asList(set.toArray(new String[0]));
        Collections.sort(list, new Comparator<String>() {
            RuleBasedCollator collator = (RuleBasedCollator) Collator.getInstance(Locale.CHINA);

            @Override
            public int compare(String o1, String o2) {
                return collator.compare(o1.charAt(0)+"", o2.charAt(0)+"");
            }
        });
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
