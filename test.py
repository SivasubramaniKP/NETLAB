from typing import *
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        

        def DFS(index):
            if index == len(nums) - 1:
                return [[nums[index]]]
            
            perms = DFS(index + 1)
            res = []
            for perm in perms:
                for i in range(len(perm) + 1):
                    temp = perm.copy()
                    temp.insert(i, nums[index])
                    res.append(temp.copy())

            return res
        return DFS(0)
                   
s = Solution()
print(s.permute([1, 2, 3]))