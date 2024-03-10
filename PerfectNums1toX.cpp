#include <iostream>

bool Perfect(int num) {
    int sum = 0;
    for (int i = 1; i < num; i++) {
        if (num % i == 0) {
            sum += i;
        }
    }
    return sum == num;
}

int main() {
    int n;
    std::cout << "Enter a positive number -> ";
    std::cin >> n;

    if (n <= 0) {
        std::cout << "Enter positive numbers only." << std::endl;
            return 0;
    }

    std::cout << "Perfect numbers from 1 to " << n << " -> ";
    for (int i = 1; i <= n; i++) {
        if (Perfect(i)) {
            std::cout << i << " ";
        }
    }
    std::cout << std::endl;

    return 0;
}
