# TODO: optimize the code to avoid using list slicing which incurs a cost in python.
# REVIEW: Merge Sort time complexity should be O(n log n)
# REVIEW: Implement in-place sorting?
# REF: Merge Sort in Python - https://stackabuse.com/merge-sort-in-python/
# REVIEW: Try Iterative Approach?
# REF: Non-Recursive Merge Sort - https://www.baeldung.com/cs/non-recursive-merge-sort

# Uncomment print statements to understand the concept more clearly
def merge_sort(list):
    """
    Sorts a list in ascending order
    - Divide: Find the midpoint of the list and divide into subsets
    - Conquer: Recursively sort the sublists created in previous step
    - Combine: Merge the sorted sublists created in previous step

    uses split(list) and merge(left_list, right_list) as helper methods

    Returns a new sorted list
    Takes Overall O(kn log n) time
    Space Complexity: O(n) or Linear
    """

    # Naively sorted when the given list is empty or with length of 1
    if len(list) <= 1:
        return list

    # two sublists are returned and captured in two variables
    left_half, right_half = split(list)

    # print(f"left half = {left_half}")
    left = merge_sort(left_half)
    # print(f"left = {left}")
    # print(f"right half = {right_half}")
    right = merge_sort(right_half)
    # print(f"right = {right}")

    return merge(left, right)


def split(list):
    """
    Divide the unsorted list at midpoint into sublists

    Returns two sublists - left and right

    slicing operation takes O(k) time, where k is the slized size. (refer python docs)
    Takes Overall O(k log n) time
    """

    mid = len(list) // 2  # floor division (//) to find the mid point
    left = list[:mid]  # slicing from start to mid(exclusive)
    right = list[mid:]  # slicing from mid to end

    return left, right


def merge(left, right):
    """
    Merges two lists, sorting them in process

    Returns a new merged list
    Takes O(n) time or Linear Time
    """

    sorted_values = []
    left_index = 0
    right_index = 0

    # compare the values from left list with the values from right list
    # exit the loop when either of the indexes reaches their respective list lengths
    while left_index < len(left) and right_index < len(right):
        # print(f"left = {left[left_index]} - right = {right[right_index]}")
        if left[left_index] <= right[right_index]:
            sorted_values.append(left[left_index])
            left_index += 1
            # print(f"left index = {left_index}")
        else:
            sorted_values.append(right[right_index])
            right_index += 1
            # print(f"right index = {right_index}")

    # remaining left over values are copied over to the sorted list.
    # assuming the values inside the list is already sorted.
    # one of the lists is empty but no need to check which one since the empty list will add nothing.
    sorted_values += left[left_index:]
    sorted_values += right[right_index:]

    # print(f"sorted values = {sorted_values}")
    return sorted_values


def verify_sorted(list):
    n = len(list)

    if n == 0 or n == 1:
        return True

    # recursively check the list
    # compare the first two elements in the list
    # recursively pass sublist from the index 1 to the end of the sublist
    return list[0] <= list[1] and verify_sorted(list[1:])


a_list = [50, 43, 8, 123, 9, 4, 87, 3]
l = merge_sort(a_list)

print(a_list)
print(verify_sorted(a_list))

print(l)
print(verify_sorted(l))
