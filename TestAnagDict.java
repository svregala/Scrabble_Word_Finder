// Name: Steve Regala
// USC NetID: sregala
// CS 455 PA4
// Fall 2021

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TestAnagDict {

   public static void main(String[] args) {

      Scanner in = new Scanner(System.in);
      String nameFile = "";

      try {

         System.out.println("Enter a file name");

         nameFile = in.next();
         AnagramDictionary object1 = new AnagramDictionary(nameFile);
         //object1.printSortedDict(); // implement method when needed
         /*
            // print out dictionary for debugging purposes
           public void printSortedDict() {
               for (Map.Entry<String, ArrayList<String>> entry: sortedDict.entrySet()) {
                  System.out.println(entry.getKey() + " " + entry.getValue());
               }
            }
          */

         System.out.println(object1.getAnagramsOf("rlee"));
         System.out.println(object1.getAnagramsOf("alcm"));
         System.out.println(object1.getAnagramsOf("iderc"));
         System.out.println(object1.getAnagramsOf("ettas"));
         System.out.println(object1.getAnagramsOf("acm"));
         System.out.println(object1.getAnagramsOf("a@cm%&")); //returns an empty set
         System.out.println(object1.getAnagramsOf("ACM"));     // empty set
         System.out.println(object1.getAnagramsOf("acmACM"));  // empty set

      }

      catch (IllegalDictionaryException exception) {
         System.out.println(exception.getMessage());
      }

      catch (FileNotFoundException exception) {
         System.out.println("ERROR: Dictionary file \"" + nameFile + "\" does not exist.");
      }


   }


}