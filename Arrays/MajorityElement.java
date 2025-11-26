class Solution
{
    static int majorityElement(int [] nums)
    {
        int count = 0;
        int candidate = 0;
        
        for (int num : nums)
        {
            if (count == 0)
            {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }

        int occurrence = 0;
        for (int num : nums)
        {
            if (candidate == num)
            {
                occurrence++;
            }
        }

        if (occurrence > nums.length/2)
        {
            return candidate;
        }
        else 
        {
            return -1;
        }
    }
}
