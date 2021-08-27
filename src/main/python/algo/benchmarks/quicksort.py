# REF: https://teamtreehouse.com/library/algorithms-sorting-and-searching/sorting-algorithms/code-for-quicksort

# Better than Selection Sort and marginally faster than Merge Sort
# Divide and Conquer Technique
# choose a pivot value from the list
# split the list into sublist: left sublist(less than pivot) and right sublist(greater than pivot)

# O(n log n) time - best case
# O(n^2) time - worst case

import sys

from load import load_numbers

# pass in file to load
# python quicksort.py numbers/5.txt
numbers = load_numbers(sys.argv[1])


def quicksort(values):
    if len(values) <= 1:
        return values

    pivot = values[0]

    less_than_pivot = []
    greater_than_pivot = []

    for value in values[1:]:
        if value < pivot:
            less_than_pivot.append(value)
        else:
            greater_than_pivot.append(value)

    return quicksort(less_than_pivot) + [pivot] + quicksort(greater_than_pivot)


sorted_numbers = quicksort(numbers)
print(sorted_numbers)
