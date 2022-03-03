 public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int start = 0;
        int end = nums.length-3;
        int result = 0;
        int old_qw = 0;
        boolean full = true;
        while (start < nums.length-2){
            int qw1 = nums[start] - nums[start+1];
            int qw2 = nums[start+1] - nums[start+2];
            if (start==0) {
                old_qw = qw1;
                if (qw1 == qw2) result++;
            }
            else if (qw1 == qw2 && qw2 == old_qw){
                result += 2;
            }
            else if (qw1 == qw2) {
                result++;
                full = false;
            }
            else  full = false;
            System.out.printf("%d %d\n", qw1, qw2);
            start++;
        }
        if (full && nums.length > 4) result++;
        return result;
    }

/*TEST
[1,2,3,4]
[1,2,3,4, 5]
[7,7,7,7]
[1,3,5,7,9]
[3,-1,-5,-9]
[1,2,3,4,8]
[7,2,3,4,5]
[1,2,3,10,4,5,6]
*/
