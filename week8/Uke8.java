import  java.util.Iterator;
class VaarArray <T> implements Iterable < T > {
    T  []  array;
    public VaarArray (int strl){
        array = (T[]) new Object[strl];
    }

    public   boolean  settInn ( T elem ){
        for (int i = 0; i < array.length; i++){
            if (array[i] == null){
                array[i] = elem;
                return true;
            }
        }
        return false;
    }
    public   boolean  fjernFraIndex ( int  n ){
        // tilfeller hvor det er tull å sette null.
        if(array.length > n || n < 0){
            return false;
        }
        if (array[n] == null){
            return false;
        }
        array[n] = null;
        return true;
    }
    public   Iterator <T>  iterator (){
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator <T>{
        int posisjon = 0;
        public boolean hasNext(){
            for (int i = posisjon; i < array.length; i++){
                if(array[i] != null){
                    posisjon = i;
                    return true;
                }
            }
            return false;
        }

        public T next(){
            return array[posisjon++];
        }
    }
}















//
