package etc;


public class test01 {

    public static void main(String[] args) {
        
        System.out.println(search("abcdefg", 3));
        
    }

    public static boolean search(String target, int key) {

        int ans = 0;

        boolean[] arr = new boolean[128];
        for (int i = 0; i < target.length(); i++) {
            int val = target.charAt(i);

            if (arr[val]) return true;
            else arr[val] = true;
        }

        return false;

        
    }
    
}