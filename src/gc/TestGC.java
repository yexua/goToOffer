package gc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TestGC {

    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        int[] b = new int[1024 * 10];
        List cache = new ArrayList();
        for (int i = 0; i < 10; i++) {

        }
        HashMap map = new HashMap();
        ConcurrentHashMap h = new ConcurrentHashMap();
        map.get("d");
        h.get("d");
        System.gc();
    }
}
