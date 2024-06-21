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