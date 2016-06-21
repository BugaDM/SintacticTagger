import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class Tagger {

	/*
	 * NN=sustantivo NNP=nombre propio singular NNPS=nombre propio plurar
	 * NNS=sustantivo plural
	 */
	public final static String[] tags = { "NN", "NNP", "NNPS", "NNS" };

	public static void main(String[] args) {
		MaxentTagger tagger = new MaxentTagger("libs/models/english-bidirectional-distsim.tagger");
		List<String> tagsList = Arrays.asList(tags);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the text you want to analyze: ");
		String text = sc.nextLine();
		String taggedText = tagger.tagString(text);

		String[] pairs = taggedText.split(" ");

		ArrayList<String> matchedTags = new ArrayList<String>();
		
		for (String s : pairs) {
			String[] pair = s.split("_");
			if (tagsList.contains(pair[1]))
				matchedTags.add(pair[0]);
			System.out.print(pair[0] + " = ");
			switch (pair[1]) {
			case "CC":
				System.out.print("Coordinating conjunction");
				break;
			case "CD":
				System.out.print("Cardinal number");
				break;
			case "DT":
				System.out.print("Determiner");
				break;
			case "EX":
				System.out.print("Existential there");
				break;
			case "FW":
				System.out.print("Foreign word");
				break;
			case "IN":
				System.out.print("Preposition or subordinating conjunction");
				break;
			case "JJ":
				System.out.print("Adjective");
				break;
			case "JJR":
				System.out.print("Adjective, comparative");
				break;
			case "JJS":
				System.out.print("Adjective, superlative");
				break;
			case "LS":
				System.out.print("List item marker");
				break;
			case "MD":
				System.out.print("Modal");
				break;
			case "NN":
				System.out.print("Noun, singular or mass");
				break;
			case "NNS":
				System.out.print("Noun, plural");
				break;
			case "NNP":
				System.out.print("Proper noun, singular");
				break;
			case "NNPS":
				System.out.print("Proper noun, plural");
				break;
			case "PDT":
				System.out.print("Predeterminer");
				break;
			case "POS":
				System.out.print("Possessive ending");
				break;
			case "PRP":
				System.out.print("Personal pronoun");
				break;
			case "PRP$":
				System.out.print("Possessive pronoun");
				break;
			case "RB":
				System.out.print("Adverb");
				break;
			case "RBR":
				System.out.print("Adverb, comparative");
				break;
			case "RBS":
				System.out.print("Adverb, superlative");
				break;
			case "RP":
				System.out.print("Particle");
				break;
			case "SYM":
				System.out.print("Symbol");
				break;
			case "TO":
				System.out.print("to");
				break;
			case "UH":
				System.out.print("Interjection");
				break;
			case "VB":
				System.out.print("Verb, base form");
				break;
			case "VBD":
				System.out.print("Verb, past tense");
				break;
			case "VBG":
				System.out.print("Verb, gerund or present participle");
				break;
			case "VBN":
				System.out.print("Verb, past participle");
				break;
			case "VBP":
				System.out.print("Verb, non­3rd person singular present");
				break;
			case "VBZ":
				System.out.print("Verb, 3rd person singular present");
				break;
			case "WDT":
				System.out.print("Wh­determiner");
				break;
			case "WP":
				System.out.print("Wh­pronoun");
				break;
			case "WP$":
				System.out.print("Possessive wh­pronoun");
				break;
			case "WRB":
				System.out.print("Wh­adverb");
				break;
			}
			System.out.println();

		}
		System.out.println();
		System.out.print("Tags: ");
		for(String tag : matchedTags){
			System.out.print(tag+", ");
		}
		sc.close();

	}

	public static ArrayList<String> getTags(String a, MaxentTagger tagger) {

		// Pasa el array de tags a lista
		List<String> tagsList = Arrays.asList(tags);

		// Analiza el string
		String tagged = tagger.tagString(a);

		// Separa los pares palabra/tipo [EJ: furiously/RB]
		String[] pairs = tagged.split(" ");

		// Coge solo las palabras que nos interesan (sustantivos)
		ArrayList<String> matchedTags = new ArrayList<String>();
		for (String s : pairs) {
			String[] pair = s.split("_");
			if (tagsList.contains(pair[1]))
				matchedTags.add(pair[0]);
		}

		return matchedTags;

	}

}
