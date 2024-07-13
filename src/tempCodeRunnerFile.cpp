#include <iostream>
using namespace std;

// 선택 정렬의 시간 복잡도는 배열의 사이즈 == n의 반복을 ^2번을 하므로 O(n^2)이다.

int main(){
    int i, j, min, index, temp;
    int arry[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

    for (i = 0; i < 10; i++)
    {
        min = 9999;
        for (j = i; j < 10; j++)
        {
            if (arry[j] < min)
            {
                min = arry[j];
                index = j;
            }
        }
        temp = arry[j];
        arry[i] = min;
        arry[index] = temp;
    }
    for (i = 0; i < 10; i++)
        cout << arry[i] << " ";
    return 0;
    
    
}