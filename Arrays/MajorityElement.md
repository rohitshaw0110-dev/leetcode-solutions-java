Majority Element

## 📝 Problem Summary
You are given an integer array `nums` of size `n`.  
The **majority element** is the element that appears **more than ⌊n/2⌋ times**.

It is guaranteed that the majority element **always exists**.

Return the majority element.

---

## 💡 Optimal Solution — Boyer–Moore Voting Algorithm

The Boyer–Moore algorithm is the most efficient method to find the majority element.

### Key Insight:
If an element appears more than `n/2` times, then:
- It “cancels out” all other elements,
- And is guaranteed to be the last remaining candidate after full traversal.

We maintain two variables:

- `candidate` → current potential majority  
- `count` → number of votes for candidate

### Rules:
1. If `count == 0`, pick the current number as new candidate.
2. If the number equals the candidate, increment `count`.
3. Else, decrement `count`.

At the end, `candidate` is the majority element (guaranteed by problem constraints).

---

## ✅ Java Code (LeetCode Submission)

```java
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
🔍 Example
Example 1
Input:
nums = [3, 2, 3]
Output:
3

Example 2
Input:
nums = [2,2,1,1,1,2,2]
Output:
2

🧠 Why the Algorithm Works (Short Explanation)
Think of the array as a voting system:

The majority element always has more “votes” than all others combined.

Each time a different element appears, it cancels out one vote.

Since the majority cannot be outnumbered, it will always survive until the end.

🧪 Local Testing
To run locally, use a Main.java with:

java
Copy code
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(sol.majorityElement(nums)); // Output: 2
    }
}
✔️ Summary
Simple

Elegant

Optimal

Most common interview solution

Guaranteed correct because majority element always exists




