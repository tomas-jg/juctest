import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class test {
    public static void main(String[] args) {


//        public boolean add(E e) {
//            return map.put(e, PRESENT)==null;
//        }


        Set<String> set = new CopyOnWriteArraySet<>();
                //new HashSet<>();

        for (int i = 0; i <= 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            }).start();
        }
    }
}
