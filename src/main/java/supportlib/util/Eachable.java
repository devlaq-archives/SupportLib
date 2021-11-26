package supportlib.util;

import supportlib.func.*;

public interface Eachable<T>{
    void each(Cons<? super T> cons);
}
