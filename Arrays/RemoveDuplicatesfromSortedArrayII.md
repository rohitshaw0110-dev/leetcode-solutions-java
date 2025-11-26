Remove Duplicates from Sorted Array II

## 📝 Problem Summary
You are given a sorted integer array `nums`.  
Modify it **in-place** so that **each unique element appears at most twice**.

Return:
- `k` → the number of valid elements after removal
- The first `k` elements of `nums` should contain the result
- Anything beyond index `k-1` does not matter

---

## 💡 Key Insight — Compare with the element two positions before

Because array is sorted:
- Duplicates appear together
- We can allow **two** occurrences, but skip the rest

We use:
- `k` → write pointer  
- Start `k = 2` (first two elements always allowed)

### Keep `nums[i]` ONLY IF:
```java
nums[i] != nums[k - 2]
This ensures:

If value already appeared twice → skip it

Otherwise → keep it

🚀 Approach
If length ≤ 2 → already valid

Set k = 2

Loop from index i = 2 to end

Keep nums[i] only when it's not equal to nums[k-2]

Return k

✅ Java Code (LeetCode version)
java
Copy code
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int k = 2; // next write position

        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
🧪 Example 1
Input:
nums = [1,1,1,2,2,3]

Output:

ini
Copy code
k = 5
nums = [1,1,2,2,3,_]
🧪 Example 2
Input:
nums = [0,0,1,1,1,1,2,3,3]

Output:

ini
Copy code
k = 7
nums = [0,0,1,1,2,3,3,_,_]
