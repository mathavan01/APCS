public class Phrase
{
    private String currentPhrase;
    public Phrase(String p){
        currentPhrase = p;
    }
    public int findNthOccurrence(String str, int n){
        int count = 0;
        int tempIdx = 0;
        while (count < n){
            if (currentPhrase.indexOf(str, tempIdx) != -1){
                count++;
                tempIdx = currentPhrase.indexOf(str, tempIdx) + str.length();
            } else {
                return -1;
            }
        }
        return tempIdx - str.length();
    }
    public void replaceNthOccurrence(String str, int n, String repl){
        int idx = this.findNthOccurrence(str, n);
        if (idx != -1){
            currentPhrase = currentPhrase.substring(0, idx) + repl + currentPhrase.substring(idx + str.length()); 
        }
    }
    public int findLastOccurrence(String str){
        return currentPhrase.lastIndexOf(str);
    }
    public String toString(){
        return currentPhrase;
    }
}
