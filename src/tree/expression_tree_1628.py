import abc
from abc import ABC, abstractmethod
from typing import List

"""
This is the interface for the expression tree Node.
You should not remove it, and you can define some classes to implement it.
"""


class Node(ABC):
    @abstractmethod
    # define your fields here
    def evaluate(self) -> int:
        pass


class NumNode(Node):
    def __init__(self, num):
        self.num = num

    def evaluate(self):
        return self.num


class OpNode(Node):
    def __init__(self, left, right):
        self.left: Node = left
        self.right: Node = right

    def evaluate(self) -> int:
        pass


class PlusNode(OpNode):
    def evaluate(self) -> int:
        return self.left.evaluate() + self.right.evaluate()


class MinusNode(OpNode):
    def evaluate(self) -> int:
        return self.left.evaluate() - self.right.evaluate()


class MultiplyNode(OpNode):
    def evaluate(self) -> int:
        return self.left.evaluate() * self.right.evaluate()


class DivideNode(OpNode):
    def evaluate(self) -> int:
        return self.left.evaluate() // self.right.evaluate()


"""    
This is the TreeBuilder class.
You can treat it as the driver code that takes the postinfix input
and returns the expression tree represnting it as a Node.
"""


class TreeBuilder(object):
    def buildTree(self, postfix: List[str]) -> 'Node':
        operators = {'+': PlusNode, '-': MinusNode, '*': MultiplyNode, '/': DivideNode}
        stack = []
        for elem in postfix:
            if elem in operators:
                right = stack.pop()
                left = stack.pop()
                result = operators[elem](left, right)
                stack.append(result)
            else:
                result = NumNode(int(elem))
                stack.append(result)

        return stack[0]


obj = TreeBuilder()
expTree = obj.buildTree(["3", "4", "+", "2", "*", "7", "/"])
print(expTree.evaluate())

obj = TreeBuilder()
expTree = obj.buildTree(["4","5","2","7","+","-","*"])
print(expTree.evaluate())
