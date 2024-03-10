#include <iostream>
using namespace std;

class Contact
{

private:
    string last_name;
    string first_name;
    string address;
    string email;
    string phone_number;

public:
    // setters
    void set_last_name(string last_name) { this->last_name = last_name; }
    void set_first_name(string first_name) { this->first_name = first_name; }
    void set_address(string address) { this->address = address; }

    void set_email(string email)
    {
        size_t at_position = email.find('@');
        size_t dot_position = email.find('.', at_position);

        if (at_position != string::npos && dot_position != string::npos && dot_position > at_position)
        {
            this->email = email;
        }
        else
        {
            cout << "Invalid email format. Please provide a valid email address." << endl;
        }
    }

    void set_phone_number(string phone_number)
    {
        if (phone_number.length() == 10 && all_of(phone_number.begin(), phone_number.end(), ::isdigit))
        {
            this->phone_number = phone_number;
        }
        else
        {
            cout << "Invalid phone number format. Please provide a 10-digit phone number." << endl;
        }
    }

    // getters
    string get_last_name() { return last_name; }
    string get_first_name() { return first_name; }
    string get_address() { return address; }
    string get_email() { return email; }
    string get_phone_number() { return phone_number; }

    // overloaded constructor
    Contact(string last_name, string first_name, string address, string email, string phone_number)
    {
        this->last_name = last_name;
        this->first_name = first_name;
        this->address = address;
        this->email = email;
        this->phone_number = phone_number;
    }

    // Default constructor
    Contact()
    {
        last_name = "";
        first_name = "";
        address = "";
        email = "";
        phone_number = "";
    }

    // Print
    void Print()
    {
        cout << "------ CONTACT CARD ------" << endl
             << "First name: " << get_first_name()
             << endl
             << "Last name: " << get_last_name() << endl
             << "Address: " << get_address() << endl
             << "Email: " << get_email()
             << endl
             << "Phone Number: " << get_phone_number() << endl
             << "--------------------------" << endl
             << endl;
    }
};

int main()
{
    // overloaded constructor
    Contact contact1("Doe", "John", "123 Main St", "john.doe@example.com", "1234567890");
    // default constructor
    Contact contact2;

    
    cout << "\n--GETTERS AND SETTERS \n";
    contact2.set_last_name("Smith");
    contact2.set_first_name("Jane");
    contact2.set_address("456 Elm St");
    contact2.set_email("jane.smith@example.com");
    contact2.set_phone_number("9876543210");

    cout << contact2.get_address() << endl;
    cout << contact2.get_email() << endl;
    cout << contact2.get_first_name() << endl;
    cout << contact2.get_last_name() << endl;
    cout << contact2.get_phone_number() << endl;

    
    cout << "\n--PRINT FUCNTION\n";
    contact1.Print();
    contact2.Print();

    
    cout << "\n--INVALID ENTRIES\n";
    Contact contact3;
    contact3.set_email("invalidemail");
    contact3.set_email("invali.demail@something"); 
    contact3.set_email("invalidemail@something"); 
    contact3.set_email("invalidemail.something"); 
    contact3.set_phone_number("123");
    contact3.set_phone_number("abc");   
    contact3.set_phone_number("12345678901"); 
    return 0;
}