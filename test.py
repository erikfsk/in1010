def  hovedprogram (): a  =  3
b  =   3.3
c  =   'Hei'   # Ingen forskjell på " og ' d  =   [ 1 ,   2 ,   3]
e  =   [ a ,  b ,  c]
f  =   { 'a' :   3 ,   'b' :   4}
for  i  in  range ( 10 ): print ( "Tallet er" ,  i)
for  j  in  d: print ( i)
while  a  <   4: print ( a)
a  +=   1;
inp  =  input ( "Hva heter du? ") int_inp  =   int ( inp)
float_inp  =   float ( inp)
hovedprogram () class  A ( object ):
       # Konstruktør
def  __init__ ( self ,  arg1 ,  arg2 ): self . arg1  =  arg1 self . arg2  =  arg2
def  foo ( self ,  bar ): return  bar