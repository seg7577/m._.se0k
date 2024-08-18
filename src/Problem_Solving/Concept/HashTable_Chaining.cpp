#include <iostream>
#include <cstring>
#include <vector>

using namespace std;

class Node
{
    private:
        string key;
        string value;
        Node* next;
    public:
        void Set(string key, string value)
        {
            this->key = key;
            this->value = value;
        }
        Node* CreateNode(string key, string value)
        {
            Node* newNode = (Node*)malloc(sizeof(Node));
            newNode->key = key;
            newNode->value = value;

            return newNode;
        }
        void SetNext(Node* n)
        {
            this->next = n;
        }
        Node* getNext()
        {
            return this->next;
        }
        string getValue()
        {
            return this->value;
        }
        string getKey()
        {
            return this->key;
        }
};

class HashTable{
    private:
        int TableSize;
        Node** Table;
    public:
        HashTable* CreateHashTable(int TableSize)
        {
            HashTable* h = (HashTable*)malloc(sizeof(HashTable));
            h->TableSize = TableSize;
            Node** Talbe = (Node**)malloc(sizeof(Node) * TableSize);

            memset(h->Table, 0, sizeof(Node) * TableSize);

            return h;
        }
        void DestroyHashTable(HashTable* h)
        {
            free(Table);
            free(h);
        }
        void Set(HashTable* h, string key, string value)
        {
            int index = Hash(key, TableSize);
            Node* newNode;
            newNode = newNode->CreateNode(key, value);

            if (h->Table[index] == NULL)    h->Table[index] = newNode;
            else
            {
                Node* n = Table[index];
                newNode->SetNext(n);
                h->Table[index] = newNode;
            }
        }
        string Get(string key)
        {
            int index = Hash(key, TableSize);
            Node* Chaining = Table[index];
            Node* Target = NULL;

            if (Chaining == NULL)               return "error!";
            if (Chaining->getNext() == NULL)    return Chaining->getValue();
            
            while(1)
            {
                if (Chaining->getKey() == key)
                {
                    Target = Chaining;
                    break;
                }

                if (Chaining->getNext() == NULL)    break;
                else                                Chaining = Chaining->getNext();
            }

            return Target->getValue();
        }
        int Hash(string key, int TableSize)
        {
            int HashValue = 0;
            for (int i = 0; i < key.length(); i++)
                HashValue += (HashValue << 3) + key[i];
            
            return HashValue % TableSize;
        }

        int main()
        {
            int Size;
            cin >> Size;

            HashTable* h = CreateHashTable(Size);

            int n;
            cin >> n;
            
            vector<string> ans;
            string key, value;
            for (int i = 0; i < n; i++)
            {
                cin >> key >> value;
                h->Set(h, key, value);

                ans.push_back(key);
            }

        }
};