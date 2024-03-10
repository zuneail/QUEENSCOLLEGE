#include <iostream>

bool Prime(int num) {
    if (num <= 1) 
        return false;
    
    for (int i = 2; i * i <= num; ++i) {
        if (num % i == 0) 
            return false;
    }
    return true;
}

int main() {
    int n;
    std::cout << "Enter a positive number -> ";
    std::cin >> n;

    std::cout << "Outputting prime numbers from 1 to " << n << std::endl;
    
    for (int i = 2; i <= n; ++i) {
        if (Prime(i)) std::cout << i << " ";
    }
    
    std::cout << "\nFinished" <<std::endl;
        return 0;
}
