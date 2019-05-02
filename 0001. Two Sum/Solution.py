class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(nums) < 1:
            return False
        ad_dict = {}
        for i in range(len(nums)):
            if target - nums[i] in ad_dict:
                return [ad_dict[target - nums[i]], i]
            else:
                ad_dict[nums[i]] = i

        return []
