namespace java com.yz.jvm.serialization.thrift

struct Student{
    1: optional i32 id;
    2: optional string name;
    3: optional string describe;
    4: optional list<string> scores;
}

