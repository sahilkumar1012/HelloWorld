

class TrieNode:
    def __init__(self):
        self.map = {}
        self.eow = False

class Contacts:

    def __init__(self):
        self.trie = TrieNode()
    def addContact(self, s):
        curr = self.trie
        for c in s:
            exists = curr.map.get(c)
            if not exists:
                curr.map[c] = TrieNode()
            curr = curr.map[c]
        curr.eow = True


    def search(self,s):

        curr = self.trie
        for c in s:
            if c not in curr.map:
                return False
            curr = curr.map[c]
        return curr.eow

    def delete(self,s):
        curr = self.trie
        for c in s:
            if c not in curr.map:
                return
            curr = curr.map[c]

        curr.eow = False

class Test:
    def test_addContact(self):
        contacts = Contacts()
        contacts.addContact("hack")
        contacts.addContact("hackerrank")
        assert contacts.search("hack") == True
        assert contacts.search("hackerrank") == True
        assert contacts.search("hacker") == False

    def test_search(self):
        contacts = Contacts()
        contacts.addContact("apple")
        contacts.addContact("apricot")
        assert contacts.search("apple") == True
        assert contacts.search("apricot") == True
        assert contacts.search("app") == False
        assert contacts.search("banana") == False

    def test_delete(self):
        contacts = Contacts()
        contacts.addContact("apple")
        contacts.addContact("apricot")
        assert contacts.search("apple") == True
        assert contacts.search("apricot") == True
        contacts.delete("apple")
        assert contacts.search("apple") == False
        assert contacts.search("apricot") == True



test = Test()
test.test_addContact()
test.test_search()
test.test_delete()



