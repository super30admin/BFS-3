#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 15 09:21:09 2019

@author: tanvirkaur
"""

import collections
class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        queue = collections.deque([s])
        found = False
        result =[]
        hset = set([s])
        while queue:
            substr = queue.popleft()
            if self.isValid(substr):
                found = True
                result.append(substr)
            if found: continue  
            for i in range(len(substr)):
                if substr[i] not in ('(', ')'): continue
                newstr = substr[:i] + substr[i+1:]
                if newstr not in hset:
                    queue.append(newstr)
                    hset.add(newstr)                    
        return result

    def isValid(self, s):
        count = 0
        for c in s:
            if c == '(': count += 1
            elif c == ')':
                if count == 0:return False
                count += -1
        return count == 0