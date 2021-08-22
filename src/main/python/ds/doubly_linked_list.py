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
            current = current.next_node
            position += 1

        return current

    # TODO: insert at the end of the list
    def insert(self, data, index):
        """
        Inserts a new `Node` containing data at any index position

        Insertion Takes O(1) time or Constant Time
        Finding the node at insertion point Takes O(n) time or Linear Time

        Overall Takes O(n) time or Linear Time
        """

        if index > self.__count:
            raise IndexError("index out of range")

        if index == 0:
            self.add(data)
            return

        # re reference new node between the node at the given index and it's previous node
        if index > 0:
            current_node = self.node_at_index(index)
            prev_node = current_node.prev_node

            new_node = Node(data, prev_node=prev_node, next_node=current_node)

            current_node.prev_node = new_node
            prev_node.next_node = new_node

        self.__count += 1

    def remove(self, key):
        """
        Removes data that matches the key
        Return the removed node or `None` if the key doesn't exist
        Takes O(n) time or Linear Time
        """

        current = self.head
        found = False

        # loop while current != None and found == False
        while current and not found:
            if current.data == key and current is self.head:
                found = True

                self.head = current.next_node
                # if the list is not empty assign prev_node to None.
                # (i.e.) if self.head is not None
                if self.head:
                    self.head.prev_node = None

                self.__count -= 1
                return current
            elif current.data == key:
                found = True

                # get previous and next node of the node to be deleted
                prev_node = current.prev_node
                next_node = current.next_node

                # reassign it
                prev_node.next_node = next_node
                # if the removed node is not the tail node
                if next_node:
                    next_node.prev_node = prev_node

                self.__count -= 1
                return current
            else:
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

            if self.head:
                self.head.prev_node = None

            self.__count -= 1
            return current

        current = self.node_at_index(index)

        prev_node = current.prev_node
        next_node = current.next_node

        prev_node.next_node = next_node
        if next_node:
            next_node.prev_node = prev_node

        self.__count -= 1
        return current


def test_doubly_linked_list():
    dl = DoublyLinkedList()

    print(dl.is_empty())


# test_doubly_linked_list()
