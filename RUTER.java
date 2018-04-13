class Rute{

    abstract void finnUtvei(){

    }

    abstract void gaa(...){

    }
}


class HviteRute extends Rute{
    void finnUtvei(){
        this.gaa();
    }

    void gaa(...){
        if(){
            this.north.gaa(...)
        }else if(){
            this.south.gaa(...)
        } ...

    }
}


class SortRute extends Rute{
    void finnUtvei(){
        System.out.println("NEI!");
    }

    void gaa(...){
    }
}

class Aapning extends Rute{

    void finnUtvei(){
        System.out.println("Dette er en åpning.");
    }
    @Override
    void gaa(...){
        addExit();
    }
}
