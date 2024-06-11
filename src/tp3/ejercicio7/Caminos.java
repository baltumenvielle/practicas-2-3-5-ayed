package tp3.ejercicio7;

import tp3.ejercicio1.GeneralTree;
import java.util.List;
import java.util.LinkedList;

public class Caminos {
	private GeneralTree<Integer> a = new GeneralTree<Integer>();
	
	public Caminos(GeneralTree<Integer> a) {
		this.a = a;
	}
	
	public List<Integer> caminoAHojaMasLejana() {
		List<Integer> caminoActual = new LinkedList<Integer>(), caminoMax = new LinkedList<Integer>();
		if (!a.isEmpty()) caminoHelper(a, caminoActual, caminoMax);
		return caminoMax;
	}
	
	private void caminoHelper(GeneralTree<Integer> a, List<Integer> caminoActual, List<Integer> caminoMax) {
		caminoActual.add(a.getData());
		
		if (!a.isLeaf()) {
			List<GeneralTree<Integer>> children = a.getChildren();
			for (GeneralTree<Integer> child: children) {
				caminoHelper(child, caminoActual, caminoMax);
			}
		}
		if (caminoActual.size() > caminoMax.size()) {
			caminoMax.removeAll(caminoMax);
			caminoMax.addAll(caminoActual);
		}
		
		caminoActual.remove(caminoActual.size()-1); // elimina el ultimo
	}
	
    public static void main(String[] args) {
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subA = new GeneralTree<Integer>(6, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(new GeneralTree<Integer>(10));
        subChildren2.add(subA);
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(17, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(9, subChildren3);
        
        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(16));
        subChildren4.add(new GeneralTree<Integer>(7));
        GeneralTree<Integer> subB = new GeneralTree<Integer>(14, subChildren4);
        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
        subChildren5.add(subB);
        subChildren5.add(new GeneralTree<Integer>(18));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(15, subChildren5);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol);
        
        Caminos cam = new Caminos(a);
        
        System.out.println("Camino a hoja mas lejana: " + cam.caminoAHojaMasLejana());
 }
}
