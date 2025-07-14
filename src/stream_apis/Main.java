package stream_apis;

public class Main {
    public static void main(String[] args) {
        // "Java is very popular programming language"
        String str = "Java is very popular programming language";
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(!str.substring(i+1, charArray.length).contains(String.valueOf(charArray[i]))) {
                System.out.println("First non-repeating char : " + charArray[i]);
                break;
            }
        }


    }
}