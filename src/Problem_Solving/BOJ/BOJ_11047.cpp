// #include <iostream>
// #include <vector>
// #include <algorithm>

// using namespace std;

// int main() {
// 	int n, k, ans = 0;
// 	cin >> n >> k;

// 	vector<int> v(n);
// 	for (int i = 0; i < n; i++)
// 		cin >> v[i];

// 	sort(v.begin(), v.end(), greater<>());

// 	for (int i = 0; i < n; i++)
// 		while (k - v[i] >= 0)
// 		{
// 			ans++;
// 			k -= v[i];
// 		}

// 	cout << ans << '\n';

// 	return 0;
// }