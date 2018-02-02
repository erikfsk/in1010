class  A  {}
class  B  extends  A  {}
class  C  extends  A  {}
class  D  extends  C  {}

class   TrueOrFalse  {
  public   static   void  main ( String []  args )  {
    A a  =   new  A ();
    B b  =   new  B ();
    C c  =   new  C ();
    D d  =   new  D ();
    A e  =   new  D ();
    A f  =   new  B ();
    System . out . println ( "a) "   +   ( b  instanceof  A ));
    System . out . println ( "b) "   +   ( c  instanceof  D ));
    System . out . println ( "c) "   +   ( d  instanceof  A ));
    System . out . println ( "d) "   +   ( e  instanceof  C ));
    System . out . println ( "e) "   +   ( f  instanceof  C ));
  }
}
