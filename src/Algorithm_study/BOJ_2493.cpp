#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    /*
    1. 6 입력 -> 스택이 비어있으므로 0 출력 이후 스택 삽입
    2. 9 입력 -> 스택 top < 9이므로 0 출력 이후 스택 top에 대해 pop연산 진행 이후 스택 push
    3. 5 입력 -> 5 < 스택 top이므로 스택 top에 대한 인덱스 출력 이후 스택에 push
    4. 7 입력 -> 스택 top < 7 이므로 7 < 스택 top의 연산이 true가 될 때까지 pop연산을 진행한다.
    이후 만족하는 탑의 인덱스를 출력하고 7을 삽입함
    5. 4 입력 -> 4 < 스택 top이므로 스택 top의 인덱스를 출력 후 스택에 삽입
    */

    cin.tie(0);
    ios_base::sync_with_stdio(false);
    int n;
    cin >> n;
   
    stack<pair<int, int> > s;
    int num, answer;
    for (int i = 1; i <= n; i++)
    {
        cin >> num;
        if (s.empty())
        {
            s.push(make_pair(num, i));
            cout << "0 ";
            
        }
        else if (num < s.top().first)
        {
                cout << s.top().second << " ";
                s.push(make_pair(num, i));
        }
        else
        {
            int answer = 0;
            while(s.top().first < num)
            {
                s.pop();
                if (s.empty())
                {
                    answer = 0;
                    break;
                }
                answer = s.top().second;
            }
            cout << answer << " ";
            s.push(make_pair(num, i));
        }
    }
    return 0;
}
