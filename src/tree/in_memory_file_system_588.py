from typing import List
from collections import defaultdict


class Node:
    def __init__(self):
        self.children = defaultdict(Node)
        self.content = ''


class FileSystem:

    def __init__(self):
        self.root = Node()

    def find(self, path: str):
        if path == '/':
            return self.root
        node = self.root
        for part in path.split("/")[1:]:
            node = node.children[part]
        return node

    def ls(self, path: str) -> List[str]:
        node = self.find(path)
        if node.content:
            return [path.split("/")[-1]]

        return sorted(node.children.keys())

    def mkdir(self, path: str) -> None:
        self.find(path)

    def addContentToFile(self, filePath: str, content: str) -> None:
        node = self.find(filePath)
        node.content += content

    def readContentFromFile(self, filePath: str) -> str:
        return self.find(filePath).content


fileSystem = FileSystem()
print(fileSystem.ls("/"))  # return []
fileSystem.mkdir("/a/b/c")
fileSystem.addContentToFile("/a/b/c/d", "hello")
print(fileSystem.ls("/"))  # return ["a"]
print(fileSystem.readContentFromFile("/a/b/c/d"))  # return "hello"
