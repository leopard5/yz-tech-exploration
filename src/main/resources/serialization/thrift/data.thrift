namespace java com.yz.jvm.serialization.thrift

struct Person {
    1: optional string username;
    2: optional i32 age;
    3: optional bool married;
}

exception DataException {
    1: optional i32 code;
    2: optional string message;
    3: optional string callstack;
}

service PersonService {
    Person getPersonById(1: required string name);
}