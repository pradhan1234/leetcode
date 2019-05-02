# Space Complexity : O(n)
# Time Complexity : O(n)
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
	# we would store complement of a number and its index(because we want to return index)
        for i in range(len(nums)):
            if target - nums[i] in ad_dict:
		# We have found the target - current number in the dictionary and hence we return both the indices
                return [ad_dict[target - nums[i]], i]
            else:
                ad_dict[nums[i]] = i

        return []
