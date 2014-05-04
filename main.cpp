#include <cstdlib>
#include <iostream>
#define N 12
using namespace std;
//int N = 4;
int T[N][N];// = {{10,4,7,9},{6,5,8,12},{0,4,6,7},{5,7,9,1}};
int mejorCosto =29999 ;
void llenaMatriz()
{
     int i,j;
   for ( i=0;i<N;i++)
     for ( j=0;j<N;j++)
       T[i][j] = rand() % 100;
   
 }
 
int diferencia(int a,int b)
{
       if ( a > b ) return a-b ;
       return b-a ;
}


void camino(int i, int j, int costoActual,int pasos)
{
     if ((i>=0) && ( i < N) && ( j < N) && ( j >= 0)&& ( pasos < N*3))
     {
            
         if ((i==N-1)&&(j==N-1)) 
           if (costoActual < mejorCosto )
            {
                mejorCosto = costoActual;
                 printf("entre a la matriz costo actual = %d  pasos = %d  \n",mejorCosto,pasos);
            } 
         if ( i+1 <N )
              camino(i+1,j,costoActual + diferencia(T[i][j],T[i+1][j]),pasos+1);                             
         if ( j+1 <N )
              camino(i,j+1,costoActual + diferencia(T[i][j],T[i][j+1]),pasos+1);
         if ( i-1 >=0 )
              camino(i-1,j,costoActual + diferencia(T[i][j],T[i-1][j]),pasos+1);
         if ( j-1 >= 0 )
              camino(i,j-1,costoActual + diferencia(T[i][j],T[i][j-1]),pasos+1);                             
     }
   }                       
                             

int main(int argc, char *argv[])
{
    srand(time(NULL));
    llenaMatriz();
    camino(0,0,0,0);
    system("PAUSE");
    return EXIT_SUCCESS;
}
