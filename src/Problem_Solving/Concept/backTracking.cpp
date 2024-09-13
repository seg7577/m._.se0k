/*
문제 : n개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 s가 되는 경우의 수를 구하는 프로그램을 작성하시오.
---------------------------------------------------------------------------------------------------------------------------------
입력 : 첫째 줄에 정수의 개수를 나타내는 n과 정수 s가 주어진다.(1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 n개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
출력 : 첫째 줄에 합이 s가 뙤는 부분수열의 개수를 출력한다.
---------------------------------------------------------------------------------------------------------------------------------
플이 : 백트래킹은..."현재 상태에서 가능한 모든 후보군을 따라 들어가며 탐색하는 알고리즘" 라고는 하는데 그냥 dfs에서 뒤에서부터 하면 장땡인...그런..그런...그런...
일단 dfs를 하기 위해 트리 구조로 형상화를 하였고, 이후 가지치기? 할 때는 해당 인덱스의 값이 포함 되는 경우, 안 되는 경우 두 가지로 나누어서 dfs를 두 번씩 호출하여 재귀로 풀어냈다. 여기서 주의할 점은 현재 원소를 포함하지 않는 경우로 탐색을 진행하다 보면 공집합이 포함되는 경우가 발생할 수 있기 때문에 s == 0인 경우에는 탐색이 종료된 이후 answer--를 해주었다.
*/

#include <iostream>
using namespace std;

int n, s, answer = 0;
int arr[25];

void func(int idx, int sum) {
    if (idx == n) {  // 배열의 끝에 도달한 경우
        if (sum == s) answer++;
        return;
    }

    // 현재 원소를 포함하지 않는 경우
    func(idx + 1, sum);
    
    // 현재 원소를 포함하는 경우
    func(idx + 1, sum + arr[idx]);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> s;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    func(0, 0);  // 시작 인덱스와 합 0으로 초기화

    // s가 0인 경우, 공집합(빈 부분수열)이 포함되므로 이를 제외
    if (s == 0) answer--;

    cout << answer << '\n';
    return 0;
}

/*
문제 : 자연수 n과 m이 주어졌을 때, 아래 조건을 만족하는 길이가 m인 수열을 모두 구하는 프로그램을 작성하시오.
1. 1부터 n까지 자연수 중에서 중복 없이 m개를 고른 수열
2. 고른 수열은 오름차순이어야 한다.

---------------------------------------------------------------------------------------------
입력 : 첫째 줄에 자연수 n과 m이 주어진다.
출력 : 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력ㄷ한다. 중복되는 수열을 여러 번 출력3하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
수열은 사전 순으로 증가하는 순서로 출력해야 한다.

---------------------------------------------------------------------------------------------
풀이 : 앞 문제인 n과 m(1)에서의 백트래킹 코드를 본 떠서 진행하며 visted를 하나 더 사용하여 중복된 수열 및 오름차순을 만들어보려고 했으나 해내지 못했다..
그렇게 고민하던 중 반복문을 유심히 보니 한 가지를 알 수 있었다. 함수가 호출되고 재귀로 호출된 경우 이전의 반복문에서의 i까지는 반복을 건너 뛴다는 점이였다.(조건문을 통해 내부 코드가 실행되지 않음을 말함.)
이를 이용하면 함수 매개변수(parameter)을 하나 더 만들어 반복문의 시작점을 반복된 지점까지 이어서 하게 하여 오름차순을 구성하게 되었다.
*/



#include <iostream>
#define MAX 10
using namespace std;

int n, m;
int arr[MAX];
bool vis[MAX];

void func(int k, int start)
{
    if(k == m)
    {
        for (int i = 0; i < m; i++)
            cout << arr[i] << ' ';
        cout << '\n';
        
        return;
    }
    
    for (int i = start; i <= n; i++)
    {
        if (!vis[i])
        {
            arr[k] = i;
            vis[i] = true;
            func(k+1, i);
            vis[i] = false;
        }
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
    cin >> n >> m;
    func(0, 1);
    
    return 0;
}

#include <iostream>
#include <vector>

using namespace std;

bool vis[8];
int n, m;
int arry[8];
vector<int> vec;
void dfs(int cnt);
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	
	for (int i = 0; i < n; i++)
		arry[i] = i + 1;

	dfs(0);
	return 0;
}
void dfs(int cnt)
{
	if (cnt == m)
	{
		for (int i = 0; i < m; i++)
			cout << vec[i] << ' ';
		cout << '\n';
		return;
	}
	for (int i = 0; i < n; i++)
	{
		if (vis[i])	continue;
		vis[i] = true;
		vec.push_back(arry[i]);
		dfs(cnt + 1);
		vec.pop_back();
		vis[i] = false;
	}
	return;
}
#include <iostream>

using namespace std;

int n, m;
bool vis[10];
int arr[10];

void func(int k)
{
    if (k == m)
    //배열이 m번째의 인덱스까지 모두 채워진 경우에 대한 처리 (즉, 길이가 m인 수열이 완성된 경우)
    {
        for (int i = 0; i < m; i++)
        //완성된 m개의 수열을 출력
            cout << arr[i] << ' ';
        cout << '\n';
        return;
    }
    
    for (int i = 1; i <= n; i++)
    //1부터 n까지의 수를 차례로 시도
    {
        if (!vis[i])
        //아직 해당 숫자[i]가 수열에 사용되지 않았다면
        {
            arr[k] = i;
            vis[i] = true;
            //i를 현재 위치 k에 넣고, 사용했음을 표시
            func(k+1);
            vis[i] = false;
            //재귀 호출 이후 다시 해당 숫자를 사용하지 않았다고 표시
        }
    }
}


int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
    cin >> n >> m;
    func(0);
}