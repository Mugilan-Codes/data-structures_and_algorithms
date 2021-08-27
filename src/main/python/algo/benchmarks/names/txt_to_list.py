# Convert a txt file to a list by separating them line-by-line

with open(
    "/Users/mugil/Projects/practice/DSA/src/main/python/algo/comparison/names/unsorted.txt"
) as file:
    lines = file.readlines()
    lines = [line.rstrip() for line in lines]

print(lines)
