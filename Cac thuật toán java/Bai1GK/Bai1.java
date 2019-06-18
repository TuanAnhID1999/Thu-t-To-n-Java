package De1;

public class Bai1 {
    public static  int find(String s1, String s2, int d){
        String cut = s1.substring(s1.length()-d);
        System.out.println(cut);
        for (int i = 0; i < s2.length(); i++) {
            if(cut.regionMatches(0, s2, i, d)) {
                return i;
            }
        }

        return -1;
    }

    public static String getMaxPostfix(String s1, String s2){
        int count =0;
        for (int i =0; i < s1.length(); i++){
            find(s1,s2,i);
        }
        return  "";
    }

    public static void main(String[] args) {
        String s1 = "abcdbacd";
        String s2 = "cdabacdcbacđabcd";
        System.out.println(find(s1,s2,3));

    }
}
