class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length -1;
        int carry = 1;
        int[] ans = new int[digits.length + 1];
        while (i >= 0){
            ans[i + 1] = (digits[i] + carry) % 10;
            carry = (digits[i--] + carry) / 10;
        }
        ans[0] = carry;
        if (ans[0] == 0) return Arrays.copyOfRange(ans,1,ans.length);
        else return ans;
    }
}