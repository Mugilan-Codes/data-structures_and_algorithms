# REF: Linear Search Implementations -  https://teamtreehouse.com/library/introduction-to-algorithms/algorithms-in-code/linear-search-implementations


def linear_search(list, target):
    """
    Returns the index position of the target in the list if found, else None
    """

    # Loops worst case is Linear Time
    for i in range(0, len(list)):
        if list[i] == target:
            return i

    return None


def verify(index):
    if index is not None:
        print(f"Target found at index: {index}")
    else:
        print("Target not found in list")


# numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
numbers = [i for i in range(1, 10)]

result = linear_search(numbers, 12)
verify(result)

result = linear_search(numbers, 6)
verify(result)
