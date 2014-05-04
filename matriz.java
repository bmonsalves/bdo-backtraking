public class matriz
{
// Atributos //

int[][] M;
int N; // Tamaño de la matriz
int mejorCosto; // Referencia para comparar el costoActual
int y=0; // Numero de llamadas recursivas
int cont=0; //cantidad de veces que no entro al if con recursividad

	// Constructor //

	matriz(int n)
	{
		// Se asigna el valor ingresado como tamaño de la matriz
		N=n;
		// Se asigna un numero mayor al numero de digitos de los valores
		// dentro de la matriz
		mejorCosto = 99;
		// Se crea el objeto matriz de tipo integer
		M = new int[N][N];
		// Se llena la matriz
		llenar();
		// Se muestra en pantalla la matriz resultante
		imprimir();
		// Se buscan todos los caminos posibles de la posicion (0,0)
		// a la posicion (N-1,N-1)
		buscar(0,0,0,0);
		// Se muestra en pantalla el numero de llamadas recursivas resultantes
		System.out.println(" llamadas recursivas = "+y) ;
	}


	// Para llenar la matriz
	private void llenar()
	{
		java.util.Random llenando = new java.util.Random();
		for ( int i=0;i < N ; i++)
		for ( int j=0; j<N ; j++)
		M[i][j] = llenando.nextInt(9);
	}

	// Para imprimir la matriz
	private void imprimir()
	{
		// Se recorre la matriz
		for ( int i=0;i < N ; i++)
		{
			System.out.println();
			for ( int j=0; j<N ; j++)
			// Se muestra el pantalla la matriz resultante
			System.out.print(M[i][j]+" ");
		}
		System.out.println();
	}

	// BACKTRACKING //
	public void buscar(int i, int j, int pasos, int costoActual)
	{
		// Se cuenta el numero de llamadas recursivas
		y++;

		// Se comprueba que las posiciones señaladas esten dentro de la matriz
		// Se comprueba que el numero de pasos sea menor al tamaño total
		// de la matriz para preferenciar la busqueda de caminos con menospasos,
		// y asi finalizar llamadas recursivas innecesarias(pasos < N*N/4)
		// ----
		// Se comprueba que el costo actual es menor al mejor costo,
		// para preferenciar la busqueda de caminos menos costosos,
		// y asi finalizar llamadas recursivas innecesarias
		//(costoActual<mejorCosto))
		if ((( i>-1) && ( j>-1) && ( i<N) && ( j<N)) && (pasos < N*3) && (costoActual<mejorCosto))
		{
			// CASOS DIRECTOS //

			// Se comprueba si se llego al final del camino
			if (( i==N-1)&&(j==N-1))
				{
					System.out.println("recorrido completo");
					cont = 0;
					// Se comprueba si el costo actual es menor que el mejor costo
					// para preferenciar la busqueda de caminos menos costosos
					// y asi finalizar llamadas recursivas innecesarias
				if ( costoActual<mejorCosto)
				{
					mejorCosto = costoActual;
					System.out.println("costo = "+ costoActual + " pasos = "+pasos);
				}
			}

			// CASOS RECURSIVOS //

			if ( i+1 <N){
				buscar(i+1,j,pasos+1,costoActual + Math.abs(M[i][j] - M[i+1][j]));
				//System.out.println("derecha = "+M[i+1][j]);
			}
			if ( j+1 <N){
				buscar(i,j+1,pasos+1,costoActual + Math.abs(M[i][j] - M[i][j+1]));
				//System.out.println("abajo = "+M[i][j+1]);
			}
			if ( i-1 >-1){
				buscar(i-1,j,pasos+1,costoActual + Math.abs(M[i][j] - M[i-1][j]));
				//System.out.println("izquierda = "+M[i-1][j]);
			}
			if ( j-1 > -1){
				buscar(i,j-1,pasos+1,costoActual + Math.abs(M[i][j] - M[i][j-1]));
				//System.out.println("arriba = "+M[i][j-1]);
			}
		}else{
			cont++;
			if (cont==30000) {
				System.out.println("no if");
			}
			
		}
	}

	public static void main(String[] args){

		new matriz(10);
	}
}