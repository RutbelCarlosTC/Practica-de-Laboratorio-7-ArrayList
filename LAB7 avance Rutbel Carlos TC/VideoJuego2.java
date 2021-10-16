package laboratorio7;
import java.util.*;

public class VideoJuego2 {
	
	static Random rand=new Random();
	static int total;
	

	public static void main(String[] args) {
		
		int n1,n2;
		n1=rand.nextInt(10)+1;
		n2=rand.nextInt(10)+1;
		total=n1+n2;
		System.out.println("Número de soldados (Ejercito1): "+n1);
		System.out.println("Número de soldados (Ejercito2): "+n2);
		ArrayList<ArrayList<Soldado>> ejercito1 = new ArrayList<ArrayList<Soldado>>();
		ArrayList<ArrayList<Soldado>> ejercito2 = new ArrayList<ArrayList<Soldado>>();
		
		inicializar(ejercito1);
		inicializar(ejercito2);
		//posiciones aleatorias sin repetir:
		ArrayList<Integer>indexTotal= indexRandom(total);
		ArrayList<Integer>indexEjercito1 = subConjunto(n1,indexTotal);
		ArrayList<Integer>indexEjercito2 = subConjunto(indexTotal,n2);
	
		llenarEjercito(ejercito1,indexEjercito1,1);
		llenarEjercito(ejercito2,indexEjercito2,2);
		
		mostrarTablero(ejercito1,ejercito2);

	}
	public static ArrayList<Integer>indexRandom(int n){
		int fila,col;
		ArrayList<Integer> a =new ArrayList<Integer>();
		fila = rand.nextInt(10);
		col=rand.nextInt(10);
		a.add(fila*10+col);
		for(int i=1;i<n;i++) {
			fila=rand.nextInt(10);
			col=rand.nextInt(10);
			a.add(fila*10+col);
			for(int j=0;j<i;j++) {
				if(a.get(j) == a.get(i)) {
					a.remove(i);
					i--;
				}
						
			}
		}
		return a;
	}
	public static void llenarEjercito(ArrayList<ArrayList<Soldado>> e, ArrayList<Integer>index,int grupo) {
		int fil,col,puntos;
		String nombre;
		Soldado soldado;
		for(int i=0;i<index.size();i++) {
			fil=index.get(i)/10;
			col=index.get(i)%10;
			puntos=rand.nextInt(5)+1;
			nombre="Soldado"+(i+1)+"X"+grupo;
			soldado=new Soldado(nombre,puntos,fil,col);
			e.get(fil).set(col, soldado);
		}
	}
	public static void inicializar(ArrayList<ArrayList<Soldado>> e){
		for(int i=0;i<10;i++) {
			e.add(new ArrayList<Soldado>());
			for(int j=0;j<10;j++) {
				e.get(i).add(null);
			}
		}
	}
	public static void mostrarTablero(ArrayList<ArrayList<Soldado>> a,ArrayList<ArrayList<Soldado>> b){
		ArrayList<ArrayList<Soldado>> todos=unir(a,b);
		for(int i=0;i<todos.get(0).size();i++) 
			System.out.print("\t"+(i+1));
		System.out.println();
		
		for(int i=0;i<todos.size();i++) {
			System.out.print((i+1)+"\t");
			for(int j=0;j<todos.get(i).size();j++) {
				if(todos.get(i).get(j)==null)
					System.out.print("-------\t");
				else {
					String nombre = todos.get(i).get(j).getNombre();
					System.out.print("SOLD"+nombre.substring(nombre.length()-3)+"\t");
				}
					
			}
			System.out.println();
		}
		
	}
	public static ArrayList<ArrayList<Soldado>> unir(ArrayList<ArrayList<Soldado>> a,ArrayList<ArrayList<Soldado>> b) {
		ArrayList<ArrayList<Soldado>> total =new ArrayList<ArrayList<Soldado>>();
		inicializar(total);
		for(int i=0;i<a.size();i++) {	
			for(int j=0;j<a.size();j++) {
				if(a.get(i).get(j)==null && b.get(i).get(j)==null )
					continue;
				else if(a.get(i).get(j)!=null)
					total.get(i).set(j,(a.get(i).get(j)));
				else 
					total.get(i).set(j,(b.get(i).get(j)));
			}
		}
		return total;
		
	}
	//subconjunto  de los 'n' primeros elementos de un ArrayList
	public static ArrayList<Integer> subConjunto(int n,ArrayList<Integer> a){
		ArrayList<Integer> subConjunto =new ArrayList<Integer>();
		for(int i=0;i<n;i++) 
				subConjunto.add(a.get(i));
		return subConjunto;
	}
	//subconjunto  de los 'n' ultimos elementos de un ArrayList
	public static ArrayList<Integer> subConjunto(ArrayList<Integer> a,int n){
			ArrayList<Integer> subConjunto =new ArrayList<Integer>();
			for(int i=(a.size()-n);i<a.size();i++) 
					subConjunto.add(a.get(i));
			return subConjunto;
	}
	
	
	


}
