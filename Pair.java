public class Pair<T,P> {
    T key;
    P value;
    public Pair(T t1,P p1) {
        key = t1;
        value = p1;
    }
    public T getKey() {
        return key;
    }
    public P getValue() {
        return value;
    }
}
