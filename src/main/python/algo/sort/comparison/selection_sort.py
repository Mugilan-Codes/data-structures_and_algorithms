# Better than Bogo Sort
# sets a minimum number in the list and compares it against the list.
# add the minimum number each time to a new list

import sys

from load import load_numbers

# pass in file to load
# python selection_sort.py numbers/5.txt
numbers = load_numbers(sys.argv[1])


def selection_sort(values):
    sorted_list = []

    for _ in range(0, len(values)):
        index_to_move = index_of_min(values)
        sorted_list.append(values.pop(index_to_move))

    return sorted_list


def index_of_min(values):
    min_index = 0

    for i in range(1, len(values)):
        if values[i] < values[min_index]:
            min_index = i

    return min_index


# print(numbers)
print(selection_sort(numbers))
