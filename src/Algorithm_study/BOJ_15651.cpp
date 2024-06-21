#include <iostream>
#include <vector>

using namespace std;

int n, m;
bool vis[7];
int arry[7];
bool duplication[7];
vector<int>vec;

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
}
int Count = 1;
void dfs(int cnt)
{
	if (cnt == m)
	{
		for (int i = 0; i < m; i++)
		{
			cout << vec[i] << ' ';
		}
		cout << '\n';
		return;
	}
	for (int i = 0; i < n; i++)
	{
		vec.push_back(arry[i]);
		dfs(cnt + 1);
		vec.pop_back();
	}
}