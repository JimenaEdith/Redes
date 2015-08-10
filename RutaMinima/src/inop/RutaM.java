package inop;

public class RutaM {

	/**
	 * @param args
	 */
	public String algoritmo(long [][] alg){
		int vertices=alg.length;
		long matrizAdyacencia[][]=alg;
		String caminos[][]=new String [vertices][vertices];
		String caminosAuxiliares[][]=new String [vertices][vertices];
		String caminoRecorrido="",cadena="",caminitos="";
		int i,j,k;
		float temp1,temp2,temp3,temp4,minimo;
		//Inicializando las matrices camino
		for	(i=0;i<vertices;i++){
			for(j=0;j<vertices;j++){
			caminos[i][j]="";
			caminosAuxiliares[i][j]="";
			}
		}
		for(k=0;k<vertices;k++){
			for(i=0;i<vertices;i++){
				for(j=0;j<vertices;j++){
					temp1=matrizAdyacencia[i][j];
					temp2=matrizAdyacencia[i][k];
					temp3=matrizAdyacencia[i][j];
					temp4=temp2+temp3;
					
					minimo=Math.min(temp1, temp4);
					if(temp1!=temp4){
						if(minimo==temp4){
							caminosAuxiliares[i][j]=k+"";
							caminos[i][j]=caminosR(i,k,caminosAuxiliares,caminoRecorrido)+(k+1);
							
						}
					}
					matrizAdyacencia[i][j]=(long)minimo;
					
                 }
			}
		}
		//camino a cadena
		for(i=0;i<vertices;i++){
			for(j=0;j<vertices;j++){
				cadena=cadena+"["+matrizAdyacencia[i][j]+"]";
			}
		}
	}

}
