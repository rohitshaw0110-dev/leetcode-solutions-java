Rotate Array

## 📝 Problem Summary

Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

### Example 1:
**Input:**  
`nums = [1,2,3,4,5,6,7], k = 3`  
**Output:**  
`[5,6,7,1,2,3,4]`  

**Explanation:**  
- Rotate 1 step → `[7,1,2,3,4,5,6]`  
- Rotate 2 steps → `[6,7,1,2,3,4,5]`  
- Rotate 3 steps → `[5,6,7,1,2,3,4]`

### Example 2:
**Input:** `nums = [-1,-100,3,99], k = 2`  
**Output:** `[3,99,-1,-100]`

---

## 💡 Optimal Solution — Reverse Trick (O(n) Time, O(1) Space)

The optimal approach rotates the array in **three reverse operations**:

1. Reverse the entire array  
2. Reverse the first `k` elements  
3. Reverse the remaining `n - k` elements  

This efficiently rotates the array in-place using constant extra memory.

### Why this works
Rotating right by `k` means the last `k` elements should appear at the front.  
Reversing portions of the array restores the correct relative order.

---

## ✅ Java Code (Efficient, LeetCode-Ready)

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return;

        k = k % n;
        if (k == 0) return;

        reverse(nums, 0, n - 1);     // reverse entire array
        reverse(nums, 0, k - 1);     // reverse first k elements
        reverse(nums, k, n - 1);     // reverse remaining elements
    }

    private void reverse(int[] a, int li, int ri) {
        while (li < ri) {
            int temp = a[li];
            a[li] = a[ri];
            a[ri] = temp;
            li++;
            ri--;
        }
    }
}
🧪 Example Walkthrough
For nums = [1,2,3,4,5,6,7], k = 3:

Reverse all
→ [7,6,5,4,3,2,1]

Reverse first k = 3
→ [5,6,7,4,3,2,1]

Reverse last n-k = 4
→ [5,6,7,1,2,3,4]

📌 Notes
Always reduce k using k = k % n to prevent unnecessary rotations.

This is the solution preferred in interviews and competitive coding.

🧪 Local Testing (Optional)
java
Copy code
public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7};
    int k = 3;
    Solution sol = new Solution();
    sol.rotate(nums, k);
    System.out.println(Arrays.toString(nums));
}
✔️ Summary
Reversal method = fastest + cleanest solution

In-place, constant space

Passes all LeetCode constraints efficiently
