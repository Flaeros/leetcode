import math


def shortest_path(tree, source, target):
    spt = []
    tree_size = len(tree)
    vertices = []

    for i in range(tree_size):
        vertices.append(math.inf)

    vertices[source] = 0

    while len(spt) != tree_size:
        current_vertice = get_nearest_vertice(vertices, spt)
        spt.append(current_vertice)
        edges = tree[current_vertice]
        for next_vertice, next_length in enumerate(edges):
            if next_vertice not in spt and next_length != 0:
                vertices[next_vertice] = min(vertices[next_vertice], edges[next_vertice] + vertices[current_vertice])

    return vertices[target]


def get_nearest_vertice(vertices, spt):
    vertice, length = math.inf, math.inf

    for i in range(len(vertices)):
        if vertices[i] < length and i not in spt:
            vertice, length = i, vertices[i]

    return vertice


print(shortest_path([[0, 4, 0, 0, 0, 0, 0, 8, 0],
                     [4, 0, 8, 0, 0, 0, 0, 11, 0],
                     [0, 8, 0, 7, 0, 4, 0, 0, 2],
                     [0, 0, 7, 0, 9, 14, 0, 0, 0],
                     [0, 0, 0, 9, 0, 10, 0, 0, 0],
                     [0, 0, 4, 14, 10, 0, 2, 0, 0],
                     [0, 0, 0, 0, 0, 2, 0, 1, 6],
                     [8, 11, 0, 0, 0, 0, 1, 0, 7],
                     [0, 0, 2, 0, 0, 0, 6, 7, 0]
                     ],
                    0, 4))
