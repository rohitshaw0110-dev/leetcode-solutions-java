Remove Element
🔍 Problem Summary

You are given an integer array nums and a value val.
Remove all occurrences of val in-place.

After removal:

The first k elements should contain the values ≠ val.

The order does not matter.

Values after index k do not matter.

Return k.

This matches LeetCode's custom judge expectations.

💡 Intuition

We need to keep all elements not equal to val.
The easiest way: use a write pointer (k).

Logic:

Loop through each element.

If it's not equal to val, write it to nums[k] and increment k.

At the end, k is the count of valid elements.

This is efficient, simple, and fully in-place.

🚀 Algorithm
k = 0
for each index i:
    if nums[i] != val:
        nums[k] = nums[i]
        k++

return k

✅ Java Code
class Solution 
{
  public int removeElement(int[] nums, int val) 
  {
    int k = 0;
    
    for (int i = 0; i < nums.length; i++) 
    {
      if (nums[i] != val) 
      {
        nums[k] = nums[i];
        k++;
      }
    }
    
    return k;
  }
}

📝 Example
Input:
nums = [3,2,2,3], val = 3

Output:
k = 2
nums = [2,2,_,_]


Only first 2 elements matter.

📌 Notes

Order of remaining elements does not matter.

Values after index k are irrelevant.

Works efficiently in-place.
