import java.io.IOException;

/*
An exception that can be thrown by AnagramDictionary (see comments in AnagramDictionary.java for details).
We already wrote it for you.
 */

/**
   This class reports problems with the dictionary file.
 */
public class IllegalDictionaryException extends IOException {
   public IllegalDictionaryException() {}
   public IllegalDictionaryException(String message)
   {
      super(message);
   }
}
