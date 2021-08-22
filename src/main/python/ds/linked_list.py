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


class LinkedList:
    """
    Singly Linked List
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
            else:
                current = current.next_node

        return None

    def insert(self, data, index):
        """
        Inserts a new `Node` containing data at index position

        Insertion Takes O(1) time or Constant Time
        Finding the node at insertion point Takes O(n) time or Linear Time

        Overall Takes O(n) time or Linear Time
        """

        # error if the size of the array
        if index >= self.__count:
            raise IndexError("index out of range")

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
