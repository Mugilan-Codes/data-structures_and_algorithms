# REF: Binary Search Implementations - https://teamtreehouse.com/library/introduction-to-algorithms/algorithms-in-code/binary-search-implementations
# Time Complexity - O(log n) (or) logorithmic runtime
# Space Complexity - O(1) (or) constant space


def binary_search(list, target):
    first = 0
    last = len(list) - 1

    while first <= last:
        midpoint = (first + last) // 2

        if list[midpoint] == target:
            return midpoint
        elif list[midpoint] < target:
            first = midpoint + 1
        else:
            last = midpoint - 1

    return None


def verify(index):
    if index is not None:
        print(f"Target found at index: {index}")
    else:
        print("Target not found in list")


# TODO: values must be sorted
# numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
numbers = [i for i in range(1, 11)]

result = binary_search(numbers, 12)
verify(result)

result = binary_search(numbers, 6)
verify(result)
