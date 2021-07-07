# from typing import List
# from collections import deque
# import collections
#
#
# class Solution:
#     def removeInvalidParentheses(self, s: str) -> List[str]:
#
#         if s is None: return []
#         result = []
#         queue = deque()
#         queue.append(s)
#         visted = set()
#         visted.add(s)
#         flag = False
#
#         while queue.__len__() > 0 and not flag:
#             size = queue.__len__()
#             for id in range(size):
#                 string = queue.popleft()
#                 if self.isValid(s=string):
#                     flag = True
#                     result.append(string)
#                     visted.add(string)
#                 else:
#                     for j in range(len(string)):
#                         if string[j].isalpha():
#                             continue
#                         child = string[0:j] + string[j + 1:]
#                         if child not in visted:
#                             visted.add(child)
#                             queue.append(child)
#         return result
#
#     def isValid(self, s: str) -> bool:
#         stack = []
#         for character in s:
#             if character == '(':
#                 stack.append(')')
#
#             elif stack.__len__() == 0 or stack.pop() != character:
#                 return False
#
#         return stack.__len__() == 0
#
#
# s = "()())()"
# print(Solution().removeInvalidParentheses(s=s))
#
#
#names = ['Louis IX', 'Louis VIII', 'Maria III', 'Oscar IV', 'Adams XXX', 'Anuar III', 'Maria III', 'Oscar V']
names = ['Steven XL','Steven XVI', 'David IX', 'Mary XV', 'Mary XIII','Mary XX']

def sortRoman(names):
    names_separated = []
    age_separated = []
    for i in range(len(names)):
        separated = names[i].split()
        for j in range(len(separated)):
            if j % 2 == 0:
                names_separated.append(separated[j])
            else:
                age_separated.append(separated[j])

    list_full_ordered = zip(names_separated, age_separated)
    return list(sorted(list_full_ordered))


if __name__ == "__main__":
    print(sortRoman(names))