# Time - O(2 ** n)
# Space - O(n)
# n is the length of the given input string
from collections import deque
def my_func(s):
    # base condition
    if not s or len(s) == 0:
        return ['']
    # final result stored
    opt = []
    # to avoid repeated calculations
    visited = set()
    q = deque()
    q.append(s)
    visited.add(s)
    # if the given string is answer
    if is_valid(s):
        opt.append(s)
    # BFS starts
    while len(q)!= 0:
        size = len(q)# size / levels of BFS


        # If any value in output array , return the answer
        if len(opt) > 0:
            break
        for i in range(size):
            temp = q.popleft()

            for i in range(len(temp)):
                # if temp[i].isalpha():
                #     continue
                # process any/all characters
                if temp[i] != '(' and temp[i] != ')':
                    continue
                new_str = temp[:i] + temp[i+1: len(temp)]
                # we don't want to process the calculated string value again
                if new_str not in visited:
                    if is_valid(new_str):
                        opt.append(new_str)
                    q.append(new_str)
                    visited.add(new_str)

    return opt


def is_valid(s):
    cnt = 0
    for ch in s:
        if ch == ')':
            cnt -= 1
        elif ch == '(':
            cnt += 1

        if cnt < 0:
            return False

    return (cnt == 0)


s = ")(f"
print(my_func(s))
