from linked_list import LinkedList


# Uncomment print statements to understand the concept more clearly
def merge_sort(linked_list):
    """
    Sorts a linked list in ascending order
    - Recursively divide the linked list into sublinkedlists conatining a single node
    - Repeatedly merge these sublinkedlists to produce sorted sublinkedlists until one remains

    uses size(), is_empty() from LinkedList
    uses split() and merge() as helper methods

    Returns a sorted linked list

    Takes O(n) space or Linear Space Complexity
    Runs in O(kn log n) time
    """

    # print(f"linked_list = {linked_list}")

    # naively sorted if the size of the list is 1 or empty
    if linked_list.size() == 1:
        return linked_list
    if linked_list.is_empty():
        return linked_list

    left_half, right_half = split(linked_list)
    # print(f"left half = {left_half}, right half = {right_half}")

    left = merge_sort(left_half)
    right = merge_sort(right_half)
    # print(f"left = {left}, right = {right}")

    return merge(left, right)


def split(linked_list):
    """
    Divide the unsorted linked list at midpoint into sublinkedlists

    uses is_empty(), node_at_index() from LinkedList

    Returns two sublinkedlists - left and right

    Runs in O(k log n) time
    """

    if linked_list is None or linked_list.is_empty():
        left_half = linked_list
        right_half = None

        return left_half, right_half

    size = linked_list.size()
    mid = size // 2
    mid_index = mid - 1  # index value starts from 0
    mid_node = linked_list.node_at_index(mid_index)
    # print(f"size = {size}, mid = {mid}, mid_index = {mid_index}, mid_node = {mid_node}")

    left_half = linked_list
    right_half = LinkedList()

    # assign the next node of mid node to right as head
    # remove the reference from mid node to its next node (to split)
    right_half.head = mid_node.next_node
    mid_node.next_node = None

    return left_half, right_half


def merge(left, right):
    """
    Merge two linked lists, sorting them by data in nodes

    uses add() from LinkedList

    Returns a new, merged linked list

    Takes O(n) space or Linear Space Complexity
    Runs in O(n) time or Linear Time
    """

    merged = LinkedList()

    # add a fake head node that is discarded later
    # set current to the head of the linked list
    merged.add(0)
    current = merged.head
    # print(f"before merged = {merged}")

    # obtain head nodes for left and right linked lists
    left_head = left.head
    right_head = right.head

    # iterate over left and right linked lists until we reach the tail node of both
    while left_head or right_head:
        if left_head is None:  # tail of left
            # add the node from right to merged linked list
            current.next_node = right_head
            right_head = right_head.next_node  # set to None, loop condition False
        elif right_head is None:  # tail of right
            # add the node from left to merged linked list
            current.next_node = left_head
            left_head = left_head.next_node  # set to None, loop condition False
        else:
            left_data = left_head.data
            right_data = right_head.data

            if left_data < right_data:
                current.next_node = left_head
                left_head = left_head.next_node
            else:
                current.next_node = right_head
                right_head = right_head.next_node

        # print(f"current = {current}, merged = {merged}")
        current = current.next_node

    # discard fake head by setting first merged node as head
    head = merged.head.next_node
    merged.head = head
    # print(f"after merged = {merged}")

    return merged


def check(current):
    next_node = current.next_node

    if next_node is None:
        return True

    return current.data < next_node.data and check(next_node)


def verify_sorted(linked_list):
    n = linked_list.size()

    if n == 0 or n == 1:
        return True

    current = linked_list.head

    return check(current)


def main():
    l = LinkedList()
    l.add(76)
    l.add(10)
    l.add(20)
    l.add(30)
    l.add(25)
    l.add(44)
    l.add(50)

    print(l)
    print(verify_sorted(l))

    sorted_linked_list = merge_sort(l)

    print(sorted_linked_list)
    print(verify_sorted(sorted_linked_list))


if __name__ == "__main__":
    main()
