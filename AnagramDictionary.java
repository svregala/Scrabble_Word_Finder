// Name: Steve Regala
// USC NetID: sregala
// CS 455 PA4
// Fall 2021

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.util.ArrayList;


/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */
public class AnagramDictionary {

   /**
    Representation Invariant:
    - sortedDict must be formed from a valid, existing dictionary without any duplicates
    NOTE: the variable name is sortedDict because it holds a map with the key as the canonical form of word, and
          the value of each key is the array list of the words that could be made using the canonical form of the word>
    */
   private Map<String, ArrayList<String>> sortedDict;


   /**
      Create an anagram dictionary from the list of words given in the file indicated by fileName.
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
      @throws IllegalDictionaryException  if the dictionary has any duplicate words
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException,
                                                    IllegalDictionaryException {

      sortedDict = new HashMap<String, ArrayList<String>>();

      File file = new File(fileName);  // FileNotFoundException is thrown here
      Scanner in = new Scanner(file);

      while (in.hasNext()) {

         String tempWord = in.next();

         if (!sortedDict.containsKey(sortString(tempWord))) {
            ArrayList<String> newArrayList = new ArrayList<>();
            newArrayList.add(tempWord);
            sortedDict.put(sortString(tempWord), newArrayList);
         }
         else {
            ArrayList<String> existingArrayList = sortedDict.get(sortString(tempWord));
            if (existingArrayList.contains(tempWord)) {
               throw new IllegalDictionaryException("ERROR: Illegal dictionary: dictionary file has a duplicate word: " + tempWord);
            }
            else {
               existingArrayList.add(tempWord);
               sortedDict.put(sortString(tempWord), existingArrayList);
            }
         }

      }

   }


   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param string string to process
      @return a list of the anagrams of string
    */
   public ArrayList<String> getAnagramsOf(String string) {

      ArrayList<String> result = new ArrayList<>();
      String sortedString = sortString(string);

      if (sortedDict.containsKey(sortedString)) {
         result.addAll(sortedDict.get(sortedString));
      }

      return result;
   }



   // ------------------------------- PRIVATE HElPER METHODS BELOW -------------------------------



   /**
      This is a private helper method to sort a given string in alphabetical order (this is used in inserting the
      key-values into our instance variable, sortedDict, of type HashMap). This puts the string into our canonical form.
      @param s  represents the string to be sorted
      @return  the sorted version of the given string
    */
   private String sortString(String s) {

      char charArr[] = s.toCharArray();      // convert string to a character array
      Arrays.sort(charArr);                  // use sort method of Arrays class
      return new String(charArr);            // convert sorted array into String (String array constructor), built-in Java API

   }

}