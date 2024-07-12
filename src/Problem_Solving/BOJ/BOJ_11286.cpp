// #include <iostream>
// #include <queue>

// using namespace std;

// priority_queue<pair<int, bool>, vector<pair<int, bool>>, greater<pair<int, bool>>> pq;

// int main()
// {
// 	ios_base::sync_with_stdio(false);
// 	cin.tie(0);
// 	cout.tie(0);

// 	int n;
// 	cin >> n;
	
// 	for (int i = 0; i < n; i++)
// 	{
// 		int x;
// 		cin >> x;

// 		if (x == 0)
// 		{
// 			if (pq.empty())
// 				cout << 0 << '\n';
// 			else if (!pq.empty() && pq.top().second)
// 			{
// 				cout << pq.top().first << '\n';
// 				pq.pop();
// 			}
// 			else if (!pq.empty() && !pq.top().second)
// 			{
// 				cout << pq.top().first * -1 << '\n';
// 				pq.pop();
// 			}
// 		}
// 		else if (x < 0)
// 			pq.push({ x * -1, false });
// 		else
// 			pq.push({ x, true });
// 	}
// 	return 0;
// }