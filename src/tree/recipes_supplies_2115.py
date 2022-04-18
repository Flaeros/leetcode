# topological sort
# supplies are non-dependant nodes (add to queue)
# in_degree array contains recipes and count of dependable ingredients(nodes)
# ing_to_recipe dict contains edges, which recipes depend on ingredient
# while iterating q, decrement in-degree and add recipes with 0 in-degree into result

from collections import deque, defaultdict


class Solution:
    def findAllRecipes(self, recipes, ingredients, supplies):

        in_degree = {}
        ing_to_recipe = defaultdict(set)

        for rec, curr_ingredients in zip(recipes, ingredients):
            for ing in curr_ingredients:
                ing_to_recipe[ing].add(rec)
            in_degree[rec] = len(curr_ingredients)

        result = []
        available = deque(supplies)
        while available:
            supply = available.popleft()
            for recipe in ing_to_recipe[supply]:
                in_degree[recipe] -= 1
                if in_degree[recipe] == 0:
                    available.append(recipe)
                    result.append(recipe)

        return result


print(Solution().findAllRecipes(recipes=["bread", "sandwich", "burger"],
                                ingredients=[["yeast", "flour"], ["bread", "meat"], ["sandwich", "meat", "bread"]],
                                supplies=["yeast", "flour", "meat"]))
