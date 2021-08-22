class Node:
    """
    An object for storing a single node of a linked list

    Attributes
      prev_node - Reference to the previous node in the list
      data - Stored value
      next_node - Reference to the next node in the list
    """

    data = None

    def __init__(self, data, prev_node=None, next_node=None):
        self.data = data
        self.prev_node = prev_node
        self.next_node = next_node

    # displays whether the node has previous or next node with arrows. (printed to the console)
    def __repr__(self):
        prev_str = "<- " if self.prev_node else ""
        next_str = " ->" if self.next_node else ""

        return f"{prev_str}<Node data: {self.data}>{next_str}"


# TODO: track tail node of the list
class DoublyLinkedList:
    """
    Attributes:
      head: The head node of the list
    """

    def __init__(self):
        self.head = None
        self.__count = 0

    def __len__(self):
        """
        Returns the length of the linked list. `len()`
        Takes O(1) time or Constant Time
        """

        return self.__count

    def __repr__(self):
        """
        Returns a string representation of the list
        Takes O(n) time or Linear Time
        """

        nodes = []
        current = self.head

        while current:
            if current is self.head:
                nodes.append(f"[Head: {current.data}] <-")
            elif current.next_node is None:
                nodes.append(f"-> [Tail: {current.data}]")
            else:
                nodes.append(f"-> [{current.data}] <-")

            current = current.next_node

        return "".join(nodes)

    def is_empty(self):
        """
        Determines if the linked list is empty or not
        Takes O(1) time or Constant Time
        """

        return self.head is None

    def add(self, data):
        """
        Adds new `Node` containing data at the head of the list (prepend)
        Takes O(1) time or Constant Time
        """

        new_node = Node(data, prev_node=None, next_node=self.head)

        # assign head node's prev_node to be new_node if the list is not empty
        if not self.is_empty():
            self.head.prev_node = new_node

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

        return None

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

        while position < index:
            current = current.data
            position += 1

        return current


def test_doubly_linked_list():
    dl = DoublyLinkedList()

    print(dl.is_empty())


# test_doubly_linked_list()
