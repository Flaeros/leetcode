package array;

public class MajorityElement_169 {
    public static void main(String[] args) {
        System.out.println(new MajorityElement_169().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(new MajorityElement_169().majorityElement(new int[]{3, 2, 3}));
    }

    public int majorityElement(int[] num) {
        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }
}
