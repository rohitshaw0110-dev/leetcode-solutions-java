Jump Game
📝 Problem Summary

You are given an integer array nums where each element represents the maximum jump length from that position.
You start at index 0 and want to determine whether you can reach the last index.

Return:

true → if it is possible to reach the last index

false → otherwise

🔍 Examples
Example 1

Input:
nums = [2,3,1,1,4]
Output: true
Explanation:
Jump 1 step → index 1, then jump 3 steps → reach index 4.

Example 2

Input:
nums = [3,2,1,0,4]
Output: false
Explanation:
You get stuck at index 3 because its jump length is 0.

💡 Approach: Greedy (Optimal)

Track the farthest index reachable while scanning the array from left to right.

Key Ideas

Maintain a variable furthest that stores the maximum index reachable so far.

At index i:

If i > furthest, then index i is unreachable → return false.

Otherwise extend reach:
furthest = max(furthest, i + nums[i])

If furthest >= last index, return true.

This greedy method is optimal because:

You always track the best reachable index.

You never need to check all possible jump paths.

✅ Java Solution
class Solution {
    public boolean canJump(int[] nums) 
    {
        if (nums == null || nums.length == 0) return false;

        int n = nums.length;
        int furthest = 0;

        for (int i = 0; i < n; i++)
        {
            // If we reach an index beyond the current reachable range
            if (i > furthest) return false;

            // Update the furthest reachable index
            furthest = Math.max(furthest, i + nums[i]);

            // If we can reach or pass the last index
            if (furthest >= n - 1) return true; 
        }

        // Final defensive check
        return furthest >= n - 1;
    }
}

🧪 Example Dry Run (nums = [2,3,1,1,4])
i	nums[i]	furthest before	i + nums[i]	furthest after
0	2	0	2	2
1	3	2	4	4 ← reaches last index

Conclusion → true

🎯 Summary

Track how far you can jump, not how you jump.

If you ever reach an index you cannot jump to → false.

If your reach ever extends past the last index → true.

This greedy approach efficiently solves Jump Game in linear time.
