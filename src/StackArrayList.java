import java.util.ArrayList;

public class StackArrayList<T> extends Stack<T> {

    private ArrayList<T> miListaInterna;

    public StackArrayList() {
        miListaInterna = new ArrayList<T>();
    }

}
