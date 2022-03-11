class SolutionSimple(object):
    def suggestedProducts(self, products, searchWord):
        if not searchWord:
            return []

        data = {}

        for product in products:
            for i in range(1, len(product) + 1):
                data.setdefault(product[:i], []).append(product)

        result = []
        for i in range(1, len(searchWord) + 1):
            if searchWord[:i] in data:
                raw = data[searchWord[:i]]
                raw.sort()
                result.append(raw[:3])
            else:
                result.append([])

        return result


class SolutionTrie(object):

    def __init__(self):
        self.result_buffer = []
        self.end = '_end'
        self.root = {}

    def build_trie(self, products):
        products.sort()
        for product in products:
            current = self.root
            for char in product:
                current = current.setdefault(char, {})
            current[self.end] = self.end

    def suggestedProducts(self, products, searchWord):
        self.build_trie(products)

        result = []
        for i in range(1, len(searchWord) + 1):
            key = searchWord[:i]
            current = self.root

            exists = True
            for char in key:
                if char in current:
                    current = current[char]
                else:
                    exists = False

            if not exists:
                result.append([])
                continue

            prefix = key
            self.result_buffer = []
            self.dfs_with_prefix(current, prefix)
            result.append(self.result_buffer)

        return result

    def dfs_with_prefix(self, current, prefix):
        if len(self.result_buffer) == 3:
            return

        if self.end in current:
            self.result_buffer.append(prefix)

        for key, val in current.items():
            if self.end != key:
                self.dfs_with_prefix(val, prefix + key)


print(SolutionSimple().suggestedProducts(products=["mobile", "mouse", "moneypot", "monitor", "mousepad"],
                                       searchWord="mouse"))
print(SolutionSimple().suggestedProducts(["havana"], "tatiana"))

print(SolutionTrie().suggestedProducts(products=["mobile", "mouse", "moneypot", "monitor", "mousepad"],
                                       searchWord="mouse"))
print(SolutionTrie().suggestedProducts(["havana"], "tatiana"))
