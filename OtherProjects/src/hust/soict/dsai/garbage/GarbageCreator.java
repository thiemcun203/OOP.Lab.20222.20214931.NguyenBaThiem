package hust.soict.dsai.garbage;
import java.util.List;
import java.util.ArrayList;


public class GarbageCreator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            for (int i = 0; i < 10000; i++) {
                String s = new String("garbage");
                list.add(s);
            }
            list.clear();
        }
    }
}
