Remove Duplicates from Sorted Array

## 📝 Problem Summary
Given a sorted integer array `nums`, remove duplicates **in-place** such that each unique element appears only once.  
The **relative order** of elements must remain the same.

Return `k` — the number of unique elements.

After removal:
- The first `k` elements of `nums` must contain the unique values.
- Values beyond `k-1` **do not matter**.

---

## 💡 Approach — Two Pointer Technique

Because the array is sorted, duplicates appear next to each other.

We use:
- `k` → write pointer for next unique position
- `i` → loop through the array

### Logic:
1. First element is always unique → set `k = 1`
2. For each index `i` from 1 to end:
   - If `nums[i] != nums[i - 1]` → copy to `nums[k]` & increment `k`

Once done, first `k` items are unique.

---

## ✅ Java Code (LeetCode version)

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
🧪 Example
Input:

ini
Copy code
nums = [0,0,1,1,1,2,2,3,3,4]
Output:

ini
Copy code
k = 5
nums = [0,1,2,3,4,_,_,_,_,_]
Underscores (_) represent don't-care values.
