import  java . util . Iterator;
class VaarArray < T > implements Iterable < T > {
    T  []  array;
    public VaarArray (int strl){
        array = (T[]) new Object[strl];
    }

    public   boolean  settInn ( T elem ){
        for (int i = 0; i < arr.length; i++){
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
    public   Iterator < T >  iterator (){

    }
    private class ArrayIterator implements Iterator < T >{
        int posisjon = 0;
        int teller = 0;
        public boolean hasNext(){
            if (teller == 0){
                if(array[0] != null){
                    pos = 0;
                    return true;
                }
            }
            for (int i = pos+1; i < array.length; i++){
                if(array[i] != null){
                    pos = i;
                    return true;
                }
            }
            return false;
        }

        public T next(){
            teller++;
            return array[pos];
        }
}















//
