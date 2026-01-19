package Chaînes_caractères_Collections;

import java.util.*;

public class Main {

	//Partie A — Chaînes
	
		//Q1) Normalisation (String,System.out.println( StringBuilder)
	public static  String Normalisation (String S) {
		S=S.toLowerCase();
		S=S.replaceAll("[^a-zàâçéèêëîïôûùüÿñæœ0-9]", " ");
		S=S.replaceAll("\\s+", " ");
		S=S.strip();
		return S; 
	}
		//Q2) Découpage (split) + construction performante
	
	public static  List<String> tokens(String s) {
		String normalize = Normalisation(s);
        String[] words = normalize.split(" ");
        return Arrays.asList(words);
	}
	public static String rebuildSentence(List<String> words) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i));
            if (i < words.size() - 1)
                sb.append(" ");
        }
        return sb.toString();
    }
	
	//Partie B — Collections : List & Set 
	
		//Q3) Stopwords & filtrage
	public static List<String> filterStopwords(List<String> toks, Set<String> stopset) {
	    List<String> filtered = new ArrayList<>();
	    for (String t : toks) {
	        if (!stopset.contains(t)) {
	            filtered.add(t);
	        }
	    }
	    return filtered;
	}
	
	
	

	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		//A
		System.out.println("//A");
		
		String s="	Hiking is great! I love hiking...	";
		System.out.println("Texte before Normalisation: " + s);
		String n = Normalisation(s);
		System.out.println("Texte after Normalisation: " + n);
		List<String> toks = tokens(s);
        System.out.println("Tokens: " + toks);
        System.out.println("Reconstruction: " + rebuildSentence(toks));
		 
        //B
        System.out.println("//B");
        
        String[] RAW_COMMENTS = {
            "Java est génial! J'adore Java...",
            "java, JAVA, JaVa — trop de versions ?",
            "Les listes en Java sont puissantes; des Sets aussi.",
        };

        String STOPWORDS = "est,les,des,en,de,trop";
        Set<String> stopset = new HashSet<>(Arrays.asList(STOPWORDS.split(",")));


        List<String> allWords = new ArrayList<>();

        for (String comment : RAW_COMMENTS) {
            List<String> toks1 = tokens(comment);
            List<String> filtered = filterStopwords(toks1, stopset);
            allWords.addAll(filtered);
        }

        // Unicité & ordre
        Set<String> hashSet = new HashSet<>(allWords);
        Set<String> treeSet = new TreeSet<>(allWords);
        Set<String> linkedHashSet = new LinkedHashSet<>(allWords);

    
        System.out.println("HashSet (sans ordre): " + hashSet);
        System.out.println("TreeSet (trié): " + treeSet);
        System.out.println("LinkedHashSet (ordre d’apparition): " + linkedHashSet);
    
	}
}

