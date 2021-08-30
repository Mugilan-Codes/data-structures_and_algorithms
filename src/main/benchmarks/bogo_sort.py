# REF: https://teamtreehouse.com/library/algorithms-sorting-and-searching/sorting-algorithms/code-for-bogosort

# Worst sorting algorithm
# randomly shuffles the list until the list is sorted

import random
import sys

from load import load_numbers

# pass in file to load
# python bogo_sort.py numbers/5.txt
numbers = load_numbers(sys.argv[1])


def is_sorted(values):
    for index in range(len(values) - 1):
        if values[index] > values[index + 1]:
            return False

    return True


def bogo_sort(values):
    attempts = 0
    while not is_sorted(values):
        random.shuffle(values)
        attempts += 1

    print(attempts)
    return values


print(numbers)
print(bogo_sort(numbers))
