import utility.Utility;

public class AddTwoStringProblem {
    public static void main(String[] args) {
        String first = Utility.getStringInput();
        String second = Utility.getStringInput();

        String smallerString = first.length() < second.length() ? first : second;
        String longerString = first.length() > second.length() ? first : second;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < longerString.length(); i++) {
            if(i < longerString.length() - smallerString.length()){
                builder.append(longerString.charAt(i));
            }else  {
                if(smallerString.length() == longerString.length()) {
                    int f = Integer.parseInt(String.valueOf(longerString.charAt(i)));
                    int s = Integer.parseInt(String.valueOf(smallerString.charAt(i)));
                    builder.append(f + s);
                } else  {
                    int f = Integer.parseInt(String.valueOf(longerString.charAt(i)));
                    int s = Integer.parseInt(String.valueOf(smallerString.charAt(Math.abs(smallerString.length() - i))));
                    builder.append(f + s);
                }

            }
        }
        System.out.println(builder);
    }
}
