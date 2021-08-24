# Python (recursion depth) prefers iterative approach instead of recursive because of higher space complexity
# Time Complexity - O(log n) (or) logorithmic runtime
# Space Complexity - O(log n) (or) logorithmic space


def recursive_binary_search(list, target):
    if len(list) == 0:
        return False
    else:
        midpoint = (len(list)) // 2

        if list[midpoint] == target:
            return True
        else:
            if list[midpoint] < target:
                return recursive_binary_search(list[midpoint + 1 :], target)
            else:
                return recursive_binary_search(list[:midpoint], target)


def verify(result):
    print(f"Target Found: {result}")


def main():
    numbers = [i for i in range(1, 9)]

    result = recursive_binary_search(numbers, 12)
    verify(result)

    result = recursive_binary_search(numbers, 6)
    verify(result)


if __name__ == "__main__":
    main()
