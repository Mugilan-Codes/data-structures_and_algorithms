from ds.singly_linked_list import SinglyLinkedList

# BUG: Not working

# Uncomment print statements to understand the concept more clearly
def merge_sort(linked_list):
    """
    Sorts a linked list in ascending order
    - Recursively divide the linked list into sublinkedlists conatining a single node
    - Repeatedly merge these sublinkedlists to produce sorted sublinkedlists until one remains

    uses len() from SinglyLinkedList
    uses split() and merge() as helper methods

    Returns a sorted linked list
    """

    # naively sorted if the size of the list is 1 or empty
    if len(linked_list) == 1:
        return linked_list
    if linked_list.is_empty():
        return linked_list

    left_half, right_half = split(linked_list)

    left = merge_sort(left_half)
    right = merge_sort(right_half)

    return merge(left, right)


def split(linked_list):
    """
    Divide the unsorted linked list at midpoint into sublinkedlists

    uses is_empty(), len(), node_at_index() from SinglyLinkedList

    Returns two sublinkedlists - left and right
    """

    if linked_list is None or linked_list.is_empty():
        left_half = linked_list
        right_half = None

        return left_half, right_half

    size = len(linked_list)
    mid = size // 2
    # index value starts from 0. therefore mid - 1
    mid_node = linked_list.node_at_index(mid - 1)

    # assign whole linked list
    left_half = linked_list
    # create new linked list instance
    right_half = SinglyLinkedList()

    # set the mid node as the head of the new linked list
    right_half.head = mid_node.next_node
    # remove the next node reference from mid node to split the linked list
    mid_node.next_node = None

    return left_half, right_half


def merge(left, right):
    """
    Merge two linked lists, sorting them by data in nodes

    uses add() from SinglyLinkedList

    Returns a new, merged linked list
    """

    # creates new linked list that contains nodes from merging left and right
    merged = SinglyLinkedList()

    # add a fake head node that is discarded later
    merged.add(0)

    # set current to the head of the linked list
    current = merged.head

    # obtain head nodes for left and right linked lists
    left_head = left.head
    right_head = right.head

    # iterate over left and right linked lists until we reach the tail node of both
    while left_head or right_head:
        # if the head of the left node is none, current is at tail
        # add the node from right to merged linked list
        if left_head is None:
            current.next_node = right_head
            # call next on right to set loop condition to False
            right_head = right_head.next_node
        # if the head of the right node is none, current is at tail
        # add the node from left to merged linked list
        elif right_head is None:
            current.next_node = left_head
            # call next on left to set loop condition to False
            left_head = left_head.next_node
        # not at either tail node
        else:
            # obtain node data to perform comparison operations
            left_data = left_head.data
            right_data = right_head.data

            # set current to left node when left data is lesser than right data
            if left_data < right_data:
                current.next_node = left_head
                # move left head to next node
                left_head = left_head.next_node
            # set current to right node when right data is lesser than or equal to left data
            else:
                current.next_node = right_head
                # move right head to next node
                right_head = right_head.next_node

        # move current to next node
        current = current.next_node
        print(current)

    # discard fake head
    # set first merged node as head
    head = merged.head.next_node
    merged.head = head

    return merged


# TODO: write verify sorted function


def main():
    l = SinglyLinkedList()
    l.add(10)
    l.add(20)
    l.add(30)
    # l.add(44)
    # l.add(50)
    # l.add(20)

    print(l)

    sorted_linked_list = merge_sort(l)

    print(sorted_linked_list)


if __name__ == "__main__":
    main()
