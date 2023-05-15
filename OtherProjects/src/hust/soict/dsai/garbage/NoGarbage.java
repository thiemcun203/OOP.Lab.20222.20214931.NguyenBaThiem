package hust.soict.dsai.garbage;
import java.util.List;
import java.util.ArrayList;
public class NoGarbage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s = "garbage";
        while (true) {
            for (int i = 0; i < 10000; i++) {
                list.add(s);
            }
            list.clear();
        }
    }
}

