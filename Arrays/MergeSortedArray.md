Arrays/MergeSortedArray.md
Merge Sorted Array

Problem Summary

You are given two sorted arrays:

 `nums1` of size `m + n`
 `nums2` of size `n`

The first `m` elements in `nums1` are valid, and the last `n` positions are zeros (placeholders).
Your task is to merge nums2 into nums1 as a single sorted array in-place.

Key Insight

If we try to merge from the front, we risk overwriting values in `nums1` that we haven't used yet.

The trick is to merge from the back.
This works because the end of `nums1` has empty space to store the largest elements first.

Optimal Approach — Two Pointers From the End

Use three pointers:

| Pointer         | Meaning                                       |
| --------------- | --------------------------------------------- |
| `i = m - 1`     | Last valid element in nums1                   |
| `j = n - 1`     | Last element in nums2                         |
| `k = m + n - 1` | Last index of nums1 (where we place elements) |

Steps:

1. Compare `nums1[i]` and `nums2[j]`.
2. Put the larger value at `nums1[k]`.
3. Move pointers accordingly.
4. If any elements of `nums2` remain, copy them.

No need to copy remaining elements of `nums1` — they are already in correct order.

Algorithm

i = m - 1
j = n - 1
k = m + n - 1

while i >= 0 and j >= 0:
    place larger of nums1[i] and nums2[j] at nums1[k]
    move pointer of that array backward
    move k--

while j >= 0:
    copy remaining nums2[j] into nums1[k]

Time & Space Complexity

| Complexity | Value           |
| ---------- | --------------- |
| **Time**   | O(m + n)        |
| **Space**  | O(1) (in-place) |

Example

Input:

nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6], n = 3

Output:

[1,2,2,3,5,6]

Summary

* Merge from the back to avoid overwriting.
* Uses two pointers + in-place modification.
* Clean, efficient, optimal solution.
