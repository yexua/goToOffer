package demo;

@FunctionalInterface
public interface Comparators<T> {
    int compar(T o1, T o2);

    boolean equals(Object obj);

    String toString();
}
