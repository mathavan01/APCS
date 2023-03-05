import java.util.*;
public class HiddenWord
{
    private String hiddenWord;
    public HiddenWord(String hiddenWord){
        this.hiddenWord = hiddenWord;
    }
    public String getHint(String guess){
        String hint = "";
        for (int i = 0; i < hiddenWord.length(); i++){
            if (guess.charAt(i) == hiddenWord.charAt(i)){
                hint += hiddenWord.charAt(i);
            } else if (hiddenWord.indexOf(guess.charAt(i)) != -1){
                hint += "+";
            } else {
                hint += "*";
            }
        }
        return hint;
    }
}
