public class Driver
{
    public static void main(String[] args){
        Phrase a = new Phrase("xyaaabbbxbxabyx");
        a.replaceNthOccurrence("ab", 2, "rr");
        System.out.println(a.toString());
        System.out.println(a.findLastOccurrence("ab"));
    }
}
