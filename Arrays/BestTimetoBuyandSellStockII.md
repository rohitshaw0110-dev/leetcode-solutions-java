Best Time to Buy and Sell Stock II

## 📝 Problem Summary

You are given an integer array `prices`, where `prices[i]` is the price of a stock on day `i`.

You may buy and sell the stock **multiple times**, with the condition that:
- You can hold **at most one** share at a time
- You may buy and sell **on the same day**
- Your goal is to **maximize total profit**

Return the **maximum profit** achievable.

---

## 🔍 Examples

### Example 1
**Input:**  
`prices = [7,1,5,3,6,4]`  
**Output:** `7`  

**Explanation:**  
- Buy at 1, sell at 5 → profit = 4  
- Buy at 3, sell at 6 → profit = 3  
Total profit = **7**

---

### Example 2
**Input:**  
`prices = [1,2,3,4,5]`  
**Output:** `4`  

All rising differences:  
`(2-1) + (3-2) + (4-3) + (5-4) = 4`

---

### Example 3
**Input:**  
`prices = [7,6,4,3,1]`  
**Output:** `0`  

Prices only go down → no profit.

---

## 💡 Optimal Strategy

To maximize profit with unlimited transactions:

> **Accumulate every positive price difference.**

We don’t need to know exact buy or sell days.  
Any time the price increases, that difference is a guaranteed profit opportunity.

This works because multiple transactions are allowed.

---

## ✅ Java Code (Greedy, Efficient)

```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}
