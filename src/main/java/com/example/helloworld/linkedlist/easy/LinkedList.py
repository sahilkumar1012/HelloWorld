class ListNode:
    """Class representing a node in a singly linked list."""
    def __init__(self, v: int):
        self.val = v  # Value of the node
        self.next = None  # Pointer to the next node


class MyList:
    """Singly linked list with common operations."""
    def __init__(self):
        self.head = None  # Head pointer of the linked list

    # Insert a new node with value `new_val` after the first occurrence of `v`
    def insert_after(self, v: int, new_val: int):
        current = self.head
        while current and current.val != v:
            current = current.next

        if current:  # If v is found
            new_node = ListNode(new_val)
            new_node.next = current.next
            current.next = new_node

    # Delete a node with value `v`
    def delete(self, v: int):
        if not self.head:
            return  # Empty list, nothing to delete

        # If head itself needs to be deleted
        if self.head.val == v:
            self.head = self.head.next
            return

        current = self.head
        while current.next and current.next.val != v:
            current = current.next

        if current.next:  # If found, bypass the node
            current.next = current.next.next

    # Insert at the head (O(1) operation)
    def insert_head(self, v: int):
        new_node = ListNode(v)
        new_node.next = self.head
        self.head = new_node

    # Delete the head node
    def delete_head(self):
        if self.head:
            self.head = self.head.next

    # Search for a value in the linked list
    def search(self, v: int) -> bool:
        current = self.head
        while current:
            if current.val == v:
                return True
            current = current.next
        return False

    # Print the linked list
    def print_list(self):
        current = self.head
        while current:
            print(current.val, end=" -> ")
            current = current.next
        print("None")


# Example Usage:
my_list = MyList()
my_list.insert_head(4)
my_list.insert_head(3)
my_list.insert_head(1)

my_list.insert_after(3, 2)  # Insert 2 after 3
my_list.print_list()  # Output: 1 -> 3 -> 2 -> 4 -> None

my_list.delete(3)  # Delete 3
my_list.print_list()  # Output: 1 -> 2 -> 4 -> None

print(my_list.search(2))  # Output: True
print(my_list.search(5))  # Output: False

my_list.delete_head()
my_list.print_list()  # Output: 2 -> 4 -> None
