# REF: Singly and Doubly Linked Lists - https://teamtreehouse.com/library/introduction-to-data-structures/building-a-linked-list/singly-and-doubly-linked-lists-2
# REF: Linked Lists Operations - https://teamtreehouse.com/library/introduction-to-data-structures/building-a-linked-list/linked-lists-operations


class Node:
    """
    An object for storing a single node of a linked list.

    Attributes
      data - Stored value
      next_node - Reference to next node in the list
    """

    data = None
    next_node = None

    def __init__(self, data):
        self.data = data

    # Representation of the node. (printed to the console)
    # without this it would look like this: <__main__.Node object at 0x101ab2ac0>
    def __repr__(self):
        # return "<Node data: %s>" % self.data
        return f"<Node data: {self.data}>"


class SinglyLinkedList:
    """
    Linear data structure that stores values in nodes.
    The list maintains a reference to the first node, also called head.
    Each node points to the next node in the list

    Attributes:
        head: The head node of the list
    """

    def __init__(self):
        self.head = None
        # Maintaining a count attribute allows for len() to be implemented in constant time
        self.__count = 0

    def __repr__(self):
        """
        Returns a string representation of the list
        Takes O(n) time or Linear Time
        """

        nodes = []
        current = self.head

        # as long as current is not None
        while current:
            if current is self.head:
                nodes.append(f"[Head: {current.data}]")
            elif current.next_node is None:
                nodes.append(f"[Tail: {current.data}]")
            else:
                nodes.append(f"[{current.data}]")

            current = current.next_node

        return "-> ".join(nodes)

    def __len__(self):
        """
        Returns the length of the linked list. `len()`
        Takesn O(1) time or Constant Time
        """

        return self.__count

    def is_empty(self):
        """
        Determines if the linked list is empty
        Takes O(1) time or Constant Time
        """

        return self.head is None  # self.head == None

    # REVIEW: __len__ is better?
    def size(self):
        """
        Returns the number of nodes in the list
        Takes O(n) time or Linear Time
        """

        current = self.head
        count = 0

        while current:
            count += 1
            current = current.next_node

        return count

    def add(self, data):
        """
        Adds new Node containing data at the head of the list (prepend)
        Takes O(1) time or Constant Time
        """

        new_node = Node(data)
        new_node.next_node = self.head
        self.head = new_node
        self.__count += 1

    def search(self, key):
        """
        Search for the first node containing the data that matches the key
        Returns the node or `None` if not found
        Takes O(n) time or Linear Time
        """

        current = self.head

        while current:
            if current.data == key:
                return current

            current = current.next_node

        return None  # TODO: return a string

    def insert(self, data, index):
        """
        Inserts a new `Node` containing data at any index position

        Insertion Takes O(1) time or Constant Time
        Finding the node at insertion point Takes O(n) time or Linear Time

        Overall Takes O(n) time or Linear Time
        """

        # error if the size of the array is less than the given index
        if index > self.__count:
            raise IndexError("index out of range")

        # insert at the head position
        if index == 0:
            self.add(data)
            return

        if index > 0:
            new = Node(data)

            position = index
            current = self.head

            # find the existing node at given index
            while position > 1:
                current = current.next_node
                position -= 1

            # allocate prev and next nodes
            prev_node = current
            next_node = current.next_node

            # add inbetween
            prev_node.next_node = new
            new.next_node = next_node

        self.__count += 1

    def node_at_index(self, index):
        """
        Returns the node at specified index
        Takes O(n) time or Linear Time
        """

        if index >= self.__count:
            raise IndexError("index out of range")

        if index == 0:
            return self.head

        current = self.head
        position = 0

        # loops through to the index position
        while position < index:
            current = current.next_node
            position += 1

        return current

    def remove(self, key):
        """
        Removes data that matches the key
        Return the removed node or `None` if the key doesn't exist
        Takes O(n) time or Linear Time
        """

        current = self.head
        prev_node = None
        found = False

        # loop while current != None and found == False
        while current and not found:
            if current.data == key:
                found = True

                # check if the key is found at the head
                if current is self.head:
                    self.head = current.next_node
                else:
                    prev_node.next_node = current.next_node

                self.__count -= 1
                return current

            # prepare for next loop
            prev_node = current
            current = current.next_node

        return None

    def remove_at_index(self, index):
        """
        Removes node at specified index
        Takes O(n) time or Linear Time
        """

        if index >= self.__count:
            raise IndexError("index out of range")

        current = self.head

        if index == 0:
            self.head = current.next_node
            self.__count -= 1
            return current

        position = index

        # find the ( given index - 1 ) position's node
        while position > 1:
            current = current.next_node
            position -= 1

        prev_node = current
        current = current.next_node  # the node to be removed
        next_node = current.next_node

        # linking the remaining nodes after remove
        prev_node.next_node = next_node
        self.__count -= 1

        return current


# TODO: display keys that are being searched even when it is not found
def verify_search(value):
    if value is None:
        print("Key not found")
    else:
        print(f"Key Found: {value}")


def test_singly_linked_list():
    l = SinglyLinkedList()

    print(l.is_empty())

    l.add(10)
    l.add(20)
    l.add(30)
    l.add(40)
    l.add(50)
    l.add(70)

    print(len(l))
    print(l.size())
    print(l)

    verify_search(l.search(60))
    verify_search(l.search(50))

    l.insert(60, 1)
    print(l)

    print(l.node_at_index(5))

    print(l.remove(80))
    print(l.remove(30))

    print(l.remove_at_index(4))

    print(l)


if __name__ == "__main__":
    test_singly_linked_list()
