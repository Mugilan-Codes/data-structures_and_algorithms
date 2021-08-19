# List

# REF: Array Characteristics and Storage - https://teamtreehouse.com/library/introduction-to-data-structures/exploring-arrays/array-characteristics-and-storage
# REF: Operations on Arrays - https://teamtreehouse.com/library/introduction-to-data-structures/exploring-arrays/operations-on-arrays

list_1 = [1, 2, 3]

print(list_1[0])  # 1

# print(list_1[3])  # IndexError: list index out of range

if 3 in list_1:
    print(True)

if 4 not in list_1:
    print(True)

# append - add item to end of the list
# Time Complexity - O(1) Constant Runtime
# Space Complexity - O(1) Ammortized Constant Space
list_1.append(5)  # [1, 2, 3, 5]

# insert - add item into the list at given position
# Time Complexity - O(n) Linear Runtime
list_1.insert(3, 4)  # [1, 2, 3, 4, 5]

# extend - To add (or concatenate) one list to another
# Time Complexity - O(n) Linear Runtime
list_2 = [6, 7, 8]
list_1.extend(list_2)  # [1, 2, 3, 4, 5, 6, 7, 8]

# remove - remove an item from list
# Time Complexity - O(n) Linear Runtime
list_1.remove(1)  # [2, 3, 4, 5, 6, 7, 8]
