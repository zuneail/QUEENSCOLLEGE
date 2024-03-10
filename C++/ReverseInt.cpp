#include <iostream>

int reverse_int(int num) {
    int reversed = 0;
    while (num > 0) {
        reversed = reversed * 10 + num % 10;
        num /= 10;
    }
    return reversed;
}

int main() {
    int num;
    
    while (true) {
        std::cout << "Enter a positive integer (enter a negative int to break): ";
        std::cin >> num;
        
        if (num < 0) {
            std::cout << "Exiting";
            break;
        }
        
        std::cout << "Reverse of " << num << " is: " << reverse_int(num) << std::endl;
    }
    
    return 0;
}
