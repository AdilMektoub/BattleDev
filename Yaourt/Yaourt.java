package Yaourt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Yaourt {

	public static void nombreOccurenceCouleur(ArrayList<String> list) {
		Map<String, Integer> hm = new HashMap<String, Integer>();

		for (String s : list) {
			Integer j = hm.get(s);
			hm.put(s, (j == null) ? 1 : j + 1);
		}

		TreeMap<String, Integer> tri = new TreeMap<String, Integer>();
		tri.putAll(hm);
		int maxValueInMap = (Collections.max(tri.values())); // retourne le max valeur dans le Hashmap
		for (Entry<String, Integer> entry : tri.entrySet()) { // iteration de hashmap
			if (entry.getValue() == maxValueInMap) {
				System.out.println("les deux couleurs choisie après le sondage: ");
				System.out.println(entry.getKey() + " : " + entry.getValue() + " fois");
				tri.remove(entry.getKey());
				TreeMap<String, Integer> tri2 = new TreeMap<String, Integer>();
				tri2.putAll(tri);
				int maxValueInMap2 = (Collections.max(tri2.values()));
				for (Entry<String, Integer> entry2 : tri2.entrySet()) {
					if (entry2.getValue() == maxValueInMap2) {
						System.out.println(entry2.getKey() + " : " + entry2.getValue() + " fois");
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("veuiller saisir le nombre de personne a interroger?");
		int n = sc.nextInt();
		if (n < 3 && n > 10000) {
			System.out.println("veuillez saisir un nombre entre 3 et 10000");
			n = sc.nextInt();
		} else {
			for (int i = 0; i < n; i++) {
				Scanner cc = new Scanner(System.in);
				String couleur = cc.next();
				list.add(couleur);
			}
			nombreOccurenceCouleur(list);
		}
	}
}
//
// maxValueInMap=(Collections.max(tri.values())); 
// Print the key with max value

//System.out.println("\n ----------informatif-----------");
//for (Map.Entry<String, Integer> val : tri.entrySet()) {
//	
// System.out.println("le couleur " + val.getKey() + " "
//                    + "étais choisie"
//                    + ": " + val.getValue() + " fois"); 
//}

//System.out.println("\n ");
//System.out.println("les deux couleurs choisie après le sondage: ");
//System.out.println(tri.keySet().toArray()[0]); //  ou?	
//System.out.println(tri.lastKey());
