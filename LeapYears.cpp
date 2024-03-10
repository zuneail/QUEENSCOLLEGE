#include <iostream>

bool leap_year(int year) {
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
        return true;
    } else {
        return false;
    }
}

void print_ans(int start_year, int end_year) {
    int count = 0;
    for (int year = start_year; year <= end_year; ++year) {
        if (leap_year(year)) {
            std::cout << year << " ";
            count++;
            if (count % 5 == 0) {
                std::cout << std::endl;
            }
        }
    }
    std::cout << std::endl;
}

int main() {
    int start_year, end_year;
    std::cout << "Enter the starting year: ";
    std::cin >> start_year;
    std::cout << "Enter the ending year: ";
    std::cin >> end_year;

    std::cout << "Leap years between " << start_year << " and " << end_year << ":" << std::endl;
    print_ans(start_year, end_year);

    return 0;
}
