// Name: Steve Regala
// USC NetID: sregala
// CS 455 PA4
// Fall 2021

import java.util.*;
import java.lang.Character;


/**
 This class has information about Scrabble scores for scrabble letters and words.
 This class works for both upper and lower case versions of the letters.
 */
public class ScoreTable {

   /**
    Representation Invariant:
    - scoreResult is a tree map initialized by a helper method that takes in an array list as an input parameter,
      and this array list of words must be valid words, i.e. no special characters/numbers, only strings of letters
    - scoreResult is a tree map that will hold the resulting words that could be made from the given rack,
      along with their scores
    NOTE: scoreResult is a tree map with words as keys, and the total score of each word as values
    */
   private Map<String, Integer> scoreResult;

   private static final char SUBTRACT_CONSTANT_LOWERCASE = 'a';
   private static final char SUBTRACT_CONSTANT_UPPERCASE = 'A';
   private static final int[] LETTER_VALUES = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};


   /**
      ScoreTable constructor
      Create the ScoreTable object and initialize scoreResult as a tree map initialized by a helper method
      PRE: the array list of words must be valid words, i.e. no special characters/numbers, only strings of letters
      @param listOfWords  in practice, this is the array list that is passed through a helper method that helps initialize scoreResult
    */
   public ScoreTable(ArrayList<String> listOfWords) {
      scoreResult = finalScore(listOfWords);
   }


   /**
    Returns the size of the tree map scoreResult (this is called when we print out how many words we can form with the given rack).
    @return  the size of the tree map scoreResult
    */
   public int getSize() {
      return scoreResult.size();
   }


   /**
      Prints the sorted version of the tree map scoreResult according to how we specified it to sort;
      I implemented a sort function that sorts this tree map by the scores (values) of the keys, in decreasing order.
    */
   public void printSorted() {

      ArrayList<Map.Entry<String, Integer>> listOfEntry = new ArrayList<Map.Entry<String, Integer>>(scoreResult.entrySet());
      listOfEntry.sort(new scoreSort());

      for (int i=0; i<listOfEntry.size(); i++) {
         System.out.println(listOfEntry.get(i).getValue() + ": " + listOfEntry.get(i).getKey());
      }

   }



   // ------------------------------- PRIVATE HElPER METHODS BELOW -------------------------------



   /**
    This is a private helper method that helps initialize the tree map scoreResult.
    Each word from the array list is a key and the value is the total score of that word.
    It calls private helper method computeScore.
    PRE: the array list of words must be valid words, i.e. no special characters/numbers, only strings of letters
    @param listOfWords  an array list of words to put into the tree map
    @return  a tree map used to initialize the private instance variable scoreResult
    */
   private TreeMap<String, Integer> finalScore(ArrayList<String> listOfWords) {

      TreeMap<String, Integer> result = new TreeMap<String, Integer>();

      for (String word:listOfWords) {
         result.put(word, computeScore(word));
      }

      return result;
   }


   /**
      This is a private helper method that computes the score of each word (key) in the tree map scoreResult.
      This method utilizes our given constants declared in the beginning of this class.
      PRE: it must be a string input parameter word that consists of only letters (lower/upper case)
      @param word  this is a string input parameter, must be only letters
      @return  an integer that represents the score of the input word
    */
   private int computeScore(String word) {

      int score = 0;

      for (int i=0; i<word.length(); i++) {
         if (Character.isLowerCase(word.charAt(i))) {
            score += LETTER_VALUES[word.charAt(i) - SUBTRACT_CONSTANT_LOWERCASE];
         }
         else {
            score += LETTER_VALUES[word.charAt(i) - SUBTRACT_CONSTANT_UPPERCASE];
         }
      }

      return score;
   }

}


/**
   This class implements the comparator function according to how I specified it.
   This is called in the printSorted() method; specifically the tree map scoreResult is sorted before being printed.
   It is sorted in descending order of the values of the tree map. This gives us the desired output.
 */
class scoreSort implements Comparator<Map.Entry<String, Integer>> {
   public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
      return b.getValue() - a.getValue();
   }
}