// Name: Steve Regala
// USC NetID: sregala
// CS 455 PA4
// Fall 2021


import java.util.ArrayList;

public class TestScoreTable {

   public static void main(String[] args) {

      ArrayList<String> listArr = new ArrayList<>();
      listArr.add("calm");
      listArr.add("al");
      listArr.add("mal");
      listArr.add("lam");
      listArr.add("am");
      listArr.add("la");
      listArr.add("lac");
      listArr.add("ma");
      listArr.add("clam");
      listArr.add("cam");
      listArr.add("mac");
      ScoreTable object1 = new ScoreTable(listArr);

      object1.printSorted();

   }

}