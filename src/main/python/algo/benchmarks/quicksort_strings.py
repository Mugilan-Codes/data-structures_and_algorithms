import sys

from load import load_strings

names = load_strings(sys.argv[1])


def quicksort(values):
    if len(values) <= 1:
        return values

    pivot = values[0]

    less_than_pivot = []
    greater_than_pivot = []

    for value in values[1:]:
        if value <= pivot:
            less_than_pivot.append(value)
        else:
            greater_than_pivot.append(value)

    return quicksort(less_than_pivot) + [pivot] + quicksort(greater_than_pivot)


sorted_names = quicksort(names)
for n in sorted_names:
    print(n)

# put this in a new file using
# python quicksort_strings.py names/unsorted.txt > names/sorted.txt
