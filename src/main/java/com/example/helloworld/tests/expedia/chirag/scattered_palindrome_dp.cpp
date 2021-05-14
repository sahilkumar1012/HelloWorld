
#include <iostream>
#include <string>
#include <map>

using namespace std;
// run in clion ide

int solve(string s){
    long long answer = 0;
    map<int, int> m;
    m[0] = 1;
    int x = 0;
    for (auto& c : s) {
        int d = c - 'a';
        x ^= 1 << d;
        answer += m[x];
        for (int i = 0; i < 26; ++i) {
            answer += m[x ^ (1 << i)];
        }
        m[x] += 1;
    }
    return answer;
}

int main()
{
    cout<<solve("ddrrg")<<endl;
    cout<<solve("abc")<<endl;
    cout<<solve("ddrrg")<<endl;
}

