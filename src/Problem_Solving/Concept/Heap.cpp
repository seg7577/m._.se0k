#include "HEAP.h"

using namespace std;

Heap* Heap_Create(int IntitialSize)                                             //새로운 힙 노드를 생성하는 메서드
{
    Heap* NewHeap = (Heap*)malloc(sizeof(Heap));                                //Heap의 크기만큼 공간을 할당하여 Heap*의 형태로 강제 형변환을 진행하여 할당한다.
    NewHeap->Capacity = IntitialSize;                                           //새로운 heap 노드의 크기에 대해 저장한다.
    NewHeap->UsedSize = 0;                                                      
    NewHeap->Nodes = (HeapNode*)malloc(sizeof(HeapNode) * NewHeap->Capacity);   //NewHeap의 Nodes는 Capacity만큼의 공간을 동적 생성한다.

    cout << "size : " << sizeof(HeapNode) << '\n';
    return NewHeap;
}

void Heap_Destroy(Heap* H)                                                      //해제는 생성의 역순으로 진행
{
    free(H->Nodes);
    free(H);
}

void Heap_Insert(Heap* H, ElementType NewData)
//이 함수는 힙에 새로운 데이터를 삽입하기 전에, 현재 힙의 크기와 용량을 확인하여 필요한 경우 힙의 용량을 두 배로 늘린다., 용량을 늘린 후, 실제 삽입 작업을 수행할 준비를 한다. 전체 삽입 과정에서 힙의 크기와 부모 노드의 위치를 추적한다.
{       
    int CurrentPosition = H->UsedSize;                                          //현재 삽입하려는 위치를 저장한단. 초기 값으로 힙에 이미 사용된 크기 (H->UsedSize)를 할당한다.
    int ParentPosition = Heap_GetParent(CurrentPosition);                       //현재 삽입하려는 위치의 부모 노드 위치를 저장한다. 

    if (H->UsedSize == H->Capacity)                                             //힙의 사용된 크기가 힙의 전체 용량과 동일한지 확인한다. 만약 동일하다면 힙이 꽉 찼ㄷ는 의미                       
    {                                                                           //힙이 꽉 찼을 경우, 힙의 용량을 두 배로 늘린다. realloc 함수를 사용하여 힙의 노드 배열의 크기를 새 용량에 맞게 재할당한다. 이 과정에서 기존의 데이터는 그대로 유지되지만, 더 많은 노드를 저장할 수 있도록 배열의 크기가 증가함
        H->Capacity *= 2;
        H->Nodes = (HeapNode*)realloc(H->Nodes, sizeof(HeapNode) * H->Capacity);

    }

    H->Nodes[CurrentPosition].Data = NewData;                                   //새 데이터를 현재 위치(CurrentPosition)에 삽입한다.

    while (CurrentPosition > 0 && H->Nodes[CurrentPosition].Data < H->Nodes[ParentPosition].Data)
    //현재 위치가 루트가 아니며(범위에 대한 조건), 현재 노드의 데이터가 부모 노드의 데이터보다 작은 동안 반복 -> (최소힙 조건), 아래에서 위로 올라가는 형식
    {
        Heap_SwapNodes(H, CurrentPosition, ParentPosition);                     //현재 위치한 노드와 부모 노드의 위치를 바꿈
        
        CurrentPosition = ParentPosition;                                       //현재의 위치를 부모의 위치로 초기화
        ParentPosition = Heap_GetParent(CurrentPosition);                       //부모 위치를 재계산하는 것
    }

    H->UsedSize++;                                                              //힙에 사용된 크기를 1 증가 == 새로운 노드가 삽입 되었음을 반영함
}

void Heap_SwapNodes(Heap* H, int Index1, int Index2)
{
    int CopySize = sizeof(HeapNode);
    HeapNode* Temp = (HeapNode*)malloc(CopySize);

    memcpy(Temp, &H->Nodes[Index1], CopySize);
    memcpy(&H->Nodes[Index1], &H->Nodes[Index2], CopySize);
    memcpy(&H->Nodes[Index2], Temp, CopySize);
    //복사 받을 메모리를 가리키는 포인터, 복사할 메모리를 가리키고 있는 포인터, 복사할 데이터의 길이

    free(Temp);
}

void Heap_DeleteMin(Heap* H, HeapNode* Root)
{
    int ParentPosition = 0;
    int LeftPosition = 0;
    int RightPosition = 0;

    memcpy(Root, &H->Nodes[0], sizeof(HeapNode));                               //삭제를 위해 말단에 위치한 인자로 받은 노드의 포인터에 현재 루트 노드의 주소를 저장한다.
    memset(&H->Nodes[0], 0, sizeof(HeapNode));                                  //루트 노드의 데이터를 0으로 초기화
    //세팅하고자하는 메모리의 시작 주소, 메모리에 세팅하고자 하는 데이터 값, 사이즈 -> 실패한다면 NULL을 반환함

    H->UsedSize--;                                                              //총 힙의 개수 반영 == 노드의 개수를 감소시킴
    Heap_SwapNodes(H, 0, H->UsedSize);                                          //마지막 노드와 루트 노드를 교환함. 이로 인해 마지막 노드가 루트 노드로 이동한다.

    LeftPosition = Heap_GetLeftChild(0);
    RightPosition = LeftPosition + 1;
    //루트 노드의 각각 자식 노드에 대한 위치 계산

    while(1)
    //힙 재정렬을 위한 반복
    {
        int SelectedChild = 0;
        if (LeftPosition >= H-> UsedSize)                                       //이 힙의 사용된 크기보다 크거나 같으면 반복을 종료한다.
            break;
        if (RightPosition >= H->UsedSize)                                       //이 힙의 사용된 크기보다 크거나 같으면 왼쪽 자식을 선택한다.
            SelectedChild = LeftPosition;
        else                                                                    //그렇지 않다면 자식 노드 중 데이터를 비교하여 더 작은 Data 값을 가진 자식 노드를 선택한다.
        {
            if (H->Nodes[LeftPosition].Data > H->Nodes[RightPosition].Data)     
                SelectedChild = RightPosition;
            else
                SelectedChild = LeftPosition;
        }

        if (H->Nodes[SelectedChild].Data < H->Nodes[ParentPosition].Data)       //선택된 노드(자식 노드 중 더 작은 Data값을 가진 노드)가 부모 노드의 데이터보다 작은 두 노드를 교환한다.
        {
            Heap_SwapNodes(H, ParentPosition, SelectedChild);
            ParentPosition = SelectedChild;                                     //부모 위치를 선택된 자식의 위치로 업데이트 함.
        }
        else                                                                
            break;

        LeftPosition=Heap_GetLeftChild(ParentPosition);                         
        RightPosition = LeftPosition + 1;                                       //왼쪽 자식 위치와 오른쪽 자식 위치를 다시 계산함.
    }

    if (H->UsedSize < (H->Capacity / 2))                                        //힙의 사용된 크기가 전체 용량의 절반 보다 작아지면, 힙의 용량을 절반으로 줄인다.
    {
        H->Capacity /= 2;
        H->Nodes = (HeapNode*) realloc(H->Nodes, sizeof(HeapNode) * H->Capacity);
    }
}

int Heap_GetParent(int Index)
{
    return (int)((Index - 1) / 2);
}

int Heap_GetLeftChild(int Index)
{
    return (2 * Index) + 1;
}

void Heap_PrintNodes(Heap* H)
{
    for (int i = 0; i < H->UsedSize; i++)
    {
        cout << H->Nodes[i].Data;
    }
    cout << '\n';
}