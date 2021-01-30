#!/bin/python3

import math
import os

class TreeNode:
    def __init__(self, value, children):
        self.value = value
        self.children = children
        self.total_sum = None
    def __repr__(self):
        return "TreeNode(%s, %s)" % (self.value, self.total_sum)

def build_tree(tree_values, tree_edges):
    tree_nodes = [TreeNode(v, set()) for v in tree_values]
    for node_from, node_to in tree_edges:
        tree_nodes[node_from - 1].children.add(tree_nodes[node_to - 1])
        tree_nodes[node_to - 1].children.add(tree_nodes[node_from - 1])
    return tree_nodes[0]

def is_even_number(value):
    return not value & 1 

def populate_tree_sums(root):
    stack = (root, None)
    visited = set()

    while stack:
        selected_node = stack[0]

        if selected_node not in visited:
            visited.add(selected_node)
            for child in selected_node.children:
                child.children.remove(selected_node)
                stack = (child, stack)
        else:
            stack = stack[-1]
            selected_node.total_sum = sum(
                map(
                    lambda tn: tn.total_sum, 
                    selected_node.children
                )
            ) + selected_node.value

def find_best_balanced_forest(root):
    stack = (root, None)
    visited, visited_sums, root_complement_sums = set(), set(), set()
    min_result_value = math.inf

    while stack:
        selected_node = stack[0]
        if selected_node not in visited:
            visited.add(selected_node)
            for child in selected_node.children:
                stack = (child, stack)
            selected_sum_comp = root.total_sum - selected_node.total_sum
            root_complement_sums.add(selected_sum_comp)
            if (
                    (selected_node.total_sum * 2) in visited_sums or 
                    (root.total_sum - selected_node.total_sum * 2) in visited_sums
                ) and selected_node.total_sum * 3 >= root.total_sum:

                candidate_value = selected_node.total_sum * 3 - root.total_sum
                if candidate_value < min_result_value:
                    min_result_value = candidate_value
        else:
            if (selected_node.total_sum * 2) == root.total_sum:
                candidate_value = selected_node.total_sum
                if candidate_value < min_result_value:
                    min_result_value = candidate_value
            if (
                    (
                        selected_node.total_sum in visited_sums or
                        selected_node.total_sum in root_complement_sums
                    ) and selected_node.total_sum * 3 >= root.total_sum
               ):
                candidate_value = selected_node.total_sum * 3 - root.total_sum
                if candidate_value < min_result_value:
                    min_result_value = candidate_value
            
            selected_sum_comp = root.total_sum - selected_node.total_sum
            if is_even_number(selected_sum_comp):
                selected_sum_comp_half = selected_sum_comp // 2
                if selected_sum_comp_half > selected_node.total_sum and (
                        selected_sum_comp_half in visited_sums or
                        selected_sum_comp_half in root_complement_sums
                    ):
                    candidate_value = selected_sum_comp_half - selected_node.total_sum 
                    if candidate_value < min_result_value:
                        min_result_value = candidate_value
            root_complement_sums.remove(selected_sum_comp)
            visited_sums.add(selected_node.total_sum)
            stack = stack[-1]

    if min_result_value == math.inf:
        min_result_value = -1
    return min_result_value

def balancedForest(tree_values, tree_edges):
    root = build_tree(tree_values, tree_edges)
    populate_tree_sums(root)
    return find_best_balanced_forest(root)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input())

    for q_itr in range(q):
        n = int(input())

        c = list(map(int, input().rstrip().split()))

        edges = []

        for _ in range(n - 1):
            edges.append(list(map(int, input().rstrip().split())))

        result = balancedForest(c, edges)

        fptr.write(str(result) + '\n')

    fptr.close()
